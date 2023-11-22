package com.alipay.mobile.rome.syncsdk.service.a;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7230a = "g";
    private final com.alipay.mobile.rome.syncsdk.service.a b;
    private String c = null;
    private byte[] d;

    public g(com.alipay.mobile.rome.syncsdk.service.a aVar, byte[] bArr) {
        this.b = aVar;
        this.d = bArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.alipay.mobile.rome.syncsdk.util.c.a(f7230a, "SendLinkSyncDataTask: run: ");
        com.alipay.mobile.rome.syncsdk.transport.b.a a2 = com.alipay.mobile.rome.syncsdk.transport.b.c.a(this.b.m());
        a2.a(8);
        a2.b(0);
        if (!TextUtils.isEmpty(this.c)) {
            a2.a(this.c);
        } else {
            byte[] bArr = this.d;
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            a2.a(bArr);
        }
        try {
            this.b.k().a(a2);
        } catch (Exception e) {
            String str = f7230a;
            StringBuilder sb = new StringBuilder("sendSyncPacket: [ Exception=");
            sb.append(e);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
        }
    }
}
