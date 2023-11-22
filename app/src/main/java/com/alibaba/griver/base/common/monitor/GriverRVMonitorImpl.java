package com.alibaba.griver.base.common.monitor;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.PWAUtils;
import com.alipay.alipaysecuritysdk.rds.constant.DictionaryKeys;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverRVMonitorImpl implements RVMonitor {
    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void event(String str, String str2, int i, Map<String, String> map) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void logNebulaTech(String str, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, Map<String, Object> map4) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void markSpmBehavor(Context context, String str, Map<String, String> map) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void markSpmBehavor(String str, Map<String, String> map) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void markSpmExpose(Context context, String str, Map<String, String> map) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void performanceLog(String str, String str2, String str3, String str4, Map<String, Object> map) {
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void performance(String str, Map<String, Object> map, Map<String, Object> map2, Map<String, Long> map3, Map<String, Object> map4) {
        if ("RV_APP_STARTUP".equalsIgnoreCase(str)) {
            try {
                GriverMonitor.performance("RV_APP_STARTUP", "GriverAppContainer", a("RV_APP_STARTUP", map3, map2, map));
            } catch (Exception e) {
                GriverLogger.e("GriverRVMonitorImpl", "get common data failed", e);
            }
        } else if ("RV_APP_PAGE".equalsIgnoreCase(str)) {
            GriverMonitor.performance("RV_APP_PAGE", "GriverAppContainer", a("RV_APP_PAGE", map3, map2, map));
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("commonDatas", JSON.toJSONString(map));
            hashMap.put("extDatas", JSON.toJSONString(map2));
            hashMap.put("stages", JSON.toJSONString(map3));
            hashMap.put("events", JSON.toJSONString(map4));
            GriverMonitor.performance(str, "GriverAppContainer", hashMap);
        }
    }

    private Map<String, String> a(String str, Map<String, Long> map, Map<String, Object> map2, Map<String, Object> map3) {
        MonitorMap.Builder builder = new MonitorMap.Builder();
        if (map2 != null) {
            try {
                builder.appendAll(GriverMonitor.convertObjectToString(map2));
            } catch (Exception unused) {
                GriverLogger.w("GriverRVMonitorImpl", "parse performance data failed");
            }
        }
        AppModel appModel = null;
        if (map3 != null) {
            try {
                appModel = (AppModel) JSON.parseObject((String) map3.get("appModel"), AppModel.class);
            } catch (Exception e) {
                GriverLogger.e("GriverRVMonitorImpl", "parse app model failed", e);
            }
            builder.appId((String) map3.get("appId")).url((String) map3.get("url")).needAsynAppType(true);
            if (appModel != null) {
                builder.version(appModel);
            } else {
                builder.version((String) map3.get("version"));
            }
        }
        if (map != null) {
            builder.appendAll(GriverMonitor.convertObjectToString(map));
            if (TextUtils.equals(str, "RV_APP_STARTUP")) {
                if (a(map, "firstScreen")) {
                    builder.append(GriverMonitorConstants.KEY_LAUNCH_COST, String.valueOf(map.get("firstScreen").longValue() - map.get(PerfId.jumpAppStart).longValue()));
                } else if (a(map, "appxPageLoaded")) {
                    builder.append(GriverMonitorConstants.KEY_LAUNCH_COST, String.valueOf(map.get("appxPageLoaded").longValue() - map.get(PerfId.jumpAppStart).longValue()));
                }
            } else if (TextUtils.equals(str, "RV_APP_PAGE")) {
                if (a(map, "firstScreen")) {
                    builder.append(GriverMonitorConstants.KEY_LAUNCH_COST, String.valueOf(map.get("firstScreen").longValue() - map.get(PerfId.pageInit).longValue()));
                } else if (a(map, "appxPageLoaded")) {
                    builder.append(GriverMonitorConstants.KEY_LAUNCH_COST, String.valueOf(map.get("appxPageLoaded").longValue() - map.get(PerfId.pageInit).longValue()));
                }
            }
        }
        if (appModel != null && PWAUtils.isPwaApp(appModel)) {
            StringBuilder sb = new StringBuilder();
            sb.append(PWAUtils.isLoadOldWay());
            builder.append(GriverMonitorConstants.MINI_PROGRAM_TYPE_PWA_TEMPLATE_DEGRADED, sb.toString());
        }
        return builder.build();
    }

    private boolean a(Map<String, Long> map, String str) {
        return map != null && map.containsKey(str) && map.get(str) != null && map.get(str).longValue() > 0;
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void behavior(Page page, String str, Map<String, Object> map, Map<String, Object> map2, BridgeCallback bridgeCallback) {
        if (bridgeCallback != null) {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("commonDatas", JSON.toJSONString(map));
        hashMap.put("extDatas", JSON.toJSONString(map2));
        GriverMonitor.event(str, "GriverAppContainer", hashMap);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void error(Page page, String str, String str2, String str3, Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put("commonDatas", JSON.toJSONString(map));
        hashMap.put("extDatas", JSON.toJSONString(map2));
        hashMap.put("code", str2);
        hashMap.put("msg", str3);
        GriverMonitor.error(str, "GriverAppContainer", hashMap);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void flowLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("extDatas", JSON.toJSONString(map));
        hashMap.put("info", str2);
        hashMap.put("stage", str3);
        hashMap.put("appId", str4);
        hashMap.put(DictionaryKeys.V2_PAGENAME, str5);
        GriverMonitor.event(str, "GriverAppContainer", hashMap);
    }

    @Override // com.alibaba.ariver.app.api.monitor.RVMonitor
    public void errorLog(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("extDatas", JSON.toJSONString(map));
        hashMap.put("errorCode", str);
        hashMap.put("errorMsg", str2);
        hashMap.put("appId", str4);
        hashMap.put(DictionaryKeys.V2_PAGENAME, str5);
        GriverMonitor.error(str3, "GriverAppContainer", hashMap);
    }
}
