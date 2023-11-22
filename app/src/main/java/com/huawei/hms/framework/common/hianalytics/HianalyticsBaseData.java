package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public abstract class HianalyticsBaseData {
    public static final String EVENT_ID = "url_request";
    public static final String SDK_NAME = "sdk_name";
    public static final String SDK_TYPE = "sdk_type";
    public static final String SDK_VERSION = "sdk_version";
    private LinkedHashMap<String, String> getAuthRequestContext;

    public HianalyticsBaseData() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        this.getAuthRequestContext = linkedHashMap;
        linkedHashMap.put(SDK_TYPE, "UxPP");
        this.getAuthRequestContext.put(SDK_NAME, "networkkit");
    }

    public HianalyticsBaseData put(String str, String str2) {
        if (str == null || str2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("key = ");
            sb.append(str);
            sb.append(" : value = ");
            sb.append(str2);
            Logger.v("HianalyticsBaseData", sb.toString());
        } else {
            this.getAuthRequestContext.put(str, str2);
        }
        return this;
    }

    public HianalyticsBaseData put(String str, long j) {
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("key = null : value = ");
            sb.append(j);
            Logger.v("HianalyticsBaseData", sb.toString());
        } else {
            LinkedHashMap<String, String> linkedHashMap = this.getAuthRequestContext;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(j);
            linkedHashMap.put(str, sb2.toString());
        }
        return this;
    }

    public HianalyticsBaseData put(LinkedHashMap<String, String> linkedHashMap) {
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            Logger.v("HianalyticsBaseData", "data is null");
        } else {
            this.getAuthRequestContext.putAll(linkedHashMap);
        }
        return this;
    }

    public HianalyticsBaseData putIfNotDefault(String str, long j, long j2) {
        return j == j2 ? this : put(str, j);
    }

    public LinkedHashMap<String, String> get() {
        return this.getAuthRequestContext;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : get().entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            Logger.w("HianalyticsBaseData", "catch JSONException", e);
        }
        return jSONObject.toString();
    }
}
