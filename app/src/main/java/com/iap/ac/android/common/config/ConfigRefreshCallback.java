package com.iap.ac.android.common.config;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public interface ConfigRefreshCallback {
    void onFetchFailed(String str, String str2);

    void onFetchSuccess(JSONObject jSONObject);
}
