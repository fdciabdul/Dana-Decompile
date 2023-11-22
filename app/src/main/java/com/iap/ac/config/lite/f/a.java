package com.iap.ac.config.lite.f;

import android.text.TextUtils;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.ConfigGetter;
import com.iap.ac.config.lite.c.d;
import com.iap.ac.config.lite.c.f;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.e.a;
import com.iap.ac.config.lite.facade.result.AmcsConfigRpcResult;
import com.iap.ac.config.lite.fetcher.ConfigFetchCallback;
import java.util.Map;

/* loaded from: classes3.dex */
public class a extends c<com.iap.ac.config.lite.c.b> {
    private static final String t = e.b("ConfigFetchAllScheduler");
    private long q;
    private String r;
    private String s;

    private a(Map<String, Object> map, ConfigCenterContext configCenterContext, long j, String str, ConfigFetchCallback configFetchCallback) {
        super(map, configCenterContext, configFetchCallback);
        this.r = str;
        this.q = j;
        l();
    }

    public static a a(ConfigCenterContext configCenterContext, long j, String str, Map<String, Object> map, ConfigFetchCallback configFetchCallback) {
        a aVar = new a(map, configCenterContext, j, str, configFetchCallback);
        aVar.e();
        return aVar;
    }

    private void l() {
        ConfigCenter configCenter = ConfigCenter.getInstance(this.d.getBizCode());
        ConfigGetter sectionConfigGetter = configCenter.getSectionConfigGetter("amcs");
        String stringConfig = sectionConfigGetter != null ? sectionConfigGetter.getStringConfig("encryptStatus") : null;
        long a2 = a(true);
        long a3 = a(false);
        if (e.a(configCenter)) {
            f fVar = new f(this.d);
            a(new a.g(fVar, a2), new a.g(fVar, a3), new a.g(new d(this.d), a3));
            return;
        }
        f fVar2 = new f(this.d, true);
        f fVar3 = new f(this.d);
        if ("MIXED".equals(stringConfig)) {
            a(new a.g(fVar2, a2), new a.g(fVar3, a3));
        } else if ("ENCRYPT".equals(stringConfig)) {
            a(new a.g(fVar2, a2), new a.g(fVar2, a3));
        } else {
            a(new a.g(fVar3, a2), new a.g(fVar3, a3));
        }
    }

    @Override // com.iap.ac.config.lite.e.a
    public String c() {
        return "ConfigFetchAllScheduler";
    }

    @Override // com.iap.ac.config.lite.e.a
    public void g() {
        String str = t;
        ACLog.i(str, "** Notify all fetch tasks failed.");
        if (!isCanceled()) {
            this.n.onFetchFailed("Unknown", "All fetch tasks failed.");
            cancel();
            return;
        }
        ACLog.w(str, "Scheduler already canceled. will skip notify failure.");
    }

    @Override // com.iap.ac.config.lite.f.c
    protected String k() {
        String json = JsonUtils.toJson(e.a(this.d, this.f7642o));
        this.s = json;
        return TextUtils.equals(this.r, json) ? String.valueOf(this.q) : "0";
    }

    @Override // com.iap.ac.config.lite.e.a
    public int a() {
        ConfigGetter sectionConfigGetter = ConfigCenter.getInstance(this.d.getBizCode()).getSectionConfigGetter("amcs");
        int intConfig = sectionConfigGetter != null ? sectionConfigGetter.getIntConfig("refreshMaxCount", 1) : 1;
        String str = t;
        StringBuilder sb = new StringBuilder();
        sb.append("refreshMaxCount = ");
        sb.append(intConfig);
        ACLog.i(str, sb.toString());
        return intConfig;
    }

    @Override // com.iap.ac.config.lite.f.c
    protected void a(AmcsConfigRpcResult amcsConfigRpcResult) {
        this.n.onFetchSuccess(amcsConfigRpcResult, this.s);
    }
}
