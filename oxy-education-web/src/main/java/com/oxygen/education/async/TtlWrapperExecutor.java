package com.oxygen.education.async;

import com.alibaba.ttl.TtlRunnable;

import java.util.Objects;
import java.util.concurrent.Executor;

/**
 * 包装成ttl的execute
 *
 * @author oxygen
 **/
public class TtlWrapperExecutor implements Executor {

    private final Executor delegate;

    public TtlWrapperExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public void execute(Runnable command) {
        delegate.execute(Objects.requireNonNull(TtlRunnable.get(command)));
    }
}
