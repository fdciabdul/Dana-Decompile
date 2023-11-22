package com.alipay.mobile.rome.syncsdk.service;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f7236a;

    private h(f fVar) {
        this.f7236a = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(f fVar, byte b) {
        this(fVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        str = f.f7234a;
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "FlowControlTask: [ flow control is over ]");
        com.alipay.mobile.rome.syncsdk.a.c.a(false);
        com.alipay.mobile.rome.syncsdk.b.a.a().b(LongLinkService.a().f(), "flow_control");
        a b = LongLinkService.b();
        if (b == null) {
            str2 = f.f7234a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, "FlowControlTask: [ connManager=null ]");
            return;
        }
        b.c();
    }
}
