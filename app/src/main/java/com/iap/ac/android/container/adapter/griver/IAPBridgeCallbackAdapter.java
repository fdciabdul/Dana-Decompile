package com.iap.ac.android.container.adapter.griver;

import com.iap.ac.android.common.container.interceptor.BridgeCallback;
import com.iap.ac.android.common.container.interceptor.BridgeResponse;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class IAPBridgeCallbackAdapter implements BridgeCallback {

    /* renamed from: a  reason: collision with root package name */
    private com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback f7555a;

    public static IAPBridgeCallbackAdapter from(com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback bridgeCallback) {
        return new IAPBridgeCallbackAdapter(bridgeCallback);
    }

    private IAPBridgeCallbackAdapter(com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback bridgeCallback) {
        this.f7555a = bridgeCallback;
    }

    @Override // com.iap.ac.android.common.container.interceptor.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject, boolean z) {
        this.f7555a.sendJSONResponse(Utils.jsonObjectToFastJson(jSONObject), z);
    }

    @Override // com.iap.ac.android.common.container.interceptor.BridgeCallback
    public void sendJSONResponse(JSONObject jSONObject) {
        this.f7555a.sendJSONResponse(Utils.jsonObjectToFastJson(jSONObject));
    }

    @Override // com.iap.ac.android.common.container.interceptor.BridgeCallback
    public void sendBridgeResponse(BridgeResponse bridgeResponse) {
        this.f7555a.sendBridgeResponse(new com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse(Utils.jsonObjectToFastJson(bridgeResponse.get())));
    }
}
