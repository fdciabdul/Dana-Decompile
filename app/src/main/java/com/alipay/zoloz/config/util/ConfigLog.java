package com.alipay.zoloz.config.util;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public class ConfigLog {
    private static final boolean IS_DEBUG = false;

    private static boolean isDebug() {
        return false;
    }

    public static void d(String str, String str2) {
        if (isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigLog_");
            sb.append(str);
            InstrumentInjector.log_d(sb.toString(), str2);
        }
    }

    public static void w(String str, String str2) {
        if (isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigLog_");
            sb.append(str);
            InstrumentInjector.log_w(sb.toString(), str2);
        }
    }

    public static void e(String str, String str2, Exception exc) {
        if (isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigLog_");
            sb.append(str);
            InstrumentInjector.log_e(sb.toString(), str2, exc);
        }
    }

    public static void e(String str, Exception exc) {
        if (isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigLog_");
            sb.append(str);
            InstrumentInjector.log_e(sb.toString(), "", exc);
        }
    }

    public static void e(String str, String str2) {
        if (isDebug()) {
            StringBuilder sb = new StringBuilder();
            sb.append("ConfigLog_");
            sb.append(str);
            InstrumentInjector.log_e(sb.toString(), str2);
        }
    }
}
