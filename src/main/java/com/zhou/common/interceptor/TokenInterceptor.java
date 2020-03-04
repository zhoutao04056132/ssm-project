package com.zhou.common.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhou.common.util.JwtUtil;
import com.zhou.common.ResponseData;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("accessToken");
        String name = request.getHeader("name");
        System.out.println("name:" + name);
        String userIdStr = request.getHeader("userId");
        System.out.println("userId:" + userIdStr);
        ResponseData responseData = null;
        if (StringUtils.isEmpty(token)) {
            responseData = ResponseData.unAuthorized();
            responseMessage(response, response.getWriter(), responseData);
            return false;
        }

        DecodedJWT jwt = JwtUtil.verify(token);
        if (null == jwt) {
            responseData = ResponseData.unAuthorized();
            responseMessage(response, response.getWriter(), responseData);
            return false;
        }

        if (!jwt.getClaim("name").asString().equals(name)) {
            responseData = ResponseData.unCorrectName();
            responseMessage(response, response.getWriter(), responseData);
            System.out.println("success name test!");
            return false;
        }

        if (!jwt.getClaim("userId").asString().equals(userIdStr)) {
            responseData = ResponseData.unCorrectUserId();
            responseMessage(response, response.getWriter(), responseData);
            System.out.println("success userId test!");
            return false;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime >= jwt.getExpiresAt().getTime()) {
            responseData = ResponseData.expired();
            responseMessage(response, response.getWriter(), responseData);
            System.out.println("success expire test!");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }

    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }
}
