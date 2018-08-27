package com.example.demo.common;

public class ErrorInfo<T> {

    private static Integer OK = 200;
    private static Integer Error = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;

    public static Integer getOK() {
        return OK;
    }

    public static void setOK(Integer OK) {
        ErrorInfo.OK = OK;
    }

    public static Integer getError() {
        return Error;
    }

    public static void setError(Integer error) {
        Error = error;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
