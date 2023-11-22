package com.huawei.hms.hatool;

import org.json.JSONObject;

/* loaded from: classes8.dex */
public class f1 extends o {
    public String BuiltInFictitiousFunctionClassFactory = "";

    @Override // com.huawei.hms.hatool.s
    public final JSONObject PlaceComponentResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.MyBillsEntityDataFactory);
        jSONObject.put("appid", this.getAuthRequestContext);
        jSONObject.put("hmac", this.BuiltInFictitiousFunctionClassFactory);
        jSONObject.put("chifer", this.scheduleImpl);
        jSONObject.put("timestamp", this.KClassImpl$Data$declaredNonStaticMembers$2);
        jSONObject.put("servicetag", this.PlaceComponentResult);
        jSONObject.put("requestid", this.getErrorConfigVersion);
        return jSONObject;
    }
}
