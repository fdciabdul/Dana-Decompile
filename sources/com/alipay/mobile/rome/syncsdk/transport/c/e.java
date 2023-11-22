package com.alipay.mobile.rome.syncsdk.transport.c;

/* loaded from: classes3.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7246a = "e";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public e(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final boolean b(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        return aVar != null && aVar.a() == 1;
    }

    @Override // com.alipay.mobile.rome.syncsdk.transport.c.a
    public final void a(com.alipay.mobile.rome.syncsdk.transport.b.a aVar) {
        com.alipay.mobile.rome.syncsdk.util.c.a(f7246a, "processPacket: close ");
        this.b.e();
    }
}
