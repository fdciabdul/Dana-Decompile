package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.service.ConnStateFsm;

/* loaded from: classes3.dex */
public class f implements Runnable {

    /* renamed from: a */
    private static final String f7229a = "f";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public f(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = f7229a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "RegisterTask: run ");
        if (ConnStateFsm.State.CONNECTED != this.b.b()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "RegisterTask: run: [ not connected state ]");
            return;
        }
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "sendRegisterPacket");
        com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
        boolean z = false;
        a2.a(0);
        a2.b(0);
        try {
            String h = com.alipay.mobile.rome.syncsdk.a.c.h();
            if (TextUtils.isEmpty(h)) {
                h = "reconn";
            }
            a2.a(com.alipay.mobile.rome.syncsdk.util.f.a(com.alipay.mobile.rome.syncsdk.util.a.a(this.b.f7222a, h)));
            if (ConnStateFsm.State.CONNECTED != this.b.b()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(str, "RegisterTask: run: [ not connected state ]");
                return;
            }
            if (!TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f7211a) && !TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().f())) {
                z = true;
            }
            if (z) {
                this.b.v();
            } else {
                this.b.w();
            }
            long currentTimeMillis = System.currentTimeMillis();
            this.b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.f.a().b(currentTimeMillis, com.alipay.mobile.rome.syncsdk.a.b.a());
        } catch (Throwable th) {
            String str2 = f7229a;
            StringBuilder sb = new StringBuilder("sendRegisterPacket: [ Exception=");
            sb.append(th);
            sb.append(" ]");
            sb.append(th.getMessage());
            com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb.toString());
            com.alipay.mobile.rome.syncsdk.service.f.a().a(com.alipay.mobile.rome.syncsdk.a.b.b());
        }
    }
}
