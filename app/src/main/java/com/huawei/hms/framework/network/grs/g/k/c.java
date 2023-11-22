package com.huawei.hms.framework.network.grs.g.k;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class c {
    public final Set<String> KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet();
    public final Context MyBillsEntityDataFactory;
    public final GrsBaseInfo PlaceComponentResult;

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.PlaceComponentResult = grsBaseInfo;
        this.MyBillsEntityDataFactory = context;
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.KClassImpl$Data$declaredNonStaticMembers$2.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String PlaceComponentResult() {
        Set<String> authRequestContext = com.huawei.hms.framework.network.grs.f.b.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getPackageName(), this.PlaceComponentResult).MyBillsEntityDataFactory.getAuthRequestContext();
        if (authRequestContext.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = authRequestContext.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        try {
            jSONObject.put("services", jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }
}
