package com.huawei.hms.hatool;

import android.content.Context;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public final class i1 {
    public static i1 MyBillsEntityDataFactory;
    public Context KClassImpl$Data$declaredNonStaticMembers$2;
    public final Object PlaceComponentResult = new Object();

    public static JSONObject MyBillsEntityDataFactory(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                y.getAuthRequestContext("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    public static void PlaceComponentResult(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            h0.BuiltInFictitiousFunctionClassFactory();
            h0.MyBillsEntityDataFactory(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            y.moveToNextValue("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public static i1 MyBillsEntityDataFactory() {
        if (MyBillsEntityDataFactory == null) {
            synchronized (i1.class) {
                if (MyBillsEntityDataFactory == null) {
                    MyBillsEntityDataFactory = new i1();
                }
            }
        }
        return MyBillsEntityDataFactory;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        h0 BuiltInFictitiousFunctionClassFactory = h0.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory == null) {
            y.PlaceComponentResult("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "onReport: Before calling runtaskhandler()");
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(str, u0.getAuthRequestContext(-1), b.moveToNextValue());
    }
}
