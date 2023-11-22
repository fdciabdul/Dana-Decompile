package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class d extends a {
    public d(Context context, String str, boolean z) {
        this.PlaceComponentResult = true;
        if (KClassImpl$Data$declaredNonStaticMembers$2(TextUtils.isEmpty(str) ? "grs_app_global_route_config.json" : str, context) == 0) {
            this.MyBillsEntityDataFactory = true;
        }
    }

    public d(boolean z) {
        this.PlaceComponentResult = true;
        this.MyBillsEntityDataFactory = false;
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public final int MyBillsEntityDataFactory(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2(str);
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public final int getAuthRequestContext(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new com.huawei.hms.framework.network.grs.local.model.a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONArray("applications").getJSONObject(0);
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = jSONObject.getString("name");
            JSONArray jSONArray = jSONObject.getJSONArray("services");
            if (jSONArray != null && jSONArray.length() != 0) {
                if (jSONObject.has("customservices")) {
                    KClassImpl$Data$declaredNonStaticMembers$2(jSONObject.getJSONArray("customservices"));
                }
                return 0;
            }
            return -1;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.f.a
    public final int BuiltInFictitiousFunctionClassFactory(String str) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        this.getAuthRequestContext = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("countryOrAreaGroups")) {
                jSONArray = jSONObject.getJSONArray("countryOrAreaGroups");
            } else if (jSONObject.has("countryGroups")) {
                jSONArray = jSONObject.getJSONArray("countryGroups");
            } else {
                Logger.e("LocalManagerV2", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                jSONArray = null;
            }
            if (jSONArray == null) {
                return -1;
            }
            if (jSONArray.length() != 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    com.huawei.hms.framework.network.grs.local.model.b bVar = new com.huawei.hms.framework.network.grs.local.model.b();
                    bVar.MyBillsEntityDataFactory = jSONObject2.getString("id");
                    jSONObject2.getString("name");
                    jSONObject2.getString("description");
                    if (jSONObject2.has("countriesOrAreas")) {
                        jSONArray2 = jSONObject2.getJSONArray("countriesOrAreas");
                    } else if (jSONObject2.has("countries")) {
                        jSONArray2 = jSONObject2.getJSONArray("countries");
                    } else {
                        Logger.w("LocalManagerV2", "current country or area group has not config countries or areas.");
                        jSONArray2 = null;
                    }
                    HashSet hashSet = new HashSet(16);
                    if (jSONArray2 != null && jSONArray2.length() != 0) {
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            hashSet.add((String) jSONArray2.get(i2));
                        }
                        bVar.BuiltInFictitiousFunctionClassFactory = hashSet;
                        this.getAuthRequestContext.add(bVar);
                    }
                    return -1;
                }
            }
            return 0;
        } catch (JSONException e) {
            Logger.w("LocalManagerV2", "parse countrygroup failed maybe json style is wrong. %s", StringUtils.anonymizeMessage(e.getMessage()));
            return -1;
        }
    }
}
