package com.alibaba.griver.core.worker;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;

/* loaded from: classes2.dex */
public class QJSUtils {
    public static boolean isAllowedQJS(String str) {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_QJS_CONFIG);
        if (configJSONObject != null && JSONUtils.getBoolean(configJSONObject, "enable", false)) {
            try {
                JSONArray jSONArray = configJSONObject.getJSONArray("blackList");
                if (jSONArray == null || !jSONArray.contains(str)) {
                    if (JSONUtils.getBoolean(configJSONObject, "disableWhiteList", false)) {
                        return true;
                    }
                    JSONArray jSONArray2 = configJSONObject.getJSONArray("whiteList");
                    if (jSONArray2 != null && jSONArray2.size() != 0) {
                        return jSONArray2.contains(str);
                    }
                    return false;
                }
                return false;
            } catch (Exception unused) {
                RVLogger.e("QJSUtils", "parse json exception");
                return false;
            }
        }
        return false;
    }

    public static boolean isAllowedWorkerPool() {
        JSONObject configJSONObject = GriverInnerConfig.getConfigJSONObject(GriverConfigConstants.KEY_QJS_CONFIG);
        if (configJSONObject != null && JSONUtils.getBoolean(configJSONObject, "enable", false)) {
            return JSONUtils.getBoolean(configJSONObject, "workerPoolEnable", false);
        }
        return false;
    }
}
