package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.k.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class a {
    private static d KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static final String PlaceComponentResult = "a";

    public static d KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        synchronized (a.class) {
            d dVar = KClassImpl$Data$declaredNonStaticMembers$2;
            if (dVar != null) {
                return dVar;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(GrsApp.getInstance().getBrand("/"));
            sb.append("grs_sdk_server_config.json");
            String BuiltInFictitiousFunctionClassFactory = c.BuiltInFictitiousFunctionClassFactory(sb.toString(), context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(BuiltInFictitiousFunctionClassFactory).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.get(i).toString());
                    }
                }
                d dVar2 = new d();
                KClassImpl$Data$declaredNonStaticMembers$2 = dVar2;
                dVar2.BuiltInFictitiousFunctionClassFactory = arrayList;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject.getString("grs_query_endpoint_1.0");
                KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = jSONObject.getString("grs_query_endpoint_2.0");
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = jSONObject.getInt("grs_query_timeout");
            } catch (JSONException e) {
                Logger.w(PlaceComponentResult, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e.getMessage()));
            }
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }
}
