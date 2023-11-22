package com.alipay.mobile.rome.syncsdk.service.a;

/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7228a = "e";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public e(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = f7228a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "HeartBeatTask: run: ");
        if (!this.b.q()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "HeartBeatTask: run: [ connection isDeviceBined=false ]");
            return;
        }
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "sendHeartBeat: ");
        com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
        a2.a(3);
        a2.b(0);
        a2.a("");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.f.a().a(currentTimeMillis, com.alipay.mobile.rome.syncsdk.a.b.a());
        } catch (Exception e) {
            String str2 = f7228a;
            StringBuilder sb = new StringBuilder("sendHeartBeat: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
        }
    }
}
