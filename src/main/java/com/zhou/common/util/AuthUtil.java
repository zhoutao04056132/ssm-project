package com.zhou.common.util;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.StringUtils;

public class AuthUtil {
    // 用于接口层对token等header参数验证，因为对于游客用户某些接口不需要在拦截器验证，但是在接口层仍需要验证权限以控制返回数据
    public static boolean verifyAuth(String token, String name, String userIdStr) throws Exception{
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(name) || StringUtils.isEmpty(userIdStr)) {
            return false;
        }

        DecodedJWT jwt = JwtUtil.verify(token);
        if (null == jwt) {
            return false;
        }

        if (!jwt.getClaim("name").asString().equals(name)) {
            return false;
        }

        if (!jwt.getClaim("userId").asString().equals(userIdStr)) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime >= jwt.getExpiresAt().getTime()) {
            return false;
        }

        return true;
    }
}
