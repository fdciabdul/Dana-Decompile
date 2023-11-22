package com.alibaba.griver.base.resource.preset;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class GriverMiniAppPresetConfig {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6375a;
    private JSONArray b;

    public GriverMiniAppPresetConfig(String str) {
        try {
            JSONObject parseObject = JSONUtils.parseObject(str);
            this.f6375a = JSONUtils.getBoolean(parseObject, GriverConfigConstants.KEY_PRESET_APP_CONFIG_DISABLE, false);
            this.b = JSONUtils.getJSONArray(parseObject, "blacklist", new JSONArray());
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse config error");
            sb.append(th);
            GriverLogger.e("GriverMiniAppPresetConf", sb.toString());
        }
    }

    public boolean isDisable() {
        return this.f6375a;
    }

    public JSONArray getBlacklist() {
        return this.b;
    }
}
