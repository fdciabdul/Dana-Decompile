package com.alipay.mobile.rome.syncsdk.transport.c;

/* loaded from: classes3.dex */
public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7247a = "f";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public f(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null && aVar.a() == 3;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        com.alipay.mobile.rome.syncsdk.util.c.a(f7247a, "processPacket: heartbeat ");
        this.b.a(System.currentTimeMillis());
        if (aVar.b() == 0) {
            try {
                com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
                a2.a(3);
                a2.b(1);
                a2.a("");
                this.b.k().a(a2);
            } catch (Exception e) {
                String str = f7247a;
                StringBuilder sb = new StringBuilder("processPacket: [ Exception=");
                sb.append(e);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            }
        }
        com.alipay.mobile.rome.syncsdk.service.f.a().b(com.alipay.mobile.rome.syncsdk.a.b.c());
    }
}
