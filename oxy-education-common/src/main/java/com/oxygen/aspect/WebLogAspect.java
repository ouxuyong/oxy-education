package com.oxygen.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志切面
 * @author oxy
 */
@Slf4j
@Aspect
public class WebLogAspect extends AbstractLogAspect{

    /**
     * 切入点
     * 子类可以重写
     */
    @Pointcut(
            "@target(org.springframework.web.bind.annotation.RestController) && " +
                    "(@annotation(org.springframework.web.bind.annotation.RequestMapping) || " +
                    "@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
                    "@annotation(org.springframework.web.bind.annotation.DeleteMapping) || " +
                    "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
                    "@annotation(org.springframework.web.bind.annotation.PostMapping)&& !@annotation(com.oxygen.annotation.IgnoreLogAspect))"
    )
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
