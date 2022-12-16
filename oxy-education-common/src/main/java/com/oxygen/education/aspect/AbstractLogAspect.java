package com.oxygen.education.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oxygen.education.annotation.LogAspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
/**
 * 日志切面抽象类
 * @author oxy
 */
@Slf4j
public abstract class AbstractLogAspect {

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     */
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StringBuilder stringBuilder = new StringBuilder(getRequestLogFullInfo(proceedingJoinPoint));

        long startTime = System.currentTimeMillis();
        //执行目标方法
        Object proceed = proceedingJoinPoint.proceed();
        long costTime = System.currentTimeMillis() - startTime;
        String returnType = null;
        String returnVal = "null";
        if (proceed != null) {
            returnType = proceed.getClass().getSimpleName();
            returnVal = objectMapper.writeValueAsString(proceed);
        }

        stringBuilder.append("==============>执行完成! ")
                .append(",返回值类型: ").append(returnType)
                .append(",返回值: ").append(returnVal)
                .append(",执行时间: ").append(costTime).append("ms");
        log.info(stringBuilder.toString());


        return proceed;
    }

    private String getRequestLogFullInfo(JoinPoint joinPoint) {

        StringBuilder stringBuilder = new StringBuilder();
        String joinPointLogInfoStr = getJoinPointLogInfoStr(joinPoint);
        if(!StringUtils.isEmpty(joinPointLogInfoStr)){
            stringBuilder.append( joinPointLogInfoStr);
        }
        return stringBuilder.toString();
    }

    /**
     * 得到当前代理方法 需要记录的信息
     * 方便用于子类重写
     *
     * @param joinPoint
     * @return
     */
    protected String getJoinPointLogInfoStr(JoinPoint joinPoint) {
        if (joinPoint.getSignature() instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            String name = method.getName();
            String[] parameterNames = methodSignature.getParameterNames();
            Object[] args = joinPoint.getArgs();
            StringBuilder stringBuilder;
            LogAspect logAspectDesc = method.getAnnotation(LogAspect.class);
            if(logAspectDesc != null && !StringUtils.isEmpty(logAspectDesc.name())){
                stringBuilder = new StringBuilder("执行的方法名:" + logAspectDesc.name());
            }else {
                stringBuilder = new StringBuilder("执行的方法名:" + name);
            }

            stringBuilder.append(" [");
            if (parameterNames != null && parameterNames.length > 0) {
                //开始遍历拼接
                for (int i = 0; i < parameterNames.length; i++) {
                    String parameterName = parameterNames[i];
                    stringBuilder.append(parameterName).append("=");
                    try {
                        if (args[i] != null) {
                            stringBuilder.append(objectMapper.writeValueAsString(args[i]));
                        } else {
                            stringBuilder.append("null");
                        }
                    } catch (JsonProcessingException e) {
                        //忽略异常
                        stringBuilder.append("notConvertJsonString");
                    }
                    stringBuilder.append(";");
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        return "";
    }
}
