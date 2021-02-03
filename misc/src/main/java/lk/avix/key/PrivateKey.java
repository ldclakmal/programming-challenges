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

import java.io.File;
import java.io.FileReader;
import java.security.Security;
import java.util.Objects;

public class PrivateKey {

    private static final String keyFile = "encrypted-private.key";
//    private static final String keyFile = "private.key";
    private static final String keyPassword = "ballerina";

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String filePath = Objects.requireNonNull(Client.class.getClassLoader().getResource(keyFile)).getFile();
        File privateKeyFile = new File(filePath);
        PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
        Object obj = pemParser.readObject();
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
        PrivateKeyInfo privateKeyInfo;
        if (obj instanceof PEMEncryptedKeyPair) {
            PEMDecryptorProvider decryptorProvider = new JcePEMDecryptorProviderBuilder().build(
                    keyPassword.toCharArray());
            PEMKeyPair pemKeyPair = ((PEMEncryptedKeyPair) obj).decryptKeyPair(decryptorProvider);
            privateKeyInfo = pemKeyPair.getPrivateKeyInfo();
        } else {
            privateKeyInfo = (PrivateKeyInfo) obj;
        }
        java.security.PrivateKey privateKey = converter.getPrivateKey(privateKeyInfo);
        System.out.println(privateKey.getAlgorithm());
    }
}
