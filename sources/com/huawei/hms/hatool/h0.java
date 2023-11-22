package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.o0;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class h0 {
    public static h0 MyBillsEntityDataFactory;
    public Context BuiltInFictitiousFunctionClassFactory;

    static {
        new HashMap();
    }

    public static h0 BuiltInFictitiousFunctionClassFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private static h0 KClassImpl$Data$declaredNonStaticMembers$2() {
        h0 h0Var;
        synchronized (h0.class) {
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new h0();
            }
            h0Var = MyBillsEntityDataFactory;
        }
        return h0Var;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (!c.getAuthRequestContext(str, str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("auto report is closed tag:");
            sb.append(str);
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
            return;
        }
        long lookAheadTest = c.lookAheadTest(str, str2);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lookAheadTest <= 30000) {
            y.moveToNextValue("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        y.KClassImpl$Data$declaredNonStaticMembers$2("hmsSdk", "begin to call onReport!");
        c.MyBillsEntityDataFactory(str, str2, currentTimeMillis);
        MyBillsEntityDataFactory(str, str2, b.moveToNextValue());
    }

    public static void MyBillsEntityDataFactory(String str, int i, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i) {
            currentTimeMillis = u0.MyBillsEntityDataFactory("yyyy-MM-dd", currentTimeMillis);
        }
        try {
            o0.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.execute(new o0.a(new j0(str2, jSONObject, str, u0.getAuthRequestContext(i), currentTimeMillis)));
        } catch (RejectedExecutionException unused) {
            y.PlaceComponentResult("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }

    public final void MyBillsEntityDataFactory(String str, String str2, String str3) {
        Context context = this.BuiltInFictitiousFunctionClassFactory;
        if (context == null) {
            y.PlaceComponentResult("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String authRequestContext = h.getAuthRequestContext(context);
        if (c.BuiltInFictitiousFunctionClassFactory(str, str2) && !"WIFI".equals(authRequestContext)) {
            StringBuilder sb = new StringBuilder();
            sb.append("strNetworkType is :");
            sb.append(authRequestContext);
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", sb.toString());
        } else if (TextUtils.isEmpty(authRequestContext) || "2G".equals(authRequestContext)) {
            y.PlaceComponentResult("hmsSdk", "The network is bad.");
        } else {
            try {
                o0.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2.execute(new o0.a(new k0(str, str2, str3)));
            } catch (RejectedExecutionException unused) {
                y.PlaceComponentResult("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
            }
        }
    }
}
