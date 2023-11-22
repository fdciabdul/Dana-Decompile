package com.iap.ac.android.loglite.api;

import android.app.Application;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.core.AnalyticsService;
import com.iap.ac.android.loglite.core.pageMonitor.PageMonitorLifecycleCallbacks;
import com.iap.ac.android.loglite.log.PageMonitor;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class CommonAnalyticsAgent {
    private static final ConcurrentHashMap<String, CommonAnalyticsAgent> innerMap = new ConcurrentHashMap<>();
    private String bizId;

    public CommonAnalyticsAgent(String str) {
        this.bizId = str;
    }

    public static CommonAnalyticsAgent getInstance(String str) {
        ConcurrentHashMap<String, CommonAnalyticsAgent> concurrentHashMap = innerMap;
        if (concurrentHashMap.get(str) == null) {
            synchronized (CommonAnalyticsAgent.class) {
                if (concurrentHashMap.get(str) == null) {
                    concurrentHashMap.put(str, new CommonAnalyticsAgent(str));
                }
            }
        }
        return concurrentHashMap.get(str);
    }

    public void autoTrackPageInfo(String str) {
        String str2 = this.bizId;
        synchronized (AnalyticsService.class) {
            List<String> list = AnalyticsService.f7589a;
            Application application = AnalyticsContext.getInstance().getApplication();
            if (AnalyticsContext.getInstance().getConfigurationManager().d) {
                PageMonitorLifecycleCallbacks pageMonitorLifecycleCallbacks = AnalyticsService.b;
                if (pageMonitorLifecycleCallbacks != null) {
                    application.unregisterActivityLifecycleCallbacks(pageMonitorLifecycleCallbacks);
                }
                PageMonitorLifecycleCallbacks pageMonitorLifecycleCallbacks2 = new PageMonitorLifecycleCallbacks(str, str2);
                AnalyticsService.b = pageMonitorLifecycleCallbacks2;
                application.registerActivityLifecycleCallbacks(pageMonitorLifecycleCallbacks2);
            } else {
                PageMonitorLifecycleCallbacks pageMonitorLifecycleCallbacks3 = AnalyticsService.b;
                if (pageMonitorLifecycleCallbacks3 != null) {
                    application.unregisterActivityLifecycleCallbacks(pageMonitorLifecycleCallbacks3);
                }
            }
        }
    }

    public void flushLogs() {
        AnalyticsContext.getInstance().flushLogs();
    }

    public void onPageDestroy(Object obj) {
        PageMonitor.a().a(obj);
    }

    public void onPageEnd(Object obj, String str, String str2, Map<String, String> map) {
        PageMonitor.a().a(obj, str, str2, this.bizId, map);
    }

    public void onPageStart(Object obj, String str) {
        PageMonitor.a().a(obj, str);
    }

    public void refreshLogSessionId() {
        AnalyticsContext.getInstance().refreshSessionId();
    }

    public void sendAntEvent(String str, String str2, Map<String, String> map) {
        AnalyticsService.a(str, str2, this.bizId, map);
    }

    public void sendBehaviorLog(String str, String str2, Map<String, String> map) {
        AnalyticsService.b(str, str2, this.bizId, map);
    }

    public void sendKeyBizExceptionLog(String str, String str2, Map<String, String> map) {
        AnalyticsService.c(str, str2, this.bizId, map);
    }

    public void sendPerformanceLog(String str, String str2, Map<String, String> map) {
        AnalyticsService.d(str, str2, this.bizId, map);
    }
}
