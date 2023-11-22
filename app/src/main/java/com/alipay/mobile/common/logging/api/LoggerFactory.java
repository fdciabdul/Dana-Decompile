package com.alipay.mobile.common.logging.api;

import android.content.Context;
import com.alipay.mobile.common.logging.SyncLogUtil;
import com.alipay.mobile.common.logging.api.trace.TraceLogger;
import com.alipay.mobile.common.logging.impl.TraceLoggerImpl;

/* loaded from: classes.dex */
public class LoggerFactory {
    private LoggerFactory() {
    }

    public static void init(Context context) {
        synchronized (LoggerFactory.class) {
            SyncLogUtil.init(context);
        }
    }

    public static TraceLogger getTraceLogger() {
        TraceLoggerImpl traceLoggerImpl;
        synchronized (LoggerFactory.class) {
            traceLoggerImpl = new TraceLoggerImpl();
        }
        return traceLoggerImpl;
    }
}
