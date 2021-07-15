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

    private static final String encryptedPrivateKey = "encryptedPrivate.key";
    private static final String encryptedKeyPair = "eEncryptedKeyPair.pem";
    private static final String privateKey = "private.key";
    private static final String keyPassword = "ballerina";

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String encryptedPrivateKeyFilePath = Objects.requireNonNull(
                Client.class.getClassLoader().getResource(encryptedPrivateKey)).getFile();
        String encryptedKeyPairFilePath = Objects.requireNonNull(
                Client.class.getClassLoader().getResource(encryptedKeyPair)).getFile();
        String privateKeyFilePath = Objects.requireNonNull(
                Client.class.getClassLoader().getResource(privateKey)).getFile();
        char[] passphrase = keyPassword.toCharArray();
        java.security.PrivateKey privateKey1 = decodeEncryptedPrivateKey(encryptedPrivateKeyFilePath, passphrase);
        java.security.PrivateKey privateKey2 = decodeEncryptedKeyPair(encryptedKeyPairFilePath, passphrase);
        java.security.PrivateKey privateKey3 = decodePrivateKey(privateKeyFilePath);
        System.out.println("Private Key 1 Algorithm: " + privateKey1.getAlgorithm());
        System.out.println("Private Key 2 Algorithm: " + privateKey2.getAlgorithm());
        System.out.println("Private Key 3 Algorithm: " + privateKey3.getAlgorithm());
    }

    public static java.security.PrivateKey decodeEncryptedPrivateKey(String keyPath, char[] keyPassphrase) throws Exception {
        File privateKeyFile = new File(keyPath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        InputDecryptorProvider decryptorProvider = new JcePKCSPBEInputDecryptorProviderBuilder()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME).build(keyPassphrase);
        PrivateKeyInfo privateKeyInfo = ((PKCS8EncryptedPrivateKeyInfo) obj).decryptPrivateKeyInfo(decryptorProvider);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        return converter.getPrivateKey(privateKeyInfo);
    }

    private static java.security.PrivateKey decodeEncryptedKeyPair(String keyPath, char[] keyPassphrase) throws Exception {
        File privateKeyFile = new File(keyPath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        PEMDecryptorProvider decryptorProvider = new JcePEMDecryptorProviderBuilder()
                .setProvider(BouncyCastleProvider.PROVIDER_NAME).build(keyPassphrase);
        PEMKeyPair pemKeyPair = ((PEMEncryptedKeyPair) obj).decryptKeyPair(decryptorProvider);
        PrivateKeyInfo privateKeyInfo = pemKeyPair.getPrivateKeyInfo();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        return converter.getPrivateKey(privateKeyInfo);
    }

    public static java.security.PrivateKey decodePrivateKey(String keyPath) throws Exception {
        File privateKeyFile = new File(keyPath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) obj;
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        return converter.getPrivateKey(privateKeyInfo);
    }
}
