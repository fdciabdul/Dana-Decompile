package com.iap.ac.android.common.container.interceptor;

import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;

/* loaded from: classes3.dex */
public interface BridgeJSAPIPreInterceptor {

    /* loaded from: classes8.dex */
    public static class JSAPIPreInterceptContext extends BridgeInterceptor.InterceptContext {
        public String jsapiName;
    }

    boolean handleJSAPIPreIntercept(JSAPIPreInterceptContext jSAPIPreInterceptContext, BridgeCallback bridgeCallback);
}
