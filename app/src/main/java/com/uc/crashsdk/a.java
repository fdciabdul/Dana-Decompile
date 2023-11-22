package com.uc.crashsdk;

import android.util.Log;
import android.util.SparseArray;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.google.common.base.Ascii;
import com.uc.crashsdk.export.LogType;
import java.io.File;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f7699a = "";
    public static String b = "";
    static final /* synthetic */ boolean j = true;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {TarHeader.LF_DIR, 93, -14, -126, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 162;
    private static Map<String, String> k = new HashMap();
    private static List<String> l = new ArrayList();
    public static int c = 10;
    public static int d = 8;
    public static int e = 6;
    public static int f = 2;
    public static int g = 6;
    public static int h = 8;
    public static int i = 2048;
    private static String m = "";
    private static String n = null;

    /* renamed from: o  reason: collision with root package name */
    private static HashMap<String, c> f7700o = new HashMap<>();
    private static List<String> p = new ArrayList();
    private static int q = 0;
    private static int r = 0;
    private static int s = 0;
    private static HashMap<String, b> t = new HashMap<>();
    private static List<String> u = new ArrayList();
    private static int v = 0;
    private static int w = 0;
    private static int x = 0;
    private static int y = 0;
    private static int z = 0;
    private static SparseArray<e> A = new SparseArray<>();
    private static List<Integer> B = new ArrayList();
    private static HashMap<String, C0154a> C = new HashMap<>();
    private static List<String> D = new ArrayList();
    private static int E = 0;
    private static int F = 0;
    private static Runnable G = new d(1);
    private static boolean H = false;
    private static boolean I = false;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void J(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = com.uc.crashsdk.a.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 + 99
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L18:
            r3 = 0
        L19:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.J(int, int, int, java.lang.Object[]):void");
    }

    public static byte[] c() {
        return new byte[]{Ascii.CAN, 99, 121, 60};
    }

    static /* synthetic */ void i() {
        com.uc.crashsdk.a.c.b("Begin update unexp info ...");
        long currentTimeMillis = System.currentTimeMillis();
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeUpdateUnexpInfo(p.C());
        }
        StringBuilder sb = new StringBuilder("Update unexp info took ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append(" ms");
        com.uc.crashsdk.a.c.b(sb.toString());
        a(false);
    }

    static /* synthetic */ void j() {
        String format = String.format("%s/%s/%s", p.K(), p.L(), p.M());
        m = g();
        if (com.uc.crashsdk.b.d) {
            JNIBridge.nativeSyncStatus("ver", m, 0);
        }
        com.uc.crashsdk.a.d.a(com.uc.crashsdk.b.g(), format);
        String str = m;
        if ((str == null || !str.equals(format)) && p.t()) {
            com.uc.crashsdk.a.c.b(String.format("Is new version ('%s' -> '%s'), deleting old stats data!", m, format));
            com.uc.crashsdk.b.a(true);
        }
    }

    public static String a() {
        String str = n;
        if (str != null) {
            return str;
        }
        try {
            String str2 = com.uc.crashsdk.e.a().getPackageManager().getPackageInfo(f7699a, 0).versionName;
            n = str2;
            return str2;
        } catch (Exception e2) {
            com.uc.crashsdk.a.a.a(e2, true);
            return "";
        }
    }

    public static void a(String str, String str2) {
        synchronized (k) {
            if (!k.containsKey(str)) {
                l.add(str);
            }
            k.put(str, str2);
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeAddHeaderInfo(str, str2);
            }
        }
    }

    public static void b() {
        if (!j && !com.uc.crashsdk.b.d) {
            throw new AssertionError();
        }
        synchronized (k) {
            for (String str : l) {
                JNIBridge.nativeAddHeaderInfo(str, k.get(str));
            }
        }
    }

    public static void a(OutputStream outputStream, String str) {
        synchronized (k) {
            for (String str2 : l) {
                try {
                    outputStream.write(str2.getBytes(str));
                    outputStream.write(": ".getBytes(str));
                    String str3 = k.get(str2);
                    if (str3 != null) {
                        outputStream.write(str3.getBytes(str));
                    }
                    outputStream.write("\n".getBytes(str));
                } catch (Throwable th) {
                    f.a(th, outputStream);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public int f7703a;
        public String b;
        public boolean c;
        public boolean d;
        public boolean e;

        public c(int i, String str, boolean z, boolean z2, boolean z3) {
            this.f7703a = i;
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = z3;
        }
    }

    public static int a(String str, String str2, boolean z2, boolean z3, int i2, boolean z4) {
        int i3;
        int i4;
        int i5;
        boolean z5 = false;
        if (str == null || str2 == null) {
            return 0;
        }
        synchronized (f7700o) {
            if (f7700o.containsKey(str)) {
                i4 = f7700o.get(str).f7703a;
                i3 = LogType.addType(i4, i2);
            } else {
                i3 = i2;
                i4 = 0;
            }
            if (LogType.isForJava(i3) && !LogType.isForJava(i4)) {
                int i6 = q;
                if (i6 >= c) {
                    i3 = LogType.removeType(i3, 16);
                } else {
                    q = i6 + 1;
                }
            }
            if (LogType.isForNative(i3) && !LogType.isForNative(i4)) {
                int i7 = r;
                if (i7 >= c) {
                    i3 = LogType.removeType(i3, 1);
                } else {
                    r = i7 + 1;
                }
            }
            if (LogType.isForUnexp(i3) && !LogType.isForUnexp(i4)) {
                int i8 = s;
                if (i8 >= c) {
                    i3 = LogType.removeType(i3, 256);
                } else {
                    s = i8 + 1;
                }
            }
            i5 = i3;
            if ((i5 & LZMA_Base.kMatchMaxLen) != 0) {
                if (i4 == 0) {
                    p.add(str);
                }
                z5 = true;
            }
            if (z5) {
                if (com.uc.crashsdk.b.d && (LogType.isForNative(i2) || LogType.isForUnexp(i2))) {
                    int nativeAddDumpFile = JNIBridge.nativeAddDumpFile(str, str2, z2, z3, LogType.isForNative(i2), LogType.isForUnexp(i2), z4);
                    if (!LogType.isForNative(nativeAddDumpFile)) {
                        i5 = LogType.removeType(i5, 1);
                    }
                    if (!LogType.isForUnexp(nativeAddDumpFile)) {
                        i5 = LogType.removeType(i5, 256);
                    }
                }
                f7700o.put(str, new c(i5, str2, z2, z3, z4));
            }
        }
        return i5;
    }

    public static void d() {
        if (!j && !com.uc.crashsdk.b.d) {
            throw new AssertionError();
        }
        synchronized (f7700o) {
            for (String str : p) {
                c cVar = f7700o.get(str);
                int i2 = cVar.f7703a;
                if (LogType.isForNative(i2) || LogType.isForUnexp(i2)) {
                    JNIBridge.nativeAddDumpFile(str, cVar.b, cVar.c, cVar.d, LogType.isForNative(i2), LogType.isForUnexp(i2), cVar.e);
                }
            }
        }
    }

    public static void a(OutputStream outputStream, String str, ArrayList<String> arrayList) {
        c cVar;
        boolean z2 = arrayList == null;
        synchronized (f7700o) {
            for (String str2 : p) {
                try {
                    cVar = f7700o.get(str2);
                } catch (Throwable th) {
                    f.a(th, outputStream);
                }
                if (arrayList == null) {
                    if (!LogType.isForJava(cVar.f7703a)) {
                    }
                } else if (!a(arrayList, str2)) {
                }
                if (cVar.d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append("\n");
                    outputStream.write(sb.toString().getBytes(str));
                }
                if (cVar.c) {
                    f.a(outputStream, cVar.b);
                } else {
                    f.b(outputStream, cVar.b);
                }
                if (cVar.e && z2) {
                    File file = new File(cVar.b);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }
    }

    private static boolean a(ArrayList<String> arrayList, String str) {
        if (com.uc.crashsdk.a.h.a(str)) {
            return false;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f7702a;
        public Callable<String> b;
        public long c;

        public b(int i, Callable<String> callable, long j) {
            this.f7702a = i;
            this.b = callable;
            this.c = j;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        if ((r9 - com.uc.crashsdk.a.y) >= r8) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0057 A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:7:0x0007, B:9:0x000f, B:14:0x0023, B:16:0x002c, B:18:0x0032, B:31:0x0057, B:23:0x0041, B:25:0x0045, B:29:0x0051, B:26:0x0049, B:32:0x005d, B:34:0x0063, B:36:0x0069, B:50:0x0097, B:52:0x009e, B:54:0x00a6, B:56:0x00ac, B:58:0x00b2, B:59:0x00b7, B:61:0x00bd, B:68:0x00cc, B:70:0x00d0, B:72:0x00d6, B:74:0x00dc, B:76:0x00ee, B:78:0x00f4, B:80:0x00fb, B:81:0x0100, B:83:0x0106, B:85:0x010c, B:87:0x0112, B:65:0x00c4, B:41:0x0078, B:43:0x007c, B:44:0x0086, B:47:0x008f), top: B:93:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0097 A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:7:0x0007, B:9:0x000f, B:14:0x0023, B:16:0x002c, B:18:0x0032, B:31:0x0057, B:23:0x0041, B:25:0x0045, B:29:0x0051, B:26:0x0049, B:32:0x005d, B:34:0x0063, B:36:0x0069, B:50:0x0097, B:52:0x009e, B:54:0x00a6, B:56:0x00ac, B:58:0x00b2, B:59:0x00b7, B:61:0x00bd, B:68:0x00cc, B:70:0x00d0, B:72:0x00d6, B:74:0x00dc, B:76:0x00ee, B:78:0x00f4, B:80:0x00fb, B:81:0x0100, B:83:0x0106, B:85:0x010c, B:87:0x0112, B:65:0x00c4, B:41:0x0078, B:43:0x007c, B:44:0x0086, B:47:0x008f), top: B:93:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cc A[Catch: all -> 0x011e, TryCatch #0 {, blocks: (B:7:0x0007, B:9:0x000f, B:14:0x0023, B:16:0x002c, B:18:0x0032, B:31:0x0057, B:23:0x0041, B:25:0x0045, B:29:0x0051, B:26:0x0049, B:32:0x005d, B:34:0x0063, B:36:0x0069, B:50:0x0097, B:52:0x009e, B:54:0x00a6, B:56:0x00ac, B:58:0x00b2, B:59:0x00b7, B:61:0x00bd, B:68:0x00cc, B:70:0x00d0, B:72:0x00d6, B:74:0x00dc, B:76:0x00ee, B:78:0x00f4, B:80:0x00fb, B:81:0x0100, B:83:0x0106, B:85:0x010c, B:87:0x0112, B:65:0x00c4, B:41:0x0078, B:43:0x007c, B:44:0x0086, B:47:0x008f), top: B:93:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.lang.String r10, int r11, java.util.concurrent.Callable<java.lang.String> r12, long r13) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.lang.String, int, java.util.concurrent.Callable, long):int");
    }

    public static void e() {
        if (!j && !com.uc.crashsdk.b.d) {
            throw new AssertionError();
        }
        synchronized (t) {
            for (String str : u) {
                b bVar = t.get(str);
                int i2 = bVar.f7702a;
                if (LogType.isForNative(i2) || LogType.isForUnexp(i2)) {
                    JNIBridge.nativeAddCallbackInfo(str, LogType.isForNative(i2), LogType.isForUnexp(i2), bVar.c);
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:7|(2:8|9)|(3:35|36|(4:39|40|41|17)(1:38))(3:11|12|(4:14|15|16|17)(1:18))|19|(1:21)(1:34)|(1:33)(1:25)|26|27|29|17|5) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        com.uc.crashsdk.f.a(r2, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.OutputStream r9, java.lang.String r10, java.lang.String r11, java.util.ArrayList<java.lang.String> r12) {
        /*
            java.util.HashMap<java.lang.String, com.uc.crashsdk.a$b> r0 = com.uc.crashsdk.a.t
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.u     // Catch: java.lang.Throwable -> L96
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L96
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L96
            if (r2 == 0) goto L94
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L96
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L96
            java.util.HashMap<java.lang.String, com.uc.crashsdk.a$b> r3 = com.uc.crashsdk.a.t     // Catch: java.lang.Throwable -> L78
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L78
            com.uc.crashsdk.a$b r3 = (com.uc.crashsdk.a.b) r3     // Catch: java.lang.Throwable -> L78
            int r4 = r3.f7702a     // Catch: java.lang.Throwable -> L78
            if (r12 != 0) goto L28
            boolean r4 = com.uc.crashsdk.export.LogType.isForJava(r4)     // Catch: java.lang.Throwable -> L78
            if (r4 != 0) goto L2f
            goto L9
        L28:
            boolean r4 = a(r12, r2)     // Catch: java.lang.Throwable -> L78
            if (r4 != 0) goto L2f
            goto L9
        L2f:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r4.<init>()     // Catch: java.lang.Throwable -> L78
            r4.append(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.String r5 = "\n"
            r4.append(r5)     // Catch: java.lang.Throwable -> L78
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L78
            byte[] r4 = r4.getBytes(r10)     // Catch: java.lang.Throwable -> L78
            r9.write(r4)     // Catch: java.lang.Throwable -> L78
            long r4 = r3.c     // Catch: java.lang.Throwable -> L78
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L56
            long r3 = r3.c     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = com.uc.crashsdk.JNIBridge.nativeGetCallbackInfo(r2, r3)     // Catch: java.lang.Throwable -> L78
            goto L5e
        L56:
            java.lang.StringBuilder r2 = c(r2)     // Catch: java.lang.Throwable -> L78
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L78
        L5e:
            if (r2 == 0) goto L6e
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L78
            if (r3 <= 0) goto L6e
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L78
            r9.write(r2)     // Catch: java.lang.Throwable -> L78
            goto L7c
        L6e:
            java.lang.String r2 = "(data is null)\n"
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L78
            r9.write(r2)     // Catch: java.lang.Throwable -> L78
            goto L7c
        L78:
            r2 = move-exception
            com.uc.crashsdk.f.a(r2, r9)     // Catch: java.lang.Throwable -> L96
        L7c:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r10)     // Catch: java.lang.Throwable -> L8e
            r9.write(r2)     // Catch: java.lang.Throwable -> L8e
            byte[] r2 = r11.getBytes(r10)     // Catch: java.lang.Throwable -> L8e
            r9.write(r2)     // Catch: java.lang.Throwable -> L8e
            goto L9
        L8e:
            r2 = move-exception
            com.uc.crashsdk.f.a(r2, r9)     // Catch: java.lang.Throwable -> L96
            goto L9
        L94:
            monitor-exit(r0)
            return
        L96:
            r9 = move-exception
            monitor-exit(r0)
            goto L9a
        L99:
            throw r9
        L9a:
            goto L99
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    public static String a(String str) {
        String obj;
        synchronized (t) {
            obj = c(str).toString();
        }
        return obj;
    }

    private static StringBuilder c(String str) {
        String a2;
        StringBuilder sb = new StringBuilder();
        try {
            b bVar = t.get(str);
            try {
                if (bVar == null) {
                    StringBuilder sb2 = new StringBuilder("Unknown callback: ");
                    sb2.append(str);
                    a2 = sb2.toString();
                } else if (bVar.b != null) {
                    a2 = bVar.b.call();
                } else {
                    a2 = com.uc.crashsdk.d.a(str);
                }
                if (a2 != null) {
                    sb.append(a2);
                }
            } catch (Throwable th) {
                sb.append("[DEBUG] Callback occurred new exception:\n");
                sb.append(Log.getStackTraceString(th));
            }
        } catch (Throwable th2) {
            com.uc.crashsdk.a.a.a(th2, false);
        }
        try {
            if (sb.length() == 0) {
                sb.append("(data is null)\n");
            }
        } catch (Throwable th3) {
            com.uc.crashsdk.a.a.a(th3, false);
        }
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<Thread> f7707a;
        public String b;

        public e(Thread thread, String str) {
            this.f7707a = new WeakReference<>(thread);
            this.b = str;
        }
    }

    private static boolean a(String str, Thread thread) {
        if (thread == null) {
            return false;
        }
        synchronized (A) {
            int id2 = (int) thread.getId();
            if (A.get(id2) == null) {
                B.add(Integer.valueOf(id2));
            }
            A.put(id2, new e(thread, str));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014a A[Catch: all -> 0x018a, TryCatch #6 {all -> 0x018a, blocks: (B:38:0x0147, B:40:0x014a, B:41:0x0153, B:43:0x0158, B:45:0x015c, B:46:0x0165, B:51:0x0182, B:53:0x0188, B:54:0x0189), top: B:90:0x0147, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0158 A[Catch: all -> 0x018a, TryCatch #6 {all -> 0x018a, blocks: (B:38:0x0147, B:40:0x014a, B:41:0x0153, B:43:0x0158, B:45:0x015c, B:46:0x0165, B:51:0x0182, B:53:0x0188, B:54:0x0189), top: B:90:0x0147, outer: #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.io.OutputStream r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(java.io.OutputStream, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uc.crashsdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C0154a {

        /* renamed from: a  reason: collision with root package name */
        int f7701a;
        int b;
        List<String> c = new ArrayList();

        public C0154a(int i, int i2) {
            this.f7701a = i;
            this.b = i2;
        }
    }

    public static int a(String str, int i2, int i3) {
        int i4;
        int i5;
        boolean z2 = false;
        if (str == null || i2 <= 0) {
            return 0;
        }
        synchronized (C) {
            if (C.containsKey(str)) {
                i5 = C.get(str).b;
                i4 = LogType.addType(i5, i3);
            } else {
                i4 = i3;
                i5 = 0;
            }
            if (LogType.isForJava(i4) && !LogType.isForJava(i5)) {
                int i6 = E;
                if (i6 >= h) {
                    i4 = LogType.removeType(i4, 16);
                } else {
                    E = i6 + 1;
                }
            }
            if (LogType.isForNative(i4) && !LogType.isForNative(i5)) {
                int i7 = F;
                if (i7 >= h) {
                    i4 = LogType.removeType(i4, 1);
                } else {
                    F = i7 + 1;
                }
            }
            if ((i4 & LZMA_Base.kMatchMaxLen) != 0) {
                if (i5 == 0) {
                    D.add(str);
                }
                z2 = true;
            }
            if (z2) {
                if (com.uc.crashsdk.b.d && LogType.isForNative(i3) && !JNIBridge.nativeCreateCachedInfo(str, i2)) {
                    i4 = LogType.removeType(i4, 1);
                }
                C.put(str, new C0154a(i2, i4));
            }
        }
        return i4;
    }

    public static int b(String str, String str2) {
        int i2 = 0;
        if (str == null || str2 == null) {
            return 0;
        }
        int length = str2.length();
        int i3 = i;
        if (length > i3) {
            str2 = str2.substring(0, i3);
        }
        synchronized (C) {
            C0154a c0154a = C.get(str);
            if (c0154a != null) {
                if (c0154a.c.size() >= c0154a.f7701a) {
                    c0154a.c.remove(0);
                }
                c0154a.c.add(str2);
                i2 = LogType.addType(0, 16);
                if (!com.uc.crashsdk.b.d && LogType.isForNative(c0154a.b)) {
                    i2 = LogType.addType(i2, 1);
                }
            }
            if (com.uc.crashsdk.b.d && JNIBridge.nativeAddCachedInfo(str, str2)) {
                i2 = LogType.addType(i2, 1);
            }
        }
        return i2;
    }

    public static void f() {
        if (!j && !com.uc.crashsdk.b.d) {
            throw new AssertionError();
        }
        synchronized (C) {
            for (String str : D) {
                C0154a c0154a = C.get(str);
                if (LogType.isForNative(c0154a.b) && JNIBridge.nativeCreateCachedInfo(str, c0154a.f7701a)) {
                    Iterator<String> it = c0154a.c.iterator();
                    while (it.hasNext() && JNIBridge.nativeAddCachedInfo(str, it.next())) {
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(3:34|35|(4:37|38|39|23))(3:9|10|(2:33|23))|12|13|14|15|(2:18|16)|19|20|22|23|5) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        com.uc.crashsdk.f.a(r2, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0081, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0082, code lost:
    
        com.uc.crashsdk.f.a(r2, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
    
        com.uc.crashsdk.f.a(r2, r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(java.io.OutputStream r7, java.lang.String r8, java.lang.String r9, java.util.ArrayList<java.lang.String> r10) {
        /*
            java.util.HashMap<java.lang.String, com.uc.crashsdk.a$a> r0 = com.uc.crashsdk.a.C
            monitor-enter(r0)
            java.util.List<java.lang.String> r1 = com.uc.crashsdk.a.D     // Catch: java.lang.Throwable -> L9f
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L9f
        L9:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L9f
            if (r2 == 0) goto L9d
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L9f
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L9f
            java.util.HashMap<java.lang.String, com.uc.crashsdk.a$a> r3 = com.uc.crashsdk.a.C     // Catch: java.lang.Throwable -> L9f
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Throwable -> L9f
            com.uc.crashsdk.a$a r3 = (com.uc.crashsdk.a.C0154a) r3     // Catch: java.lang.Throwable -> L9f
            int r4 = r3.b     // Catch: java.lang.Throwable -> L9f
            if (r10 != 0) goto L28
            boolean r4 = com.uc.crashsdk.export.LogType.isForJava(r4)     // Catch: java.lang.Throwable -> L9f
            if (r4 != 0) goto L2e
            goto L9
        L28:
            boolean r4 = a(r10, r2)     // Catch: java.lang.Throwable -> L9f
            if (r4 == 0) goto L9
        L2e:
            java.util.Locale r4 = java.util.Locale.US     // Catch: java.lang.Throwable -> L5a
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L5a
            r6 = 0
            r5[r6] = r2     // Catch: java.lang.Throwable -> L5a
            r2 = 1
            java.util.List<java.lang.String> r6 = r3.c     // Catch: java.lang.Throwable -> L5a
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L5a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L5a
            r5[r2] = r6     // Catch: java.lang.Throwable -> L5a
            r2 = 2
            int r6 = r3.f7701a     // Catch: java.lang.Throwable -> L5a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L5a
            r5[r2] = r6     // Catch: java.lang.Throwable -> L5a
            java.lang.String r2 = "%s (%d/%d)\n"
            java.lang.String r2 = java.lang.String.format(r4, r2, r5)     // Catch: java.lang.Throwable -> L5a
            byte[] r2 = r2.getBytes(r8)     // Catch: java.lang.Throwable -> L5a
            r7.write(r2)     // Catch: java.lang.Throwable -> L5a
            goto L5e
        L5a:
            r2 = move-exception
            com.uc.crashsdk.f.a(r2, r7)     // Catch: java.lang.Throwable -> L9f
        L5e:
            java.util.List<java.lang.String> r2 = r3.c     // Catch: java.lang.Throwable -> L81
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L81
        L64:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L81
            if (r3 == 0) goto L85
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L81
            byte[] r3 = r3.getBytes(r8)     // Catch: java.lang.Throwable -> L81
            r7.write(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = "\n"
            byte[] r3 = r3.getBytes(r8)     // Catch: java.lang.Throwable -> L81
            r7.write(r3)     // Catch: java.lang.Throwable -> L81
            goto L64
        L81:
            r2 = move-exception
            com.uc.crashsdk.f.a(r2, r7)     // Catch: java.lang.Throwable -> L9f
        L85:
            java.lang.String r2 = "\n"
            byte[] r2 = r2.getBytes(r8)     // Catch: java.lang.Throwable -> L97
            r7.write(r2)     // Catch: java.lang.Throwable -> L97
            byte[] r2 = r9.getBytes(r8)     // Catch: java.lang.Throwable -> L97
            r7.write(r2)     // Catch: java.lang.Throwable -> L97
            goto L9
        L97:
            r2 = move-exception
            com.uc.crashsdk.f.a(r2, r7)     // Catch: java.lang.Throwable -> L9f
            goto L9
        L9d:
            monitor-exit(r0)
            return
        L9f:
            r7 = move-exception
            monitor-exit(r0)
            goto La3
        La2:
            throw r7
        La3:
            goto La2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b(java.io.OutputStream, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(int r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.a(int, java.lang.String):int");
    }

    public static boolean a(boolean z2) {
        int C2;
        if (!com.uc.crashsdk.b.c || !com.uc.crashsdk.b.q()) {
            com.uc.crashsdk.a.c.b("Unexp log or unexp stats not enabled, skip update unexp info!");
            return false;
        }
        if (z2) {
            com.uc.crashsdk.a.i.a(G);
            C2 = 0;
        } else if (!com.uc.crashsdk.b.o()) {
            com.uc.crashsdk.a.c.b("Stop update unexp info in background!");
            return false;
        } else if (p.C() <= 0) {
            return false;
        } else {
            if (com.uc.crashsdk.a.i.b(G)) {
                return true;
            }
            C2 = p.C() * 1000;
        }
        com.uc.crashsdk.a.i.a(0, G, C2);
        return true;
    }

    public static ArrayList<String> b(String str) {
        if (com.uc.crashsdk.a.h.a(str)) {
            return null;
        }
        String[] split = str.split(";");
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : split) {
            if (!com.uc.crashsdk.a.h.a(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public static String g() {
        if (!H) {
            String a2 = com.uc.crashsdk.a.d.a(com.uc.crashsdk.b.g());
            m = a2;
            H = true;
            if (a2 == null) {
                m = "";
            }
        }
        return m;
    }

    public static void h() {
        if (I) {
            if (com.uc.crashsdk.b.d) {
                JNIBridge.nativeSyncStatus("ver", m, 0);
                return;
            }
            return;
        }
        I = true;
        com.uc.crashsdk.a.i.a(0, new d(2));
    }

    /* loaded from: classes8.dex */
    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f7705a = true;
        private int b;

        d(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i = this.b;
            if (i == 1) {
                a.i();
            } else if (i == 2) {
                a.j();
            } else if (!f7705a) {
                throw new AssertionError();
            }
        }
    }
}
