package com.iap.ac.android.container.adapter.griver;

import com.alibaba.fastjson.JSON;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Utils {
    public static boolean isGriverContainerInit() {
        return true;
    }

    public static JSONObject fastJsonToJson(com.alibaba.fastjson.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new JSONObject(jSONObject.toString());
        } catch (Exception e) {
            ACLog.e("Utils", "fastJsonToJson error: ", e);
            return null;
        }
    }

    public static com.alibaba.fastjson.JSONObject jsonObjectToFastJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return JSON.parseObject(jSONObject.toString());
        } catch (Exception e) {
            ACLog.e("Utils", "jsonObjectToFastJson error: ", e);
            return null;
        }
    }
}
