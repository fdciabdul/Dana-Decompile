package com.alipay.alipaysecuritysdk.common.e;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {
    public static JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null && map.size() > 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                com.alipay.alipaysecuritysdk.common.c.b.a("SEC_SDK-tool", e);
            }
        }
        return jSONObject;
    }

    public static String a(Map<String, String> map, String str) {
        String str2;
        return (map == null || (str2 = map.get(str)) == null) ? "" : str2;
    }
}
