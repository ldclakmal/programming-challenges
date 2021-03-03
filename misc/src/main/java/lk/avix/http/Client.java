package lk.avix.http;

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
import java.security.cert.X509Certificate;
import java.util.Objects;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class Client {

    private static final boolean sslDisable = false;
    private static final String truststore = "ballerinaTruststore.p12";
    private static final String password = "ballerina";

    public static void main(String[] args) throws Exception {
        SSLContext sslContext;
        if (sslDisable) {
            sslContext = initSslContext();
        } else {
            String file = Objects.requireNonNull(Client.class.getClassLoader().getResource(truststore)).getFile();
            String path = new File(file).getAbsolutePath();
            sslContext = initSslContext(path, password);
        }
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .sslContext(sslContext)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://localhost:9090/oauth2/jwks"))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }

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

    private static SSLContext initSslContext(String path, String password) throws Exception {
        try (FileInputStream is = new FileInputStream(path)) {
            char[] passphrase = password.toCharArray();
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(is, passphrase);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            tmf.init(ks);
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());
            return sslContext;
        }
    }
}
