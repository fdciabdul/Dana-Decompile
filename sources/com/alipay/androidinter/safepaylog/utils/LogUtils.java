package com.alipay.androidinter.safepaylog.utils;

import com.fullstory.instrumentation.InstrumentInjector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes6.dex */
public class LogUtils {
    public static final int DEBUG = 1;
    public static final int ERROR = 8;
    public static final int INFO = 2;
    private static final String TAG = "safepaybase";
    public static final int VERBOSE = 15;
    public static final int WARNING = 4;

    public static void record(int i, String str, String str2) {
        try {
            String format = String.format(Locale.getDefault(), "[%1$s][%2$s][%3$s]", new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.getDefault()).format(new Date()), str, str2);
            if (i == 1) {
                d(format);
            } else if (i == 2) {
                i(format);
            } else if (i == 4) {
                w(format);
            } else if (i == 8) {
                e(format);
            } else if (i == 15) {
                v(format);
            }
        } catch (Throwable th) {
            printExceptionStackTrace(th);
        }
    }

    private static void v(String str) {
        v(TAG, str);
    }

    private static void v(String str, String str2) {
        log(str, str2, 15);
    }

    private static void d(String str) {
        d(TAG, str);
    }

    private static void d(String str, String str2) {
        log(str, str2, 1);
    }

    private static void i(String str) {
        i(TAG, str);
    }

    private static void i(String str, String str2) {
        log(str, str2, 2);
    }

    private static void w(String str) {
        w(TAG, str);
    }

    private static void w(String str, String str2) {
        log(str, str2, 4);
    }

    private static void e(String str) {
        e(TAG, str);
    }

    private static void e(String str, String str2) {
        log(str, str2, 8);
    }

    private static void log(String str, String str2, int i) {
        if (str2 != null && LogDebuger.isDebug()) {
            try {
                if (i == 1) {
                    InstrumentInjector.log_d(str, str2);
                } else if (i == 2) {
                    InstrumentInjector.log_i(str, str2);
                } else if (i == 4) {
                    InstrumentInjector.log_w(str, str2);
                } else if (i == 8) {
                    InstrumentInjector.log_e(str, str2);
                } else if (i == 15) {
                    InstrumentInjector.log_v(str, str2);
                }
            } catch (Throwable th) {
                printExceptionStackTrace(th);
            }
        }
    }

    public static void printExceptionStackTrace(Throwable th) {
        if (LogDebuger.isDebug()) {
            try {
                InstrumentInjector.log_e(TAG, th.getMessage());
            } catch (Throwable th2) {
                InstrumentInjector.log_e(TAG, th2.getMessage());
            }
        }
    }
}
