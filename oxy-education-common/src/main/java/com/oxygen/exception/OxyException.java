package com.oxygen.exception;

/**
 * 自定义异常
 * @author oxy
 */
public class OxyException extends RuntimeException {
    private Integer code;
    private String msg;

    public OxyException(Integer code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    @Override
    public String toString() {
        return "OxyException{code=" + this.code + ", msg=" + this.msg + '}';
    }
}