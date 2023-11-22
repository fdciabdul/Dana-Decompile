package com.alibaba.griver.base.stagemonitor.impl;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.griver.api.common.config.GriverAppConfig;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.api.GriverPerformanceStages;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverKeepAliveFullLinkStageMonitor extends GriverFullLinkStageMonitor {
    public static final String MONITOR_TOKEN = "full_link_keep_alive";

    public static String getMonitorToken(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return MONITOR_TOKEN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MONITOR_TOKEN);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String getMonitorToken(App app) {
        if (app == null) {
            return MONITOR_TOKEN;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(MONITOR_TOKEN);
        sb.append(app.getAppId());
        sb.append(app.getStartToken());
        return sb.toString();
    }

    public void initData(GriverStageMonitor griverStageMonitor) {
        Map<String, Object> paramsMap;
        transitToNext(PerfId.jumpAppStart);
        transitToNext(GriverPerformanceStages.KEY_JUMP_APP_START_UNIX, System.currentTimeMillis());
        transitToNext(PerfId.frameworkAppStart);
        transitToNext(PerfId.setupStart);
        transitToNext(PerfId.setupEnd);
        transitToNext(PerfId.startActivity);
        transitToNext(PerfId.attachContext);
        transitToNext(PerfId.activityCreated);
        transitToNext(PerfId.fragmentCreateViewed);
        transitToNext(PerfId.fragmentCreated);
        transitToNext(PerfId.viewCreate);
        transitToNext(PerfId.viewCreated);
        transitToNext(PerfId.appStart);
        transitToNext(PerfId.engineInit);
        transitToNext(PerfId.pageInit);
        transitToNext(PerfId.pageStart);
        transitToNext(PerfId.loadUrl);
        transitToNext("appxWorkerFrameworkLoaded");
        transitToNext(PerfId.appxLoaded);
        if (griverStageMonitor != null && (paramsMap = griverStageMonitor.getParamsMap()) != null) {
            this.paramMap.putAll(paramsMap);
        }
        this.paramMap.put(GriverMonitorConstants.KEY_KEEP_ALIVE, 1);
    }

    public void restart() {
        transitToNext("appxPageLoaded");
        transitToNext("firstScreen");
        if (GriverAppConfig.getInstance().isKeepAliveT2()) {
            transitToNext(GriverMonitorConstants.KEY_JST2_START);
            transitToNext(GriverMonitorConstants.KEY_JST2_FP);
            transitToNext(GriverMonitorConstants.KEY_JST2_FCP);
            transitToNext(GriverMonitorConstants.KEY_JST2_LCP);
            transitToNext(GriverMonitorConstants.KEY_JST2_T2_RENDER);
        }
    }
}
