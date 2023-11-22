package com.iap.ac.android.common.task.async;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes8.dex */
public class IAPFuture<T> implements Future<T>, IAPAsyncCallback<T> {
    public Exception mError;
    public final String mName;
    public T mResult;
    public boolean mResultReceived;

    /* loaded from: classes8.dex */
    public static final class IAPExecutionException extends ExecutionException {
        public final Exception error;
        public final String name;

        public IAPExecutionException(String str, Exception exc) {
            this.name = str;
            this.error = exc;
        }
    }

    public IAPFuture(String str) {
        this.mName = str;
    }

    private T doGet(Long l) throws InterruptedException, IAPExecutionException, TimeoutException {
        synchronized (this) {
            Exception exc = this.mError;
            if (exc == null) {
                if (this.mResultReceived) {
                    if (!isCancelled()) {
                        return this.mResult;
                    }
                    throw new CancellationException();
                }
                if (l == null) {
                    wait(0L);
                } else if (l.longValue() > 0) {
                    wait(l.longValue());
                }
                Exception exc2 = this.mError;
                if (exc2 == null) {
                    if (this.mResultReceived) {
                        if (!isCancelled()) {
                            return this.mResult;
                        }
                        throw new CancellationException();
                    }
                    throw new TimeoutException();
                }
                throw new IAPExecutionException(this.mName, exc2);
            }
            throw new IAPExecutionException(this.mName, exc);
        }
    }

    public static <T> IAPFuture<T> newFuture(String str) {
        return new IAPFuture<>(str);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, IAPExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this) {
            if (!this.mResultReceived) {
                z = this.mError != null;
            }
        }
        return z;
    }

    @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
    public void onFailure(Exception exc) {
        synchronized (this) {
            this.mError = exc;
            notifyAll();
        }
    }

    @Override // com.iap.ac.android.common.task.async.IAPAsyncCallback
    public void onSuccess(T t) {
        synchronized (this) {
            this.mResultReceived = true;
            this.mResult = t;
            notifyAll();
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, IAPExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }
}
