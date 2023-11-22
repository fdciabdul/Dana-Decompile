package com.iap.ac.android.common.config;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IConfigChangeListener {
    void onConfigChanged(String str, Object obj);

    void onSectionConfigChanged(String str, JSONObject jSONObject);
}
