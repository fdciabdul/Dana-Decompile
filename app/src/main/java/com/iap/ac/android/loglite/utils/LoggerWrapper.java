package com.iap.ac.android.loglite.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class LoggerWrapper {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7603a;

    public static void d(String str, String str2) {
        if (f7603a) {
            InstrumentInjector.log_d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f7603a) {
            InstrumentInjector.log_e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (f7603a) {
            InstrumentInjector.log_i(str, str2);
        }
    }

    public static void init(Context context) {
        f7603a = isDebuggable(context) | f7603a;
    }

    public static boolean isDebuggable(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                return (applicationInfo.flags & 2) != 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void v(String str, String str2) {
        if (f7603a) {
            InstrumentInjector.log_v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (f7603a) {
            InstrumentInjector.log_w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f7603a) {
            InstrumentInjector.log_d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f7603a) {
            InstrumentInjector.log_e(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (f7603a) {
            InstrumentInjector.log_i(str, str2, th);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (f7603a) {
            InstrumentInjector.log_v(str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f7603a) {
            InstrumentInjector.log_w(str, str2, th);
        }
    }

    public static void w(String str, Throwable th) {
        if (f7603a) {
            InstrumentInjector.log_w(str, th);
        }
    }
}
