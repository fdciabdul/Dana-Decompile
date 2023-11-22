package com.alibaba.griver.bluetooth.workflow;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.bluetooth.ble.BetterBleService;
import com.iap.ac.android.acs.plugin.utils.ErrorCode;

/* loaded from: classes2.dex */
public class BLEServiceUnit implements WorkflowUnit<JSONObject> {
    private BetterBleService mBetterBleService;

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback) {
    }

    @Deprecated
    private BLEServiceUnit(BetterBleService betterBleService) {
        this.mBetterBleService = betterBleService;
    }

    public static BLEServiceUnit create(BetterBleService betterBleService) {
        return new BLEServiceUnit(betterBleService);
    }

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public boolean onNext() {
        return this.mBetterBleService != null;
    }

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public void onError(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) 15);
        jSONObject.put("errorMessage", ErrorCode.ERROR_UNKNOWN_ERROR_MESSAGE);
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
