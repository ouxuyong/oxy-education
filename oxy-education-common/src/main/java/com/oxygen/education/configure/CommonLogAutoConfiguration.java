package com.oxygen.education.configure;

import com.oxygen.education.aspect.MethodLogAspect;
import com.oxygen.education.aspect.TestAspect;
import com.oxygen.education.aspect.WebLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author konakona
 * @date 2021/4/24 01:22
 * @功能：
 */
@Slf4j
@ComponentScan("com.oxygen")
public class CommonLogAutoConfiguration {
    public CommonLogAutoConfiguration() {
        log.info("启动了自定义配置类");
    }

    @Bean
    @ConditionalOnWebApplication
    @ConditionalOnMissingBean(MethodLogAspect.class)
    @ConditionalOnExpression(" ${education-common.methodLog.enabled:false}")
    public MethodLogAspect methodLogAspect() {
        log.info("注入方法日志切面类");
        return new MethodLogAspect();
    }

    @Bean
    @ConditionalOnWebApplication
    @ConditionalOnMissingBean(WebLogAspect.class)
    @ConditionalOnExpression(" ${education-common.webLog.enabled:false}")
    public WebLogAspect webLogAspect() {
        log.info("注入web日志切面类");
        return new WebLogAspect();
    }
    @Bean
    @ConditionalOnWebApplication
    @ConditionalOnMissingBean(TestAspect.class)
    public TestAspect testAspect() {
        log.info("注入测试日志切面类");
        return new TestAspect();
    }

}
