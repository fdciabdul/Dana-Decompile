package com.alipay.imobile.network.quake.transport.strategy;

import com.alipay.mobile.common.rpc.RpcException;

/* loaded from: classes3.dex */
public class DefaultRetryPolicy implements RetryPolicy {
    public static final float DEFAULT_BACKOFF_MULT = 1.0f;
    public static final int DEFAULT_MAX_RETRIES = 0;
    public static final int DEFAULT_TIMEOUT_MS = 10000;

    /* renamed from: a  reason: collision with root package name */
    private int f7074a;
    private int b;
    private final int c;
    private final float d;

    public DefaultRetryPolicy() {
        this(10000, 0, 1.0f);
    }

    public float getBackoffMultiplier() {
        return this.d;
    }

    @Override // com.alipay.imobile.network.quake.transport.strategy.RetryPolicy
    public int getCurrentRetryCount() {
        return this.b;
    }

    @Override // com.alipay.imobile.network.quake.transport.strategy.RetryPolicy
    public int getCurrentTimeout() {
        return this.f7074a;
    }

    protected boolean hasAttemptRemaining() {
        return this.b <= this.c;
    }

    @Override // com.alipay.imobile.network.quake.transport.strategy.RetryPolicy
    public void retry(RpcException rpcException) throws RpcException {
        this.b++;
        float f = this.f7074a;
        this.f7074a = (int) (f + (this.d * f));
        if (!hasAttemptRemaining()) {
            throw rpcException;
        }
    }

    public DefaultRetryPolicy(int i, int i2, float f) {
        this.f7074a = i;
        this.c = i2;
        this.d = f;
    }
}
