package com.iap.ac.android.acs.plugin.downgrade.handler;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IActionHandlerCallback {
    void onHandleFailure(JSONObject jSONObject);

    void onHandleSuccess(JSONObject jSONObject);
}
