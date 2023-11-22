package com.alibaba.griver.base.t2;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.embedview.mapbiz.core.controller.ReportController;

/* loaded from: classes3.dex */
public class AndroidT2Config {
    public static final String TAG = "AndroidT2Config";

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f6382a;
    private JSONArray b = null;
    private JSONArray c = null;
    private JSONArray d = null;
    private JSONArray e = null;
    private String f = null;
    private String g = null;
    private String h = null;

    public AndroidT2Config(JSONObject jSONObject) {
        this.f6382a = jSONObject;
    }

    public void initConfig() {
        try {
            this.b = JSONUtils.getJSONArray(this.f6382a, "whitelist", new JSONArray());
            this.c = JSONUtils.getJSONArray(this.f6382a, "blacklist", new JSONArray());
            this.d = JSONUtils.getJSONArray(this.f6382a, GriverConfigConstants.KEY_CCDN_H5_CONFIG_URLS, new JSONArray());
            this.f = JSONUtils.getString(this.f6382a, ReportController.PARAM_TINY, "YES");
            this.g = JSONUtils.getString(this.f6382a, "h5", "YES");
            this.h = JSONUtils.getString(this.f6382a, "switch", "YES");
            this.e = JSONUtils.getJSONArray(this.f6382a, "preloadUrls", new JSONArray());
        } catch (Exception e) {
            GriverLogger.w(TAG, "AndroidT2Config#initConfig", e);
        }
    }

    public boolean isEmpty() {
        JSONObject jSONObject = this.f6382a;
        return jSONObject == null || jSONObject.isEmpty();
    }

    public boolean isCollectT2(String str, boolean z) {
        JSONArray jSONArray = this.c;
        if (jSONArray == null || !jSONArray.contains(str)) {
            JSONArray jSONArray2 = this.b;
            if (jSONArray2 == null || !jSONArray2.contains(str)) {
                if (z && a(this.f)) {
                    return "yes".equalsIgnoreCase(this.f);
                }
                if (!z && a(this.g)) {
                    return "yes".equalsIgnoreCase(this.g);
                }
                if (a(this.h)) {
                    return "yes".equalsIgnoreCase(this.h);
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(String str) {
        return "yes".equalsIgnoreCase(str) || "no".equalsIgnoreCase(str);
    }

    public JSONArray getT2Urls() {
        return this.d;
    }

    public JSONArray getT2PreloadUrls() {
        return this.e;
    }
}
