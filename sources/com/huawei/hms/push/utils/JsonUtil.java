package com.huawei.hms.push.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class JsonUtil {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject, Bundle bundle, HashMap<String, Object> hashMap) {
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, defaultValue is null.");
            } else if (value instanceof String) {
                String str = (String) value;
                bundle.putString(key, getAuthRequestContext(jSONObject, key, TextUtils.isEmpty(str) ? null : str));
            } else if (value instanceof Integer) {
                bundle.putInt(key, getAuthRequestContext(jSONObject, key, ((Integer) value).intValue()));
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                bundle.putIntArray(key, PlaceComponentResult(jSONObject, key, iArr.length != 0 ? iArr : null));
            } else if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                bundle.putLongArray(key, getAuthRequestContext(jSONObject, key, jArr.length != 0 ? jArr : null));
            } else if (value instanceof String[]) {
                int length = ((String[]) value).length;
                bundle.putStringArray(key, PlaceComponentResult(jSONObject, key));
            } else {
                HMSLog.w("JsonUtil", "transfer jsonObject to bundle failed, invalid data type.");
            }
        }
    }

    private static int[] PlaceComponentResult(JSONObject jSONObject, String str, int[] iArr) {
        int[] iArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    iArr2 = new int[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        iArr2[i] = ((Integer) jSONArray.get(i)).intValue();
                    }
                }
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException: get ");
                sb.append(str);
                sb.append(" error.");
                HMSLog.w("JsonUtil", sb.toString());
            }
        }
        return iArr2 != null ? iArr2 : iArr;
    }

    private static String[] PlaceComponentResult(JSONObject jSONObject, String str) {
        String[] strArr = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    strArr = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr[i] = (String) jSONArray.get(i);
                    }
                }
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException: get ");
                sb.append(str);
                sb.append(" error.");
                HMSLog.w("JsonUtil", sb.toString());
            }
        }
        return strArr;
    }

    public static int getAuthRequestContext(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null) {
            try {
                return jSONObject.has(str) ? jSONObject.getInt(str) : i;
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException: get ");
                sb.append(str);
                sb.append(" error.");
                HMSLog.w("JsonUtil", sb.toString());
                return i;
            }
        }
        return i;
    }

    public static String getAuthRequestContext(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            try {
                return (!jSONObject.has(str) || jSONObject.get(str) == null) ? str2 : String.valueOf(jSONObject.get(str));
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException: get ");
                sb.append(str);
                sb.append(" error.");
                HMSLog.w("JsonUtil", sb.toString());
                return str2;
            }
        }
        return str2;
    }

    private static long[] getAuthRequestContext(JSONObject jSONObject, String str, long[] jArr) {
        long[] jArr2 = null;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(str)) {
                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                    jArr2 = new long[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jArr2[i] = jSONArray.getLong(i);
                    }
                }
            } catch (JSONException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("JSONException: get ");
                sb.append(str);
                sb.append(" error.");
                HMSLog.w("JsonUtil", sb.toString());
            }
        }
        return jArr2 != null ? jArr2 : jArr;
    }
}
