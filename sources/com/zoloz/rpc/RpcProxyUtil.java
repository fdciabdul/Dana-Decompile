package com.zoloz.rpc;

import android.content.Context;

/* loaded from: classes8.dex */
public class RpcProxyUtil {
    public String host;

    public LiteInvocationHandler buildProxyObj(Class cls, Context context) {
        LiteInvocationHandler liteInvocationHandler = new LiteInvocationHandler();
        liteInvocationHandler.host = this.host;
        return liteInvocationHandler;
    }
}
