package com.google.firebase.crashlytics.internal;

import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class Logger {
    private int logLevel = 4;
    private final String tag;
    public static final String TAG = "FirebaseCrashlytics";
    static final Logger DEFAULT_LOGGER = new Logger(TAG);

    public Logger(String str) {
        this.tag = str;
    }

    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    public void d(String str, Throwable th) {
        if (canLog(3)) {
            InstrumentInjector.log_d(this.tag, str, th);
        }
    }

    public void v(String str, Throwable th) {
        if (canLog(2)) {
            InstrumentInjector.log_v(this.tag, str, th);
        }
    }

    public void i(String str, Throwable th) {
        if (canLog(4)) {
            InstrumentInjector.log_i(this.tag, str, th);
        }
    }

    public void w(String str, Throwable th) {
        if (canLog(5)) {
            InstrumentInjector.log_w(this.tag, str, th);
        }
    }

    public void e(String str, Throwable th) {
        if (canLog(6)) {
            InstrumentInjector.log_e(this.tag, str, th);
        }
    }

    public void d(String str) {
        d(str, null);
    }

    public void v(String str) {
        v(str, null);
    }

    public void i(String str) {
        i(str, null);
    }

    public void w(String str) {
        w(str, null);
    }

    public void e(String str) {
        e(str, null);
    }

    public void log(int i, String str) {
        log(i, str, false);
    }

    public void log(int i, String str, boolean z) {
        if (z) {
            return;
        }
        canLog(i);
    }
}
