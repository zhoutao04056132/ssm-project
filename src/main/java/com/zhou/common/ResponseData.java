package com.zhou.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口响应类
 */
public class ResponseData {
    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public ResponseData() {

    }

    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ResponseData putDataValue(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public static ResponseData ok() {
        return new ResponseData(200, "Ok");
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData(401, "unauthorized");
    }

    public static ResponseData expired() {
        return new ResponseData(405, "token expired");
    }

    public static ResponseData uncorrectUserId() {
        return new ResponseData(406, "uncorrectUserId");
    }

    public static ResponseData uncorrectName() {
        return new ResponseData(407, "uncorrectName");
    }

    public static ResponseData loginFail() {
        return new ResponseData(408, "loginFail");
    }


    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error");
    }

    public static ResponseData customerError() {
        return new ResponseData(1001, "customer Error");
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
