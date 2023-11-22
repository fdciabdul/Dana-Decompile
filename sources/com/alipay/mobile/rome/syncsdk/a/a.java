package com.alipay.mobile.rome.syncsdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.LongLinkAppConfig;
import com.alipay.mobile.rome.syncsdk.util.d;
import com.iap.ac.android.acs.plugin.ui.adapter.PhoneRegionListAdapter;
import com.ta.utdid2.device.UTDevice;

/* loaded from: classes3.dex */
public class a {
    private static final String d = "a";
    private static a e;

    /* renamed from: a  reason: collision with root package name */
    public String f7211a;
    public String b;
    public LongLinkAppConfig c;
    private String f = UTDevice.getUtdid(com.alipay.mobile.rome.syncservice.d.a.f7279a);
    private boolean g;
    private String h;

    private a() {
        a((LongLinkAppConfig) null);
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            if (e == null) {
                e = new a();
            }
            aVar = e;
        }
        return aVar;
    }

    public final void a(LongLinkAppConfig longLinkAppConfig) {
        if (longLinkAppConfig == null) {
            com.alipay.mobile.rome.syncsdk.util.c.b(d, "longLinkAppConfig is null, will retrieve from manifest or mpaas.properties");
            Context context = com.alipay.mobile.rome.syncservice.d.a.f7279a;
            LongLinkAppConfig longLinkAppConfig2 = new LongLinkAppConfig();
            longLinkAppConfig2.appId = d.b(context);
            longLinkAppConfig2.appKey = d.a(context);
            longLinkAppConfig2.workspaceId = d.c(context);
            longLinkAppConfig2.productId = d.g(context);
            longLinkAppConfig2.authCode = d.f(context);
            longLinkAppConfig2.servHost = d.d(com.alipay.mobile.rome.syncservice.d.a.f7279a);
            longLinkAppConfig2.servPort = d.e(com.alipay.mobile.rome.syncservice.d.a.f7279a);
            longLinkAppConfig = longLinkAppConfig2;
        }
        if (TextUtils.isEmpty(longLinkAppConfig.productId)) {
            longLinkAppConfig.productId = String.format(PhoneRegionListAdapter.REGION_FORMAT_RULE, longLinkAppConfig.appKey, longLinkAppConfig.workspaceId);
        }
        if (TextUtils.isEmpty(longLinkAppConfig.productVersion)) {
            longLinkAppConfig.productVersion = l();
        }
        this.c = longLinkAppConfig;
        String str = d;
        StringBuilder sb = new StringBuilder("longLinkAppConfig = ");
        sb.append(this.c.toString());
        com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
    }

    public final String b() {
        String str;
        synchronized (this) {
            str = this.c.productVersion;
        }
        return str;
    }

    public final String c() {
        String str;
        synchronized (this) {
            str = this.c.productId;
        }
        return str;
    }

    public final String d() {
        String str;
        synchronized (this) {
            str = this.c.appId;
        }
        return str;
    }

    public final String e() {
        String str;
        synchronized (this) {
            str = this.f;
        }
        return str;
    }

    public final String f() {
        String str;
        synchronized (this) {
            str = this.b;
        }
        return str;
    }

    public final String g() {
        String str;
        synchronized (this) {
            str = this.c.appKey;
        }
        return str;
    }

    public final String a(Context context) {
        String a2;
        synchronized (this) {
            a2 = com.alipay.mobile.rome.syncsdk.b.a.a().a(context, "key_cdid");
        }
        return a2;
    }

    public final void a(Context context, String str) {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.b.a.a().a(context, "key_cdid", str);
        }
    }

    public final String h() {
        String str;
        synchronized (this) {
            str = this.c.servHost;
        }
        return str;
    }

    public final String i() {
        String str;
        synchronized (this) {
            str = this.c.servPort;
        }
        return str;
    }

    public final boolean j() {
        boolean z;
        synchronized (this) {
            this.g = false;
            if (TextUtils.equals(this.c.servPort, "443")) {
                this.g = true;
            }
            z = this.g;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        if (java.lang.Integer.parseInt(r0[3]) < 255) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String k() {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r5.h = r0     // Catch: java.lang.Throwable -> L8c
            com.alipay.mobile.rome.longlinkservice.LongLinkAppConfig r0 = r5.c     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.servPort     // Catch: java.lang.Throwable -> L8c
            java.lang.String r1 = "443"
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch: java.lang.Throwable -> L8c
            if (r0 == 0) goto L88
            com.alipay.mobile.rome.longlinkservice.LongLinkAppConfig r0 = r5.c     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.servHost     // Catch: java.lang.Throwable -> L8c
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L8c
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
        L1c:
            r2 = 0
            goto L7b
        L1e:
            java.lang.String r1 = " "
            boolean r1 = r0.startsWith(r1)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L33
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.substring(r2, r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L8c
            goto L1e
        L33:
            java.lang.String r1 = " "
            boolean r1 = r0.endsWith(r1)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L49
            int r1 = r0.length()     // Catch: java.lang.Throwable -> L8c
            int r1 = r1 - r2
            java.lang.String r0 = r0.substring(r3, r1)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Throwable -> L8c
            goto L33
        L49:
            java.lang.String r1 = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"
            boolean r1 = r0.matches(r1)     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L1c
            java.lang.String r1 = "\\."
            java.lang.String[] r0 = r0.split(r1)     // Catch: java.lang.Throwable -> L8c
            r1 = r0[r3]     // Catch: java.lang.Throwable -> L8c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L8c
            r4 = 255(0xff, float:3.57E-43)
            if (r1 >= r4) goto L1c
            r1 = r0[r2]     // Catch: java.lang.Throwable -> L8c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L8c
            if (r1 >= r4) goto L1c
            r1 = 2
            r1 = r0[r1]     // Catch: java.lang.Throwable -> L8c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L8c
            if (r1 >= r4) goto L1c
            r1 = 3
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L8c
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L8c
            if (r0 >= r4) goto L1c
        L7b:
            if (r2 == 0) goto L82
            java.lang.String r0 = "*.cloud.alipay.com"
            r5.h = r0     // Catch: java.lang.Throwable -> L8c
            goto L88
        L82:
            com.alipay.mobile.rome.longlinkservice.LongLinkAppConfig r0 = r5.c     // Catch: java.lang.Throwable -> L8c
            java.lang.String r0 = r0.servHost     // Catch: java.lang.Throwable -> L8c
            r5.h = r0     // Catch: java.lang.Throwable -> L8c
        L88:
            java.lang.String r0 = r5.h     // Catch: java.lang.Throwable -> L8c
            monitor-exit(r5)
            return r0
        L8c:
            r0 = move-exception
            monitor-exit(r5)
            goto L90
        L8f:
            throw r0
        L90:
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.a.a.k():java.lang.String");
    }

    private static String l() {
        Context context = com.alipay.mobile.rome.syncservice.d.a.f7279a;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Throwable th) {
            String str = d;
            StringBuilder sb = new StringBuilder("LongLinkAppInfo exception:");
            sb.append(th);
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
            return null;
        }
    }
}
