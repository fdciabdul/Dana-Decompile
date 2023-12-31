package com.ap.zoloz.hummer.biz;

import android.util.Log;
import com.alipay.mobile.security.bio.utils.Logger;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes2.dex */
public final class HummerLogger {
    private static Logger sTargetLogger = new AndroidLogger();

    private HummerLogger() {
    }

    public static void setLogger(Logger logger) {
        sTargetLogger = logger;
    }

    public static void v(String str) {
        sTargetLogger.v(HummerConstants.DEBUG_LOG_TAG, str);
    }

    public static void v(String str, String str2) {
        sTargetLogger.v(str, str2);
    }

    public static void d(String str) {
        sTargetLogger.d(HummerConstants.DEBUG_LOG_TAG, str);
    }

    public static void d(String str, String str2) {
        sTargetLogger.d(str, str2);
    }

    public static void i(String str) {
        sTargetLogger.i(HummerConstants.DEBUG_LOG_TAG, str);
    }

    public static void i(String str, String str2) {
        sTargetLogger.i(str, str2);
    }

    public static void w(String str) {
        sTargetLogger.w(HummerConstants.DEBUG_LOG_TAG, str);
    }

    public static void w(String str, String str2) {
        sTargetLogger.w(str, str2);
    }

    public static void w(Throwable th) {
        sTargetLogger.w(HummerConstants.DEBUG_LOG_TAG, th);
    }

    public static void w(String str, Throwable th) {
        sTargetLogger.w(HummerConstants.DEBUG_LOG_TAG, str, th);
    }

    public static void w(String str, String str2, Throwable th) {
        sTargetLogger.w(str, str2, th);
    }

    public static void e(String str) {
        sTargetLogger.e(HummerConstants.DEBUG_LOG_TAG, str);
    }

    public static void e(String str, String str2) {
        sTargetLogger.e(str, str2);
    }

    public static void e(Throwable th) {
        sTargetLogger.e(HummerConstants.DEBUG_LOG_TAG, th);
    }

    public static void e(String str, Throwable th) {
        sTargetLogger.e(HummerConstants.DEBUG_LOG_TAG, str, th);
    }

    public static void e(String str, String str2, Throwable th) {
        sTargetLogger.e(str, str2, th);
    }

    /* loaded from: classes3.dex */
    static final class AndroidLogger extends Logger {
        private AndroidLogger() {
        }

        @Override // com.alipay.mobile.security.bio.utils.Logger
        public final int verbose(String str, String str2) {
            return InstrumentInjector.log_v(str, str2);
        }

        @Override // com.alipay.mobile.security.bio.utils.Logger
        public final int debug(String str, String str2) {
            return InstrumentInjector.log_d(str, str2);
        }

        @Override // com.alipay.mobile.security.bio.utils.Logger
        public final int info(String str, String str2) {
            return InstrumentInjector.log_i(str, str2);
        }

        @Override // com.alipay.mobile.security.bio.utils.Logger
        public final int warn(String str, String str2) {
            return InstrumentInjector.log_w(str, str2);
        }

        @Override // com.alipay.mobile.security.bio.utils.Logger
        public final int error(String str, String str2) {
            return InstrumentInjector.log_e(str, str2);
        }

        @Override // com.alipay.mobile.security.bio.utils.Logger
        public final String getStackTraceString(Throwable th) {
            return Log.getStackTraceString(th);
        }
    }
}
