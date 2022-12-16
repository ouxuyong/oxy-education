package com.oxygen.education.response;

import com.oxygen.education.constant.SystemErrorCode;
import com.oxygen.education.exception.OxyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author konakona
 * @date 2021/5/7 18:23
 * @功能：
 */

@Slf4j
@Order(100)
@RestControllerAdvice
@ConditionalOnExpression("${education-common.aspect.enabled:false}")
public class ResponseAdvice implements ResponseBodyAdvice {
    private final static String ERROR = "error";

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return filter(returnType);
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {

        //如果是OxyResponse类型直接返回
        if (o instanceof OxyResponse) {
            return o;
        }
        if(ERROR.equals(returnType.getMethod().getName())){
            return o;
        }
        //封装实体
        return OxyResponse.success(o);
    }

    private Boolean filter(MethodParameter methodParameter) {

        if (methodParameter.getGenericParameterType().equals(OxyResponse.class)) {
            return false;
        }
        return true;
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public OxyResponse exceptionHandler(MethodArgumentNotValidException e) {
        log.error("handler --- MethodArgumentNotValidException --- {}", e);

        return OxyResponse.fail(-1, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(OxyException.class)
    public OxyResponse oxyException(OxyException exception) {
        log.error("oxyException", exception);
        return OxyResponse.fail(exception.getCode(), exception.getMsg());
    }

    /***
     *统一拦截异常
     * @param exception
     */
    @ExceptionHandler(Exception.class)
    public OxyResponse exception(Exception exception) {
        log.error("exception", exception);
        return OxyResponse.fail(SystemErrorCode.SYSTEM_ERROR, SystemErrorCode.SYSTEM_ERROR_MSG);
    }

}
