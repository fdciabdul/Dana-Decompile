package com.alibaba.griver.core.preload;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.env.GriverEnv;

/* loaded from: classes3.dex */
public class PreloadConfig {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6440a = GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_TOGGLE_PRELOAD, true);
    private final boolean b;
    private final boolean c;
    private final JSONArray d;
    private final boolean e;
    private final boolean f;

    public PreloadConfig() {
        String config = GriverInnerConfig.getConfig("prerender_2_0", "");
        if (!TextUtils.isEmpty(config)) {
            JSONObject parseObject = JSON.parseObject(config);
            this.b = JSONUtils.getBoolean(parseObject, "enable", false);
            this.c = JSONUtils.getBoolean(parseObject, "disableWhiteList", false);
            this.d = JSONUtils.getJSONArray(parseObject, "whiteList", new JSONArray());
            this.e = JSONUtils.getBoolean(parseObject, GriverConfigConstants.KEY_PRERENDER_SNAPSHOT_ENABLE, false);
            this.f = JSONUtils.getBoolean(parseObject, GriverConfigConstants.KEY_PRERENDER_KEEP_PRERENDER, true);
        } else if (GriverEnv.getDefaultConfig().prerender_2_0) {
            this.b = true;
            this.c = true;
            this.d = new JSONArray();
            this.e = true;
            this.f = true;
        } else {
            this.b = false;
            this.c = false;
            this.d = new JSONArray();
            this.e = false;
            this.f = true;
        }
    }

    public boolean isEnable() {
        return this.f6440a;
    }

    public boolean isPrerenderEnable() {
        return this.b;
    }

    public boolean canPrerender(App app) {
        if (app != null && this.b) {
            if (this.c) {
                return true;
            }
            return this.d.contains(app.getAppId());
        }
        return false;
    }

    public boolean canSnapshotEnable(App app) {
        return canPrerender(app) && this.e;
    }

    public boolean isKeepPrerender() {
        return this.f;
    }
}
