package com.alipay.mobile.rome.syncsdk.transport.connection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.alipay.mobile.rome.syncsdk.transport.b.a f7254a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.alipay.mobile.rome.syncsdk.transport.b.a aVar2) {
        this.b = aVar;
        this.f7254a = aVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f7253a.a(this.f7254a);
    }
}
