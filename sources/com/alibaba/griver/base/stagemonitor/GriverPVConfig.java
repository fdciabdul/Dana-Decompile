package com.alibaba.griver.base.stagemonitor;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverPVConfig {

    /* renamed from: a  reason: collision with root package name */
    private static GriverPVConfigInfo f6379a;

    /* loaded from: classes6.dex */
    static class GriverPVConfigInfo {
        public boolean disableWhiteList;
        public boolean enable;
        public JSONArray whiteList;

        GriverPVConfigInfo() {
        }
    }

    public static boolean canMonit(App app) {
        JSONObject parseObject;
        try {
            if (f6379a == null) {
                f6379a = new GriverPVConfigInfo();
                String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_MONITOR_MINI_APP_LOAD_URL_PV);
                if (!TextUtils.isEmpty(config) && (parseObject = JSON.parseObject(config)) != null) {
                    f6379a.enable = JSONUtils.getBoolean(parseObject, "enable", false);
                    f6379a.disableWhiteList = JSONUtils.getBoolean(parseObject, GriverConfigConstants.KEY_MONITOR_MINI_APP_LOAD_URL_PV_DISABLE_WHITE_LIST, false);
                    f6379a.whiteList = JSONUtils.getJSONArray(parseObject, "white_list", new JSONArray());
                }
            }
            if (f6379a.enable) {
                if (f6379a.disableWhiteList) {
                    return true;
                }
                if (f6379a.whiteList != null) {
                    return f6379a.whiteList.contains(app.getAppId());
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("GriverPVConfig#canMonit error");
            sb.append(th);
            GriverLogger.e("GriverPVConfig", sb.toString());
            return false;
        }
    }
}
