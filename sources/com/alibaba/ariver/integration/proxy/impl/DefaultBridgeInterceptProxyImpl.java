package com.alibaba.ariver.integration.proxy.impl;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy;
import com.alibaba.ariver.kernel.api.node.Node;

/* loaded from: classes6.dex */
public class DefaultBridgeInterceptProxyImpl implements RVBridgeInterceptProxy {
    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean postInvoke(Node node, NativeCallContext nativeCallContext, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean preDispatch(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean preInvoke(Node node, NativeCallContext nativeCallContext, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper) {
        return false;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy
    public boolean shouldInterceptPreInvoke(String str) {
        return false;
    }
}
