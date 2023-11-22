package com.alipay.mobile.verifyidentity.base.log;

import com.alipay.mobile.verifyidentity.adapterapi.log.ILog;
import com.alipay.mobile.verifyidentity.adapterapi.log.NormalLog;
import com.alipay.mobile.verifyidentity.base.adapter.AdapterManager;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes3.dex */
public class VILog {
    private static ILog log = null;
    private static String sExtraTag = "";

    static {
        ILog log2 = AdapterManager.getConfig() != null ? AdapterManager.getConfig().getLog() : null;
        log = log2;
        if (log2 == null) {
            log2 = new NormalLog();
        }
        log = log2;
    }

    public static void e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_e(sb.toString(), str2);
    }

    public static void e(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_e(sb.toString(), getExceptionMsg(th));
    }

    public static void e(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("::");
        sb2.append(getExceptionMsg(th));
        InstrumentInjector.log_e(obj, sb2.toString());
    }

    public static void w(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_w(sb.toString(), str2);
    }

    public static void w(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_w(sb.toString(), getExceptionMsg(th));
    }

    public static void w(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("::");
        sb2.append(getExceptionMsg(th));
        InstrumentInjector.log_w(obj, sb2.toString());
    }

    public static void i(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_i(sb.toString(), str2);
    }

    public static void i(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_i(sb.toString(), getExceptionMsg(th));
    }

    public static void i(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("::");
        sb2.append(getExceptionMsg(th));
        InstrumentInjector.log_i(obj, sb2.toString());
    }

    public static void d(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_d(sb.toString(), str2);
    }

    public static void d(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_d(sb.toString(), getExceptionMsg(th));
    }

    public static void d(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("::");
        sb2.append(getExceptionMsg(th));
        InstrumentInjector.log_d(obj, sb2.toString());
    }

    public static void v(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_v(sb.toString(), str2);
    }

    public static void v(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        InstrumentInjector.log_v(sb.toString(), getExceptionMsg(th));
    }

    public static void v(String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(sExtraTag);
        sb.append(",");
        sb.append(str);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("::");
        sb2.append(getExceptionMsg(th));
        InstrumentInjector.log_v(obj, sb2.toString());
    }

    public static String getExceptionMsg(Throwable th) {
        if (th == null) {
            return "";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            Throwable cause = th.getCause();
            if (cause == null) {
                th.printStackTrace(printWriter);
            }
            while (cause != null) {
                cause.printStackTrace(printWriter);
                cause = cause.getCause();
            }
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
