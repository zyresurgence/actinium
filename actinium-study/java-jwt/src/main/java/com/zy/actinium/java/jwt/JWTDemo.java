package com.zy.actinium.java.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author Neo
 */
public class JWTDemo {

    @Test
    public void createJWT() {
        String secret = "Resurgence";
        String jti = "Resurgence";
        String iss = "Resurgence";
        String typ = "JWT";
        Algorithm alg = Algorithm.HMAC256(secret);


        Map<String, Object> headerMap = new HashMap<>(3);
        headerMap.put("typ", typ);
        headerMap.put("alg", alg);
        headerMap.put("jti", jti);

        Map<String, Object> payLoadMap = new HashMap<>(1);
        payLoadMap.put("iss", iss);

        String jwt = JWT.create()
                .withHeader(headerMap)
                .withPayload(payLoadMap)
                .sign(alg);

        System.out.println("jwt: " + jwt);
    }

    @Test
    public void verifyJWT() {
        String secret = "Resurgence";
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiIsImp0aSI6IlJlc3VyZ2VuY2UifQ.eyJpc3MiOiJSZXN1cmdlbmNlIn0.xOkFuKaHBe83dDlTMxERLGxduVgK92EWSE-GQOggdYY";
        DecodedJWT verify = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token);
        String header = verify.getHeaderClaim("typ").asString();
        String payload = verify.getClaim("iss").asString();

        System.out.println(header);
        System.out.println(payload);
    }
}
