package com.alipay.mobile.rome.syncsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.alipay.mobile.rome.longlinkservice.ConnectionListener;
import com.alipay.mobile.rome.syncsdk.service.LongLinkNetInfoReceiver;
import com.alipay.mobile.rome.syncsdk.service.LongLinkService;
import com.alipay.mobile.rome.syncsdk.service.e;
import com.alipay.mobile.rome.syncsdk.util.AppStatusUtils;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7214a = "b";
    private static b b;
    private volatile e c;
    private volatile a d;

    private b(Context context) {
        final LongLinkService a2 = LongLinkService.a();
        a2.c = context;
        if (a2.c != null) {
            LongLinkService.b = new com.alipay.mobile.rome.syncsdk.service.a(context);
            com.alipay.mobile.rome.syncsdk.util.c.b(LongLinkService.f7220a, "registerNetInfoReceiver: ");
            try {
                a2.d = new LongLinkNetInfoReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                a2.c.registerReceiver(a2.d, intentFilter);
            } catch (IllegalArgumentException e) {
                String str = LongLinkService.f7220a;
                StringBuilder sb = new StringBuilder("registerNetInfoReceiver: [ IllegalArgumentException=");
                sb.append(e);
                sb.append(" ]");
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
            }
            a2.e = new BroadcastReceiver() { // from class: com.alipay.mobile.rome.syncsdk.service.LongLinkService.1
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) {
                    String str2 = LongLinkService.f7220a;
                    StringBuilder sb2 = new StringBuilder("ScreenStatusReceiver Action=");
                    sb2.append(intent.getAction());
                    com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb2.toString());
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        AppStatusUtils.f7262a = AppStatusUtils.ScreenStatus.SCREEN_OFF;
                        com.alipay.mobile.rome.syncsdk.b.a(LongLinkService.this.c).d();
                    } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                        AppStatusUtils.f7262a = AppStatusUtils.ScreenStatus.SCREEN_ON;
                        if (AppStatusUtils.a() == AppStatusUtils.AppStatus.FOREGROUND) {
                            com.alipay.mobile.rome.syncsdk.b.a(LongLinkService.this.c).c();
                        }
                    }
                }
            };
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.intent.action.SCREEN_OFF");
            intentFilter2.addAction("android.intent.action.SCREEN_ON");
            a2.c.registerReceiver(a2.e, intentFilter2);
        }
        this.c = new c(this);
    }

    public static b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    public final void a(a aVar) {
        synchronized (this) {
            String str = f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.b(str, "init longlink [ bindService ]  ");
            this.d = aVar;
            if (aVar == null) {
                com.alipay.mobile.rome.syncsdk.util.c.b(str, "bindService: [ callback=null ]");
                return;
            }
            LongLinkService.a();
            LongLinkService.a(this.c);
        }
    }

    public final void a(String str, String str2) {
        synchronized (this) {
            String str3 = f7214a;
            StringBuilder sb = new StringBuilder("setUserInfo [ userId=");
            sb.append(str);
            sb.append(" ][ sessionId=");
            sb.append(str2);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str3, sb.toString());
            com.alipay.mobile.rome.syncsdk.a.a.a().f7211a = str;
            com.alipay.mobile.rome.syncsdk.a.a.a().b = str2;
            LongLinkService.a();
            LongLinkService.e();
        }
    }

    public final void a() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.b(f7214a, "setConnActionActive: ");
            com.alipay.mobile.rome.syncsdk.a.c.g();
        }
    }

    public final boolean b() {
        boolean d;
        synchronized (this) {
            LongLinkService.a();
            d = LongLinkService.d();
        }
        return d;
    }

    public static void a(ConnectionListener connectionListener) {
        LongLinkService a2 = LongLinkService.a();
        if (connectionListener == null) {
            com.alipay.mobile.rome.syncsdk.util.c.c(LongLinkService.f7220a, "[addConnectionListener] connectionListener is null.");
            return;
        }
        if (LongLinkService.b == null) {
            LongLinkService.b = new com.alipay.mobile.rome.syncsdk.service.a(a2.c);
        }
        String str = LongLinkService.f7220a;
        StringBuilder sb = new StringBuilder("[addConnectionListener] connectionListener = ");
        sb.append(connectionListener.getClass().getName());
        com.alipay.mobile.rome.syncsdk.util.c.c(str, sb.toString());
        LongLinkService.b.z().addObserver(connectionListener);
    }

    public static void b(ConnectionListener connectionListener) {
        LongLinkService.a();
        LongLinkService.a(connectionListener);
    }

    public final void c() {
        synchronized (this) {
            String str = f7214a;
            com.alipay.mobile.rome.syncsdk.util.c.b(str, "startLink");
            LongLinkService.a();
            if (LongLinkService.d()) {
                com.alipay.mobile.rome.syncsdk.util.c.c(str, "startLink: [ already connected ] ");
                return;
            }
            LongLinkService.a();
            LongLinkService.c();
        }
    }

    public final void d() {
        synchronized (this) {
            com.alipay.mobile.rome.syncsdk.util.c.b(f7214a, "stopLink： ");
            LongLinkService a2 = LongLinkService.a();
            com.alipay.mobile.rome.syncsdk.a.c.b();
            if (LongLinkService.b == null) {
                LongLinkService.b = new com.alipay.mobile.rome.syncsdk.service.a(a2.c);
            }
            LongLinkService.b.e();
            if (a2.e != null && a2.c != null) {
                a2.c.unregisterReceiver(a2.e);
                a2.e = null;
            }
        }
    }

    public final void a(byte[] bArr) {
        synchronized (this) {
            LongLinkService.a();
            LongLinkService.a(bArr);
        }
    }
}
