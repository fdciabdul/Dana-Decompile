package com.alipay.mobile.rome.syncsdk.service.a;

/* loaded from: classes3.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7225a = "b";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public b(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = f7225a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "CloseConnTask: run: ");
        if (!this.b.p()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "sendClosePacket: [ isConnected=false ]");
            return;
        }
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "sendClosePacket: ");
        com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
        a2.a(1);
        a2.b(0);
        a2.a("");
        try {
            this.b.k().a(a2);
        } catch (Exception e) {
            String str2 = f7225a;
            StringBuilder sb = new StringBuilder("sendClosePacket: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
        }
    }
}
