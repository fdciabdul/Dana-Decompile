package com.alipay.mobile.rome.syncsdk.service.a;

/* loaded from: classes3.dex */
public class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7227a = "d";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public d(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = f7227a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "DisconnectTask: run: ");
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "disconnect: [ DisconnectTask ]");
        this.b.a();
        com.alipay.mobile.rome.syncsdk.transport.connection.a k = this.b.k();
        this.b.a((com.alipay.mobile.rome.syncsdk.transport.connection.a) null);
        if (k != null) {
            k.d();
        }
    }
}
