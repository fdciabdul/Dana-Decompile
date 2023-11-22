package com.iap.ac.config.lite.g;

import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.ConfigGetter;
import com.iap.ac.config.lite.common.AmcsConstants;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import com.iap.ac.config.lite.e.a;

/* loaded from: classes3.dex */
public class a extends com.iap.ac.config.lite.e.a<com.iap.ac.config.lite.b.a> {
    private static final String n = e.b("DnsCheckScheduler");

    private a(ConfigCenterContext configCenterContext) {
        super(configCenterContext);
        a(new a.g(new com.iap.ac.config.lite.b.a(configCenterContext), a(true)));
    }

    private long l() {
        ConfigGetter sectionConfigGetter;
        ConfigCenter configCenter = ConfigCenter.getInstance(this.d.getBizCode());
        if (!configCenter.isInitialized() || (sectionConfigGetter = configCenter.getSectionConfigGetter("amcs")) == null) {
            return 300L;
        }
        return sectionConfigGetter.getIntConfig(AmcsConstants.AMCS_SYNC_INTERVAL, 300);
    }

    @Override // com.iap.ac.config.lite.e.a
    public String c() {
        return "DnsCheckScheduler";
    }

    @Override // com.iap.ac.config.lite.e.a
    public void f() {
        ACLog.d(n, "start dns check");
    }

    @Override // com.iap.ac.config.lite.e.a
    public void g() {
        if (a() > 0) {
            this.f = 0;
            this.g = 0;
            a(a(false));
        }
    }

    public boolean k() {
        return l() > 0;
    }

    public static a a(ConfigCenterContext configCenterContext) {
        return new a(configCenterContext);
    }

    @Override // com.iap.ac.config.lite.e.a
    public boolean a(com.iap.ac.config.lite.b.a aVar) {
        try {
            long b = aVar.b();
            ConfigCenter configCenter = ConfigCenter.getInstance(this.d.getBizCode());
            String str = n;
            StringBuilder sb = new StringBuilder();
            sb.append("executePollingTask version:");
            sb.append(b);
            ACLog.d(str, sb.toString());
            if (configCenter.newerThanLocalVersion(b)) {
                KVBuilder newBuilder = KVBuilder.newBuilder();
                newBuilder.put("newVersion", Long.valueOf(b));
                newBuilder.put("host", aVar.a());
                this.d.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_UPDATE_BY_DNS, newBuilder.build());
                ACLog.d(str, "executePollingTask refreshConfig");
                configCenter.refreshConfig();
                return false;
            }
            return false;
        } catch (Exception e) {
            ACLog.e(n, "failed to retrieve dns", e);
            return false;
        }
    }

    @Override // com.iap.ac.config.lite.e.a
    public long a(boolean z) {
        long l = l();
        if (l == 0) {
            return -1L;
        }
        return l * 1000;
    }

    @Override // com.iap.ac.config.lite.e.a
    public int a() {
        return l() > 0 ? Integer.MAX_VALUE : 0;
    }
}
