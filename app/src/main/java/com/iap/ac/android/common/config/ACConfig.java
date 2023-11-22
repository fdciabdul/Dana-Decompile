package com.iap.ac.android.common.config;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ACConfig {
    public static final String EVENT_GET_DEFAULT_IMPL = "ac_common_get_config_defalut_impl";
    public static final String EVENT_GET_IMPL_ERROR = "ac_common_get_config_impl_error";
    public static final String TAG = "ACConfig";
    public static final Map<String, IACConfig> configMap = new HashMap();
    public static IACConfig defaultConfig = new IACConfig() { // from class: com.iap.ac.android.common.config.ACConfig.1
        @Override // com.iap.ac.android.common.config.IACConfig
        public final void addCommonConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener) {
            ACConfig.noImplementationError();
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final void addSectionConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener) {
            ACConfig.noImplementationError();
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final boolean getBoolean(String str, boolean z) {
            ACConfig.noImplementationError();
            return z;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final double getDouble(String str, double d) {
            ACConfig.noImplementationError();
            return d;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final int getInt(String str, int i) {
            ACConfig.noImplementationError();
            return i;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final JSONArray getJSONArrayConfig(String str) {
            ACConfig.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final JSONObject getJSONConfig(String str) {
            ACConfig.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final long getLong(String str, long j) {
            ACConfig.noImplementationError();
            return j;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final JSONObject getSectionConfig(String str) {
            ACConfig.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final String getString(String str) {
            ACConfig.noImplementationError();
            return null;
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final void refreshByKeys(List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback) {
            ACConfig.noImplementationError();
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final void refreshConfig(Map<String, Object> map, boolean z) {
            ACConfig.noImplementationError();
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final void removeAllConfigChangeListener() {
            ACConfig.noImplementationError();
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final void removeConfiChangeListener(IConfigChangeListener iConfigChangeListener) {
            ACConfig.noImplementationError();
        }

        @Override // com.iap.ac.android.common.config.IACConfig
        public final void refreshByKeys(String str, List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback) {
            ACConfig.noImplementationError();
        }
    };
    public static IACConfig iacConfig;

    public static void addCommonConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.addCommonConfigChangeListener(str, iConfigChangeListener);
        }
    }

    public static void addSectionConfigChangeListener(String str, IConfigChangeListener iConfigChangeListener) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.addSectionConfigChangeListener(str, iConfigChangeListener);
        }
    }

    public static boolean getBoolean(String str, boolean z) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return z;
        }
        return iACConfig.getBoolean(str, z);
    }

    public static double getDouble(String str, double d) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return d;
        }
        return iACConfig.getDouble(str, d);
    }

    public static IACConfig getInstance(String str) {
        if (TextUtils.isEmpty(str)) {
            return getInstance();
        }
        IACConfig iACConfig = configMap.get(str);
        if (iACConfig == null && (iACConfig = iacConfig) != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bizCode", str);
            hashMap.put("msg", "Cannot find the implemetation for this bizCode. Using default instead.");
            LogEvent logEvent = new LogEvent(EVENT_GET_DEFAULT_IMPL, hashMap);
            logEvent.bizCode = str;
            ACMonitor.getInstance(str).logEvent(logEvent);
        }
        if (iACConfig == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("bizCode", str);
            hashMap2.put("errorMsg", "Cannot find the implemetation for this bizCode.");
            LogEvent logEvent2 = new LogEvent(EVENT_GET_IMPL_ERROR, hashMap2);
            logEvent2.bizCode = str;
            logEvent2.eventType = LogEventType.CRUCIAL_LOG;
            ACMonitor.getInstance(str).logEvent(logEvent2);
            return defaultConfig;
        }
        return iACConfig;
    }

    public static int getInt(String str, int i) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return i;
        }
        return iACConfig.getInt(str, i);
    }

    public static JSONArray getJSONArrayConfig(String str) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return null;
        }
        return iACConfig.getJSONArrayConfig(str);
    }

    public static JSONObject getJSONConfig(String str) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return null;
        }
        return iACConfig.getJSONConfig(str);
    }

    public static long getLong(String str, long j) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return j;
        }
        return iACConfig.getLong(str, j);
    }

    public static JSONObject getSectionConfig(String str) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return null;
        }
        return iACConfig.getSectionConfig(str);
    }

    public static String getString(String str) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
            return null;
        }
        return iACConfig.getString(str);
    }

    public static void noImplementationError() {
        ACLog.e("ACConfig", "There is no implementation of IACConfig. Please setIacConfig before using it.");
    }

    public static void refreshByKeys(List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.refreshByKeys(list, map, configRefreshCallback);
        }
    }

    public static void refreshConfig(Map<String, Object> map) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.refreshConfig(map, false);
        }
    }

    public static void removeAllConfigChangeListener() {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.removeAllConfigChangeListener();
        }
    }

    public static void removeConfiChangeListener(IConfigChangeListener iConfigChangeListener) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.removeConfiChangeListener(iConfigChangeListener);
        }
    }

    public static void setConfigImpl(IACConfig iACConfig) {
        iacConfig = iACConfig;
    }

    public static void setConfigImpl(IACConfig iACConfig, String str) {
        configMap.put(str, iACConfig);
    }

    public static void refreshByKeys(String str, List<String> list, Map<String, Object> map, ConfigRefreshCallback configRefreshCallback) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.refreshByKeys(str, list, map, configRefreshCallback);
        }
    }

    public static void refreshConfig(Map<String, Object> map, boolean z) {
        IACConfig iACConfig = iacConfig;
        if (iACConfig == null) {
            noImplementationError();
        } else {
            iACConfig.refreshConfig(map, z);
        }
    }

    public static IACConfig getInstance() {
        IACConfig iACConfig = iacConfig;
        return iACConfig != null ? iACConfig : defaultConfig;
    }
}
