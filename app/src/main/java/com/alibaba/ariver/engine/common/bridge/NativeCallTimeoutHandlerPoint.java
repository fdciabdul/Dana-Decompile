package com.alibaba.ariver.engine.common.bridge;

import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface NativeCallTimeoutHandlerPoint extends Extension {
    void monitorTimeout(NativeCallContext nativeCallContext, BridgeResponseHelper bridgeResponseHelper);

    void removeMonitor(NativeCallContext nativeCallContext);
}
