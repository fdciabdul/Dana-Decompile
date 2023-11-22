package com.alibaba.griver.bluetooth.workflow;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Workflow {
    private BridgeCallback mBridgeCallback;
    private OnCompletedListener mOnCompletedListener;
    private OnErrorListener mOnErrorListener;
    private List<WorkflowUnit> mWorkflow = new ArrayList();

    /* loaded from: classes6.dex */
    public interface OnCompletedListener {
        void onCompleted(JSONObject jSONObject, BridgeCallback bridgeCallback);
    }

    /* loaded from: classes6.dex */
    public interface OnErrorListener {
        void onError(JSONObject jSONObject, BridgeCallback bridgeCallback);
    }

    @Deprecated
    private Workflow(BridgeCallback bridgeCallback) {
        this.mBridgeCallback = bridgeCallback;
    }

    public static Workflow create(BridgeCallback bridgeCallback) {
        return new Workflow(bridgeCallback);
    }

    public Workflow addUnit(WorkflowUnit workflowUnit) {
        this.mWorkflow.add(workflowUnit);
        return this;
    }

    private void onCompleted(JSONObject jSONObject) {
        OnCompletedListener onCompletedListener = this.mOnCompletedListener;
        if (onCompletedListener == null) {
            return;
        }
        onCompletedListener.onCompleted(jSONObject, this.mBridgeCallback);
    }

    private void onError(JSONObject jSONObject) {
        OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener == null) {
            return;
        }
        onErrorListener.onError(jSONObject, this.mBridgeCallback);
    }

    public Workflow setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.mOnCompletedListener = onCompletedListener;
        return this;
    }

    public Workflow setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        return this;
    }

    public void onTrigger() {
        JSONObject jSONObject = new JSONObject();
        for (WorkflowUnit workflowUnit : this.mWorkflow) {
            if (workflowUnit.onNext()) {
                workflowUnit.onProcess(jSONObject, this.mBridgeCallback);
            } else {
                workflowUnit.onError(this.mBridgeCallback);
                onError(jSONObject);
                return;
            }
        }
        onCompleted(jSONObject);
    }
}
