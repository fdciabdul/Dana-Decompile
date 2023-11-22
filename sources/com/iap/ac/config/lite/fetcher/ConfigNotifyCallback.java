package com.iap.ac.config.lite.fetcher;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ConfigNotifyCallback {
    void onFetchFailed(String str, String str2);

    void onFetchSuccess(JSONObject jSONObject);
}
