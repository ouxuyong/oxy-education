package com.oxygen.education.constant;

/**
 * 系统错误码和提示语
 * @author oxy
 */
public class SystemErrorCode {
    public static final Integer SYSTEM_ERROR = -1;
    public static final Integer REQUEST_PARAM_ERROR = -2;
    public static final Integer REQUEST_METHOD_ERROR = -3;
    public static final Integer FEIGN_HYSTRIX_ERROR = -500;

    public static final String REQUEST_ERROE_MSG = "请求无效";
    public static final String REQUEST_PARAMS_ERROE_MSG = "请求参数无效";
    public static final String DATA_NULL_ERROR_MSG = "查询数据为空";
    public static final String FEIGN_HYSTRIX_ERROR_MSG = "服务不可用请稍后重试";
    public static final String SYSTEM_ERROR_MSG = "系统异常";

}