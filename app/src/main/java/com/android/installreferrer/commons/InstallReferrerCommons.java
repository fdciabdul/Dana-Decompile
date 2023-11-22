package com.android.installreferrer.commons;

import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public final class InstallReferrerCommons {
    public static void logVerbose(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            InstrumentInjector.log_v(str, str2);
        }
    }

    public static void logWarn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            InstrumentInjector.log_w(str, str2);
        }
    }
}
