package com.iap.ac.android.acs.operation.utils;

import com.iap.ac.android.common.log.ACLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Utils {
    public static final String TAG = "IAPConnectPlugin";

    public static Map<String, String> json2StringMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            ACLog.e("IAPConnectPlugin", "Utils#json2StringMap, json is null");
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.optString(next));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Utils#json2StringMap, result: ");
        sb.append(hashMap);
        ACLog.d("IAPConnectPlugin", sb.toString());
        return hashMap;
    }

    public static List<String> jsonArray2StringList(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.optString(i));
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Utils#jsonArray2StringList, result:");
            sb.append(arrayList);
            ACLog.d("IAPConnectPlugin", sb.toString());
            return arrayList;
        }
        ACLog.e("IAPConnectPlugin", "Utils#jsonArray2StringList, json array is empty");
        return new ArrayList();
    }

    public static String logTag(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("IAPConnectPlugin-MiniOperation-");
        sb.append(str);
        return sb.toString();
    }

    public static JSONArray stringList2JsonArray(List<String> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Utils#stringList2JsonArray, result: ");
            sb.append(jSONArray);
            ACLog.d("IAPConnectPlugin", sb.toString());
            return jSONArray;
        }
        ACLog.e("IAPConnectPlugin", "Utils#stringList2JsonArray, string list is empty");
        return new JSONArray();
    }

    public static JSONObject stringMap2Json(Map<String, String> map) throws JSONException {
        if (map != null && !map.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Utils#stringMap2Json, result: ");
            sb.append(jSONObject);
            ACLog.d("IAPConnectPlugin", sb.toString());
            return jSONObject;
        }
        ACLog.e("IAPConnectPlugin", "Utils#stringMap2Json, string map is empty");
        return new JSONObject();
    }
}
