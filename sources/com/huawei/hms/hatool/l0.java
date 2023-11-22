package com.huawei.hms.hatool;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class l0 implements n0 {
    public String BuiltInFictitiousFunctionClassFactory;
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public List<q> PlaceComponentResult;
    public String getAuthRequestContext;

    public l0(List<q> list, String str, String str2, String str3) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.getAuthRequestContext = str3;
        this.PlaceComponentResult = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<q> list = this.PlaceComponentResult;
        if (list == null || list.size() == 0) {
            y.MyBillsEntityDataFactory("hmsSdk", "failed events is empty");
        } else if (q0.BuiltInFictitiousFunctionClassFactory(b.lookAheadTest(), "cached_v2_1", b.NetworkUserEntityData$$ExternalSyntheticLambda1() * CrashCombineUtils.DEFAULT_MAX_INFO_LEN)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The cacheFile is full,Can not writing data! reqID:");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            y.PlaceComponentResult("hmsSdk", sb.toString());
        } else {
            String authRequestContext = u0.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext);
            List<q> list2 = w.BuiltInFictitiousFunctionClassFactory(b.lookAheadTest(), "cached_v2_1", authRequestContext).get(authRequestContext);
            if (list2 != null && list2.size() != 0) {
                this.PlaceComponentResult.addAll(list2);
            }
            JSONArray jSONArray = new JSONArray();
            for (q qVar : this.PlaceComponentResult) {
                try {
                    JSONObject PlaceComponentResult = qVar.PlaceComponentResult();
                    PlaceComponentResult.put("properties", d.KClassImpl$Data$declaredNonStaticMembers$2(qVar.KClassImpl$Data$declaredNonStaticMembers$2, d0.PlaceComponentResult().MyBillsEntityDataFactory()));
                    jSONArray.put(PlaceComponentResult);
                } catch (JSONException unused) {
                    y.PlaceComponentResult("hmsSdk", "event to json error");
                }
            }
            String jSONArray2 = jSONArray.toString();
            if (jSONArray2.length() > b.scheduleImpl() * CrashCombineUtils.DEFAULT_MAX_INFO_LEN) {
                y.PlaceComponentResult("hmsSdk", "this failed data is too long,can not writing it");
                this.PlaceComponentResult = null;
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("data send failed, write to cache file...reqID:");
            sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            y.MyBillsEntityDataFactory("hmsSdk", sb2.toString());
            g0.getAuthRequestContext(b.lookAheadTest(), "cached_v2_1", authRequestContext, jSONArray2);
            g0.KClassImpl$Data$declaredNonStaticMembers$2(b.lookAheadTest(), "backup_event", u0.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }
}
