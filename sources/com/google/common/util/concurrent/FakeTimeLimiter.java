package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class FakeTimeLimiter implements TimeLimiter {
    @Override // com.google.common.util.concurrent.TimeLimiter
    public final <T> T newProxy(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        return t;
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public final <T> T callWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        try {
            return callable.call();
        } catch (Error e) {
            throw new ExecutionError(e);
        } catch (RuntimeException e2) {
            throw new UncheckedExecutionException(e2);
        } catch (Exception e3) {
            Platform.restoreInterruptIfIsInterruptedException(e3);
            throw new ExecutionException(e3);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public final <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException {
        return (T) callWithTimeout(callable, j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public final void runWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        try {
            runnable.run();
        } catch (Error e) {
            throw new ExecutionError(e);
        } catch (RuntimeException e2) {
            throw new UncheckedExecutionException(e2);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public final void runUninterruptiblyWithTimeout(Runnable runnable, long j, TimeUnit timeUnit) {
        runWithTimeout(runnable, j, timeUnit);
    }
}
