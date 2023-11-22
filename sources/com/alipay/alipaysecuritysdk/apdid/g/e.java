package com.alipay.alipaysecuritysdk.apdid.g;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f6862a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";
    private static String e = "";
    private static Map<String, String> f = new HashMap();

    public static void a() {
        synchronized (e.class) {
            Iterator<String> it = f.keySet().iterator();
            while (it.hasNext()) {
                f.get(it.next());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
    
        if (r1 >= 0) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Class<com.alipay.alipaysecuritysdk.apdid.g.e> r0 = com.alipay.alipaysecuritysdk.apdid.g.e.class
            monitor-enter(r0)
            long r1 = com.alipay.alipaysecuritysdk.apdid.g.d.a(r6)     // Catch: java.lang.Throwable -> Le
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto Le
            goto L11
        Le:
            r1 = 86400000(0x5265c00, double:4.2687272E-316)
        L11:
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L25
            long r6 = com.alipay.alipaysecuritysdk.apdid.g.d.g(r6, r7)     // Catch: java.lang.Throwable -> L25
            long r3 = r3 - r6
            long r6 = java.lang.Math.abs(r3)     // Catch: java.lang.Throwable -> L25
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto L2b
            monitor-exit(r0)
            r6 = 1
            return r6
        L25:
            r6 = move-exception
            java.lang.String r7 = "SEC_SDK-apdid"
            com.alipay.alipaysecuritysdk.common.c.b.a(r7, r6)     // Catch: java.lang.Throwable -> L2e
        L2b:
            monitor-exit(r0)
            r6 = 0
            return r6
        L2e:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.g.e.a(android.content.Context, java.lang.String):boolean");
    }

    public static String a(String str) {
        synchronized (e.class) {
            StringBuilder sb = new StringBuilder("apdidTokenCache");
            sb.append(str);
            String obj = sb.toString();
            if (f.containsKey(obj)) {
                String str2 = f.get(obj);
                if (com.alipay.alipaysecuritysdk.common.e.e.d(str2)) {
                    return str2;
                }
            }
            return "";
        }
    }

    public static String b() {
        String str;
        synchronized (e.class) {
            str = f6862a;
        }
        return str;
    }

    public static String c() {
        String str;
        synchronized (e.class) {
            str = b;
        }
        return str;
    }

    public static String d() {
        String str;
        synchronized (e.class) {
            str = d;
        }
        return str;
    }

    public static String e() {
        String str;
        synchronized (e.class) {
            str = e;
        }
        return str;
    }

    public static com.alipay.alipaysecuritysdk.apdid.g.a.a f() {
        com.alipay.alipaysecuritysdk.apdid.g.a.a aVar;
        synchronized (e.class) {
            aVar = new com.alipay.alipaysecuritysdk.apdid.g.a.a(f6862a, b, c, d, e);
        }
        return aVar;
    }

    public static void a(String str, String str2) {
        synchronized (e.class) {
            StringBuilder sb = new StringBuilder("apdidTokenCache");
            sb.append(str);
            String obj = sb.toString();
            if (f.containsKey(obj)) {
                f.remove(obj);
            }
            f.put(obj, str2);
        }
    }

    public static void b(String str) {
        f6862a = str;
    }

    public static void c(String str) {
        b = str;
    }

    public static void d(String str) {
        c = str;
    }

    public static void e(String str) {
        d = str;
    }

    public static void f(String str) {
        e = str;
    }

    public static void g() {
        f.clear();
        f6862a = "";
        b = "";
        d = "";
        e = "";
        c = "";
    }

    public static void a(com.alipay.alipaysecuritysdk.apdid.g.a.a aVar) {
        synchronized (e.class) {
            if (aVar != null) {
                f6862a = aVar.f6859a;
                b = aVar.b;
                d = aVar.d;
                e = aVar.e;
                c = aVar.c;
            }
            a();
        }
    }
}
