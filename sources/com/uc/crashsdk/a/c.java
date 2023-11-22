package com.uc.crashsdk.a;

import com.fullstory.instrumentation.InstrumentInjector;
import com.uc.crashsdk.JNIBridge;
import com.uc.crashsdk.p;

/* loaded from: classes8.dex */
public final class c {
    public static void a(String str) {
        if (p.G()) {
            InstrumentInjector.log_d("crashsdk", str);
        }
    }

    public static void b(String str) {
        if (p.G()) {
            InstrumentInjector.log_i("crashsdk", str);
        }
    }

    public static void c(String str) {
        if (p.G()) {
            InstrumentInjector.log_w("crashsdk", str);
        }
    }

    public static void a(String str, String str2) {
        if (p.G()) {
            InstrumentInjector.log_e(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(5, str, str2);
        } else {
            InstrumentInjector.log_w(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeLog(6, str, str2);
        } else {
            InstrumentInjector.log_e(str, str2);
        }
    }
}
