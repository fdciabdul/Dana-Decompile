package com.iap.ac.android.biz.acs;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public interface IMiniProgramDecodeCallback {
    void dismissLoading();

    void onResult(JSONObject jSONObject);

    void showLoading();
}
