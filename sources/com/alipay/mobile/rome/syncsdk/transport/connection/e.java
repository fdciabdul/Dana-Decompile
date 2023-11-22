package com.alipay.mobile.rome.syncsdk.transport.connection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f7257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f7257a = dVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        d.a(this.f7257a);
    }
}
