package com.alibaba.griver.core.proxy;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public class BridgeResponseUtils {
    public static JSONObject appendSuccess(JSONObject jSONObject) {
        if (jSONObject != null && !jSONObject.containsKey("success")) {
            jSONObject.put("success", (Object) Boolean.TRUE);
        }
        return jSONObject;
    }

    public static BridgeResponse SUCCESS(JSONObject jSONObject) {
        return new BridgeResponse(appendSuccess(jSONObject));
    }
}
