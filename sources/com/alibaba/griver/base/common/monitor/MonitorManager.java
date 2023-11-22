package com.alibaba.griver.base.common.monitor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* loaded from: classes3.dex */
public class MonitorManager {

    /* renamed from: a */
    private static List<String> f6295a = new ArrayList();
    private static final Random b = new Random(System.currentTimeMillis());
    public static JSONArray mTrackEventBlackList = null;

    static {
        f6295a.add(GriverMonitorConstants.EVENT_REGISTER_WORKER_SUCCESS);
    }

    public static boolean shouldNotMonitor(String str, Map<String, String> map) {
        return !a(str, map) || f6295a.contains(str) || monitIdInBlackList(str);
    }

    public static final boolean monitIdInBlackList(String str) {
        if (mTrackEventBlackList == null) {
            String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_TRACK_EVENT_BLACK_LIST, GriverConfigConstants.DEFAULT_TRACK_EVENT_BLACK_LIST);
            try {
                mTrackEventBlackList = JSON.parseArray(config);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse monitor config failed: ");
                sb.append(config);
                GriverLogger.e("MonitorManager", sb.toString(), e);
            }
            if (mTrackEventBlackList == null) {
                mTrackEventBlackList = new JSONArray();
            }
        }
        return mTrackEventBlackList.contains(str);
    }

    public static boolean jsapiEnabled() {
        JSONObject jSONObject;
        String config = GriverConfig.getConfig(GriverConfigConstants.KEY_MONITOR_SWITCH, GriverConfigConstants.DEFAULT_MONITOR_SWITCH);
        try {
            jSONObject = JSON.parseObject(config);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse monitor config failed: ");
            sb.append(config);
            GriverLogger.e("MonitorManager", sb.toString(), e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = JSON.parseObject(GriverConfigConstants.DEFAULT_MONITOR_SWITCH);
        }
        return jSONObject.getBooleanValue(GriverConfigConstants.PARAM_MONITOR_JSAPI_SWITCH);
    }

    private static boolean a(String str, Map<String, String> map) {
        JSONObject jSONObject;
        String config = GriverConfig.getConfig(GriverConfigConstants.KEY_MONITOR_SWITCH, GriverConfigConstants.DEFAULT_MONITOR_SWITCH);
        JSONObject jSONObject2 = null;
        try {
            jSONObject = JSON.parseObject(config);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse monitor config failed: ");
            sb.append(config);
            GriverLogger.e("MonitorManager", sb.toString(), e);
            jSONObject = null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.getBooleanValue(GriverConfigConstants.PARAM_MONITOR_MAIN_SWITCH)) {
            if (jSONObject.containsKey(str)) {
                try {
                    jSONObject2 = jSONObject.getJSONObject(str);
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("get detail config for: ");
                    sb2.append(str);
                    sb2.append(" failed");
                    GriverLogger.w("MonitorManager", sb2.toString());
                }
                if (jSONObject2 != null && jSONObject2.getBooleanValue("enable")) {
                    if (jSONObject2.containsKey(GriverMonitorConstants.KEY_SAMPLE_RATE)) {
                        double doubleValue = jSONObject2.getDoubleValue(GriverMonitorConstants.KEY_SAMPLE_RATE);
                        if (map != null) {
                            map.put(GriverMonitorConstants.KEY_SAMPLE_RATE, String.valueOf(doubleValue));
                        }
                        double nextInt = b.nextInt(1000);
                        Double.isNaN(nextInt);
                        double d = nextInt / 1000.0d;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("random sample rate:");
                        sb3.append(d);
                        GriverLogger.d("MonitorManager", sb3.toString());
                        if (d >= doubleValue) {
                            GriverLogger.w("MonitorManager", "do not fit the sample rate, do not upload");
                            return false;
                        }
                        return true;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean exceedThreshold(String str, double d) {
        return d >= getThreshold(str);
    }

    public static double getThreshold(String str) {
        if (GriverMonitorConstants.defaultThresholdMap.containsKey(str)) {
            double doubleValue = GriverMonitorConstants.defaultThresholdMap.get(str).doubleValue();
            String config = GriverConfig.getConfig(GriverConfigConstants.KEY_MONITOR_SWITCH, GriverConfigConstants.DEFAULT_MONITOR_SWITCH);
            JSONObject jSONObject = null;
            try {
                jSONObject = JSON.parseObject(config);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("parse monitor config failed: ");
                sb.append(config);
                GriverLogger.e("MonitorManager", sb.toString(), e);
            }
            if (jSONObject != null && jSONObject.containsKey(str)) {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    if (jSONObject2.containsKey(GriverMonitorConstants.KEY_THRESHOLD)) {
                        try {
                            return jSONObject2.getDoubleValue(GriverMonitorConstants.KEY_THRESHOLD);
                        } catch (Exception unused) {
                            GriverLogger.w("MonitorManager", "parse double value config failed for threshold, use default");
                            return doubleValue;
                        }
                    }
                    GriverLogger.w("MonitorManager", "does not have cloud threshold, use default");
                    return doubleValue;
                } catch (Exception unused2) {
                    GriverLogger.w("MonitorManager", "parse monitor config failed for threshold, use default");
                }
            }
            return doubleValue;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
