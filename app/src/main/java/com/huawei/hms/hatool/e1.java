package com.huawei.hms.hatool;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class e1 extends n {
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String KClassImpl$Data$declaredNonStaticMembers$2 = "";
    public String getAuthRequestContext = "";
    public String PlaceComponentResult = "";
    public String BuiltInFictitiousFunctionClassFactory = "";
    public String MyBillsEntityDataFactory = "";

    @Override // com.huawei.hms.hatool.s
    public final JSONObject PlaceComponentResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.scheduleImpl);
        jSONObject.put("oaid", this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        jSONObject.put("uuid", this.MyBillsEntityDataFactory);
        jSONObject.put("upid", this.BuiltInFictitiousFunctionClassFactory);
        jSONObject.put("imei", this.KClassImpl$Data$declaredNonStaticMembers$2);
        jSONObject.put("sn", this.getAuthRequestContext);
        jSONObject.put("udid", this.PlaceComponentResult);
        return jSONObject;
    }
}
