package com.alipay.imobile.network.quake;

import com.alipay.imobile.network.quake.Request;
import com.alipay.mobile.common.rpc.RpcException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class RequestFuture implements Future, Request.Listener, Request.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    private Request f7033a;
    private boolean b = false;
    private Object c;
    private RpcException d;

    private Object a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        synchronized (this) {
            RpcException rpcException = this.d;
            if (rpcException == null) {
                if (this.b) {
                    return this.c;
                }
                if (l == null) {
                    wait(0L);
                } else if (l.longValue() > 0) {
                    wait(l.longValue());
                }
                RpcException rpcException2 = this.d;
                if (rpcException2 == null) {
                    if (this.b) {
                        return this.c;
                    }
                    throw new TimeoutException();
                }
                throw new ExecutionException(rpcException2);
            }
            throw new ExecutionException(rpcException);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        synchronized (this) {
            if (this.f7033a == null) {
                return false;
            }
            if (isDone()) {
                return false;
            }
            this.f7033a.cancel();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Request request = this.f7033a;
        return request != null && request.isCanceled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean z;
        synchronized (this) {
            if (!this.b && this.d == null) {
                z = isCancelled();
            }
        }
        return z;
    }

    @Override // com.alipay.imobile.network.quake.Request.ErrorListener
    public void onErrorResponse(RpcException rpcException) {
        synchronized (this) {
            this.d = rpcException;
            notifyAll();
        }
    }

    @Override // com.alipay.imobile.network.quake.Request.Listener
    public void onResponse(Object obj) {
        synchronized (this) {
            this.b = true;
            this.c = obj;
            notifyAll();
        }
    }

    public void setRequest(Request request) {
        this.f7033a = request;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }
}
