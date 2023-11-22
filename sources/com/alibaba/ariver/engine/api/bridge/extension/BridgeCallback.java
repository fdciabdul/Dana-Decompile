package com.alibaba.ariver.engine.api.bridge.extension;

import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface BridgeCallback {
    void sendBridgeResponse(BridgeResponse bridgeResponse);

    void sendJSONResponse(JSONObject jSONObject);

    void sendJSONResponse(JSONObject jSONObject, boolean z);
}
