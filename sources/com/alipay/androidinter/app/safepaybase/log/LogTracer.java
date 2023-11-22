package com.alipay.androidinter.app.safepaybase.log;

import android.content.Context;
import com.alipay.androidinter.safepaylog.api.LogFactory;

/* loaded from: classes6.dex */
public class LogTracer {
    private static LogTracer mInstance;

    public static LogTracer getInstance() {
        if (mInstance == null) {
            mInstance = new LogTracer();
        }
        return mInstance;
    }

    public void initialize(Context context) {
        LogFactory.initialize(context);
    }

    public void traceException(String str, String str2, Throwable th) {
        LogFactory.traceException(str, str2, th);
    }

    public void traceException(String str, String str2, String str3) {
        LogFactory.traceException(str, str2, str3);
    }

    public void traceCount(String str, String str2, String str3) {
        LogFactory.traceCount(str, str2, str3);
    }

    public void tracePerf(String str, String str2, Long l) {
        LogFactory.tracePerf(str, str2, l);
    }

    public void traceInfo(String str, String str2) {
        LogFactory.traceInfo(str, str2);
    }

    public void printExceptionStackTrace(Throwable th) {
        LogFactory.printException(th);
    }
}
