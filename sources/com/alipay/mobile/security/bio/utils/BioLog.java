package com.alipay.mobile.security.bio.utils;

import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes7.dex */
public final class BioLog {
    public static final String DIAGNOSE = "diagnose";
    private static final String TAG = "BIOLOGY";
    private static final String TAG_PREFIX = "BIOLOGY_";
    private static Logger sTargetLogger = new AndroidLogger();

    /* loaded from: classes7.dex */
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
        protected final String getStackTraceString(Throwable th) {
            return Log.getStackTraceString(th);
        }
    }

    private BioLog() {
    }

    public static void setLogger(Logger logger) {
        sTargetLogger = logger;
    }

    public static void v(String str) {
        sTargetLogger.v("BIOLOGY", str);
    }

    public static void v(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.v(sb.toString(), str2);
    }

    public static void d(String str) {
        sTargetLogger.d("BIOLOGY", str);
    }

    public static void d(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.d(sb.toString(), str2);
    }

    public static void i(String str) {
        sTargetLogger.i("BIOLOGY", str);
    }

    public static void i(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.i(sb.toString(), str2);
    }

    public static void w(String str) {
        sTargetLogger.w("BIOLOGY", str);
    }

    public static void w(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.w(sb.toString(), str2);
    }

    public static void w(Throwable th) {
        sTargetLogger.w("BIOLOGY", th);
    }

    public static void w(String str, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.w(sb.toString(), th);
    }

    public static void w(String str, String str2, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.w(sb.toString(), str2, th);
    }

    public static void e(String str) {
        sTargetLogger.e("BIOLOGY", str);
    }

    public static void e(String str, String str2) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.e(sb.toString(), str2);
    }

    public static void e(Throwable th) {
        sTargetLogger.e("BIOLOGY", th);
    }

    public static void e(String str, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.e(sb.toString(), th);
    }

    public static void e(String str, String str2, Throwable th) {
        Logger logger = sTargetLogger;
        StringBuilder sb = new StringBuilder();
        sb.append(TAG_PREFIX);
        sb.append(str);
        logger.e(sb.toString(), str2, th);
    }
}
