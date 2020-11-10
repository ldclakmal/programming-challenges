package lk.avix.jwk;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class JavaSecurityJwkValidator {

    public static void main(String[] args) throws Exception {
        String modulus = "AIFcoun1YlS4mShJ8OfcczYtZXGIes_XWZ7oPhfYCqhSIJnXD3vqrUu4GXNY2E41jAm8dd7BS5GajR3g1GnaZrSqN" +
                "0w3bjpdbKjOnM98l2-i9-JP5XoedJsyDzZmml8Xd7zkKCuDqZIDtZ99poevrZKd7Gx5n2Kg0K5FStbZmDbTyX30gi0_griIZyV" +
                "CXKOzdLp2sfskmTeu_wF_vrCaagIQCGSc60Yurnjd0RQiMWA10jL8axJjnZ-IDgtKNQK_buQafTedrKqhmzdceozSot231I9dt" +
                "h7uXvmPSjpn23IYUIpdj_NXCIt9FSoMg5-Q3lhLg6GK3nZOPuqgGa8TMPs=";
        String exponent = "AQAB";
        RSAPublicKey publicKey = getPublicKey(modulus, exponent);
        assert (publicKey.getAlgorithm().equals("RSA"));    // Need to set the `-ea` (Enable Assertions) in JVM options.

        String jwt = "eyJhbGciOiJSUzI1NiIsICJ0eXAiOiJKV1QiLCAia2lkIjoiTlRBeFptTXhORE15WkRnM01UVTFaR00wTXpFek9ESmhaV" +
                "0k0TkRObFpEVTFPR0ZrTmpGaU1RIn0.eyJzdWIiOiJhZG1pbiIsICJpc3MiOiJiYWxsZXJpbmEiLCAiZXhwIjoxOTA3NjY1NzQ" +
                "2LCAianRpIjoiMTAwMDc4MjM0YmEyMyIsICJhdWQiOlsidkV3emJjYXNKVlFtMWpWWUhVSENqaHhaNHRZYSJdfQ.E8E7VO18V6" +
                "MG7Ns87Y314Dqg8RYOMe0WWYlSYFhSv0mHkJQ8bSSyBJzFG0Se_7UsTWFBwzIALw6wUiP7UGraosilf8k6HGJWbTjWtLXfniJX" +
                "x5NczikzciG8ADddksm-0AMi5uPsgAQdg7FNaH9f4vAL6SPMEYp2gN6GDnWTH7M1vnknwjOwTbQpGrPu_w2V1tbsBwSzof3Fk_" +
                "cYrntu8D_pfsBu3eqFiJZD7AXUq8EYbgIxpSwvdi6_Rvw2_TAi46drouxXK2Jglz_HvheUVCERT15Y8JNJONJPJ52MsN6t297h" +
                "yFV9AmyNPzwHxxmi753TclbapDqDnVPI1tpc-Q";

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
