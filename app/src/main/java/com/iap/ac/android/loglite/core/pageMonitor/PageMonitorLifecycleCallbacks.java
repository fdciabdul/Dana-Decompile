package com.iap.ac.android.loglite.core.pageMonitor;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.iap.ac.android.loglite.api.annotation.PageMonitor;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.ac.android.loglite.log.PagePerformanceLog;
import com.iap.ac.android.loglite.utils.BizCodeMatchUtils;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class PageMonitorLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    public static AutoTrackPageInfo d;

    /* renamed from: a  reason: collision with root package name */
    public long f7592a = 0;
    public String b;
    public String c;

    public PageMonitorLifecycleCallbacks(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public final AutoTrackPageInfo a(Object obj) {
        synchronized (BizCodeMatchUtils.class) {
            if (BizCodeMatchUtils.e == null) {
                BizCodeMatchUtils.e = new HashMap();
            }
            String name = obj.getClass().getName();
            if (BizCodeMatchUtils.e.get(name) != null) {
                return BizCodeMatchUtils.e.get(name);
            }
            AutoTrackPageInfo autoTrackPageInfo = new AutoTrackPageInfo();
            PageMonitor pageMonitor = (PageMonitor) obj.getClass().getAnnotation(PageMonitor.class);
            if (pageMonitor != null) {
                String pageId = pageMonitor.pageId();
                String simpleName = obj.getClass().getSimpleName();
                if (TextUtils.isEmpty(pageId)) {
                    pageId = simpleName;
                }
                autoTrackPageInfo.f7591a = pageId;
                autoTrackPageInfo.b = pageMonitor.isMonitor();
            }
            BizCodeMatchUtils.e.put(name, autoTrackPageInfo);
            return autoTrackPageInfo;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, "onActivityCreated");
        this.f7592a = System.currentTimeMillis();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        a(activity, "onActivityDestroyed");
        if (a(activity)) {
            com.iap.ac.android.loglite.log.PageMonitor.a().a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity, "onActivityPaused");
        if (a(activity)) {
            HashMap hashMap = new HashMap();
            hashMap.put("logVersion", "1");
            com.iap.ac.android.loglite.log.PageMonitor.a().a(activity, d.f7591a, this.b, this.c, hashMap);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity, "onActivityResumed");
        if (a(activity)) {
            d = a((Object) activity);
            com.iap.ac.android.loglite.log.PageMonitor.a().a(activity, d.f7591a);
            if (this.f7592a > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = this.f7592a;
                String str = d.f7591a;
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                sb.append(currentTimeMillis - j);
                hashMap.put("native_page_render_performance_time", sb.toString());
                hashMap.put("logVersion", "1");
                PagePerformanceLog pagePerformanceLog = new PagePerformanceLog(str, "native_page_render_performance", hashMap);
                if (!TextUtils.isEmpty(this.b)) {
                    pagePerformanceLog.c = this.b;
                }
                if (!TextUtils.isEmpty(this.c)) {
                    pagePerformanceLog.e = this.c;
                }
                AnalyticsContext.getInstance().getStorageManager().a(pagePerformanceLog, null);
                LoggerWrapper.d("AutoPageMonitor", pagePerformanceLog.toString());
            }
        }
        this.f7592a = 0L;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public final void a(Activity activity, String str) {
        LoggerWrapper.d("AutoPageMonitor", String.format("auto page monitor status,activity name is:%s,activity's lifecycle is:%s,auto monitor status:%b", activity.getClass().getSimpleName(), str, Boolean.valueOf(a(activity))));
    }

    public final boolean a(Activity activity) {
        return a((Object) activity).b && AnalyticsContext.getInstance().getConfigurationManager().d;
    }
}
