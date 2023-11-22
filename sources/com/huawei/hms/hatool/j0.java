package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.huawei.hms.hatool.f0;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class j0 implements n0 {
    public JSONObject BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public Boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String PlaceComponentResult;
    public Context getAuthRequestContext = b.lookAheadTest();
    public String moveToNextValue;
    public String scheduleImpl;

    public j0(String str, JSONObject jSONObject, String str2, String str3, long j) {
        boolean z;
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = jSONObject;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.PlaceComponentResult = str3;
        this.scheduleImpl = String.valueOf(j);
        if (a.getErrorConfigVersion(str2, "oper")) {
            e0 PlaceComponentResult = e0.PlaceComponentResult();
            if (!PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.containsKey(str2)) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.put(str2, new f0());
            }
            f0 f0Var = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.get(str2);
            f0.a aVar = f0Var.PlaceComponentResult;
            String str4 = "";
            if (aVar == null) {
                y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Session is first flush");
                f0Var.PlaceComponentResult = new f0.a(j);
            } else {
                z = f0.this.getAuthRequestContext;
                if (z) {
                    f0.BuiltInFictitiousFunctionClassFactory(f0.this);
                } else if (!aVar.PlaceComponentResult(aVar.KClassImpl$Data$declaredNonStaticMembers$2, j) && !f0.a.getAuthRequestContext(aVar.KClassImpl$Data$declaredNonStaticMembers$2, j)) {
                    aVar.KClassImpl$Data$declaredNonStaticMembers$2 = j;
                    aVar.getAuthRequestContext = false;
                }
                y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "getNewSession() session is flush!");
                String obj = UUID.randomUUID().toString();
                aVar.PlaceComponentResult = obj;
                aVar.PlaceComponentResult = obj.replace("-", "");
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.PlaceComponentResult);
                sb.append("_");
                sb.append(j);
                aVar.PlaceComponentResult = sb.toString();
                aVar.KClassImpl$Data$declaredNonStaticMembers$2 = j;
                aVar.getAuthRequestContext = true;
            }
            f0.a aVar2 = f0Var.PlaceComponentResult;
            if (aVar2 == null) {
                y.moveToNextValue("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
            } else {
                str4 = aVar2.PlaceComponentResult;
            }
            this.moveToNextValue = str4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.valueOf(f0Var.MyBillsEntityDataFactory());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "Begin to run EventRecordTask...");
        int scheduleImpl = b.scheduleImpl();
        int NetworkUserEntityData$$ExternalSyntheticLambda0 = c.NetworkUserEntityData$$ExternalSyntheticLambda0(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
        if (q0.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, "stat_v2_1", scheduleImpl * CrashCombineUtils.DEFAULT_MAX_INFO_LEN)) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "stat sp file reach max limited size, discard new event");
            h0.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2("", "alltype");
            return;
        }
        q qVar = new q();
        qVar.getAuthRequestContext = this.MyBillsEntityDataFactory;
        qVar.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.toString();
        qVar.MyBillsEntityDataFactory = this.PlaceComponentResult;
        qVar.PlaceComponentResult = this.scheduleImpl;
        qVar.BuiltInFictitiousFunctionClassFactory = this.moveToNextValue;
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        qVar.lookAheadTest = bool == null ? null : String.valueOf(bool);
        try {
            JSONObject PlaceComponentResult = qVar.PlaceComponentResult();
            PlaceComponentResult.put("properties", d.KClassImpl$Data$declaredNonStaticMembers$2(qVar.KClassImpl$Data$declaredNonStaticMembers$2, d0.PlaceComponentResult().MyBillsEntityDataFactory()));
            String authRequestContext = u0.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
            String MyBillsEntityDataFactory = g0.MyBillsEntityDataFactory(this.getAuthRequestContext, "stat_v2_1", authRequestContext, "");
            try {
                jSONArray = !TextUtils.isEmpty(MyBillsEntityDataFactory) ? new JSONArray(MyBillsEntityDataFactory) : new JSONArray();
            } catch (JSONException unused) {
                y.MyBillsEntityDataFactory("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(PlaceComponentResult);
            g0.getAuthRequestContext(this.getAuthRequestContext, "stat_v2_1", authRequestContext, jSONArray.toString());
            if (jSONArray.toString().length() > NetworkUserEntityData$$ExternalSyntheticLambda0 * 1024) {
                h0.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
            }
        } catch (JSONException unused2) {
            y.PlaceComponentResult("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
