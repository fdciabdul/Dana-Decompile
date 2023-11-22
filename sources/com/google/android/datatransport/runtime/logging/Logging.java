package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public final class Logging {
    private static final String LOG_PREFIX = "TRuntime.";
    private static final int MAX_LOG_TAG_SIZE_IN_SDK_N = 23;

    private Logging() {
    }

    private static String getTag(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return concatTag(LOG_PREFIX, str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(LOG_PREFIX);
        sb.append(str);
        return sb.toString();
    }

    private static String concatTag(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        String obj = sb.toString();
        return obj.length() > 23 ? obj.substring(0, 23) : obj;
    }

    public static void d(String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            InstrumentInjector.log_d(tag, str2);
        }
    }

    public static void d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            InstrumentInjector.log_d(tag, String.format(str2, obj));
        }
    }

    public static void d(String str, String str2, Object obj, Object obj2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            InstrumentInjector.log_d(tag, String.format(str2, obj, obj2));
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            InstrumentInjector.log_d(tag, String.format(str2, objArr));
        }
    }

    public static void i(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 4)) {
            InstrumentInjector.log_i(tag, String.format(str2, obj));
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            InstrumentInjector.log_e(tag, str2, th);
        }
    }

    public static void w(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 5)) {
            InstrumentInjector.log_w(tag, String.format(str2, obj));
        }
    }
}
