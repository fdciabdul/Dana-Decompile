package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class q implements s {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;
    public String PlaceComponentResult;
    public String getAuthRequestContext;
    public String lookAheadTest;

    public final void KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.getAuthRequestContext = jSONObject.optString("event");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.optString("properties");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, d0.PlaceComponentResult().MyBillsEntityDataFactory());
        this.MyBillsEntityDataFactory = jSONObject.optString("type");
        this.PlaceComponentResult = jSONObject.optString("eventtime");
        this.BuiltInFictitiousFunctionClassFactory = jSONObject.optString("event_session_name");
        this.lookAheadTest = jSONObject.optString("first_session_event");
    }

    @Override // com.huawei.hms.hatool.s
    public final JSONObject PlaceComponentResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.MyBillsEntityDataFactory);
        jSONObject.put("eventtime", this.PlaceComponentResult);
        jSONObject.put("event", this.getAuthRequestContext);
        jSONObject.put("event_session_name", this.BuiltInFictitiousFunctionClassFactory);
        jSONObject.put("first_session_event", this.lookAheadTest);
        if (TextUtils.isEmpty(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.KClassImpl$Data$declaredNonStaticMembers$2));
        return jSONObject;
    }
}
