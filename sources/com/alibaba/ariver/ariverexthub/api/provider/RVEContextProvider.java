package com.alibaba.ariver.ariverexthub.api.provider;

import android.app.Activity;
import com.alibaba.ariver.ariverexthub.api.RVEContext;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public abstract class RVEContextProvider {
    public String getAppId() {
        return "RVEExthub_UNKNOWN_APPID";
    }

    public Activity getCurrentActivity() {
        return null;
    }

    public String getPageUrl() {
        return null;
    }

    public boolean sendEvent(RVEContext rVEContext, String str, JSONObject jSONObject) {
        return false;
    }
}
