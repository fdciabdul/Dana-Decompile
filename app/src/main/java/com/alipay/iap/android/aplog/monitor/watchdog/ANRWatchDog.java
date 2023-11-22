package com.alipay.iap.android.aplog.monitor.watchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alipay.iap.android.aplog.api.LogHelper;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.monitor.util.ANRPerformanceLogHelper;
import com.alipay.iap.android.aplog.monitor.util.ANRUtil;
import com.alipay.iap.android.aplog.monitor.util.MonitorUtils;
import com.alipay.iap.android.aplog.util.APMTimerJob;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class ANRWatchDog extends APMTimerJob {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6940a = "ANRWatchDog";
    private final Handler b = new Handler(Looper.getMainLooper());
    private volatile int c = 0;
    private volatile int d = 0;
    private volatile int e = -1;
    private final Runnable f = new Runnable() { // from class: com.alipay.iap.android.aplog.monitor.watchdog.ANRWatchDog.1
        @Override // java.lang.Runnable
        public void run() {
            ANRWatchDog aNRWatchDog = ANRWatchDog.this;
            aNRWatchDog.d = (aNRWatchDog.d + 1) % 10;
        }
    };
    private boolean g = false;

    @Override // com.alipay.iap.android.aplog.util.APMTimerJob
    public void doJob() {
        if (this.d == this.e && (!MonitorUtils.a() || !Debug.isDebuggerConnected())) {
            a();
        } else {
            this.c = 0;
        }
        this.e = this.d;
        this.b.post(this.f);
    }

    void a() {
        TraceLogger traceLogger = LoggerFactory.getTraceLogger();
        String str = f6940a;
        StringBuilder sb = new StringBuilder();
        sb.append("countCheck:");
        sb.append(1);
        traceLogger.warn(str, sb.toString());
        TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("waitCount:");
        sb2.append(this.c);
        traceLogger2.warn(str, sb2.toString());
        ANRError NewMainOnly = ANRError.NewMainOnly();
        LoggerFactory.getTraceLogger().warn("automationanr", "Force Start parse for automation");
        LoggerFactory.getTraceLogger().warn(str, "anr", NewMainOnly);
        LoggerFactory.getTraceLogger().warn("automationanr", "Force End parse for automation");
        String stackTraceString = Log.getStackTraceString(NewMainOnly);
        if (this.c == 0) {
            if (!ANRUtil.a(0, stackTraceString)) {
                LoggerFactory.getTraceLogger().warn(str, "report nothing, invalidStack");
                ANRUtil.a();
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                hashMap.put("stackFrame", stackTraceString);
                hashMap.put("anrTime", String.valueOf(currentTimeMillis));
                hashMap.put("errorCode", "1000");
                hashMap.put("threadsTrace", ANRUtil.a());
                LogHelper.performance(ANRPerformanceLogHelper.a("APM_ANR", "1000", hashMap));
                LoggerFactory.getTraceLogger().warn(str, "report:1000");
            }
        } else if (this.c == 1) {
            if (!ANRUtil.a(0, stackTraceString)) {
                LoggerFactory.getTraceLogger().warn(str, "report nothing, invalidStack");
                ANRUtil.a();
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("stackFrame", stackTraceString);
                hashMap2.put("anrTime", String.valueOf(currentTimeMillis2));
                hashMap2.put("errorCode", "1114");
                hashMap2.put("threadsTrace", ANRUtil.a());
                LogHelper.performance(ANRPerformanceLogHelper.a("APM_ANR", "1114", hashMap2));
                LoggerFactory.getTraceLogger().warn(str, "report:1114");
            }
        } else {
            ANRUtil.a();
        }
        this.c++;
    }
}
