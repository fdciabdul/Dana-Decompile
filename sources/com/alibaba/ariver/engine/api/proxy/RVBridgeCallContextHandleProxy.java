package com.alibaba.ariver.engine.api.proxy;

import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.exthub.integration.imp.RVBridgeCallContextHandleProxyImp")
/* loaded from: classes3.dex */
public interface RVBridgeCallContextHandleProxy extends Proxiable {
    String getResourceString(String str);

    Object handleEvent(String str, Node node, NativeCallContext nativeCallContext);
}
