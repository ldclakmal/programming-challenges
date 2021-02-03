package lk.avix.key;

import lk.avix.http.Client;

import java.io.File;
import java.io.FileInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Objects;

public class PublicKey {

    private static final String certFile = "public.crt";

    public static void main(String[] args) throws Exception {
        String file = Objects.requireNonNull(Client.class.getClassLoader().getResource(certFile)).getFile();
        String path = new File(file).getAbsolutePath();
        FileInputStream is = new FileInputStream(path);
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) certificateFactory.generateCertificate(is);
        java.security.PublicKey publicKey = certificate.getPublicKey();
        System.out.println(publicKey.getAlgorithm());
    }
}
