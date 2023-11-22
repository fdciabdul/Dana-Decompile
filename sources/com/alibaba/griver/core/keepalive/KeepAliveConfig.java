package com.alibaba.griver.core.keepalive;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes3.dex */
public class KeepAliveConfig {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6427a;
    private long b;
    private JSONArray c;
    private boolean d;
    private JSONArray e;

    public KeepAliveConfig(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                if (GriverEnv.getDefaultConfig().mini_app_keep_alive) {
                    this.f6427a = true;
                    this.d = true;
                } else {
                    this.f6427a = false;
                    this.d = false;
                }
                this.b = 300000L;
                this.c = new JSONArray();
                this.e = new JSONArray();
                return;
            }
            JSONObject parseObject = JSON.parseObject(str);
            this.f6427a = JSONUtils.getBoolean(parseObject, "enable", false);
            long j = JSONUtils.getLong(parseObject, GriverConfigConstants.KEY_MINI_APP_KEEP_ALIVE_ALIVE_TIME, 300000L);
            this.b = j;
            if (j <= 0) {
                this.b = 300000L;
            }
            this.c = JSONUtils.getJSONArray(parseObject, "white_list", new JSONArray());
            JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, GriverConfigConstants.KEY_MINI_APP_KEEP_ALIVE_HIGH_ALIVE_WHITE_LIST, new JSONArray());
            this.e = new JSONArray();
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.size() && i < 3; i++) {
                    if (!TextUtils.isEmpty(jSONArray.getString(i))) {
                        this.e.add(jSONArray.get(i));
                    }
                }
            }
        } catch (Exception e) {
            GriverLogger.e("KeepAliveConfig", "KeepAliveConfig", e);
        }
    }

    public boolean isEnable() {
        return this.f6427a;
    }

    public boolean isInWhiteList(String str) {
        if (this.d) {
            return true;
        }
        return this.c.contains(str);
    }

    public boolean isInHighALiveWhiteList(String str) {
        return this.e.contains(str);
    }

    public boolean needSupportKeepAlive(String str) {
        if (this.f6427a) {
            if (isInHighALiveWhiteList(str)) {
                return true;
            }
            return isInWhiteList(str);
        }
        return false;
    }

    public long getAliveTime() {
        return this.b;
    }
}
