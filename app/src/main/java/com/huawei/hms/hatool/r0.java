package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.hatool.o0;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.util.HashMap;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class r0 {
    private static boolean BuiltInFictitiousFunctionClassFactory() {
        String authRequestContext = b.getAuthRequestContext();
        if (TextUtils.isEmpty(authRequestContext)) {
            authRequestContext = g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "public_key_time_interval", "");
            i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = authRequestContext;
        }
        String initRecordTimeStamp = b.initRecordTimeStamp();
        if (TextUtils.isEmpty(initRecordTimeStamp)) {
            initRecordTimeStamp = g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "public_key_time_last", "");
            b.BuiltInFictitiousFunctionClassFactory(initRecordTimeStamp);
        }
        if (TextUtils.isEmpty(authRequestContext) || TextUtils.isEmpty(initRecordTimeStamp)) {
            return true;
        }
        try {
            return System.currentTimeMillis() - Long.parseLong(initRecordTimeStamp) > ((long) Integer.parseInt(authRequestContext));
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkCachePubKey NumberFormatException :");
            sb.append(e.getMessage());
            y.PlaceComponentResult("GetPublicKey", sb.toString());
            return true;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        b0 b0Var;
        String str3;
        String replace = "{url}/getPublicKey?keytype=2".replace("{url}", c.scheduleImpl(str, str2));
        String errorConfigVersion = b.getErrorConfigVersion();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", errorConfigVersion);
        try {
            b0Var = a0.getAuthRequestContext(replace, new byte[0], hashMap, "POST");
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get pubKey response Exception :");
            sb.append(e.getMessage());
            y.PlaceComponentResult("GetPublicKey", sb.toString());
            b0Var = null;
        }
        if (b0Var == null) {
            str3 = "get pubKey response is null";
        } else if (b0Var.MyBillsEntityDataFactory == 200) {
            if (TextUtils.isEmpty(b0Var.KClassImpl$Data$declaredNonStaticMembers$2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(b0Var.KClassImpl$Data$declaredNonStaticMembers$2);
                String optString = jSONObject.optString("publicKey");
                String optString2 = jSONObject.optString("publicKeyOM");
                String optString3 = jSONObject.optString("pubkey_version");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(System.currentTimeMillis());
                String obj = sb2.toString();
                String optString4 = jSONObject.optString("timeInterval");
                g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "public_key_oper", AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2("HiAnalytics_Sdk_Public_Sp_Key", optString));
                g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "public_key_maint", AesGcmKS.KClassImpl$Data$declaredNonStaticMembers$2("HiAnalytics_Sdk_Public_Sp_Key", optString2));
                g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "public_key_time_interval", optString4);
                g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "public_key_version", optString3);
                g0.getAuthRequestContext(b.lookAheadTest(), "Privacy_MY", "public_key_time_last", obj);
                b.getAuthRequestContext(optString);
                b.PlaceComponentResult(optString2);
                i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.isLayoutRequested = optString3;
                b.BuiltInFictitiousFunctionClassFactory(obj);
                i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = optString4;
                return;
            } catch (JSONException e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("get pubKey parse json JSONException :");
                sb3.append(e2.getMessage());
                y.PlaceComponentResult("GetPublicKey", sb3.toString());
                return;
            }
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("get pubKey fail HttpCode :");
            sb4.append(b0Var.MyBillsEntityDataFactory);
            str3 = sb4.toString();
        }
        y.PlaceComponentResult("GetPublicKey", str3);
    }

    public static String getAuthRequestContext(String str, String str2) {
        String str3;
        String BuiltInFictitiousFunctionClassFactory = b.BuiltInFictitiousFunctionClassFactory();
        if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
            BuiltInFictitiousFunctionClassFactory = g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "public_key_version", "");
            i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.isLayoutRequested = BuiltInFictitiousFunctionClassFactory;
        }
        if ("maint".equals(str2)) {
            str3 = b.GetContactSyncConfig();
            if (TextUtils.isEmpty(str3)) {
                str3 = AesGcmKS.BuiltInFictitiousFunctionClassFactory("HiAnalytics_Sdk_Public_Sp_Key", g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "public_key_maint", ""));
                b.PlaceComponentResult(str3);
            }
        } else {
            str3 = i.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory.GetContactSyncConfig;
            if (TextUtils.isEmpty(str3)) {
                str3 = AesGcmKS.BuiltInFictitiousFunctionClassFactory("HiAnalytics_Sdk_Public_Sp_Key", g0.MyBillsEntityDataFactory(b.lookAheadTest(), "Privacy_MY", "public_key_oper", ""));
                b.getAuthRequestContext(str3);
            }
        }
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) || BuiltInFictitiousFunctionClassFactory()) {
            try {
                o0.PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2.execute(new o0.a(new m0(str, str2)));
                return null;
            } catch (RejectedExecutionException unused) {
                y.PlaceComponentResult("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
                return null;
            }
        }
        return str3;
    }
}
