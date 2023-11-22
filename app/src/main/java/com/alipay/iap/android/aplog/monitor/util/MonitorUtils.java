package com.alipay.iap.android.aplog.monitor.util;

import android.content.Context;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class MonitorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static int f6938a = -1;

    public static boolean a() {
        if (f6938a < 0) {
            Context applicationContext = LoggerFactory.getLogContext().getApplicationContext();
            if (applicationContext == null) {
                return false;
            }
            try {
                f6938a = (applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 16384).flags & 2) == 2 ? 1 : 0;
            } catch (Throwable th) {
                InstrumentInjector.log_e("MonitorUtils", "isDebuggable", th);
                f6938a = 0;
            }
        }
        return f6938a == 1;
    }
}
