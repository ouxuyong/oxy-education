package com.oxygen.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 返回体
 *
 * @author oxy
 */

public class OxyResponse<T> {
    /**
     * 状态码 0为成功，否则为失败
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 响应数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
    /**
     * 分页信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OxyResPage page;

    /**
     * 成功封装
     * @param data
     * @param <T>
     * @return
     */
    @JsonIgnore
    public static <T> OxyResponse<T> success(T data) {
        return new OxyResponse<T>(0, "ok", data);
    }

    /**
     * 失败封装
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    @JsonIgnore
    public static <T> OxyResponse<T> fail(Integer code, String msg) {
        return fail(code, msg, null);
    }


    public OxyResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public OxyResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public OxyResponse(Integer code, String msg, T data, OxyResPage page) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.page = page;
    }

    @JsonIgnore
    public static <T> OxyResponse<T> success() {
        return new OxyResponse<T>(0, "ok");
    }

    @JsonIgnore
    public static <T> OxyResponse<T> success(String msg) {
        return new OxyResponse<T>(0, msg);
    }



    @JsonIgnore
    public static <T> OxyResponse<T> success(T data, OxyResPage page) {
        return new OxyResponse<T>(0, "ok", data, page);
    }

    @JsonIgnore
    public static <T> OxyResponse<T> success(String msg, T data) {
        return new OxyResponse<T>(0, msg, data);
    }

    @JsonIgnore
    public static <T> OxyResponse<T> successData(T data) {
        return new OxyResponse<T>(0, "", data);
    }

    @JsonIgnore
    public static <T> OxyResponse<T> success(String msg, T data, OxyResPage page) {
        return new OxyResponse<T>(0, msg, data, page);
    }



    @JsonIgnore
    public static <T> OxyResponse<T> fail(Integer code, String msg, T data) {
        return new OxyResponse<T>(code, msg, data);
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public OxyResPage getPage() {
        return page;
    }

    @Override
    public String toString() {
        return "OxyResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", page=" + page +
                '}';
    }
}
//@JsonInclude(JsonInclude.Include.NON_NULL)