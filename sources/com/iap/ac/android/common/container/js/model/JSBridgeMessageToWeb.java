package com.iap.ac.android.common.container.js.model;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSBridgeMessageToWeb {
    public static final String TYPE_CALL = "call";
    public static final String TYPE_CALL_BACK = "callback";
    public String clientId;
    public String func;
    public String msgType = "callback";
    public JSONObject param;

    public JSBridgeMessageToWeb(JSBridgeMessageToNative jSBridgeMessageToNative) {
        this.clientId = jSBridgeMessageToNative.clientId;
        this.func = jSBridgeMessageToNative.func;
    }
}
