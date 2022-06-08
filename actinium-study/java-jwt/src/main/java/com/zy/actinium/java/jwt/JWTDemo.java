package com.zy.actinium.java.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author Neo
 */
public class JWTDemo {
    @Test
    public void getJWT(){
        String secret = "Resurgence";
        String jti = "Resurgence";
        String iss = "Resurgence";
        String typ = "JWT";
        Algorithm alg = Algorithm.HMAC256(secret);

        JWTCreator.Builder builder = JWT.create();

        Map<String, Object> headerMap = new HashMap<>(3);
        headerMap.put("typ", typ);
        headerMap.put("alg", alg);
        headerMap.put("jti", jti);
        builder.withHeader(headerMap);

        Map<String, Object> payLoadMap = new HashMap<>(1);
        payLoadMap.put("iss", iss);
        builder.withPayload(payLoadMap);

        String jwt = builder.sign(alg);
        System.out.println("jwt: " + jwt);
    }
}
