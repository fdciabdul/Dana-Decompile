package com.alipay.mobile.rome.syncservice.sync.c;

/* loaded from: classes3.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    String f7298a;

    public d(String str) {
        this.f7298a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        str = c.f7297a;
        StringBuilder sb = new StringBuilder("DispatchBizTask: run [ biz=");
        sb.append(this.f7298a);
        sb.append(" ]");
        com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        a.c(this.f7298a);
    }
}
