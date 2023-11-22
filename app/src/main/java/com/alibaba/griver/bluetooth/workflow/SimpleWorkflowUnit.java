package com.alibaba.griver.bluetooth.workflow;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public abstract class SimpleWorkflowUnit implements WorkflowUnit<JSONObject> {
    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public void onError(BridgeCallback bridgeCallback) {
    }

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public boolean onNext() {
        return true;
    }
}
