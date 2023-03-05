package com.oxygen.education.context;

import java.util.Optional;

/**
 * @author oxy
 */
public class OxygenContextHolder {
    private static ThreadLocal<OxyContext> THREAD_LOCAL = new ThreadLocal<>();

    public static Long getUserId(){
        return Optional.ofNullable(THREAD_LOCAL.get()).map(OxyContext ::getUserId).orElse(null);
    }

    public static Long getCompanyId(){
        return Optional.ofNullable(THREAD_LOCAL.get()).map(OxyContext ::getCompanyId).orElse(null);
    }

    /**
     * 获取全局上下文
     */
    public static OxyContext getContext() {
        OxyContext ctx = THREAD_LOCAL.get();
        if (ctx == null) {
            ctx = new OxyContext();
            THREAD_LOCAL.set(ctx);
        }
        return ctx;
    }

    /**
     * 设置全局上下文
     * @param value
     */
    public static void setContext(OxyContext value){
        THREAD_LOCAL.set(value);
    }

    public static void clearOxyContext(){
        THREAD_LOCAL.remove();
    }


}
