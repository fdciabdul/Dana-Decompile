package com.alibaba.griver.bluetooth.ble.model;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;

/* loaded from: classes2.dex */
public class TimeOutContext {
    public BridgeCallback bridgeCallback;
    public String deviceId;

    public TimeOutContext(BridgeCallback bridgeCallback, String str) {
        this.bridgeCallback = bridgeCallback;
        this.deviceId = str;
    }
}
