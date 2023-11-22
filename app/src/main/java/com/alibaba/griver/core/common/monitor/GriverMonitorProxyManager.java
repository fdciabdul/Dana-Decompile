package com.alibaba.griver.core.common.monitor;

import com.alibaba.griver.api.common.monitor.GriverMonitorProxy;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverMonitorProxyManager {
    public static GriverMonitorProxy getDefaultProxy() {
        try {
            Class.forName("com.iap.ac.android.loglite.api.CommonAnalyticsAgent");
            GriverLogger.d("GriverMonitorProxyManager", "use log lite");
            return new GriverIAPLiteMonitor();
        } catch (Exception unused) {
            return new GriverEmptyMonitor();
        }
    }
}
