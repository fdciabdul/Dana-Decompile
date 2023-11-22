package com.alibaba.griver.base.common.config;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.base.common.constants.AMCSConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class GriverConfig {

    /* renamed from: a  reason: collision with root package name */
    private static GriverConfigProxy f6284a = a();

    private static GriverConfigProxy a() {
        try {
            Class.forName(AMCSConstants.AMCS_LITE_MAIN_CLASS);
            return new GriverAmcsLiteConfig();
        } catch (Exception unused) {
            GriverLogger.w("GriverConfig", "AMCS Lite SDK not integrated, you need to implement your own config service");
            return new GriverConfigProxy() { // from class: com.alibaba.griver.base.common.config.GriverConfig.1
                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final void clearProcessCache() {
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final String getConfig(String str, String str2) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final String getConfig(String str, String str2, GriverConfigProxy.OnConfigChangeListener onConfigChangeListener) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final boolean getConfigBoolean(String str, boolean z) {
                    return false;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final JSONArray getConfigJSONArray(String str) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final JSONObject getConfigJSONObject(String str) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final String getConfigWithProcessCache(String str, String str2) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final JSONObject getSectionConfig(String str) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final JSONObject getSectionConfigWithListener(String str, GriverConfigProxy.OnSectionConfigChangeListener onSectionConfigChangeListener) {
                    return null;
                }

                @Override // com.alibaba.griver.api.common.config.GriverConfigProxy
                public final void putConfigCache(String str, String str2) {
                }
            };
        }
    }

    public static void clearProcessCache() {
        f6284a.clearProcessCache();
    }

    public static void putConfigCache(String str, String str2) {
        f6284a.putConfigCache(str, str2);
    }

    public static String getConfigWithProcessCache(String str, String str2) {
        String configWithProcessCache = f6284a.getConfigWithProcessCache(str, str2);
        return (TextUtils.isEmpty(configWithProcessCache) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : configWithProcessCache;
    }

    public static String getConfig(String str, String str2) {
        String config = f6284a.getConfig(str, str2);
        return (TextUtils.isEmpty(config) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : config;
    }

    public static String getConfig(String str) {
        String config = f6284a.getConfig(str, "");
        return (TextUtils.isEmpty(config) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : config;
    }

    public static String getConfig(String str, String str2, GriverConfigProxy.OnConfigChangeListener onConfigChangeListener) {
        String config = f6284a.getConfig(str, str2, onConfigChangeListener);
        return (TextUtils.isEmpty(config) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : config;
    }

    public static boolean getConfigBoolean(String str, boolean z) {
        return f6284a.getConfigBoolean(str, z);
    }

    public static JSONObject getConfigJSONObject(String str) {
        return f6284a.getConfigJSONObject(str);
    }

    public static JSONArray getConfigJSONArray(String str) {
        return f6284a.getConfigJSONArray(str);
    }

    public static JSONObject getSectionConfig(String str) {
        return f6284a.getSectionConfig(str);
    }

    public static JSONObject getSectionConfigWithListener(String str, GriverConfigProxy.OnSectionConfigChangeListener onSectionConfigChangeListener) {
        return f6284a.getSectionConfigWithListener(str, onSectionConfigChangeListener);
    }

    public static void setConfigProxy(GriverConfigProxy griverConfigProxy) {
        if (griverConfigProxy != null) {
            f6284a = griverConfigProxy;
        } else {
            GriverLogger.w("GriverConfig", "should not set null proxy to GriverConfig");
        }
    }
}
