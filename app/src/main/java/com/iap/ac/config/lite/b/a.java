package com.iap.ac.config.lite.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.a.g;
import com.iap.ac.config.lite.a.k;
import com.iap.ac.config.lite.a.l;
import com.iap.ac.config.lite.a.m;
import com.iap.ac.config.lite.common.KVBuilder;
import com.iap.ac.config.lite.d.e;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public class a {
    private static final String e = e.b("RetrieveDnsTask");

    /* renamed from: a  reason: collision with root package name */
    private String f7626a;
    private ConfigCenterContext b;
    private long c = 0;
    private g d;

    public a(ConfigCenterContext configCenterContext) {
        this.b = configCenterContext;
        StringBuilder sb = new StringBuilder();
        sb.append(d());
        sb.append(".");
        sb.append("amcstxt.alipay.com.");
        this.f7626a = sb.toString();
    }

    private void c() throws Exception {
        synchronized (this) {
            if (this.d == null) {
                g gVar = new g(this.f7626a);
                this.d = gVar;
                gVar.a(new l(this.b.getDnsServer()));
            }
        }
    }

    private String d() {
        StringBuilder sb = new StringBuilder(this.b.getAppId());
        sb.append("-");
        sb.append(TextUtils.isEmpty(this.b.getTntInstId()) ? "alipw3sg" : this.b.getTntInstId());
        sb.append("-");
        sb.append(TextUtils.isEmpty(this.b.getWorkspaceId()) ? "default" : this.b.getWorkspaceId());
        return sb.toString().replaceAll("_", "-");
    }

    private List<String> e() throws Exception {
        ArrayList arrayList = new ArrayList();
        c();
        try {
            List<k> a2 = this.d.a();
            if (a2 != null) {
                Iterator<k> it = a2.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(((m) it.next()).c());
                }
            }
        } catch (Exception e2) {
            InstrumentInjector.log_e(e, "resolveDns: failed!", e2);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.c > 1800000) {
                this.c = elapsedRealtime;
                this.b.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_DNS_CHECK_FAILED, KVBuilder.newBuilder().put("host", this.f7626a).put("errorMsg", e2.getMessage()).build());
            }
        }
        return arrayList;
    }

    public String a() {
        return this.f7626a;
    }

    public long b() throws Exception {
        long j;
        ACLog.d(e, String.format("start dns check for [%s]", this.f7626a));
        List<String> e2 = e();
        long j2 = 0;
        if (e2 != null) {
            Iterator<String> it = e2.iterator();
            long j3 = 0;
            while (it.hasNext()) {
                try {
                    j = Long.parseLong(it.next());
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                if (j > j3) {
                    j3 = j;
                }
            }
            j2 = j3;
        }
        ACLog.i(e, String.format(Locale.US, "success get DNS for [%s],value is [%d]", this.f7626a, Long.valueOf(j2)));
        return j2;
    }
}
