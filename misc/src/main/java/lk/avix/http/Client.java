package lk.avix.http;

import lk.avix.key.PrivateKey;
import lk.avix.key.PublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.UUID;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class Client {

    private static final String truststore = "pkcs12Truststore.p12";
    private static final String truststorePassword = "ballerina";
    private static final String keystore = "pkcs12Keystore.p12";
    private static final String keystorePassword = "ballerina";
    private static final String trustedCert = "x509Public.crt";
    private static final String privateKey = "pkcs8Private.key";
    private static final String encryptedPrivateKey = "pkcs8EncryptedPrivate.key";
    private static final String publicCert = "x509Public.crt";

    public static void main(String[] args) throws Exception {
        String truststoreFile = Objects.requireNonNull(Client.class.getClassLoader().getResource(truststore)).getFile();
        String truststorePath = new File(truststoreFile).getAbsolutePath();
        char[] truststorePass = truststorePassword.toCharArray();
        String keystoreFile = Objects.requireNonNull(Client.class.getClassLoader().getResource(keystore)).getFile();
        String keystorePath = new File(keystoreFile).getAbsolutePath();
        char[] keystorePass = keystorePassword.toCharArray();
        String trustedCertFile = Objects.requireNonNull(Client.class.getClassLoader().getResource(trustedCert)).getFile();
        String trustedCertPath = new File(trustedCertFile).getAbsolutePath();
        String privateKeyFile = Objects.requireNonNull(Client.class.getClassLoader().getResource(privateKey)).getFile();
        String privateKeyPath = new File(privateKeyFile).getAbsolutePath();
        String publicCertFile = Objects.requireNonNull(Client.class.getClassLoader().getResource(publicCert)).getFile();
        String publicCertPath = new File(publicCertFile).getAbsolutePath();

        // Option 1: Trust all certificates
        SSLContext sslDisabledSslContext = initSslContext();
        sendRequest(sslDisabledSslContext);

        // Option 2: Provide truststore and it's password
        SSLContext truststoreSslContext = initSslContext(truststorePath, truststorePass);
        sendRequest(truststoreSslContext);

        // Option 3: Provide trusted certificate file
        SSLContext trustedCertSslContext = initSslContext(trustedCertPath);
        sendRequest(trustedCertSslContext);

        // Option 4: Provide truststore, it's password and keystore, it's password for mTLS
        SSLContext mTlsSslContext1 = initSslContext(truststorePath, truststorePass, keystorePath, keystorePass);
        sendRequest(mTlsSslContext1);

        // Option 5: Provide trusted certificate file, private key and public certificate for mTLS
        SSLContext mTlsSslContext2 = initSslContext(trustedCertPath, publicCertPath, privateKeyPath, "");
        sendRequest(mTlsSslContext2);
    }

    // Init SSLContext by trusting all the certificates
    private static SSLContext initSslContext() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts, new SecureRandom());
        return sslContext;
    }

    // Init SSLContext with provided truststore and it's password
    private static SSLContext initSslContext(String truststorePath, char[] truststorePassword) throws Exception {
        try (FileInputStream is = new FileInputStream(truststorePath)) {
            KeyStore truststore = KeyStore.getInstance("PKCS12");
            truststore.load(is, truststorePassword);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(truststore);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());
            return sslContext;
        }
    }

    // Init SSLContext with provided trusted certificate file
    private static SSLContext initSslContext(String trustedCertPath) throws Exception {
        X509Certificate trustedCert = PublicKey.decodeX509PublicCertificate(trustedCertPath);
        KeyStore truststore = KeyStore.getInstance("PKCS12");
        truststore.load(null, "".toCharArray());
        truststore.setCertificateEntry(UUID.randomUUID().toString(), trustedCert);
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(truststore);
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());
        return sslContext;
    }

    // Init SSLContext with provided truststore, it's password and keystore, it's password for mTLS
    private static SSLContext initSslContext(String truststorePath, char[] truststorePassword, String keystorePath,
                                             char[] keystorePassword) throws Exception {
        try (FileInputStream truststoreIs = new FileInputStream(truststorePath);
             FileInputStream keystoreIs = new FileInputStream(keystorePath)) {
            KeyStore truststore = KeyStore.getInstance("PKCS12");
            truststore.load(truststoreIs, truststorePassword);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(truststore);

            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(keystoreIs, keystorePassword);
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore, keystorePassword);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
            return sslContext;
        }
    }

    // Init SSLContext with provided trusted certificate file, private key and public certificate for mTLS
    private static SSLContext initSslContext(String trustedCertPath, String publicCertPath, String privateKeyPath,
                                             String privateKeyPassword) throws Exception {
        X509Certificate trustedCert = PublicKey.decodeX509PublicCertificate(trustedCertPath);
        KeyStore truststore = KeyStore.getInstance("PKCS12");
        truststore.load(null, "".toCharArray());
        truststore.setCertificateEntry(UUID.randomUUID().toString(), trustedCert);
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(truststore);

        Security.addProvider(new BouncyCastleProvider());
        java.security.PrivateKey privateKey;
        if (privateKeyPassword == null || privateKeyPassword.isBlank()) {
            privateKey = PrivateKey.decodePkcs8PrivateKey(privateKeyPath);
        } else {
            privateKey = PrivateKey.decodePkcs8EncryptedPrivateKey(privateKeyPath, privateKeyPassword.toCharArray());
        }
        X509Certificate publicCert = PublicKey.decodeX509PublicCertificate(publicCertPath);
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, "".toCharArray());
        keyStore.setKeyEntry(UUID.randomUUID().toString(), privateKey, "".toCharArray(),
                             new X509Certificate[]{publicCert});
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "".toCharArray());

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), new SecureRandom());
        return sslContext;
    }

    // Send HTTP request with provided SSLContext
    private static void sendRequest(SSLContext sslContext) throws Exception {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .sslContext(sslContext)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:9090/foo/bar"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}
