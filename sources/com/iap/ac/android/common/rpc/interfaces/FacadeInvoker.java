package com.iap.ac.android.common.rpc.interfaces;

import com.alipay.mobile.common.rpc.RpcException;
import com.iap.ac.android.common.rpc.RpcRequest;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public interface FacadeInvoker {
    Object invokeMethod(Method method, RpcRequest rpcRequest) throws RpcException;
}
