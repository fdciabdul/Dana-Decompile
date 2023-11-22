package com.alibaba.griver.core.common.monitor;

import android.text.TextUtils;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorProxy;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.iap.ac.android.loglite.api.CommonAnalyticsAgent;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class GriverIAPLiteMonitor implements GriverMonitorProxy {

    /* renamed from: a  reason: collision with root package name */
    private CommonAnalyticsAgent f6395a = new CommonAnalyticsAgent("GriverAppContainer");

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void performance(String str, String str2, Map<String, String> map) {
        try {
            this.f6395a.sendAntEvent(str, str2, map);
        } catch (Exception e) {
            GriverLogger.e("GriverIAPLiteMonitor", "send monitor failed", e);
        }
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void event(String str, String str2, Map<String, String> map) {
        try {
            if (TextUtils.equals(str2, "GriverAppContainer")) {
                this.f6395a.sendAntEvent(str, str2, map);
            } else if (str2 != null && str2.startsWith(GriverMonitorConstants.APPX_BEHAVIOR_BIZ_TYPE_PREFIX)) {
                if (TextUtils.equals(str, "pageview")) {
                    if (map == null) {
                        map = new HashMap<>();
                    }
                    map.put(GriverMonitorConstants.KEY_AUTO_LOG, SummaryActivity.CHECKED);
                }
                this.f6395a.sendBehaviorLog(str, str2, map);
            } else {
                this.f6395a.sendAntEvent(str, str2, map);
            }
        } catch (Exception e) {
            GriverLogger.e("GriverIAPLiteMonitor", "send monitor failed", e);
        }
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void error(String str, String str2, Map<String, String> map) {
        try {
            this.f6395a.sendAntEvent(str, str2, map);
        } catch (Exception e) {
            GriverLogger.e("GriverIAPLiteMonitor", "send monitor failed", e);
        }
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageStart(Object obj, String str) {
        try {
            this.f6395a.onPageStart(obj, str);
        } catch (Exception e) {
            GriverLogger.e("GriverIAPLiteMonitor", "send monitor failed", e);
        }
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageExit(Object obj, String str, String str2, Map<String, String> map) {
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Exception e) {
                GriverLogger.e("GriverIAPLiteMonitor", "send monitor failed", e);
                return;
            }
        }
        map.put(GriverMonitorConstants.KEY_AUTO_LOG, SummaryActivity.CHECKED);
        String environment = GriverEnv.getEnvironment();
        if (TextUtils.isEmpty(environment)) {
            environment = "prod";
        }
        map.put("env", environment);
        this.f6395a.onPageEnd(obj, str, str2, map);
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void pageDestroy(Object obj) {
        try {
            this.f6395a.onPageDestroy(obj);
        } catch (Exception e) {
            GriverLogger.e("GriverIAPLiteMonitor", "send monitor failed", e);
        }
    }

    @Override // com.alibaba.griver.api.common.monitor.GriverMonitorProxy
    public void upload() {
        try {
            this.f6395a.flushLogs();
        } catch (Throwable th) {
            GriverLogger.e("GriverIAPLiteMonitor", "upload monitor exception", th);
        }
    }
}
