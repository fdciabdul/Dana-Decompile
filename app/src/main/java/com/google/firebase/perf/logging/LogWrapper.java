package com.google.firebase.perf.logging;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    public static LogWrapper getInstance() {
        LogWrapper logWrapper;
        synchronized (LogWrapper.class) {
            if (instance == null) {
                instance = new LogWrapper();
            }
            logWrapper = instance;
        }
        return logWrapper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        InstrumentInjector.log_d(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(String str) {
        InstrumentInjector.log_v(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        InstrumentInjector.log_i(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str) {
        InstrumentInjector.log_w(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str) {
        InstrumentInjector.log_e(LOG_TAG, str);
    }

    private LogWrapper() {
    }
}
