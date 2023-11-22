package com.alipay.mobile.rome.syncsdk.service;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f7237a;

    private i(f fVar) {
        this.f7237a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(f fVar, byte b) {
        this(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        str = f.f7234a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "HeartBeatTask: ");
        synchronized (this.f7237a) {
            f.b(this.f7237a);
        }
        a b = LongLinkService.b();
        if (b == null) {
            str2 = f.f7234a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "HeartBeatTask: [ connManager=null ]");
            return;
        }
        b.h();
    }
}
