package lk.avix.key;

import lk.avix.http.Client;

import java.io.File;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;

public class PublicKey {

    private static final String certFile = "x509Public.crt";

    public static void main(String[] args) throws Exception {
        String file = Objects.requireNonNull(Client.class.getClassLoader().getResource(certFile)).getFile();
        String path = new File(file).getAbsolutePath();
        X509Certificate certificate = decodeX509PublicCertificate(path);
        java.security.PublicKey publicKey = certificate.getPublicKey();
        System.out.println("X509 Public Key Algorithm: " + publicKey.getAlgorithm());
    }

    public static X509Certificate decodeX509PublicCertificate(String filePath) throws Exception {
        FileInputStream is = new FileInputStream(filePath);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return (X509Certificate) certificateFactory.generateCertificate(is);
    }
}
