package com.iap.ac.android.common.container.interceptor;

import com.iap.ac.android.common.container.interceptor.BridgeInterceptor;

/* loaded from: classes3.dex */
public interface NotFoundJSAPIInterceptor {

    /* loaded from: classes8.dex */
    public static class NotFoundJSAPIContext extends BridgeInterceptor.InterceptContext {
        public String jsapiName;
    }

    boolean handleNotFoundJSAPI(NotFoundJSAPIContext notFoundJSAPIContext, BridgeCallback bridgeCallback);
}
