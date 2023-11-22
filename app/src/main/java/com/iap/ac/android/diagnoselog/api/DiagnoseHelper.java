package com.iap.ac.android.diagnoselog.api;

import android.text.TextUtils;
import com.iap.ac.android.diagnoselog.core.DiagnoseLogContext;
import com.iap.ac.android.diagnoselog.core.TraceLog;
import com.iap.ac.android.diagnoselog.core.TraceLoggerImpl;
import com.iap.ac.android.diagnoselog.storage.DiagnoseFileStorage;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes3.dex */
public class DiagnoseHelper {
    public static void d(String str, String str2, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.d(str, str2);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, SummaryActivity.DAYS, str2, null));
    }

    public static void e(String str, String str2, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.e(str, str2);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "E", str2, null));
    }

    public static void i(String str, String str2, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.i(str, str2);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "I", str2, null));
    }

    public static void v(String str, String str2, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.v(str, str2);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "V", str2, null));
    }

    public static void w(String str, String str2, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.w(str, str2);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "W", str2, null));
    }

    public static void v(String str, String str2, Throwable th, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.v(str, str2, th);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "V", str2, th));
    }

    public static void d(String str, String str2, Throwable th, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.d(str, str2, th);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, SummaryActivity.DAYS, str2, th));
    }

    public static void i(String str, String str2, Throwable th, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.i(str, str2, th);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "I", str2, th));
    }

    public static void w(String str, Throwable th, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.w(str, th);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "W", "", th));
    }

    public static void e(String str, String str2, Throwable th, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.e(str, str2, th);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "E", str2, th));
    }

    public static void w(String str, String str2, Throwable th, Boolean bool) {
        TraceLoggerImpl traceLoggerImpl = DiagnoseLogContext.b().b;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (bool.booleanValue()) {
            LoggerWrapper.w(str, str2, th);
        }
        ((DiagnoseFileStorage) DiagnoseLogContext.b().f7568a).a(new TraceLog(str, "W", str2, th));
    }
}
