package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class g1 extends p {
    public String BuiltInFictitiousFunctionClassFactory;
    public String MyBillsEntityDataFactory;
    public String getAuthRequestContext;

    @Override // com.huawei.hms.hatool.s
    public final JSONObject PlaceComponentResult() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.getAuthRequestContext);
        jSONObject.put("_emui_ver", this.PlaceComponentResult);
        jSONObject.put("_model", Build.MODEL);
        jSONObject.put("_mcc", this.BuiltInFictitiousFunctionClassFactory);
        jSONObject.put("_mnc", this.MyBillsEntityDataFactory);
        jSONObject.put("_package_name", this.KClassImpl$Data$declaredNonStaticMembers$2);
        jSONObject.put("_app_ver", this.getErrorConfigVersion);
        jSONObject.put("_lib_ver", "2.2.0.313");
        jSONObject.put("_channel", this.lookAheadTest);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.scheduleImpl);
        return jSONObject;
    }
}
