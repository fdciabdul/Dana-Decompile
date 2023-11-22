package com.alibaba.ariver.ariverexthub.api;

import android.app.Activity;
import com.alibaba.ariver.ariverexthub.api.instance.RVEProxyCenter;
import com.alibaba.ariver.ariverexthub.api.provider.RVEContextProvider;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class RVEContext {

    /* renamed from: a  reason: collision with root package name */
    private RVEContextProvider f5994a;

    private RVEContext() {
    }

    public RVEContext(RVEContextProvider rVEContextProvider) {
        this.f5994a = rVEContextProvider;
    }

    public String getAppId() {
        RVEContextProvider rVEContextProvider = this.f5994a;
        if (rVEContextProvider != null) {
            return rVEContextProvider.getAppId();
        }
        return null;
    }

    public String getPageUrl() {
        RVEContextProvider rVEContextProvider = this.f5994a;
        if (rVEContextProvider != null) {
            return rVEContextProvider.getPageUrl();
        }
        return null;
    }

    public Activity getCurrentActivity() {
        RVEContextProvider rVEContextProvider = this.f5994a;
        Activity currentActivity = rVEContextProvider != null ? rVEContextProvider.getCurrentActivity() : null;
        return currentActivity == null ? RVEProxyCenter.getInstance().getTopActivity() : currentActivity;
    }

    public boolean sendEvent(String str, JSONObject jSONObject) {
        RVEContextProvider rVEContextProvider = this.f5994a;
        if (rVEContextProvider != null) {
            return rVEContextProvider.sendEvent(this, str, jSONObject);
        }
        return false;
    }
}
