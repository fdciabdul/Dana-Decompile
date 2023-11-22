package com.uc.crashsdk;

import com.alibaba.ariver.kernel.RVParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7716a;
    public static boolean b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static String l;
    private static boolean m;
    private static boolean n;

    /* renamed from: o  reason: collision with root package name */
    private static volatile boolean f7717o;
    private static boolean p;
    private static boolean q;
    private static boolean r;
    private static String t;
    private static int u;
    private static RandomAccessFile v;
    private static boolean w;
    private static String y;
    private static volatile Object[] z;
    private static Object s = new Object();
    private static Object x = new Object();
    private static Runnable A = new c();
    private static long B = 0;
    private static Object C = new Object();
    private static long D = 0;
    private static boolean E = false;
    private static boolean F = false;
    private static boolean G = false;

    public static String a() {
        String str = t;
        if (str != null) {
            return str;
        }
        String d2 = f.d();
        if (com.uc.crashsdk.a.h.a(d2)) {
            t = "LLUN";
        } else {
            int i2 = 0;
            if (d2.length() > 48) {
                int length = d2.length();
                d2 = d2.substring(0, 48);
                i2 = length - 48;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bytes = d2.getBytes();
            for (int length2 = bytes.length - 1; length2 >= 0; length2--) {
                byte b2 = bytes[length2];
                if (b2 == 46) {
                    sb.append('0');
                } else if (b2 == 58) {
                    sb.append('1');
                } else if (b2 >= 97 && b2 <= 122) {
                    sb.append((char) ((b2 + 65) - 97));
                } else if (b2 >= 65 && b2 <= 90) {
                    sb.append((char) b2);
                } else if (b2 >= 48 && b2 <= 57) {
                    sb.append((char) b2);
                } else {
                    sb.append('2');
                }
            }
            if (i2 > 0) {
                sb.append(String.valueOf(i2));
            }
            t = sb.toString();
        }
        return t;
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(p.N());
        sb.append(a());
        sb.append(".");
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String z() {
        if (f == null) {
            f = a("ss");
        }
        return f;
    }

    public static String b() {
        if (g == null) {
            g = a("ct");
        }
        return g;
    }

    public static String c() {
        if (h == null) {
            h = a(RVParams.SHOW_TITLEBAR);
        }
        return h;
    }

    public static String d() {
        if (i == null) {
            i = a(RVParams.READ_TITLE);
        }
        return i;
    }

    public static String e() {
        if (l == null) {
            l = a("lgsuf");
        }
        return l;
    }

    public static String f() {
        if (j == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(p.N());
            sb.append("up");
            j = sb.toString();
        }
        return j;
    }

    public static String g() {
        if (k == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(p.N());
            sb.append("ver");
            k = sb.toString();
        }
        return k;
    }

    public static String h() {
        StringBuilder sb = new StringBuilder();
        sb.append(p.N());
        sb.append("bvu");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String i() {
        return com.uc.crashsdk.a.b.a(new File(z()), 8, false);
    }

    private static void A() {
        if (f7717o || n) {
            return;
        }
        synchronized (s) {
            if (f7717o) {
                return;
            }
            b(p.N());
            String i2 = i();
            File file = new File(b());
            p = com.alipay.mobile.rome.syncsdk.transport.connection.f.f7258a.equals(i2);
            q = "b".equals(i2);
            boolean exists = file.exists();
            r = exists;
            if (exists) {
                try {
                    file.delete();
                } catch (Exception e2) {
                    com.uc.crashsdk.a.a.a(e2, false);
                }
            }
            D();
            f7717o = true;
        }
    }

    public static boolean j() {
        A();
        return p;
    }

    public static boolean k() {
        A();
        return q;
    }

    private static boolean B() {
        A();
        return r;
    }

    public static boolean l() {
        return m;
    }

    public static void a(boolean z2) {
        boolean z3;
        if (m) {
            return;
        }
        b(p.N());
        if (z2) {
            n = true;
            p = false;
            q = false;
            r = false;
            String[] strArr = {".st", ".wa", ".callback", ".threads", ".ct", ".signal", ".ff", ".bb"};
            String[] strArr2 = {"up"};
            File[] listFiles = new File(p.N()).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String name = file.getName();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 8) {
                            z3 = false;
                            break;
                        } else if (name.endsWith(strArr[i2])) {
                            z3 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 > 0) {
                                z3 = false;
                                break;
                            } else if (name.equals(strArr2[0])) {
                                z3 = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (z3) {
                        StringBuilder sb = new StringBuilder("delete file: ");
                        sb.append(file.getPath());
                        com.uc.crashsdk.a.c.b(sb.toString());
                        com.uc.crashsdk.a.b.a(file);
                    }
                }
            }
        } else {
            m = true;
            C();
        }
        D();
    }

    private static void C() {
        if (d) {
            JNIBridge.nativeSyncStatus(HummerConstants.EXIT_H5_PAGE, null, m ? 1 : 0);
        }
    }

    private static void D() {
        Object[] F2 = F();
        if (F2[0].equals(y) || z != null) {
            e = true;
            E();
            return;
        }
        b(F2);
    }

    private static void E() {
        if (!com.uc.crashsdk.a.i.b(A)) {
            com.uc.crashsdk.a.i.a(1, A);
            return;
        }
        Object[] objArr = z;
        if (objArr == null || !F()[0].equals(objArr[0])) {
            com.uc.crashsdk.a.i.a(A);
            com.uc.crashsdk.a.i.a(1, A);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Object[] objArr) {
        z = objArr;
        synchronized (x) {
            String str = (String) objArr[0];
            long longValue = ((Long) objArr[1]).longValue();
            if (longValue < B) {
                com.uc.crashsdk.a.c.b("crashsdk", String.format("Update state generation %d, last is: %d", Long.valueOf(longValue), Long.valueOf(B)));
                return;
            }
            B = longValue;
            String z2 = z();
            if (d) {
                RandomAccessFile randomAccessFile = v;
                if (randomAccessFile != null) {
                    com.uc.crashsdk.a.b.a(randomAccessFile);
                    v = null;
                }
                boolean nativeChangeState = JNIBridge.nativeChangeState(z2, str, w);
                w = false;
                if (!nativeChangeState) {
                    StringBuilder sb = new StringBuilder("write state failed: ");
                    sb.append(str);
                    com.uc.crashsdk.a.c.c(sb.toString());
                }
            } else {
                RandomAccessFile randomAccessFile2 = v;
                if (randomAccessFile2 == null || w) {
                    if (randomAccessFile2 != null) {
                        com.uc.crashsdk.a.b.a(randomAccessFile2);
                        v = null;
                    }
                    try {
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(z2, "rw");
                        v = randomAccessFile3;
                        randomAccessFile3.seek(0L);
                        w = false;
                    } catch (Exception e2) {
                        com.uc.crashsdk.a.a.a(e2, false);
                    }
                }
                try {
                    v.write(str.getBytes());
                    v.seek(0L);
                } catch (Exception e3) {
                    com.uc.crashsdk.a.a.a(e3, false);
                }
            }
            y = str;
            z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object[] F() {
        synchronized (C) {
            long j2 = D + 1;
            D = j2;
            if (m) {
                return new Object[]{com.huawei.hms.push.e.PlaceComponentResult, Long.valueOf(j2)};
            } else if (E) {
                return new Object[]{com.alipay.mobile.rome.syncsdk.transport.connection.f.f7258a, Long.valueOf(j2)};
            } else {
                return new Object[]{"b", Long.valueOf(j2)};
            }
        }
    }

    public static boolean m() {
        return b(p.N());
    }

    public static boolean n() {
        return b(p.O());
    }

    private static boolean b(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (file.isDirectory()) {
            return true;
        }
        com.uc.crashsdk.a.c.a("crashsdk", "Crash log directory was placed by a file!!!");
        if (file.delete()) {
            file.mkdirs();
            return true;
        }
        return false;
    }

    public static void b(boolean z2) {
        if (z2 && m) {
            if (p.G()) {
                InstrumentInjector.log_v("crashsdk", "setForeground, reset sExited to false!!!");
            }
            m = false;
            C();
        }
        if (m) {
            return;
        }
        A();
        E = z2;
        if (d) {
            JNIBridge.nativeSetForeground(z2);
        }
        D();
        if (z2) {
            com.uc.crashsdk.a.a(false);
        }
        if (w) {
            return;
        }
        E();
    }

    public static boolean o() {
        return E;
    }

    public static void p() {
        F = true;
    }

    public static boolean q() {
        return F;
    }

    public static void r() {
        G = true;
    }

    public static boolean s() {
        return G;
    }

    public static boolean t() {
        if (G) {
            return true;
        }
        return !com.uc.crashsdk.a.h.a(com.uc.crashsdk.a.f7699a) && com.uc.crashsdk.a.f7699a.equals(f.d());
    }

    public static int u() {
        boolean B2 = B();
        return k() ? B2 ? 3 : 6 : j() ? B2 ? 2 : 5 : B2 ? 4 : 1;
    }

    public static void a(int i2) {
        u = i2;
        v();
    }

    public static void v() {
        if (d) {
            JNIBridge.nativeSyncStatus("logType", "12", u);
        }
    }

    public static boolean b(int i2) {
        return (i2 & u) != 0;
    }

    /* loaded from: classes8.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        protected String f7718a;

        public abstract boolean a();

        public a(String str) {
            this.f7718a = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0085, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0087, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x008b, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00a4, code lost:
    
        if (r0 == null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00a7, code lost:
    
        com.uc.crashsdk.a.a.a(r5, false);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.nio.channels.spi.AbstractInterruptibleChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.Object r4, java.lang.String r5, com.uc.crashsdk.b.a r6) {
        /*
            Method dump skipped, instructions count: 190
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.b.a(java.lang.Object, java.lang.String, com.uc.crashsdk.b$a):boolean");
    }
}
