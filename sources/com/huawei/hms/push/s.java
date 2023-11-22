package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public abstract class s {
    public static final Object MyBillsEntityDataFactory = new Object();

    public static String getAuthRequestContext(Context context) {
        return AGConnectServicesConfig.PlaceComponentResult(context).BuiltInFictitiousFunctionClassFactory("client/project_id");
    }

    public static boolean MyBillsEntityDataFactory(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        return jSONObject == null || (TextUtils.isEmpty(str) && jSONObject2 == null);
    }
}
