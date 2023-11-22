package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class w {
    public static Map<String, List<q>> BuiltInFictitiousFunctionClassFactory(Context context, String str, String str2) {
        String MyBillsEntityDataFactory = g0.MyBillsEntityDataFactory(context, str, str2, "");
        HashMap hashMap = new HashMap();
        PlaceComponentResult(str2, MyBillsEntityDataFactory, hashMap);
        return hashMap;
    }

    private static void PlaceComponentResult(String str, String str2, Map<String, List<q>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str2);
            if (jSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                q qVar = new q();
                try {
                    qVar.KClassImpl$Data$declaredNonStaticMembers$2(jSONArray.getJSONObject(i));
                    arrayList.add(qVar);
                } catch (JSONException unused) {
                    y.PlaceComponentResult("hmsSdk", "JSON Exception happened when create data for report - readDataToRecord");
                }
            }
            map.put(str, arrayList);
        } catch (JSONException unused2) {
            y.PlaceComponentResult("hmsSdk", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    private static Map<String, List<q>> PlaceComponentResult(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> PlaceComponentResult = g0.PlaceComponentResult(context, str);
        Iterator<Map.Entry<String, ?>> it = PlaceComponentResult.entrySet().iterator();
        Set<String> PlaceComponentResult2 = u0.PlaceComponentResult(b.MyBillsEntityDataFactory());
        while (it.hasNext()) {
            if (!PlaceComponentResult2.contains(it.next().getKey())) {
                it.remove();
            }
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : PlaceComponentResult.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                PlaceComponentResult(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    public static Map<String, List<q>> MyBillsEntityDataFactory(Context context, String str, String str2) {
        Map<String, List<q>> PlaceComponentResult;
        Map<String, List<q>> PlaceComponentResult2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            y.BuiltInFictitiousFunctionClassFactory("hmsSdk", "read all event records");
            PlaceComponentResult = PlaceComponentResult(context, "stat_v2_1");
            PlaceComponentResult2 = PlaceComponentResult(context, "cached_v2_1");
        } else {
            String authRequestContext = u0.getAuthRequestContext(str, str2);
            PlaceComponentResult = BuiltInFictitiousFunctionClassFactory(context, "stat_v2_1", authRequestContext);
            PlaceComponentResult2 = BuiltInFictitiousFunctionClassFactory(context, "cached_v2_1", authRequestContext);
        }
        if (PlaceComponentResult.size() == 0 && PlaceComponentResult2.size() == 0) {
            return new HashMap();
        }
        if (PlaceComponentResult.size() == 0) {
            return PlaceComponentResult2;
        }
        if (PlaceComponentResult2.size() == 0) {
            return PlaceComponentResult;
        }
        HashMap hashMap = new HashMap(PlaceComponentResult);
        hashMap.putAll(PlaceComponentResult2);
        return hashMap;
    }
}
