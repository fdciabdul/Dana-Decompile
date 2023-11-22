package com.iap.ac.android.common.container.interceptor;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface BridgeCallback {
    void sendBridgeResponse(BridgeResponse bridgeResponse);

    void sendJSONResponse(JSONObject jSONObject);

    void sendJSONResponse(JSONObject jSONObject, boolean z);
}
