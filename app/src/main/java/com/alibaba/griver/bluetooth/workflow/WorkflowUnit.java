package com.alibaba.griver.bluetooth.workflow;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;

/* loaded from: classes6.dex */
public interface WorkflowUnit<T> {
    void onError(BridgeCallback bridgeCallback);

    boolean onNext();

    void onProcess(T t, BridgeCallback bridgeCallback);
}
