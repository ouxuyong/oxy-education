package com.oxygen.education.aspect;

import com.oxygen.education.annotation.Encryption;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Base64;

/**
 * 测试界面类
 * @author oxy
 */
@Slf4j
@Aspect
public class TestAspect {


    @Around(value = "(@annotation(com.oxygen.education.annotation.Encryption))")
    public Object before(ProceedingJoinPoint joinPoint) throws Throwable {
        if(!(joinPoint.getSignature() instanceof MethodSignature)){
            return joinPoint.proceed();
        }
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();

        Encryption encryption = method.getAnnotation(Encryption.class);
        if (encryption == null) {
            return joinPoint.proceed();
        }
        String[] parameterNames = methodSignature.getParameterNames();

        int index = getEncryptionIndex(parameterNames,encryption.value());
        if(index == -1){
            log.error("获取加密索引失败");
            return joinPoint.proceed();
        }
        Object[] args = joinPoint.getArgs();
        args[index] = encryption((String)args[index]);
        return joinPoint.proceed(args);
    }

    /**
     * 获取目标字段的索引
     * @param parameterNames
     * @param encryptionKey
     * @return
     */
    private int getEncryptionIndex(String[] parameterNames,String encryptionKey){
        for(int i = 0; i < parameterNames.length;i++){
            if(encryptionKey.equals(parameterNames[i])){
                return i;
            }
        }
        return -1;
    }

    /**
     * 加密
     * @param value
     * @return
     */
    private String encryption(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
}
