package com.alipay.alipaysecuritysdk.common.c;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class b {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {10, -99, -17, -84, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int MyBillsEntityDataFactory = 19;

    /* renamed from: a  reason: collision with root package name */
    public static a f6869a;

    /* loaded from: classes3.dex */
    public interface a {
        void print(String str, String str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 26
            int r8 = 30 - r8
            byte[] r0 = com.alipay.alipaysecuritysdk.common.c.b.KClassImpl$Data$declaredNonStaticMembers$2
            int r9 = r9 * 15
            int r9 = r9 + 12
            int r7 = r7 * 3
            int r7 = 106 - r7
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L19:
            r3 = 0
        L1a:
            r6 = r9
            r9 = r7
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r7) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L35:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + 2
            int r8 = r8 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.common.c.b.c(int, byte, short, java.lang.Object[]):void");
    }

    public static void a(String str, String str2) {
        a(1, str, str2, true);
    }

    public static void b(String str, String str2) {
        a(2, str, str2, false);
    }

    public static void a(String str, Throwable th) {
        a(2, str, th.getMessage(), false);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            StringBuilder sb = new StringBuilder("\t");
            sb.append(stackTraceElement.toString());
            a(2, str, sb.toString(), false);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        a(2, str, str2, false);
        a(2, str, th.getMessage(), true);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            StringBuilder sb = new StringBuilder("\t");
            sb.append(stackTraceElement.toString());
            a(2, str, sb.toString(), false);
        }
    }

    private static String a() {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        int length = stackTrace.length - 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (length <= 0) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[length - 1];
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
                byte b2 = (byte) (b + 1);
                Object[] objArr = new Object[1];
                c(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (MyBillsEntityDataFactory & 5);
                byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[16];
                Object[] objArr2 = new Object[1];
                c(b3, b4, b4, objArr2);
                if (((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null)).contains(b.class.getName())) {
                    sb.append("(");
                    sb.append(stackTrace[length].getFileName());
                    sb.append(":");
                    sb.append(stackTrace[length].getLineNumber());
                    sb.append(")");
                    sb.append(stackTrace[length].getMethodName());
                    break;
                }
                length--;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return sb.toString();
    }

    private static void a(int i, String str, String str2, boolean z) {
        if (str2 == null) {
            return;
        }
        a aVar = f6869a;
        if (aVar != null) {
            aVar.print(str, str2);
        }
        if (z) {
            for (String str3 : str2.split("\n")) {
                ArrayList<String> arrayList = new ArrayList();
                if (str3.length() < 10000) {
                    arrayList.add(str3);
                } else {
                    int i2 = 0;
                    while (i2 < str3.length()) {
                        int i3 = i2 + 10000;
                        if (i3 >= str3.length()) {
                            i3 = str3.length();
                        }
                        arrayList.add(str3.substring(i2, i3));
                        i2 = i3;
                    }
                }
                for (String str4 : arrayList) {
                    if (i == 0) {
                        InstrumentInjector.log_d(str, String.format("%-60s %s", a(), str4));
                    } else if (i == 1) {
                        InstrumentInjector.log_i(str, String.format("%-60s %s", a(), str4));
                    } else if (i != 2) {
                        InstrumentInjector.log_d(str, String.format("%-60s %s", a(), str4));
                    } else {
                        InstrumentInjector.log_e(str, String.format("%-60s %s", a(), str4));
                    }
                }
            }
        }
    }
}
