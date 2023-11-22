package com.alibaba.griver.api.common.config;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes3.dex */
public class ConfigUtils {
    public static boolean canUseTopWhiteList(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject parseObject = JSONUtils.parseObject(str);
                if (JSONUtils.getBoolean(parseObject, "enable", z)) {
                    JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, "blackList", new JSONArray());
                    for (int i = 0; i < jSONArray.size(); i++) {
                        if (str2.startsWith(jSONArray.getString(i))) {
                            return false;
                        }
                    }
                    if (JSONUtils.getBoolean(parseObject, "disableWhiteList", z)) {
                        return true;
                    }
                    JSONArray jSONArray2 = JSONUtils.getJSONArray(parseObject, "whiteList", new JSONArray());
                    for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                        if (str2.startsWith(jSONArray2.getString(i2))) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("just print ");
                sb.append(th);
                GriverLogger.w("ConfigUtils", sb.toString());
            }
        }
        return z;
    }

    public static boolean canUseWhiteList(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject parseObject = JSONUtils.parseObject(str);
                if (JSONUtils.getBoolean(parseObject, "enable", z) && !JSONUtils.getJSONArray(parseObject, "blackList", new JSONArray()).contains(str2)) {
                    if (JSONUtils.getBoolean(parseObject, "disableWhiteList", false)) {
                        return true;
                    }
                    return JSONUtils.getJSONArray(parseObject, "whiteList", new JSONArray()).contains(str2);
                }
                return false;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("just print ");
                sb.append(th);
                GriverLogger.w("ConfigUtils", sb.toString());
            }
        }
        return z;
    }
}
