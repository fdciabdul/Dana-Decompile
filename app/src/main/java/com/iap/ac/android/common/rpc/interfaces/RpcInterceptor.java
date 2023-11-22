package com.iap.ac.android.common.rpc.interfaces;

import com.iap.ac.android.common.rpc.RpcRequest;
import com.iap.ac.android.common.rpc.model.RpcExceptionInterceptResult;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public interface RpcInterceptor {
    Object onAfterReceive(RpcRequest rpcRequest, Object obj, FacadeInvoker facadeInvoker, Method method);

    void onBeforeSend(RpcRequest rpcRequest);

    RpcExceptionInterceptResult onExceptionOccurred(RpcRequest rpcRequest, Throwable th, FacadeInvoker facadeInvoker, Method method);
}
