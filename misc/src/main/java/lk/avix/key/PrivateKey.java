package lk.avix.key;

import lk.avix.http.Client;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMDecryptorProvider;
import org.bouncycastle.openssl.PEMEncryptedKeyPair;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.pkcs.jcajce.JcePKCSPBEInputDecryptorProviderBuilder;

import java.io.File;
import java.io.FileReader;
import java.security.Security;
import java.util.Objects;

public class PrivateKey {

    private static final String pkcs8EncryptedPrivateKey = "pkcs8EncryptedPrivate.key";
    private static final String pkcs1EncryptedPrivateKey = "pkcs1EncryptedPrivate.key";
    private static final String pkcs8PrivateKey = "pkcs8Private.key";
    private static final String keyPassword = "ballerina";

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String pkcs8EncryptedFilePath = Objects.requireNonNull(
                Client.class.getClassLoader().getResource(pkcs8EncryptedPrivateKey)).getFile();
        String pkcs1EncryptedFilePath = Objects.requireNonNull(
                Client.class.getClassLoader().getResource(pkcs1EncryptedPrivateKey)).getFile();
        String pkcs8FilePath = Objects.requireNonNull(
                Client.class.getClassLoader().getResource(pkcs8PrivateKey)).getFile();
        java.security.PrivateKey pkcs8EncryptedPrivateKey = decodePkcs8EncryptedPrivateKey(pkcs8EncryptedFilePath);
        java.security.PrivateKey pkcs1EncryptedPrivateKey = decodePkcs1EncryptedPrivateKey(pkcs1EncryptedFilePath);
        java.security.PrivateKey pkcs8PrivateKey = decodePkcs8PrivateKey(pkcs8FilePath);
        System.out.println("PKCS8 Encrypted Private Key Algorithm: " + pkcs8EncryptedPrivateKey.getAlgorithm());
        System.out.println("PKCS1 Encrypted Private Key Algorithm: " + pkcs1EncryptedPrivateKey.getAlgorithm());
        System.out.println("PKCS8 Private Key Algorithm: " + pkcs8PrivateKey.getAlgorithm());
    }

    private static java.security.PrivateKey decodePkcs8EncryptedPrivateKey(String filePath) throws Exception {
        File privateKeyFile = new File(filePath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        InputDecryptorProvider decryptorProvider = new JcePKCSPBEInputDecryptorProviderBuilder()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME).build(keyPassword.toCharArray());
        PrivateKeyInfo privateKeyInfo = ((PKCS8EncryptedPrivateKeyInfo) obj).decryptPrivateKeyInfo(decryptorProvider);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        return converter.getPrivateKey(privateKeyInfo);
    }

    private static java.security.PrivateKey decodePkcs1EncryptedPrivateKey(String filePath) throws Exception {
        File privateKeyFile = new File(filePath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        PEMDecryptorProvider decryptorProvider = new JcePEMDecryptorProviderBuilder()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME).build(keyPassword.toCharArray());
        PEMKeyPair pemKeyPair = ((PEMEncryptedKeyPair) obj).decryptKeyPair(decryptorProvider);
        PrivateKeyInfo privateKeyInfo = pemKeyPair.getPrivateKeyInfo();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        return converter.getPrivateKey(privateKeyInfo);
    }

    public static java.security.PrivateKey decodePkcs8PrivateKey(String filePath) throws Exception {
        File privateKeyFile = new File(filePath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) obj;
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        return converter.getPrivateKey(privateKeyInfo);
    }
}
