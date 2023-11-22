package com.alibaba.griver.api.common.config;

import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes3.dex */
public class GriverAppInfoConfig {

    /* renamed from: a  reason: collision with root package name */
    private long f6272a;
    private long b;
    private int c;
    private int d;

    public GriverAppInfoConfig(JSONObject jSONObject) {
        this.f6272a = 864000L;
        this.b = 3600L;
        this.c = 5;
        this.d = 30;
        if (jSONObject != null) {
            try {
                this.f6272a = JSONUtils.getLong(jSONObject, GriverConfigConstants.PARAM_APP_INFO_SYNC_UPDATE, 864000L);
                this.b = JSONUtils.getLong(jSONObject, GriverConfigConstants.PARAM_APP_INFO_ASYNC_UPDATE, 3600L);
                this.c = JSONUtils.getInt(jSONObject, GriverConfigConstants.PARAM_APP_INFO_ASYNC_UPDATE_DELAY, 5);
                this.d = JSONUtils.getInt(jSONObject, GriverConfigConstants.PARAM_PREPARE_APP_TIMEOUT, 30);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("get app info config error");
                sb.append(th);
                GriverLogger.w("GriverAppInfoConfig", sb.toString());
            }
        }
    }

    public long getPreReqRate() {
        return this.f6272a;
    }

    public long getUpdateReqRate() {
        return this.b;
    }

    public int getAppAsyncUpdateDelay() {
        return this.c;
    }

    public int getExpireTime() {
        return this.d;
    }
}
