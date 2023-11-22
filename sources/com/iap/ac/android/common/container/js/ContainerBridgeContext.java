package com.iap.ac.android.common.container.js;

import com.iap.ac.android.common.container.js.model.JSBridgeMessageToNative;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class ContainerBridgeContext {
    public JSBridgeMessageToNative toNativeMsg;

    public JSBridgeMessageToNative getToNativeMsg() {
        return this.toNativeMsg;
    }

    public abstract boolean sendBridgeResult(String str, Object obj);

    public abstract boolean sendBridgeResult(JSONObject jSONObject);

    public void setToNativeMsg(JSBridgeMessageToNative jSBridgeMessageToNative) {
        this.toNativeMsg = jSBridgeMessageToNative;
    }
}
