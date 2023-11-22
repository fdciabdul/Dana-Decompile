package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class l1 {
    public static j1 KClassImpl$Data$declaredNonStaticMembers$2;

    public static boolean MyBillsEntityDataFactory() {
        return o1.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult();
    }

    private static j1 KClassImpl$Data$declaredNonStaticMembers$2() {
        j1 j1Var;
        synchronized (l1.class) {
            if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                KClassImpl$Data$declaredNonStaticMembers$2 = o1.BuiltInFictitiousFunctionClassFactory().getAuthRequestContext;
            }
            j1Var = KClassImpl$Data$declaredNonStaticMembers$2;
        }
        return j1Var;
    }

    public static void getAuthRequestContext(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (KClassImpl$Data$declaredNonStaticMembers$2() == null || !w0.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult()) {
            return;
        }
        if (i != 1 && i != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Data type no longer collects range.type: ");
            sb.append(i);
            y.MyBillsEntityDataFactory("hmsSdk", sb.toString());
            return;
        }
        j1 j1Var = KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onEvent. TAG: ");
        sb2.append(j1Var.getAuthRequestContext);
        sb2.append(", TYPE: ");
        sb2.append(i);
        sb2.append(", eventId : ");
        sb2.append(str);
        y.MyBillsEntityDataFactory("hmsSdk", sb2.toString());
        if (s0.KClassImpl$Data$declaredNonStaticMembers$2(str) || !j1Var.MyBillsEntityDataFactory(i)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
            sb3.append(j1Var.getAuthRequestContext);
            sb3.append(", TYPE: ");
            sb3.append(i);
            y.PlaceComponentResult("hmsSdk", sb3.toString());
            return;
        }
        if (!s0.MyBillsEntityDataFactory(linkedHashMap)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("onEvent() parameter mapValue will be cleared.TAG: ");
            sb4.append(j1Var.getAuthRequestContext);
            sb4.append(", TYPE: ");
            sb4.append(i);
            y.PlaceComponentResult("hmsSdk", sb4.toString());
            linkedHashMap = null;
        }
        i1.MyBillsEntityDataFactory();
        String str2 = j1Var.getAuthRequestContext;
        JSONObject MyBillsEntityDataFactory = i1.MyBillsEntityDataFactory(linkedHashMap);
        h0.BuiltInFictitiousFunctionClassFactory();
        h0.MyBillsEntityDataFactory(str2, i, str, MyBillsEntityDataFactory);
    }

    @Deprecated
    public static void MyBillsEntityDataFactory(Context context, String str, String str2) {
        if (KClassImpl$Data$declaredNonStaticMembers$2() != null) {
            j1 j1Var = KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append("onEvent(context). TAG: ");
            sb.append(j1Var.getAuthRequestContext);
            sb.append(", eventId : ");
            sb.append(str);
            y.MyBillsEntityDataFactory("hmsSdk", sb.toString());
            if (context == null) {
                y.PlaceComponentResult("hmsSdk", "context is null in onevent ");
            } else if (s0.KClassImpl$Data$declaredNonStaticMembers$2(str) || !j1Var.MyBillsEntityDataFactory(0)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
                sb2.append(j1Var.getAuthRequestContext);
                y.PlaceComponentResult("hmsSdk", sb2.toString());
            } else {
                if (!s0.KClassImpl$Data$declaredNonStaticMembers$2("value", str2, 65536)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onEvent() parameter VALUE is overlong, content will be cleared.TAG: ");
                    sb3.append(j1Var.getAuthRequestContext);
                    y.PlaceComponentResult("hmsSdk", sb3.toString());
                    str2 = "";
                }
                i1.MyBillsEntityDataFactory();
                i1.PlaceComponentResult(j1Var.getAuthRequestContext, str, str2);
            }
        }
    }

    public static void getAuthRequestContext() {
        if (KClassImpl$Data$declaredNonStaticMembers$2() == null || !w0.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult()) {
            return;
        }
        j1 j1Var = KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append("onReport. TAG: ");
        sb.append(j1Var.getAuthRequestContext);
        sb.append(", TYPE: ");
        sb.append(-1);
        y.MyBillsEntityDataFactory("hmsSdk", sb.toString());
        i1.MyBillsEntityDataFactory();
        i1.KClassImpl$Data$declaredNonStaticMembers$2(j1Var.getAuthRequestContext);
    }
}
