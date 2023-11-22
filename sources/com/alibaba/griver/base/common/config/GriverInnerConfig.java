package com.alibaba.griver.base.common.config;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.base.common.constants.AMCSConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class GriverInnerConfig {

    /* renamed from: a  reason: collision with root package name */
    private static GriverConfigProxy f6286a = a();

    private static GriverConfigProxy a() {
        try {
            Class.forName(AMCSConstants.AMCS_LITE_MAIN_CLASS);
            return new GriverInnerAmcsLiteConfig();
        } catch (Exception unused) {
            GriverLogger.w("GriverInnerConfig", "AMCS Lite SDK not integrated, you need to implement your own config service");
            return new GriverConfigProxy() { // from class: com.alibaba.griver.base.common.config.GriverInnerConfig.1
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
        f6286a.clearProcessCache();
    }

    public static void putConfigCache(String str, String str2) {
        f6286a.putConfigCache(str, str2);
    }

    public static String getConfigWithProcessCache(String str, String str2) {
        String configWithProcessCache = f6286a.getConfigWithProcessCache(str, str2);
        return (TextUtils.isEmpty(configWithProcessCache) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : configWithProcessCache;
    }

    public static String getConfig(String str, String str2) {
        String config = f6286a.getConfig(str, str2);
        return (TextUtils.isEmpty(config) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : config;
    }

    public static String getConfig(String str) {
        String config = f6286a.getConfig(str, "");
        return (TextUtils.isEmpty(config) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : config;
    }

    public static String getConfig(String str, String str2, GriverConfigProxy.OnConfigChangeListener onConfigChangeListener) {
        String config = f6286a.getConfig(str, str2, onConfigChangeListener);
        return (TextUtils.isEmpty(config) && GriverConfigConstants.insideStringConfig.containsKey(str)) ? GriverConfigConstants.insideStringConfig.get(str) : config;
    }

    public static boolean getConfigBoolean(String str, boolean z) {
        return f6286a.getConfigBoolean(str, z);
    }

    public static JSONObject getConfigJSONObject(String str) {
        return f6286a.getConfigJSONObject(str);
    }

    public static JSONArray getConfigJSONArray(String str) {
        return f6286a.getConfigJSONArray(str);
    }

    public static JSONObject getSectionConfig(String str) {
        return f6286a.getSectionConfig(str);
    }

    public static JSONObject getSectionConfigWithListener(String str, GriverConfigProxy.OnSectionConfigChangeListener onSectionConfigChangeListener) {
        return f6286a.getSectionConfigWithListener(str, onSectionConfigChangeListener);
    }

    public static void setConfigProxy(GriverConfigProxy griverConfigProxy) {
        if (griverConfigProxy != null) {
            f6286a = griverConfigProxy;
        } else {
            GriverLogger.e("GriverInnerConfig", "should not set null proxy to GriverConfig");
        }
    }

    public static HashMap<String, String> getPerformanceConfigMonitor() {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : Arrays.asList(GriverConfigConstants.KEY_DEFAULT_APPINFO_MEMORY_CONFIG)) {
            String config = getConfig(str);
            boolean z = false;
            if (!TextUtils.isEmpty(config)) {
                if (!config.toLowerCase(Locale.ROOT).equals(SummaryActivity.CHECKED.toLowerCase(Locale.ROOT))) {
                    try {
                        JSONObject parseObject = JSONUtils.parseObject(config);
                        if (parseObject.containsKey("enable")) {
                            if (!parseObject.getString("enable").toLowerCase(Locale.ROOT).equals(SummaryActivity.CHECKED.toLowerCase(Locale.ROOT))) {
                            }
                        }
                    } catch (Exception e) {
                        GriverLogger.e("GriverInnerConfig", "getPerformanceConfigMonitor error ", e);
                    }
                }
                z = true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            hashMap.put(str, sb.toString());
        }
        return hashMap;
    }
}
