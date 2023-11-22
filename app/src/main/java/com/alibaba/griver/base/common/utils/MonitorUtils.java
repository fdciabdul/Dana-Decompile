package com.alibaba.griver.base.common.utils;

import android.os.Bundle;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.base.common.logger.GriverLogger;
import id.dana.data.here.HereOauthManager;
import java.net.URLEncoder;

/* loaded from: classes6.dex */
public class MonitorUtils {
    public static String getSourceInfoFromStartupParams(Bundle bundle) {
        if (bundle != null && bundle.containsKey("sourceInfo")) {
            Object obj = bundle.get("sourceInfo");
            try {
                if (obj instanceof String) {
                    return URLEncoder.encode(obj.toString());
                }
                return URLEncoder.encode(JSON.toJSONString(obj), HereOauthManager.ENC);
            } catch (Exception e) {
                GriverLogger.e("MonitorUtils", "ENCODE ERROR", e);
                return "";
            }
        }
        return "";
    }
}
