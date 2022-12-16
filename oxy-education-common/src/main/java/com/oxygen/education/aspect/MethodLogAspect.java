package com.oxygen.education.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 * @author oxy
 */
@Slf4j
@Aspect
@Component
public class MethodLogAspect extends AbstractLogAspect{

    /**
     * 切入点
     * 子类可以重写
     */
    @Pointcut("(@annotation(com.oxygen.education.annotation.LogAspect))")
    protected void webLog() {

    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     */
    @Around(value = "webLog()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        return doAround(proceedingJoinPoint);
    }

}
