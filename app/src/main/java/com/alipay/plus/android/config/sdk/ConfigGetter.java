package com.alipay.plus.android.config.sdk;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.plus.android.config.sdk.a.e;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes7.dex */
public abstract class ConfigGetter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7353a = e.a("ConfigGetter");

    public boolean containsKey(String str) {
        JSONObject configInternal;
        return (str == null || (configInternal = getConfigInternal()) == null || !configInternal.containsKey(str)) ? false : true;
    }

    public boolean getBoolConfig(String str) {
        return getBoolConfig(str, false);
    }

    public boolean getBoolConfig(String str, boolean z) {
        Object config = getConfig(str);
        return config == null ? z : config instanceof Boolean ? ((Boolean) config).booleanValue() : config instanceof String ? SummaryActivity.CHECKED.equalsIgnoreCase((String) config) : z;
    }

    public Object getConfig(String str) {
        return getConfig(str, null);
    }

    public Object getConfig(String str, Object obj) {
        JSONObject configInternal = getConfigInternal();
        return (configInternal == null || TextUtils.isEmpty(str)) ? obj : configInternal.get(str);
    }

    protected abstract JSONObject getConfigInternal();

    public JSONObject getConfigObject() {
        return getConfigInternal();
    }

    public double getDoubleConfig(String str) {
        return getDoubleConfig(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public double getDoubleConfig(String str, double d) {
        return getNumberConfig(str, Double.valueOf(d)).doubleValue();
    }

    public float getFloatConfig(String str) {
        return getFloatConfig(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public float getFloatConfig(String str, double d) {
        return getNumberConfig(str, Double.valueOf(d)).floatValue();
    }

    public int getIntConfig(String str) {
        return getIntConfig(str, 0);
    }

    public int getIntConfig(String str, int i) {
        return getNumberConfig(str, Integer.valueOf(i)).intValue();
    }

    public JSONArray getJSONArrayConfig(String str) {
        return getJSONArrayConfig(str, null);
    }

    public JSONArray getJSONArrayConfig(String str, JSONArray jSONArray) {
        Object config = getConfig(str);
        return config instanceof JSONArray ? (JSONArray) config : jSONArray;
    }

    public JSONObject getJSONObjectConfig(String str) {
        return getJSONObjectConfig(str, null);
    }

    public JSONObject getJSONObjectConfig(String str, JSONObject jSONObject) {
        Object config = getConfig(str);
        return config instanceof JSONObject ? (JSONObject) config : jSONObject;
    }

    public ConfigGetter getJSONObjectGetter(String str) {
        final JSONObject jSONObjectConfig = getJSONObjectConfig(str);
        if (jSONObjectConfig == null) {
            return null;
        }
        return new ConfigGetter() { // from class: com.alipay.plus.android.config.sdk.ConfigGetter.1
            @Override // com.alipay.plus.android.config.sdk.ConfigGetter
            protected JSONObject getConfigInternal() {
                return jSONObjectConfig;
            }
        };
    }

    public long getLongConfig(String str) {
        return getLongConfig(str, 0L);
    }

    public long getLongConfig(String str, long j) {
        return getNumberConfig(str, Long.valueOf(j)).longValue();
    }

    public Number getNumberConfig(String str) {
        return getNumberConfig(str, 0);
    }

    public Number getNumberConfig(String str, Number number) {
        Object config = getConfig(str);
        if (config == null) {
            return number;
        }
        if (config instanceof Number) {
            return (Number) config;
        }
        if (config instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) config));
            } catch (Exception e) {
                LoggerWrapper.d(f7353a, "Take it easy! just parse failed. will use default!", e);
            }
        }
        return number;
    }

    public String getStringConfig(String str) {
        return getStringConfig(str, null);
    }

    public String getStringConfig(String str, String str2) {
        Object config = getConfig(str);
        return config == null ? str2 : String.valueOf(config);
    }
}
