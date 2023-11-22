package com.uc.crashsdk.a;

import android.os.Build;
import android.os.Process;
import android.util.SparseArray;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.timepicker.TimeModel;
import com.google.common.base.Ascii;
import com.uc.crashsdk.p;
import id.dana.data.here.HereOauthManager;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.oauth.OauthConstant;
import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes8.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f7713a = new Object();
    private static Map<String, String> b = new HashMap();
    private static int c = 0;
    private static Map<String, b> d = new HashMap();
    private static Object e = new Object();
    private static SparseArray<String> f = new SparseArray<>();
    private static boolean g = false;
    private static boolean h = false;
    private static final char[] i = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] d() {
        return new byte[]{Byte.MAX_VALUE, 100, 110, Ascii.US};
    }

    static /* synthetic */ void a(StringBuilder sb, String str, long j) {
        b(sb, str, String.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(String str) {
        if (h) {
            return false;
        }
        h = true;
        File file = new File(str);
        ArrayList<b> a2 = a(file, "crp", 100);
        b bVar = new b("crp", false, false);
        bVar.a("et", String.valueOf(com.uc.crashsdk.b.u()));
        bVar.a("prc", com.uc.crashsdk.f.d());
        bVar.a("imp", com.uc.crashsdk.b.t() ? "1" : "0");
        a(bVar);
        a2.add(0, bVar);
        boolean b2 = b(com.uc.crashsdk.f.j(), a((Iterable<b>) a2, true, false).toString());
        com.uc.crashsdk.a.b.a(file);
        if (!b2) {
            com.uc.crashsdk.a.b.a(file, a((Iterable<b>) a2, false, true).toString());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean d(String str) {
        File file = new File(str);
        Iterator<b> it = a(file, "cst", 30).iterator();
        while (it.hasNext()) {
            b next = it.next();
            String a2 = next.a("prc");
            if (!h.a(a2)) {
                b bVar = d.get(a2);
                if (bVar != null) {
                    bVar.a(next);
                } else {
                    d.put(a2, next);
                }
            }
        }
        boolean b2 = b(com.uc.crashsdk.f.j(), a((Iterable<b>) d.values(), true, false).toString());
        com.uc.crashsdk.a.b.a(file);
        if (!b2) {
            com.uc.crashsdk.a.b.a(file, a((Iterable<b>) d.values(), false, true).toString());
        }
        return true;
    }

    static /* synthetic */ int e() {
        return k();
    }

    static /* synthetic */ void f() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.N());
        sb.append("cr.wa");
        String obj = sb.toString();
        com.uc.crashsdk.b.a(f7713a, obj, new l(obj, obj));
    }

    static /* synthetic */ boolean h() {
        if (g) {
            return false;
        }
        g = true;
        if (com.uc.crashsdk.a.b.equals("2.0") && com.uc.crashsdk.b.b((int) SQLiteDatabase.CREATE_IF_NECESSARY)) {
            return false;
        }
        File file = new File(j());
        String b2 = com.uc.crashsdk.a.b.b(file);
        b bVar = new b("pv", true, true);
        if (!h.a(b2)) {
            bVar.b(b2);
        }
        if (bVar.b == Process.myPid()) {
            return false;
        }
        bVar.a("pv", 1L);
        bVar.a("fjv", 1L);
        String j = com.uc.crashsdk.f.j();
        long j2 = bVar.f7715a;
        if ((j2 == 0 || System.currentTimeMillis() - j2 >= 28800000) ? b(j, bVar.a(true, true, false)) : false) {
            bVar.c = new HashMap();
            bVar.f7715a = System.currentTimeMillis();
            bVar.b = Process.myPid();
        }
        com.uc.crashsdk.a.b.a(file, bVar.a(false, false, true));
        return true;
    }

    static /* synthetic */ void i() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.N());
        sb.append("dt.wa");
        String obj = sb.toString();
        com.uc.crashsdk.b.a(e, obj, new m(obj, obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        long f7715a = 0;
        int b = 0;
        Map<String, String> c = new HashMap();
        private String d;
        private boolean e;
        private boolean f;

        b(String str, boolean z, boolean z2) {
            this.e = false;
            this.f = false;
            this.d = str;
            this.e = z;
            this.f = z2;
        }

        final void a(String str, String str2) {
            this.c.put(str, str2);
        }

        final void a(String str, long j) {
            a(str, String.valueOf(c(str) + j));
        }

        final boolean a(b bVar) {
            if (!this.f) {
                c.a("crashsdk", String.format("WaItem '%s' is not mergable!", this.d));
                return false;
            }
            for (String str : bVar.c.keySet()) {
                if (str.startsWith("c_")) {
                    a(str, bVar.a(str));
                } else {
                    long c = bVar.c(str);
                    if (c != 0) {
                        a(str, c);
                    } else {
                        a(str, bVar.a(str));
                    }
                }
            }
            return true;
        }

        final String a(String str) {
            return this.c.get(str);
        }

        private long c(String str) {
            return h.c(a(str));
        }

        final String a(boolean z, boolean z2, boolean z3) {
            String str;
            if (this.d == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (z) {
                try {
                    str = Build.HARDWARE;
                } catch (Throwable th) {
                    com.uc.crashsdk.a.a.a(th, false);
                    str = "-";
                }
                k.b(sb, "lt", "uc");
                k.b(sb, "pre", p.e());
                k.b(sb, "pkg", com.uc.crashsdk.a.f7699a);
                k.b(sb, "rom", Build.VERSION.RELEASE);
                k.b(sb, H5GetLogInfoBridge.RESULT_MODEL, Build.MODEL);
                k.a(sb, OauthConstant.OauthType.SDK_TYPE, Build.VERSION.SDK_INT);
                k.b(sb, "cpu", Build.CPU_ABI);
                k.b(sb, "hdw", str);
                k.a(sb, "ram", k.e());
                k.b(sb, "cver", "2.0.0.4");
                k.b(sb, "cseq", "170706161743");
                k.b(sb, "aver", com.uc.crashsdk.a.a());
                k.b(sb, "ver", p.K());
                k.b(sb, "sver", p.L());
                k.b(sb, "seq", p.M());
                k.b(sb, H5GetLogInfoBridge.RESULT_OS, "android");
                sb.append("\n");
            }
            k.b(sb, "lt", this.d);
            k.a(sb, this.c);
            if (this.e && !z2) {
                long j = this.f7715a;
                if (j != 0) {
                    k.b(sb, "up", String.valueOf(j));
                }
                if (z3) {
                    k.b(sb, "pid", String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(Process.myPid())));
                } else if (this.b != 0) {
                    k.b(sb, "pid", String.format(Locale.US, TimeModel.NUMBER_FORMAT, Integer.valueOf(this.b)));
                }
            }
            sb.append("\n");
            return sb.toString();
        }

        final boolean b(String str) {
            if (h.a(str)) {
                return false;
            }
            long j = 0;
            HashMap hashMap = new HashMap();
            Map<String, String> a2 = k.a(str);
            String str2 = null;
            int i = 0;
            for (String str3 : a2.keySet()) {
                String str4 = a2.get(str3);
                if (str3.equals("lt")) {
                    str2 = str4;
                } else if (this.e && str3.equals("up")) {
                    j = h.c(str4);
                } else if (this.e && str3.equals("pid")) {
                    i = (int) h.c(str4);
                } else {
                    hashMap.put(str3, str4);
                }
            }
            String str5 = this.d;
            if (str5 == null || str5.equals(str2)) {
                this.f7715a = j;
                this.b = i;
                this.d = str2;
                this.c = hashMap;
                return true;
            }
            return false;
        }
    }

    public static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("`")) {
            if (str2.length() > 1) {
                String[] split = str2.split("=");
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    public static void a(StringBuilder sb, Map<String, String> map) {
        for (String str : map.keySet()) {
            b(sb, str, map.get(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    public static void b(String str) {
        synchronized (f7713a) {
            File file = new File(j());
            b bVar = new b("pv", true, true);
            String b2 = com.uc.crashsdk.a.b.b(file);
            if (!h.a(b2)) {
                bVar.b(b2);
            }
            bVar.a(str, 1L);
            bVar.a("aujv", 1L);
            com.uc.crashsdk.a.b.a(file, bVar.a(false, false, false));
        }
    }

    public static void a() {
        if (com.uc.crashsdk.b.t()) {
            i.a(0, new a(2), 36000L);
        }
    }

    public static boolean a(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder("c_");
            sb.append(str.replaceAll("[^0-9a-zA-Z-_]", "-"));
            String obj = sb.toString();
            String replaceAll = h.a(str2) ? "" : str2.replaceAll("[`=]", "-");
            synchronized (b) {
                if (b.get(obj) == null) {
                    int i2 = c;
                    if (i2 >= 20) {
                        return false;
                    }
                    c = i2 + 1;
                }
                b.put(obj, replaceAll);
                return true;
            }
        } catch (Throwable th) {
            com.uc.crashsdk.a.a.a(th, false);
            return false;
        }
    }

    private static void a(b bVar) {
        synchronized (b) {
            for (String str : b.keySet()) {
                bVar.a(str, b.get(str));
            }
        }
    }

    public static void b() {
        if (p.I()) {
            i.a(1, new a(1), 2000L);
        }
    }

    /* loaded from: classes8.dex */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f7714a = true;
        private int b;

        a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i == 1) {
                k.f();
            } else if (i == 2) {
                synchronized (k.f7713a) {
                    k.h();
                }
            } else if (i == 3) {
                k.i();
            } else if (!f7714a) {
                throw new AssertionError();
            }
        }
    }

    private static StringBuilder a(Iterable<b> iterable, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (b bVar : iterable) {
            if (z3) {
                sb.append(bVar.a(z, z, z2));
                z3 = false;
            } else {
                sb.append(bVar.a(false, z, z2));
            }
        }
        return sb;
    }

    public static void a(String str, int i2, int i3) {
        if (p.I()) {
            synchronized (e) {
                b bVar = d.get(str);
                if (bVar == null) {
                    bVar = new b("cst", false, true);
                    d.put(str, bVar);
                    a(bVar);
                }
                synchronized (f) {
                    if (f.size() == 0) {
                        a(100, "pv");
                        a(1, "all");
                        a(2, "afg");
                        a(3, "jfg");
                        a(4, "jbg");
                        a(7, "nfg");
                        a(8, "nbg");
                        a(27, "nafg");
                        a(28, "nabg");
                        a(9, "nho");
                        a(10, "uar");
                        a(29, "ulm");
                        a(30, "ukt");
                        a(31, "uet");
                        a(11, "ufg");
                        a(12, "ubg");
                        a(13, "lup");
                        a(14, "luf");
                        a(15, "lef");
                        a(16, "laf");
                        a(22, "lac");
                        a(23, "lau");
                        a(17, "llf");
                        a(18, "lul");
                        a(19, "lub");
                        a(20, "luc");
                        a(21, "luu");
                        a(24, "lzc");
                        a(25, "lrc");
                        a(26, "lss");
                    }
                }
                String str2 = f.get(i2);
                if (str2 == null) {
                    StringBuilder sb = new StringBuilder("map key is not set with: ");
                    sb.append(i2);
                    c.a("crashsdk", sb.toString());
                }
                bVar.a("prc", str);
                if (str2 != null) {
                    bVar.a(str2, String.valueOf(i3));
                }
            }
        }
    }

    public static void c() {
        if (p.I()) {
            i.a(1, new a(3));
        }
    }

    private static void a(int i2, String str) {
        f.put(i2, str);
    }

    private static ArrayList<b> a(File file, String str, int i2) {
        ArrayList<String> a2 = com.uc.crashsdk.a.b.a(file, i2);
        ArrayList<b> arrayList = new ArrayList<>();
        Iterator<String> it = a2.iterator();
        while (it.hasNext()) {
            String next = it.next();
            b bVar = new b(str, false, false);
            if (bVar.b(next)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private static String j() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.N());
        sb.append("pv.wa");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.lang.String r9, java.lang.String r10) {
        /*
            boolean r0 = com.uc.crashsdk.a.h.a(r10)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            byte[] r10 = r10.getBytes()
            r0 = 16
            r2 = 8
            r3 = 0
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L3b
            byte[] r4 = com.uc.crashsdk.a.e.c()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.e.a(r0, r3, r4)     // Catch: java.lang.Throwable -> L3b
            r4 = 4
            byte[] r5 = d()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.e.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L3b
            byte[] r4 = com.uc.crashsdk.a.c()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.e.a(r0, r2, r4)     // Catch: java.lang.Throwable -> L3b
            r4 = 12
            byte[] r5 = com.uc.crashsdk.a.f.c()     // Catch: java.lang.Throwable -> L3b
            com.uc.crashsdk.a.e.a(r0, r4, r5)     // Catch: java.lang.Throwable -> L3b
            byte[] r0 = com.uc.crashsdk.a.e.a(r10, r0)     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L3f
            r10 = r0
            r0 = 1
            goto L40
        L3b:
            r0 = move-exception
            com.uc.crashsdk.a.a.a(r0, r3)
        L3f:
            r0 = 0
        L40:
            boolean r4 = com.uc.crashsdk.p.J()
            if (r4 == 0) goto L49
            java.lang.String r4 = "4ea4e41a3993"
            goto L4b
        L49:
            java.lang.String r4 = "28ef1713347d"
        L4b:
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r9)
            r6.append(r5)
            java.lang.String r7 = "AppChk#2014"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = e(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            boolean r8 = com.uc.crashsdk.p.J()
            if (r8 == 0) goto L7c
            java.lang.String r8 = "https://gjapplog.uc.cn/collect?chk="
            goto L7e
        L7c:
            java.lang.String r8 = "https://applog.uc.cn/collect?chk="
        L7e:
            r7.append(r8)
            int r8 = r6.length()
            int r8 = r8 - r2
            int r2 = r6.length()
            java.lang.String r2 = r6.substring(r8, r2)
            r7.append(r2)
            java.lang.String r2 = "&vno="
            r7.append(r2)
            r7.append(r5)
            java.lang.String r2 = "&uuid="
            r7.append(r2)
            r7.append(r9)
            java.lang.String r9 = "&app="
            r7.append(r9)
            r7.append(r4)
            if (r0 == 0) goto Lb0
            java.lang.String r9 = "&enc=aes"
            r7.append(r9)
        Lb0:
            java.lang.String r9 = r7.toString()
            byte[] r9 = com.uc.crashsdk.a.e.a(r9, r10)
            if (r9 != 0) goto Lbb
            return r3
        Lbb:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r9)
            java.lang.String r9 = "retcode=0"
            boolean r9 = r10.contains(r9)
            if (r9 == 0) goto Lc9
            return r1
        Lc9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.k.b(java.lang.String, java.lang.String):boolean");
    }

    private static int k() {
        Iterator<String> it = com.uc.crashsdk.a.b.a(new File("/proc/meminfo"), 2).iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.indexOf("MemTotal:") >= 0) {
                try {
                    return Integer.parseInt(next.replaceAll("\\D+", ""));
                } catch (NumberFormatException e2) {
                    com.uc.crashsdk.a.a.a(e2, false);
                    return 0;
                }
            }
        }
        return 0;
    }

    private static String e(String str) {
        try {
            byte[] bytes = str.getBytes(HereOauthManager.ENC);
            MessageDigest messageDigest = MessageDigest.getInstance(MD5Util.ALGORIGTHM_MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            StringBuilder sb = new StringBuilder(length * 2);
            for (int i2 = 0; i2 < length + 0; i2++) {
                byte b2 = digest[i2];
                char[] cArr = i;
                char c2 = cArr[(b2 & 240) >> 4];
                char c3 = cArr[b2 & 15];
                sb.append(c2);
                sb.append(c3);
            }
            return sb.toString();
        } catch (Exception e2) {
            if (p.G()) {
                InstrumentInjector.log_d("crashsdk", "getMD5: ", e2);
            }
            return null;
        }
    }
}
