package com.zy.nimbus.jose.jwt;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.AESEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.zy.util.security.SecureRandomUtils;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Neo
 */
public class JWTDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTDemo.class);

    @Test
    public void createJWE() throws JOSEException {
        JWEAlgorithm alg = JWEAlgorithm.A256KW;
        EncryptionMethod enc = EncryptionMethod.A256GCM;
        String base64SecretKey = "icNfEfJBbipYJcSE+KFplO3otO1M5sBbBUOfo8LrMKU=";
        byte[] bytes = Base64.decodeBase64(base64SecretKey);

        JWEHeader header = new JWEHeader(alg, enc);

        JWTClaimsSet.Builder claimsSetBuilder = new JWTClaimsSet.Builder();
        claimsSetBuilder.issuer("resurgence");
        JWTClaimsSet claimsSet = claimsSetBuilder.build();
        System.out.println(bytes.length);

        AESEncrypter encrypter = new AESEncrypter(bytes);

        EncryptedJWT encryptedJWT = new EncryptedJWT(header, claimsSet);
        encryptedJWT.encrypt(encrypter);
        String jwt = encryptedJWT.serialize();
        LOGGER.info(jwt);
    }


    @Test
    public void generateSecretKey() {
        byte[] secretKey = new byte[32];
        SecureRandomUtils.nextBytes(secretKey);
        String base64SecretKey = Base64.encodeBase64String(secretKey);
        LOGGER.info(base64SecretKey);
    }
}
