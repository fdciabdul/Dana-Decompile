package com.alipay.mobile.rome.syncsdk.util;

import com.alipay.mobile.common.logging.api.LoggerFactory;
import com.alipay.mobile.common.logging.api.trace.TraceLogger;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    static volatile TraceLogger f7265a;

    public static void a(String str, String str2) {
        if (f7265a == null) {
            f7265a = LoggerFactory.getTraceLogger();
        }
        TraceLogger traceLogger = f7265a;
        StringBuilder sb = new StringBuilder("sync_");
        sb.append(str);
        traceLogger.debug(sb.toString(), str2);
    }

    public static void b(String str, String str2) {
        if (f7265a == null) {
            f7265a = LoggerFactory.getTraceLogger();
        }
        TraceLogger traceLogger = f7265a;
        StringBuilder sb = new StringBuilder("sync_");
        sb.append(str);
        traceLogger.info(sb.toString(), str2);
    }

    public static void c(String str, String str2) {
        if (f7265a == null) {
            f7265a = LoggerFactory.getTraceLogger();
        }
        TraceLogger traceLogger = f7265a;
        StringBuilder sb = new StringBuilder("sync_");
        sb.append(str);
        traceLogger.warn(sb.toString(), str2);
    }

    public static void d(String str, String str2) {
        if (f7265a == null) {
            f7265a = LoggerFactory.getTraceLogger();
        }
        TraceLogger traceLogger = f7265a;
        StringBuilder sb = new StringBuilder("sync_");
        sb.append(str);
        traceLogger.error(sb.toString(), str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (f7265a == null) {
            f7265a = LoggerFactory.getTraceLogger();
        }
        TraceLogger traceLogger = f7265a;
        StringBuilder sb = new StringBuilder("sync_");
        sb.append(str);
        traceLogger.error(sb.toString(), str2, th);
    }
}
