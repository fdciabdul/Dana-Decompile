package com.alibaba.ariver.engine.api.bridge.model;

import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public interface SendToNativeCallback {
    public static final String KEY_CODE = "error";
    public static final String KEY_MESSAGE = "errorMessage";

    void onCallback(JSONObject jSONObject, boolean z);
}
