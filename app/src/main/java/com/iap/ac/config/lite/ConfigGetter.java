package com.iap.ac.config.lite;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.d.e;
import id.dana.sendmoney.summary.SummaryActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class ConfigGetter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7614a = e.b("ConfigGetter");

    /* loaded from: classes.dex */
    class a extends ConfigGetter {
        final /* synthetic */ JSONObject b;

        a(ConfigGetter configGetter, JSONObject jSONObject) {
            this.b = jSONObject;
        }

        @Override // com.iap.ac.config.lite.ConfigGetter
        protected JSONObject getConfigInternal() {
            return this.b;
        }
    }

    public boolean containsKey(String str) {
        JSONObject configInternal;
        return (str == null || (configInternal = getConfigInternal()) == null || !configInternal.has(str)) ? false : true;
    }

    public boolean getBoolConfig(String str) {
        return getBoolConfig(str, false);
    }

    public Object getConfig(String str) {
        return getConfig(str, null);
    }

    protected abstract JSONObject getConfigInternal();

    public JSONObject getConfigObject() {
        return getConfigInternal();
    }

    public double getDoubleConfig(String str) {
        return getDoubleConfig(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public float getFloatConfig(String str) {
        return getFloatConfig(str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public int getIntConfig(String str) {
        return getIntConfig(str, 0);
    }

    public JSONArray getJSONArrayConfig(String str) {
        return getJSONArrayConfig(str, null);
    }

    public JSONObject getJSONConfig(String str) {
        return getJSONConfig(str, null);
    }

    public long getLongConfig(String str) {
        return getLongConfig(str, 0L);
    }

    public ConfigGetter getMapGetter(String str) {
        JSONObject jSONConfig = getJSONConfig(str);
        if (jSONConfig == null) {
            return null;
        }
        return new a(this, jSONConfig);
    }

    public Number getNumberConfig(String str) {
        return getNumberConfig(str, 0);
    }

    public String getStringConfig(String str) {
        return getStringConfig(str, null);
    }

    public boolean getBoolConfig(String str, boolean z) {
        Object config = getConfig(str);
        if (config == null) {
            return z;
        }
        if (config instanceof Boolean) {
            return ((Boolean) config).booleanValue();
        }
        return config instanceof String ? SummaryActivity.CHECKED.equalsIgnoreCase((String) config) : z;
    }

    public Object getConfig(String str, Object obj) {
        JSONObject configInternal = getConfigInternal();
        if (configInternal != null && !TextUtils.isEmpty(str)) {
            try {
                return configInternal.get(str);
            } catch (JSONException unused) {
            }
        }
        return obj;
    }

    public double getDoubleConfig(String str, double d) {
        return getNumberConfig(str, Double.valueOf(d)).doubleValue();
    }

    public float getFloatConfig(String str, double d) {
        return getNumberConfig(str, Double.valueOf(d)).floatValue();
    }

    public int getIntConfig(String str, int i) {
        return getNumberConfig(str, Integer.valueOf(i)).intValue();
    }

    public JSONArray getJSONArrayConfig(String str, JSONArray jSONArray) {
        Object config = getConfig(str);
        return config instanceof JSONArray ? (JSONArray) config : jSONArray;
    }

    public JSONObject getJSONConfig(String str, JSONObject jSONObject) {
        Object config = getConfig(str);
        return config instanceof JSONObject ? (JSONObject) config : jSONObject;
    }

    public long getLongConfig(String str, long j) {
        return getNumberConfig(str, Long.valueOf(j)).longValue();
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
                ACLog.d(f7614a, "Take it easy! just parse failed. will use default!", e);
            }
        }
        return number;
    }

    public String getStringConfig(String str, String str2) {
        Object config = getConfig(str);
        if (config == null) {
            return str2;
        }
        if (config instanceof String) {
            return (String) config;
        }
        if (config instanceof Number) {
            return String.valueOf(config);
        }
        return JsonUtils.toJson(config);
    }
}
