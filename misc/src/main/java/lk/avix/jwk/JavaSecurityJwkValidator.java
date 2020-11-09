package lk.avix.jwk;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class JavaSecurityJwkValidator {

    public static void main(String[] args) throws Exception {
        String modulus = "luZFdW1ynitztkWLC6xKegbRWxky-5P0p4ShYEOkHs30QI2VCuR6Qo4Bz5rTgLBrky03W1GAVrZxuvKRGj9V9-Pmjd" +
                "Gtau4CTXu9pLLcqnruaczoSdvBYA3lS9a7zgFU0-s6kMl2EhB-rk7gXluEep7lIOenzfl2f6IoTKa2fVgVd3YKiSGsyL4tztS70" +
                "vmmX121qm0sTJdKWP4HxXyqK9neolXI9fYyHOYILVNZ69z_73OOVhkh_mvTmWZLM7GM6sApmyLX6OXUp8z0pkY-vT_9-zRxxQs7" +
                "GurC4_C1nK3rI_0ySUgGEafO1atNjYmlFN-M3tZX6nEcA6g94IavyQ";
        String exponent = "AQAB";
        RSAPublicKey publicKey = getPublicKey(modulus, exponent);
        assert (publicKey.getAlgorithm().equals("RSA"));    // Need to set the `-ea` (Enable Assertions) in JVM options.

        String jwt = "eyJ4NXQiOiJOVEF4Wm1NeE5ETXlaRGczTVRVMVpHTTBNekV6T0RKaFpXSTRORE5sWkRVMU9HRmtOakZpTVEiLCJraWQiO" +
                "iJOVEF4Wm1NeE5ETXlaRGczTVRVMVpHTTBNekV6T0RKaFpXSTRORE5sWkRVMU9HRmtOakZpTVEiLCJhbGciOiJSUzI1NiJ9.ey" +
                "JzdWIiOiJhZG1pbkBjYXJib24uc3VwZXIiLCJhdWQiOiJ2RXd6YmNhc0pWUW0xalZZSFVIQ2poeFo0dFlhIiwibmJmIjoxNTg3" +
                "NDc1Njk0LCJhenAiOiJ2RXd6YmNhc0pWUW0xalZZSFVIQ2poeFo0dFlhIiwiaXNzIjoiaHR0cHM6XC9cL2xvY2FsaG9zdDo5ND" +
                "QzXC9vYXV0aDJcL3Rva2VuIiwiZXhwIjoxNTg3NDc1NzA0LCJpYXQiOjE1ODc0NzU2OTQsImp0aSI6ImZmMTk3NmI0LTU0MmYt" +
                "NDgxNC1iOGNlLTg0ODNhNGYxZWE5ZiJ9.VHXgtU72omIibSfwuggIXhykivfAncUFF5-mCCrrVwRBNWpd2KEVBqizGU_onCdNo" +
                "SsJOc608d-2Tq77ZzJkq7RXPRTxdim4lHkL9PgJpuJzbbk7-c9z3Zd10Kd7n_BuiiUCqJxQQTvfwAShjl6pHd-Z6bqBTdIPDBg" +
                "hJnTmGgEydWDBzvl8zsUPZJAUFHLlKUBIW8Qy0tC7NpUnPWyYoXdFf0hpkQi0h58fTG9iMr-30mlFJgBRjsanbBQEemWXokZ6T" +
                "uam1DQAQB9-Tsxk1TQ5GRyMKcsD2gWt-aJsyRLtXSwmgsUxTyA6VCLlF9oJuMxg-hQKxiDS1RSXHReczw";

        boolean status = validateJwtSignature(jwt, publicKey);
        assert (status);    // Need to set the `-ea` (Enable Assertions) in JVM options.
    }

    private static RSAPublicKey getPublicKey(String modulus, String exponent) throws Exception {
//        byte[] decodedModulus = Base64.decodeBase64(modulus);
//        byte[] decodedExponent = Base64.decodeBase64(exponent);
        byte[] m = Base64.getUrlDecoder().decode(modulus);
        byte[] e = Base64.getUrlDecoder().decode(exponent);
        RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(1, m),
                                                     new BigInteger(1, e));
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(spec);
    }

    private static boolean validateJwtSignature(String jwt, RSAPublicKey publicKey) throws Exception {
        String[] jwtParts = jwt.split("\\.");
        String base64UrlEncodedHeader = jwtParts[0];
        String base64UrlEncodedPayload = jwtParts[1];
        String base64UrlEncodedSignature = jwtParts[2];

        String data = base64UrlEncodedHeader + "." + base64UrlEncodedPayload;
        byte[] base64UrlDecodedSignature = java.util.Base64.getUrlDecoder().decode(base64UrlEncodedSignature);

        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(publicKey);
        sig.update(data.getBytes());
        return sig.verify(base64UrlDecodedSignature);
    }
}
