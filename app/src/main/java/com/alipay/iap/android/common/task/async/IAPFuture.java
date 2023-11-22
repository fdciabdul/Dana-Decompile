package com.alipay.iap.android.common.task.async;

import com.alipay.iap.android.common.errorcode.IAPError;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class IAPFuture<T> implements Future<T>, IAPAsyncCallback<T> {
    private IAPError mError;
    private final String mName;
    private T mResult;
    private boolean mResultReceived;

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    private IAPFuture(String str) {
        this.mName = str;
    }

    public static <T> IAPFuture<T> newFuture(String str) {
        return new IAPFuture<>(str);
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

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, IAPExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws InterruptedException, IAPExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private T doGet(Long l) throws InterruptedException, IAPExecutionException, TimeoutException {
        synchronized (this) {
            if (this.mError != null) {
                throw new IAPExecutionException(this.mName, this.mError);
            }
            if (this.mResultReceived) {
                if (isCancelled()) {
                    throw new CancellationException();
                }
                return this.mResult;
            }
            if (l == null) {
                wait(0L);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.mError != null) {
                throw new IAPExecutionException(this.mName, this.mError);
            }
            if (!this.mResultReceived) {
                throw new TimeoutException();
            }
            if (isCancelled()) {
                throw new CancellationException();
            }
            return this.mResult;
        }
    }

    @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
    public void onSuccess(T t) {
        synchronized (this) {
            this.mResultReceived = true;
            this.mResult = t;
            notifyAll();
        }
    }

    @Override // com.alipay.iap.android.common.task.async.IAPAsyncCallback
    public void onFailure(IAPError iAPError) {
        synchronized (this) {
            this.mError = iAPError;
            notifyAll();
        }
    }

    /* loaded from: classes6.dex */
    public static final class IAPExecutionException extends ExecutionException {
        public final IAPError error;
        public final String name;

        public IAPExecutionException(String str, IAPError iAPError) {
            this.name = str;
            this.error = iAPError;
        }
    }
}
