package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.service.ConnStateFsm;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a */
    private static final String f7224a = "a";
    private final com.alipay.mobile.rome.syncsdk.service.a b;

    public a(com.alipay.mobile.rome.syncsdk.service.a aVar) {
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = f7224a;
        com.alipay.mobile.rome.syncsdk.util.c.a(str, "BindUserTask: run ");
        if (ConnStateFsm.State.DEVICE_BINDED != this.b.b()) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "BindUserTask: run: [ not device binded state ]");
            return;
        }
        com.alipay.mobile.rome.syncsdk.util.c.b(str, "sendBindUserPacket: ");
        com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
        a2.a(0);
        a2.b(0);
        String str2 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        String f = com.alipay.mobile.rome.syncsdk.a.a.a().f();
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(f)) {
            com.alipay.mobile.rome.syncsdk.util.c.c(str, "sendBindUserPacket: [ userId or sessionId is null ]");
            return;
        }
        a2.a(com.alipay.mobile.rome.syncsdk.util.f.a(com.alipay.mobile.rome.syncsdk.util.a.a(this.b.f7222a, "bind")));
        try {
            if (ConnStateFsm.State.DEVICE_BINDED != this.b.b()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(str, "BindUserTask: run: [ not device binded state ]");
                return;
            }
            this.b.x();
            long currentTimeMillis = System.currentTimeMillis();
            this.b.k().a(a2);
            com.alipay.mobile.rome.syncsdk.service.f.a().b(currentTimeMillis, com.alipay.mobile.rome.syncsdk.a.b.a());
        } catch (Exception e) {
            String str3 = f7224a;
            StringBuilder sb = new StringBuilder("sendBindUserPacket: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb.toString());
        }
    }
}
