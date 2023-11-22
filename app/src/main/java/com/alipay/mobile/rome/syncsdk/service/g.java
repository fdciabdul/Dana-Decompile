package com.alipay.mobile.rome.syncsdk.service;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f7235a;

    private g(f fVar) {
        this.f7235a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(f fVar, byte b) {
        this(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        str = f.f7234a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "DelayedConnectTask: ");
        synchronized (this.f7235a) {
            f.a(this.f7235a);
        }
        a b = LongLinkService.b();
        if (b == null) {
            str2 = f.f7234a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "DelayedConnectTask: [ connManager=null ]");
            return;
        }
        b.c();
    }
}
