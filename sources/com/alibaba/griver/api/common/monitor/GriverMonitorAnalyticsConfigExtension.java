package com.alibaba.griver.api.common.monitor;

import com.alibaba.ariver.app.api.App;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes6.dex */
public interface GriverMonitorAnalyticsConfigExtension extends GriverExtension {

    /* loaded from: classes6.dex */
    public interface GriverMonitorConfigFetchCallback {
        void onFetchFailed(String str, String str2);

        void onFetchSuccess(JSONObject jSONObject);
    }

    void syncMonitorConfig(App app, String str, GriverMonitorConfigFetchCallback griverMonitorConfigFetchCallback);
}
