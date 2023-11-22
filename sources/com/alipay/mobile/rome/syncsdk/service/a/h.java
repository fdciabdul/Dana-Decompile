package com.alipay.mobile.rome.syncsdk.service.a;

/* loaded from: classes3.dex */
public class h implements Runnable {

    /* renamed from: a */
    private static final String f7231a = "h";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public h(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = f7231a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "UnBindUserTask: run ");
        if (!this.b.r()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "UnBindUserTask: run: [ user not binded ]");
            return;
        }
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "sendUnbindUserPacket: ");
        com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
        a2.a(0);
        a2.b(0);
        try {
            a2.a(com.alipay.mobile.rome.syncsdk.util.f.a(com.alipay.mobile.rome.syncsdk.util.a.a(this.b.f7222a, "unbind")));
            this.b.y();
            long currentTimeMillis = System.currentTimeMillis();
            this.b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.f.a().b(currentTimeMillis, com.alipay.mobile.rome.syncsdk.a.b.a());
        } catch (Exception e) {
            String str2 = f7231a;
            StringBuilder sb = new StringBuilder("sendUnbindUserPacket: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
        }
    }
}
