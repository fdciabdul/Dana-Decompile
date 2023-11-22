package com.alipay.mobile.rome.syncsdk.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes3.dex */
public class LongLinkNetInfoReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f7219a = 0;
    public static volatile boolean b = true;
    private static final String c = "LongLinkNetInfoReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            boolean b2 = com.alipay.mobile.rome.syncsdk.util.e.b(context);
            b = b2;
            if (!b2) {
                String str = c;
                StringBuilder sb = new StringBuilder("onReceive: [ LongLinkNetInfoReceiver ] [ isNetAvailable=");
                sb.append(b);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.c(str, sb.toString());
                return;
            }
            f7219a = com.alipay.mobile.rome.syncsdk.util.e.c(context);
            if (com.alipay.mobile.rome.syncsdk.a.c.a()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(c, "onReceive: [ LongLinkNetInfoReceiver ] [ isForceStopped=true ]");
                return;
            }
            a b3 = LongLinkService.b();
            if (b3 == null) {
                com.alipay.mobile.rome.syncsdk.util.c.c(c, "onReceive: [ LongLinkNetInfoReceiver ] [ connManager=null ]");
            } else if (b3.p()) {
                b3.h();
            } else {
                com.alipay.mobile.rome.syncsdk.util.c.a(c, "onReceive: [ LongLinkNetInfoReceiver ] [ isConnected=false - need connect ]");
                if (!com.alipay.mobile.rome.syncsdk.a.c.f()) {
                    com.alipay.mobile.rome.syncsdk.a.c.e();
                }
                b3.c();
            }
        }
    }
}
