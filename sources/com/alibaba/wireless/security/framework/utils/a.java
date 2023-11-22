package com.alibaba.wireless.security.framework.utils;

import android.os.Process;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f6800a = "SGFramework";
    private static String b = "SGTIME";
    private static boolean c;
    public static final byte[] MyBillsEntityDataFactory = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 193;

    public static String a() {
        if (c) {
            try {
                Object[] objArr = new Object[1];
                d(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[21], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                d(MyBillsEntityDataFactory[6], MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[8]), objArr2);
                Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
                try {
                    Object[] objArr3 = new Object[1];
                    d(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[21], objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    byte b2 = (byte) (-MyBillsEntityDataFactory[15]);
                    byte b3 = MyBillsEntityDataFactory[21];
                    Object[] objArr4 = new Object[1];
                    d(b2, b3, (byte) (b3 + 3), objArr4);
                    return ((StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null))[3].getMethodName();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        }
        return null;
    }

    public static void a(String str) {
    }

    public static void a(String str, String str2, String str3, long j) {
        if (c) {
            String str4 = b;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(Process.myPid());
            sb.append("][");
            sb.append(Process.myTid());
            sb.append("][");
            sb.append(str);
            sb.append("][JAVA][");
            sb.append(str2);
            sb.append("] cost = ");
            sb.append(System.currentTimeMillis() - j);
            sb.append(" ms [");
            sb.append(str3);
            sb.append("]");
            InstrumentInjector.log_e(str4, sb.toString());
        }
    }

    public static void a(String str, Throwable th) {
    }

    public static long b() {
        if (c) {
            return System.currentTimeMillis();
        }
        return 0L;
    }

    public static void b(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 12
            int r6 = 27 - r6
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r8 = 106 - r8
            byte[] r0 = com.alibaba.wireless.security.framework.utils.a.MyBillsEntityDataFactory
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1a:
            r3 = 0
        L1b:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
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
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.utils.a.d(short, short, int, java.lang.Object[]):void");
    }
}
