package com.alipay.iap.android.aplog.monitor;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogHelper;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.aplog.monitor.util.ANRPerformanceLogHelper;
import com.alipay.iap.android.aplog.monitor.util.ANRUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ANRMonitorImpl extends ANRMonitor {
    @Override // com.alipay.iap.android.aplog.monitor.ANRMonitor
    String b() {
        return "SMOOTHNESS_KEY_TIME_TODAY_FOR_ANR";
    }

    @Override // com.alipay.iap.android.aplog.monitor.ANRMonitor
    String c() {
        return "SMOOTHNESS_KEY_LAST_DAY_TIME_FOR_ANR";
    }

    public ANRMonitorImpl(long j, String str) {
        super(j, str);
        this.f = new ANRTimeOuter(this, j);
    }

    @Override // com.alipay.iap.android.aplog.monitor.ANRMonitor
    public void c(long j, long j2) {
        if (d()) {
            LoggerFactory.getTraceLogger().info("ANRMonitor", "notifyBlockEvent");
            boolean z = this.b == j;
            try {
                String a2 = a(j, j2);
                String str = this.f6927a;
                if (!ANRUtil.a(0, a2)) {
                    str = "1001";
                }
                g = a2.hashCode();
                HashMap hashMap = new HashMap();
                hashMap.put("stackFrame", a2);
                hashMap.put("errorCode", str);
                String a3 = this.d.a(j, j2);
                if (!TextUtils.isEmpty(a3)) {
                    hashMap.put("threadsTrace", a3);
                }
                String a4 = this.c.a(j, j2);
                if (!TextUtils.isEmpty(a4)) {
                    hashMap.put("historyStacks", a4);
                }
                hashMap.put("cpuBusy", String.valueOf(this.e.a(j, j2)));
                String d = this.e.d();
                if (!TextUtils.isEmpty(d)) {
                    hashMap.put("cpuRate", d);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("startTime:");
                sb.append(j);
                String obj = sb.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(" endTime:");
                sb2.append(j2);
                hashMap.put("timePeriod", sb2.toString());
                if (z) {
                    a(hashMap);
                    TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("report:");
                    sb3.append(str);
                    traceLogger.warn("ANRMonitor", sb3.toString());
                    return;
                }
                TraceLogger traceLogger2 = LoggerFactory.getTraceLogger();
                StringBuilder sb4 = new StringBuilder();
                sb4.append("no report:");
                sb4.append(str);
                traceLogger2.warn("ANRMonitor", sb4.toString());
            } catch (Throwable th) {
                LoggerFactory.getTraceLogger().warn("ANRMonitor", th);
            }
        }
    }

    @Override // com.alipay.iap.android.aplog.monitor.ANRMonitor
    void a(Map<String, String> map) {
        LogHelper.performance(ANRPerformanceLogHelper.a("APM_ANR", this.f6927a, map));
        a();
    }
}
