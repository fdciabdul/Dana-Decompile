package com.iap.ac.android.common.config;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IACConfig {
    void addCommonConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener);

    void addSectionConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener);

    boolean getBoolean(String str, boolean z);

    double getDouble(String str, double d);

    int getInt(String str, int i);

    JSONArray getJSONArrayConfig(String str);

    JSONObject getJSONConfig(String str);

    long getLong(String str, long j);

    JSONObject getSectionConfig(String str);

    String getString(String str);

    void refreshByKeys(String str, List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback);

    void refreshByKeys(List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback);

    void refreshConfig(Map<String, Object> map, boolean z);

    void removeAllConfigChangeListener();

    void removeConfiChangeListener(IConfigChangeListener iConfigChangeListener);
}
