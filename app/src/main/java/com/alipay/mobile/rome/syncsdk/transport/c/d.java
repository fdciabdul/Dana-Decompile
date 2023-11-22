package com.alipay.mobile.rome.syncsdk.transport.c;

/* loaded from: classes3.dex */
final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    a f7245a;
    final /* synthetic */ b b;
    private com.alipay.mobile.rome.syncsdk.transport.b.a c;

    public d(b bVar, a aVar, com.alipay.mobile.rome.syncsdk.transport.b.a aVar2) {
        this.b = bVar;
        this.c = aVar2;
        this.f7245a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7245a.a(this.c);
    }
}
