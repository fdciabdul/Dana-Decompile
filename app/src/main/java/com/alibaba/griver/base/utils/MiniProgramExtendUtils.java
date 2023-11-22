package com.alibaba.griver.base.utils;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes2.dex */
public class MiniProgramExtendUtils {
    public static final String TAG = "MiniProgramExtendUtils";

    public static JSONObject getJsApiExecuteConfig(AppModel appModel, JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        if (enableGetAuthClientIdMerchantIdFromExtend(appModel.getAppId()) && jSONObject.containsKey(GriverBaseConstants.KEY_JSAPI_EXECUTE_CONFIG) && !TextUtils.isEmpty(str) && (jSONObject2 = jSONObject.getJSONObject(GriverBaseConstants.KEY_JSAPI_EXECUTE_CONFIG)) != null && jSONObject2.containsKey(str)) {
            return jSONObject2.getJSONObject(str);
        }
        return null;
    }

    public static boolean enableGetAuthClientIdMerchantIdFromExtend(String str) {
        JSONArray jSONArray;
        String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_JSAPI_EXE_CFG, "{\"enable\":true,\"blacklist\":[]}");
        if (!TextUtils.isEmpty(config)) {
            try {
                JSONObject parseObject = JSONUtils.parseObject(config);
                if (parseObject != null && parseObject.containsKey("enable") && parseObject.getBoolean("enable") == Boolean.TRUE) {
                    if (!parseObject.containsKey("blacklist") || (jSONArray = parseObject.getJSONArray("blacklist")) == null) {
                        return true;
                    }
                    for (int i = 0; i < jSONArray.size(); i++) {
                        if (jSONArray.getString(i).equals(str)) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (Exception e) {
                GriverLogger.e(TAG, "enableGetAuthClientIdMerchantIdFromExtend", e);
            }
        }
        return false;
    }
}
