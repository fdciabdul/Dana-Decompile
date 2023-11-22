package com.alibaba.griver.base.stagemonitor.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverPVMonitor extends GriverStageMonitor {
    public static final String MONITOR_TOKEN = "load_urls_pv";
    protected ConcurrentHashMap<String, Integer> pvMap = new ConcurrentHashMap<>();

    @Override // com.alibaba.griver.base.stagemonitor.GriverStageMonitor
    public void transitToError(String str) {
    }

    public static String getMonitorToken(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(MONITOR_TOKEN);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String getMonitorToken(App app) {
        StringBuilder sb = new StringBuilder();
        sb.append(MONITOR_TOKEN);
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        return sb.toString();
    }

    public void addUrlCount(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return;
        }
        String host = parse.getHost();
        String path = parse.getPath();
        StringBuilder sb = new StringBuilder();
        sb.append(host);
        sb.append(path);
        String encode = Uri.encode(sb.toString());
        if (this.pvMap.containsKey(encode)) {
            this.pvMap.put(encode, Integer.valueOf(this.pvMap.get(encode).intValue() + 1));
        } else {
            this.pvMap.put(encode, 1);
        }
    }

    @Override // com.alibaba.griver.base.stagemonitor.GriverStageMonitor
    public void upload(App app) {
        if (app == null) {
            return;
        }
        try {
            GriverMonitor.performance(GriverMonitorConstants.PERFORMANCE_PAGE_LOAD_URL_PV, "GriverAppContainer", a(app));
        } catch (Exception e) {
            GriverLogger.e("GriverPVMonitor", "get common data failed", e);
        }
    }

    private Map<String, String> a(App app) {
        MonitorMap.Builder builder = new MonitorMap.Builder();
        try {
            AppModel appModel = (AppModel) app.getData(AppModel.class);
            if (appModel != null) {
                builder.appId(appModel.getAppId()).url(app.getStartUrl()).version(appModel).needAsynAppType(true);
            } else {
                builder.appId(app.getAppId()).url(app.getStartUrl()).needAsynAppType(true);
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> entry : this.pvMap.entrySet()) {
                if (entry.getKey() != null && entry.getValue().intValue() != 0) {
                    sb.append(entry.getKey());
                    sb.append("_");
                    sb.append(entry.getValue());
                    sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
            }
            String obj = sb.toString();
            if (!TextUtils.isEmpty(obj) && obj.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) {
                obj = obj.substring(0, obj.length() - 1);
            }
            builder.append(GriverMonitorConstants.PERFORMANCE_PAGE_LOAD_URL_PV_LOAD_URLS, obj);
        } catch (Exception e) {
            GriverLogger.w("GriverPVMonitor", "parse performance data failed", e);
        }
        return builder.build();
    }
}
