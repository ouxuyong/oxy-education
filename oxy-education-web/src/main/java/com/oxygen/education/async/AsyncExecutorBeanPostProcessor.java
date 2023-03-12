package com.oxygen.education.async;

import com.alibaba.ttl.TtlEnhanced;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

/**
 * 异步线程池处理
 *
 * @author oxygen
 **/
@Slf4j
@Component
public class AsyncExecutorBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (bean instanceof TtlEnhanced) {
            log.info("-------------AsyncExecutorBeanPostProcessor bean instanceof ttl not handle TtlEnhanced = {}", beanName);
            return bean;
        }
        if (bean instanceof ThreadPoolTaskExecutor) {
            log.info("-------------AsyncExecutorBeanPostProcessor ThreadPoolTaskExecutor = {}", beanName);
            return wrapThreadPoolTaskExecutor(bean);
        } else if (bean instanceof ExecutorService) {
            log.info("-------------AsyncExecutorBeanPostProcessor ExecutorService = {}", beanName);
            return wrapExecutorService(bean);
        } else if (bean instanceof Executor) {
            log.info("-------------AsyncExecutorBeanPostProcessor Executor = {}", beanName);
            return wrapExecutor(bean);
        }

        return bean;
    }

    private Object wrapExecutor(Object bean) {
        log.info(bean.getClass().getName());
        Method execute = ReflectionUtils.findMethod(bean.getClass(), "execute", Runnable.class);
        assert execute != null;
        boolean methodFinal = Modifier.isFinal(execute.getModifiers());
        boolean classFinal = Modifier.isFinal(bean.getClass().getModifiers());
        boolean cglibProxy = !methodFinal && !classFinal;
        Executor executor = (Executor) bean;

        try {
            return createProxy(bean, cglibProxy, new ExecutorMethodInterceptor<>(executor));
        } catch (AopConfigException ex) {
            if (cglibProxy) {
                return createProxy(bean, false, new ExecutorMethodInterceptor<>(executor));
            }

            throw ex;
        }
    }

    private Object wrapThreadPoolTaskExecutor(Object bean) {
        boolean classFinal = Modifier.isFinal(bean.getClass().getModifiers());
        boolean cglibProxy = !classFinal;
        ThreadPoolTaskExecutor executor = (ThreadPoolTaskExecutor) bean;
        return createThreadPoolTaskExecutorProxy(bean, cglibProxy, executor);
    }

    private Object wrapExecutorService(Object bean) {
        boolean classFinal = Modifier.isFinal(bean.getClass().getModifiers());
        boolean cglibProxy = !classFinal;
        ExecutorService executor = (ExecutorService) bean;
        return createExecutorServiceProxy(bean, cglibProxy, executor);
    }

    Object createThreadPoolTaskExecutorProxy(Object bean, boolean cglibProxy,
                                             ThreadPoolTaskExecutor executor) {
        return getProxiedObject(bean, cglibProxy, executor, () -> new TtlWrapperThreadPoolTaskExecutor(executor));
    }

    Object createExecutorServiceProxy(Object bean, boolean cglibProxy,
                                      ExecutorService executor) {
        return getProxiedObject(bean, cglibProxy, executor, () -> new TtlWrapperExecutorService(executor));
    }

    Object createProxy(Object bean, boolean cglibProxy, Advice advice) {
        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setProxyTargetClass(cglibProxy);
        factory.addAdvice(advice);
        factory.setTarget(bean);
        return factory.getObject();
    }

    @SuppressWarnings("unchecked")
    private Object getProxiedObject(Object bean, boolean cglibProxy, Executor executor,
                                    Supplier<Executor> supplier) {
        ProxyFactoryBean factory = new ProxyFactoryBean();
        factory.setProxyTargetClass(cglibProxy);
        factory.addAdvice(new ExecutorMethodInterceptor<Executor>(executor) {
            @Override
            <T extends Executor> T executor(T executor) {
                return (T) supplier.get();
            }
        });
        factory.setTarget(bean);
        try {
            return factory.getObject();
            // 报错不生成代理类了，原样返回
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.debug("Exception occurred while trying to get a proxy. Will fallback to a different implementation", e);
            }
            return bean;
        }
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}

class ExecutorMethodInterceptor<T extends Executor> implements MethodInterceptor {

    private final T delegate;

    ExecutorMethodInterceptor(T delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        T executor = executor(this.delegate);
        Method methodOnWrapperBean = getMethod(invocation, executor);
        if (methodOnWrapperBean != null) {
            try {
                return methodOnWrapperBean.invoke(executor, invocation.getArguments());
            } catch (InvocationTargetException ex) {
                Throwable cause = ex.getCause();
                throw (cause != null) ? cause : ex;
            }
        }
        return invocation.proceed();
    }

    private Method getMethod(MethodInvocation invocation, Object object) {
        Method method = invocation.getMethod();
        return ReflectionUtils
                .findMethod(object.getClass(), method.getName(), method.getParameterTypes());
    }

    @SuppressWarnings("unchecked")
    <T extends Executor> T executor(T executor) {
        return (T) new TtlWrapperExecutor(executor);
    }
}



