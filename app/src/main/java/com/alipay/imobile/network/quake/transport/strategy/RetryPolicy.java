package com.alipay.imobile.network.quake.transport.strategy;

import com.alipay.mobile.common.rpc.RpcException;

/* loaded from: classes3.dex */
public interface RetryPolicy {
    int getCurrentRetryCount();

    int getCurrentTimeout();

    void retry(RpcException rpcException) throws RpcException;
}
