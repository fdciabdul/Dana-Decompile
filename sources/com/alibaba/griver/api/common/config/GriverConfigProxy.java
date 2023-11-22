package com.alibaba.griver.api.common.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.GriverExtension;

/* loaded from: classes3.dex */
public interface GriverConfigProxy extends GriverExtension {

    /* loaded from: classes3.dex */
    public interface OnConfigChangeListener {
        void onChange(String str);
    }

    /* loaded from: classes3.dex */
    public interface OnSectionConfigChangeListener {
        void onChange(JSONObject jSONObject);
    }

    void clearProcessCache();

    String getConfig(String str, String str2);

    String getConfig(String str, String str2, OnConfigChangeListener onConfigChangeListener);

    boolean getConfigBoolean(String str, boolean z);

    JSONArray getConfigJSONArray(String str);

    JSONObject getConfigJSONObject(String str);

    String getConfigWithProcessCache(String str, String str2);

    JSONObject getSectionConfig(String str);

    JSONObject getSectionConfigWithListener(String str, OnSectionConfigChangeListener onSectionConfigChangeListener);

    void putConfigCache(String str, String str2);
}
