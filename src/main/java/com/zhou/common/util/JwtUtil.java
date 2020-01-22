package com.zhou.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 */
public class JwtUtil {
    // 设置过期时间
    private static final long EXPIRE_TIME = 20 * 60 * 1000;
    // 设置加密私钥
    private static final String TOKEN_SECRET = "112b3c4d5e6f7g8h9i";

    /**
     * 生成token方法
     * @param name
     * @param userId
     * @return
     */
    public static String sign(String name, String userId) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");

            return JWT.create()
                    .withHeader(header)
                    .withClaim("name", name)
                    .withClaim("userId", userId)
                    .withExpiresAt(expireDate)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    /**
     * 解密token
     * @param token
     * @return
     */
    public static DecodedJWT verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();

            return verifier.verify(token);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
