package com.alipay.imobile.network.quake;

import com.alipay.mobile.common.rpc.RpcException;

/* loaded from: classes3.dex */
public interface h {
    void a(Request request, Response<?> response);

    void a(Request request, Response<?> response, Runnable runnable);

    void a(Request request, RpcException rpcException);
}
