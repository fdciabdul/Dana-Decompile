package com.alibaba.griver.api.jsapi.diagnostic;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class ReportConfig {
    public JSONArray blacklist;
    public boolean disableWhitelist;
    public boolean enabled;
    public JSONArray whitelist;

    public ReportConfig(String str) {
        this.enabled = true;
        this.blacklist = new JSONArray();
        this.whitelist = new JSONArray();
        this.disableWhitelist = true;
        try {
            JSONObject parseObject = JSON.parseObject(str);
            this.enabled = JSONUtils.getBoolean(parseObject, "enabled", false);
            this.blacklist = JSONUtils.getJSONArray(parseObject, "blacklist", new JSONArray());
            this.whitelist = JSONUtils.getJSONArray(parseObject, "whitelist", new JSONArray());
            this.disableWhitelist = JSONUtils.getBoolean(parseObject, "disableWhitelist", true);
        } catch (Throwable unused) {
        }
    }

    public boolean canReport(String str) {
        if (this.enabled) {
            JSONArray jSONArray = this.blacklist;
            if (jSONArray == null || !jSONArray.contains(str)) {
                return this.disableWhitelist || this.whitelist.contains(str);
            }
            return false;
        }
        return false;
    }
}
