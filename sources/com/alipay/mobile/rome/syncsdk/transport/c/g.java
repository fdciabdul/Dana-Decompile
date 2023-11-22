package com.alipay.mobile.rome.syncsdk.transport.c;

/* loaded from: classes3.dex */
public class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7248a = "g";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public g(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null && aVar.a() == 8;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        String str = f7248a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "ImplLinkSync processPacket");
        byte[] e = aVar.e();
        if (e == null || e.length <= 0) {
            com.alipay.mobile.rome.syncsdk.util.c.d(str, "processPacket: [ packet dataStr=null ]");
        } else {
            this.b.l().a(e);
        }
    }
}
