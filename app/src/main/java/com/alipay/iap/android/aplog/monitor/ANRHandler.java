package com.alipay.iap.android.aplog.monitor;

import android.content.Context;
import android.os.Build;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.monitor.watchdog.ANRWatchDog;
import com.alipay.iap.android.aplog.util.APMTimer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class ANRHandler {

    /* renamed from: a  reason: collision with root package name */
    private static ANRWatchDog f6926a = null;
    private static ANRMonitor b = null;
    private static ANRMonitor c = null;
    private static boolean d = true;
    private static int e;

    static {
        try {
            if ("MI MAX 2".equalsIgnoreCase(Build.MODEL)) {
                d = false;
            }
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().warn("ANRHandler", th);
        }
        e = -1;
    }

    public static void a(Context context) {
        try {
            if (d) {
                if (b == null) {
                    b = new ANRMonitorImpl(RangedBeacon.DEFAULT_MAX_TRACKING_AGE, "1000");
                }
                if (c == null) {
                    c = new LagMonitorImpl(1000L, "1100");
                }
                b.e();
                c.e();
                e = 1;
            } else {
                if (f6926a == null) {
                    f6926a = new ANRWatchDog();
                    APMTimer.getInstance().register(f6926a, 0L, TimeUnit.SECONDS.toMillis(5L));
                }
                e = 0;
            }
            LoggerFactory.getTraceLogger().info("ANRHandler", "startAnrWatch");
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().error("ANRHandler", th);
        }
    }

    public static void a() {
        try {
            int i = e;
            if (i == 1) {
                ANRMonitor aNRMonitor = b;
                if (aNRMonitor != null) {
                    aNRMonitor.g();
                }
                ANRMonitor aNRMonitor2 = c;
                if (aNRMonitor2 != null) {
                    aNRMonitor2.g();
                }
            } else if (i == 0 && f6926a != null) {
                APMTimer.getInstance().unregister(f6926a);
                f6926a = null;
            }
            LoggerFactory.getTraceLogger().info("ANRHandler", "stopAnrWatch");
        } catch (Throwable th) {
            LoggerFactory.getTraceLogger().error("ANRHandler", th);
        }
    }
}
