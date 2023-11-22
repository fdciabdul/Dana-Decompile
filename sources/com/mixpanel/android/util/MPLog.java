package com.mixpanel.android.util;

import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes.dex */
public class MPLog {
    private static int BuiltInFictitiousFunctionClassFactory = 5;

    public static void MyBillsEntityDataFactory() {
    }

    public static void getAuthRequestContext() {
    }

    public static void PlaceComponentResult() {
        BuiltInFictitiousFunctionClassFactory = 2;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (MyBillsEntityDataFactory(2)) {
            InstrumentInjector.log_v(str, str2);
        }
    }

    public static void MyBillsEntityDataFactory(String str, String str2, Throwable th) {
        if (MyBillsEntityDataFactory(2)) {
            InstrumentInjector.log_v(str, str2, th);
        }
    }

    public static void PlaceComponentResult(String str, String str2) {
        if (MyBillsEntityDataFactory(3)) {
            InstrumentInjector.log_d(str, str2);
        }
    }

    public static void getAuthRequestContext(String str, String str2, Throwable th) {
        if (MyBillsEntityDataFactory(3)) {
            InstrumentInjector.log_d(str, str2, th);
        }
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        if (MyBillsEntityDataFactory(4)) {
            InstrumentInjector.log_i(str, str2);
        }
    }

    public static void PlaceComponentResult(String str, String str2, Throwable th) {
        if (MyBillsEntityDataFactory(4)) {
            InstrumentInjector.log_i(str, str2, th);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (MyBillsEntityDataFactory(5)) {
            InstrumentInjector.log_w(str, str2);
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, Throwable th) {
        if (MyBillsEntityDataFactory(5)) {
            InstrumentInjector.log_w(str, str2, th);
        }
    }

    public static void getAuthRequestContext(String str, String str2) {
        if (MyBillsEntityDataFactory(6)) {
            InstrumentInjector.log_e(str, str2);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, Throwable th) {
        if (MyBillsEntityDataFactory(6)) {
            InstrumentInjector.log_e(str, str2, th);
        }
    }

    private static boolean MyBillsEntityDataFactory(int i) {
        return BuiltInFictitiousFunctionClassFactory <= i;
    }
}
