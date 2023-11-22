package com.alipay.mobile.embedview.mapbiz.core;

import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* loaded from: classes6.dex */
public class H5MapRenderOptimizer {
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_OPTIMIZE = "optimize";
    public static final String KEY_SCALE = "scale";

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f7144a = new JSONObject();

    public JSONObject getData() {
        return this.f7144a;
    }

    public JSONObject wrapData(JSONObject jSONObject) {
        synchronized (this) {
            if (jSONObject == null) {
                return null;
            }
            if (!jSONObject.getBooleanValue("optimize")) {
                this.f7144a.clear();
            }
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                if (!"optimize".equals(key)) {
                    this.f7144a.put(key, entry.getValue());
                }
            }
            return this.f7144a;
        }
    }

    public void put(String str, Object obj) {
        synchronized (this) {
            this.f7144a.put(str, obj);
        }
    }

    public void putAll(Map<? extends String, ? extends Object> map) {
        synchronized (this) {
            this.f7144a.putAll(map);
        }
    }
}
