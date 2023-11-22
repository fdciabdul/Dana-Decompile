package com.huawei.hms.hatool;

import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes8.dex */
public class y {
    public static z BuiltInFictitiousFunctionClassFactory = new z();

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (!MyBillsEntityDataFactory() || str2 == null) {
            return;
        }
        z.MyBillsEntityDataFactory(4, str, str2);
    }

    public static void BuiltInFictitiousFunctionClassFactory(String str, String str2, Object... objArr) {
        if (MyBillsEntityDataFactory()) {
            z.MyBillsEntityDataFactory(4, str, String.format(str2, objArr));
        }
    }

    private static boolean BuiltInFictitiousFunctionClassFactory() {
        return BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(5);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (PlaceComponentResult()) {
            z.MyBillsEntityDataFactory(3, str, str2);
        }
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        if (str2 != null) {
            z.MyBillsEntityDataFactory(4, str, str2);
        }
    }

    private static boolean MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(4);
    }

    public static void PlaceComponentResult(String str, String str2) {
        if (str2 != null) {
            z.MyBillsEntityDataFactory(5, str, str2);
        }
    }

    private static boolean PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(3);
    }

    public static void getAuthRequestContext(String str, String str2) {
        if (!getAuthRequestContext() || str2 == null) {
            return;
        }
        z.MyBillsEntityDataFactory(6, str, str2);
    }

    private static boolean getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(6);
    }

    public static void moveToNextValue(String str, String str2) {
        if (!BuiltInFictitiousFunctionClassFactory() || str2 == null) {
            return;
        }
        z.MyBillsEntityDataFactory(5, str, str2);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        String str;
        z zVar = BuiltInFictitiousFunctionClassFactory;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 19) {
            sb.append(System.lineSeparator());
            sb.append("======================================= ");
            sb.append(System.lineSeparator());
            sb.append(z.getAuthRequestContext());
            sb.append(System.lineSeparator());
            str = "=======================================";
        } else {
            sb.append("====================");
            sb.append(z.getAuthRequestContext());
            str = "===================";
        }
        sb.append(str);
        InstrumentInjector.log_i("FormalHASDK", sb.toString());
        zVar.getAuthRequestContext = 3;
        zVar.BuiltInFictitiousFunctionClassFactory = true;
    }

    public static void getAuthRequestContext(String str, String str2, Object... objArr) {
        String format = String.format(str2, objArr);
        if (format != null) {
            z.MyBillsEntityDataFactory(4, str, format);
        }
    }
}
