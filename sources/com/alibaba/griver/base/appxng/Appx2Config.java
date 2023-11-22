package com.alibaba.griver.base.appxng;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes3.dex */
public class Appx2Config {
    public boolean disableWhiteList;
    public boolean enable;
    public JSONArray whiteList;

    public Appx2Config(String str) {
        this.enable = true;
        this.disableWhiteList = true;
        this.whiteList = new JSONArray();
        try {
            JSONObject parseObject = JSONUtils.parseObject(str);
            if (parseObject != null) {
                this.enable = JSONUtils.getBoolean(parseObject, "enabled", true);
                this.disableWhiteList = JSONUtils.getBoolean(parseObject, "disableWhiteList", true);
                this.whiteList = JSONUtils.getJSONArray(parseObject, "whitelist", new JSONArray());
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append(th);
            GriverLogger.w("Appx2Config", sb.toString());
        }
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean canUseAppx2_0(String str) {
        if (isEnable()) {
            if (this.disableWhiteList) {
                return true;
            }
            return this.whiteList.contains(str);
        }
        return false;
    }
}
