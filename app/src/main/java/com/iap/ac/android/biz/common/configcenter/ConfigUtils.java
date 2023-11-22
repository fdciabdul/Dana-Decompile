package com.iap.ac.android.biz.common.configcenter;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigUtils {
    public static final String TAG = "ConfigUtils";

    public static boolean canUseTopWhiteList(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                if (jSONObject.optBoolean("enable", z)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            if (str.startsWith(String.valueOf(optJSONArray.get(i)))) {
                                return false;
                            }
                        }
                    }
                    if (jSONObject.optBoolean("disableWhiteList", z)) {
                        return true;
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("whiteList");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            if (str.startsWith(optJSONArray2.getString(i2))) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("just print");
                sb.append(th);
                ACLog.w("ConfigUtils", sb.toString());
            }
        }
        return z;
    }
}
