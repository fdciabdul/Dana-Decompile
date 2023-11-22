package com.alipay.mobile.rome.syncsdk.service;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f7238a;
    private int b;
    private long c;
    private String d;

    public k(f fVar, String str, long j, int i) {
        this.f7238a = fVar;
        this.d = str;
        this.c = j;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        long o2;
        String str3;
        String str4;
        str = f.f7234a;
        StringBuilder sb = new StringBuilder("ReplyCheckTask: [ type=");
        sb.append(this.d);
        sb.append(" ][ sendTimeMillis=");
        sb.append(this.c);
        sb.append(" ][ delay=");
        sb.append(this.b);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        a b = LongLinkService.b();
        if (b == null) {
            str4 = f.f7234a;
            com.alipay.mobile.rome.syncsdk.util.c.d(str4, "ReplyCheckTask: [ connManager=null ]");
            return;
        }
        if ("typeHeartBeat".equals(this.d)) {
            o2 = b.n();
            synchronized (this.f7238a) {
                f.c(this.f7238a);
            }
        } else if (!"typeInit".equals(this.d)) {
            str2 = f.f7234a;
            StringBuilder sb2 = new StringBuilder("ReplyCheckTask: [ unknown type ][ type=");
            sb2.append(this.d);
            sb2.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb2.toString());
            return;
        } else {
            o2 = b.o();
            synchronized (this.f7238a) {
                f.d(this.f7238a);
            }
        }
        if (this.c > o2) {
            str3 = f.f7234a;
            StringBuilder sb3 = new StringBuilder("ReplyCheckTask: Reply check Timeout[ type=");
            sb3.append(this.d);
            sb3.append(" ][ sendTimeMillis=");
            sb3.append(this.c);
            sb3.append(" ][ lastTime=");
            sb3.append(o2);
            sb3.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb3.toString());
            com.alipay.mobile.rome.syncsdk.a.c.c();
            b.f();
        }
    }
}
