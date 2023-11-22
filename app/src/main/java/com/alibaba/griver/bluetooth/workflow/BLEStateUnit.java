package com.alibaba.griver.bluetooth.workflow;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.bluetooth.ble.BetterBleService;
import com.alibaba.griver.bluetooth.ble.model.BluetoothState;
import com.alipay.mobile.verifyidentity.uitools.POPUIType;

/* loaded from: classes2.dex */
public class BLEStateUnit implements WorkflowUnit<JSONObject> {
    private BetterBleService mBetterBleService;
    private int mErrorCode;
    private final int ERROR_CODE_BLE_SUPPORT = POPUIType.TOAST_ERROR;
    private final int ERROR_CODE_BLE_OFF = 12;
    private final int ERROR_CODE_BLE_NOT_INIT = 10000;

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public void onProcess(JSONObject jSONObject, BridgeCallback bridgeCallback) {
    }

    private BLEStateUnit(BetterBleService betterBleService) {
        this.mBetterBleService = betterBleService;
    }

    public static BLEStateUnit create(BetterBleService betterBleService) {
        return new BLEStateUnit(betterBleService);
    }

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public boolean onNext() {
        if (!this.mBetterBleService.isSupportBLE()) {
            this.mErrorCode = POPUIType.TOAST_ERROR;
            return false;
        } else if (this.mBetterBleService.getBluetoothState() == BluetoothState.OFF.ordinal()) {
            this.mErrorCode = 12;
            return false;
        } else if (this.mBetterBleService.isOpened()) {
            return true;
        } else {
            this.mErrorCode = 10000;
            return false;
        }
    }

    @Override // com.alibaba.griver.bluetooth.workflow.WorkflowUnit
    public void onError(BridgeCallback bridgeCallback) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", (Object) Integer.valueOf(this.mErrorCode));
        int i = this.mErrorCode;
        if (i == 12) {
            jSONObject.put("errorMessage", "Bluetooth is not enabled");
        } else if (i == 10000) {
            jSONObject.put("errorMessage", "Bluetooth is not initialized");
        } else if (i == 10001) {
            jSONObject.put("errorMessage", "current bluetooth adapter is not suppoted");
        }
        bridgeCallback.sendJSONResponse(jSONObject);
    }
}
