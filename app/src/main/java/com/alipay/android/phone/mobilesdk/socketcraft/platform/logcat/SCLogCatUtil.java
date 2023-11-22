package com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat;

/* loaded from: classes6.dex */
public final class SCLogCatUtil {
    public static final void info(String str, String str2) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.info(sb.toString(), str2);
    }

    public static final void verbose(String str, String str2) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.verbose(sb.toString(), str2);
    }

    public static final void debug(String str, String str2) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.debug(sb.toString(), str2);
    }

    public static final void warn(String str, String str2) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.warn(sb.toString(), str2);
    }

    public static final void warn(String str, Throwable th) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.warn(sb.toString(), th);
    }

    public static final void warn(String str, String str2, Throwable th) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.warn(sb.toString(), str2, th);
    }

    public static final void error(String str, String str2) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.error(sb.toString(), str2);
    }

    public static final void error(String str, Throwable th) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.error(sb.toString(), th);
    }

    public static final void error(String str, String str2, Throwable th) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.error(sb.toString(), str2, th);
    }

    public static final void printInfo(String str, String str2) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.printInfo(sb.toString(), str2);
    }

    public static final void printError(String str, Throwable th) {
        SCLogCatInterface a2 = a();
        StringBuilder sb = new StringBuilder("WS_");
        sb.append(str);
        a2.printError(sb.toString(), th);
    }

    private static SCLogCatInterface a() {
        return SCLogCatFactory.getSCLog();
    }
}
