package com.oxygen.education.interceptor;

import com.oxygen.education.context.OxygenContextHolder;
import com.oxygen.education.filter.CustomizeHeaderFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清除ThreadLocal
 * @author oxy
 */
@Slf4j
@ConditionalOnBean(CustomizeHeaderFilter.class)
@Order(Integer.MIN_VALUE)
public class CustomizeHeaderInterceptor extends HandlerInterceptorAdapter {

    private static final String FORBIDDEN_URL ="asyncTestAdverse";

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        if(!request.getRequestURI().contains(FORBIDDEN_URL)){
            OxygenContextHolder.clearOxyContext();
            log.info("主线程 {} 清除ThreadLocal",Thread.currentThread().getName());
        }
    }
}
