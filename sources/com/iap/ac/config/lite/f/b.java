package com.iap.ac.config.lite.f;

import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.e.a;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import com.iap.ac.config.lite.fetcher.ConfigFetchCallback;
import com.iap.ac.config.lite.fetcher.ConfigNotifyCallback;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b extends c<com.iap.ac.config.lite.c.b> {
    private static final String s = e.b("ConfigFetchByKeyScheduler");
    private boolean q;
    private ConfigNotifyCallback r;

    private b(Map<String, Object> map, ConfigCenterContext configCenterContext, ConfigFetchCallback configFetchCallback, ConfigNotifyCallback configNotifyCallback, List<String> list, boolean z) {
        super(map, configCenterContext, configFetchCallback);
        this.r = configNotifyCallback;
        this.q = z;
        ConfigCenter configCenter = ConfigCenter.getInstance(this.d.getBizCode());
        com.iap.ac.config.lite.c.c cVar = new com.iap.ac.config.lite.c.c(this.d, list);
        com.iap.ac.config.lite.c.e eVar = new com.iap.ac.config.lite.c.e(this.d, list);
        if (e.a(configCenter)) {
            a(new a.g(cVar, a(true)), new a.g(eVar, a(true)));
        } else {
            a(new a.g(eVar, a(true)));
        }
    }

    public static b a(ConfigCenterContext configCenterContext, List<String> list, Map<String, Object> map, ConfigFetchCallback configFetchCallback, boolean z, ConfigNotifyCallback configNotifyCallback) {
        b bVar = new b(map, configCenterContext, configFetchCallback, configNotifyCallback, list, z);
        bVar.e();
        return bVar;
    }

    private JSONObject b(AmcsConfigRpcResult amcsConfigRpcResult) {
        JSONObject jSONObject;
        if (amcsConfigRpcResult == null || (jSONObject = amcsConfigRpcResult.updateKeys) == null) {
            return null;
        }
        return (JSONObject) JsonUtils.fromJson(JsonUtils.toJson(jSONObject), JSONObject.class);
    }

    @Override // com.iap.ac.config.lite.e.a
    public int a() {
        return 1;
    }

    @Override // com.iap.ac.config.lite.e.a
    public String c() {
        return "ConfigFetchByKeyScheduler";
    }

    @Override // com.iap.ac.config.lite.e.a
    public void g() {
        ACLog.i(s, "** Notify all fetch tasks failed.");
        ConfigNotifyCallback configNotifyCallback = this.r;
        if (configNotifyCallback != null) {
            configNotifyCallback.onFetchFailed("Unknown", "All fetch tasks failed.");
        }
    }

    @Override // com.iap.ac.config.lite.f.c
    protected String k() {
        return "0";
    }

    @Override // com.iap.ac.config.lite.f.c
    protected void a(AmcsConfigRpcResult amcsConfigRpcResult) {
        if (this.q) {
            this.n.onFetchByKeysSuccess(amcsConfigRpcResult);
        }
        ConfigNotifyCallback configNotifyCallback = this.r;
        if (configNotifyCallback != null) {
            configNotifyCallback.onFetchSuccess(b(amcsConfigRpcResult));
        }
    }
}
