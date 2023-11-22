package com.alibaba.griver.api.bridge;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.griver.api.bridge.BridgeInterceptor;
import com.alibaba.griver.api.common.GriverEvent;

/* loaded from: classes3.dex */
public interface GriverBridgeCallNotFoundEvent extends GriverEvent {

    /* loaded from: classes6.dex */
    public static class BridgeContext extends BridgeInterceptor.InterceptContext {
        public String jsapiName;
    }

    boolean handleBridgeCallNotFound(BridgeContext bridgeContext, BridgeCallback bridgeCallback);
}
