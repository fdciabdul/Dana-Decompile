package com.alipay.mobile.rome.syncsdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.rome.syncsdk.service.LongLinkService;
import com.alipay.mobile.rome.syncsdk.service.f;
import com.alipay.mobile.rome.syncsdk.util.AppStatusUtils;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7213a = "c";
    private static volatile String b = "active";
    private static volatile int c;
    private static volatile boolean d;

    public static boolean a() {
        synchronized (c.class) {
            String str = f7213a;
            StringBuilder sb = new StringBuilder("  flowControlByServer=");
            sb.append(d);
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
            if (AppStatusUtils.a() == AppStatusUtils.AppStatus.BACKGROUND) {
                return true;
            }
            if (AppStatusUtils.f7262a == AppStatusUtils.ScreenStatus.SCREEN_OFF) {
                return true;
            }
            Context f = LongLinkService.a().f();
            String a2 = com.alipay.mobile.rome.syncsdk.b.a.a().a(f, "flow_control");
            if (!TextUtils.isEmpty(a2)) {
                try {
                    StringBuilder sb2 = new StringBuilder("checkFlowControl: fc=");
                    sb2.append(a2);
                    com.alipay.mobile.rome.syncsdk.util.c.a(str, sb2.toString());
                    String[] split = a2.split(",");
                    long parseLong = Long.parseLong(split[0]) - System.currentTimeMillis();
                    long parseLong2 = Long.parseLong(split[1]);
                    if (parseLong > 0 && parseLong2 > 0) {
                        f.a().a(Math.min(parseLong, parseLong2));
                    } else {
                        a(false);
                        com.alipay.mobile.rome.syncsdk.b.a.a().b(f, "flow_control");
                    }
                } catch (Exception e) {
                    String str2 = f7213a;
                    StringBuilder sb3 = new StringBuilder("checkFlowControl: e=");
                    sb3.append(e);
                    com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb3.toString());
                }
            }
            return d;
        }
    }

    public static void b() {
        synchronized (c.class) {
            com.alipay.mobile.rome.syncsdk.util.c.b(f7213a, "resetFailCount ");
            c = 0;
        }
    }

    public static void c() {
        synchronized (c.class) {
            c++;
            String str = f7213a;
            StringBuilder sb = new StringBuilder("addFailCount [ failCount=");
            sb.append(c);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public static void d() {
        synchronized (c.class) {
            if (c > 0) {
                c--;
            }
            String str = f7213a;
            StringBuilder sb = new StringBuilder("decreaseFailCount [ failCount=");
            sb.append(c);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public static void e() {
        synchronized (c.class) {
            c = 9;
            String str = f7213a;
            StringBuilder sb = new StringBuilder("setFailCountForOnceEnable [ failCount=");
            sb.append(c);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
    }

    public static boolean f() {
        boolean z;
        synchronized (c.class) {
            z = c < 10;
            String str = f7213a;
            StringBuilder sb = new StringBuilder("[isReconnEnable =");
            sb.append(z);
            sb.append(" ][ failCount=");
            sb.append(c);
            sb.append(" ][ MAX_FAIL_COUNT=10 ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
        }
        return z;
    }

    public static void a(String str) {
        synchronized (c.class) {
            String str2 = f7213a;
            StringBuilder sb = new StringBuilder("setConnAction [ connAction=");
            sb.append(str);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb.toString());
            b = str;
        }
    }

    public static void g() {
        synchronized (c.class) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7213a, "setConnActionActive");
            b = "active";
        }
    }

    public static String h() {
        String str;
        synchronized (c.class) {
            String str2 = f7213a;
            StringBuilder sb = new StringBuilder("getConnAction [ connAction=");
            sb.append(b);
            sb.append(" ]");
            com.alipay.mobile.rome.syncsdk.util.c.b(str2, sb.toString());
            str = b;
        }
        return str;
    }

    public static void a(boolean z) {
        synchronized (c.class) {
            String str = f7213a;
            StringBuilder sb = new StringBuilder("setFlowCotrol:");
            sb.append(z);
            com.alipay.mobile.rome.syncsdk.util.c.b(str, sb.toString());
            d = z;
        }
    }
}
