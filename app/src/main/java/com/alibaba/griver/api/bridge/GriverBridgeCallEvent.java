package com.alibaba.griver.api.bridge;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.GriverEvent;

/* loaded from: classes3.dex */
public interface GriverBridgeCallEvent extends GriverEvent {
    void apiDispatch(String str, String str2, String str3);

    void onBridgeCall(String str, JSONObject jSONObject, JSONObject jSONObject2, String str2, String str3);
}
