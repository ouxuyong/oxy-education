package com.oxygen.education.config;

import com.oxygen.education.interceptor.CustomizeHeaderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器适配器配置
 * @author oxy
 */
@Configuration
@Component
public class InterceptorAdapterConfig implements WebMvcConfigurer {

    @Autowired
    private CustomizeHeaderInterceptor clearHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(clearHandlerInterceptor);
    }
}
