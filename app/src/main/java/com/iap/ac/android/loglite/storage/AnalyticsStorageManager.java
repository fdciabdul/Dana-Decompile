package com.iap.ac.android.loglite.storage;

import android.app.Application;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.iap.ac.android.loglite.api.AnalyticsHelper;
import com.iap.ac.android.loglite.b.a;
import com.iap.ac.android.loglite.b.c;
import com.iap.ac.android.loglite.b.d;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.interceptor.LoggerInterceptor;
import com.iap.ac.android.loglite.log.AntEvent;
import com.iap.ac.android.loglite.log.LogEvent;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes3.dex */
public class AnalyticsStorageManager {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, AnalyticsStorage> f7596a = new ConcurrentHashMap();
    public Set<LoggerInterceptor> b = new CopyOnWriteArraySet();

    public AnalyticsStorageManager(Application application) {
        a(application);
    }

    public final void a(Application application) {
        this.f7596a.put(LogCategory.LOG_BEHAVIOUR_MANUAL, new c(application, LogCategory.LOG_BEHAVIOUR_MANUAL));
        this.f7596a.put("performance", new d(application, "performance"));
        this.f7596a.put(LogCategory.LOG_CATEGORY_HIGHAVAIL, new d(application, LogCategory.LOG_CATEGORY_HIGHAVAIL));
        this.f7596a.put("crash", new CrashFileStorage(application, "crash"));
        this.f7596a.put("antEvent", new a(application, null));
    }

    public void a(LogEvent logEvent, String str) {
        AnalyticsStorage analyticsStorage;
        if (AnalyticsContext.getInstance().getConfigurationManager().c(str)) {
            String g = logEvent.g();
            long length = g.length();
            if (length <= 102400) {
                String f = logEvent.f();
                if (logEvent instanceof AntEvent) {
                    analyticsStorage = this.f7596a.get("antEvent");
                } else {
                    analyticsStorage = this.f7596a.get(f);
                }
                if (analyticsStorage != null) {
                    analyticsStorage.a(logEvent, str);
                    if (!this.b.isEmpty()) {
                        Iterator<LoggerInterceptor> it = this.b.iterator();
                        while (it.hasNext()) {
                            it.next().onSendLog(g);
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("write log-- ");
                    sb.append(g);
                    LoggerWrapper.i("AnalyticsStorageManager", sb.toString());
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("logLength", String.valueOf(length));
            AnalyticsHelper.sendPerformanceLog("logTooLong", hashMap);
        }
    }
}
