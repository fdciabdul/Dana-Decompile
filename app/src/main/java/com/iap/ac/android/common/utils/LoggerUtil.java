package com.iap.ac.android.common.utils;

import android.util.Log;
import android.util.Pair;
import com.google.common.base.Ascii;

/* loaded from: classes8.dex */
public class LoggerUtil {
    public static final byte[] MyBillsEntityDataFactory = {1, -107, Ascii.ESC, -41, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
    public static final int getAuthRequestContext = 224;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 68 - r7
            int r8 = 27 - r8
            int r6 = 106 - r6
            byte[] r0 = com.iap.ac.android.common.utils.LoggerUtil.MyBillsEntityDataFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L16:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.common.utils.LoggerUtil.a(byte, int, byte, java.lang.Object[]):void");
    }

    public static Pair<String, String> backTrackInvoker() {
        return backTrackInvoker(2);
    }

    public static String stackTraceToString(String str) {
        try {
            Object[] objArr = new Object[1];
            a(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[3]), MyBillsEntityDataFactory[34], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(MyBillsEntityDataFactory[8], 65, (byte) (MyBillsEntityDataFactory[17] + 1), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                a(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[3]), MyBillsEntityDataFactory[34], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a((byte) (MyBillsEntityDataFactory[9] - 1), (byte) (-MyBillsEntityDataFactory[31]), (byte) (MyBillsEntityDataFactory[17] + 1), objArr4);
                Object[] objArr5 = (Object[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null);
                if (objArr5 == null) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("-StackTrace:");
                for (Object obj : objArr5) {
                    sb.append("###");
                    sb.append("\tat ");
                    sb.append(obj);
                }
                sb.append("###");
                return sb.toString();
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

    public static String throwableToString(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static Pair<String, String> backTrackInvoker(int i) {
        try {
            Object[] objArr = new Object[1];
            a(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[3]), MyBillsEntityDataFactory[34], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(MyBillsEntityDataFactory[8], 65, (byte) (MyBillsEntityDataFactory[17] + 1), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                a(MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[3]), MyBillsEntityDataFactory[34], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a((byte) (MyBillsEntityDataFactory[9] - 1), (byte) (-MyBillsEntityDataFactory[31]), (byte) (MyBillsEntityDataFactory[17] + 1), objArr4);
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null);
                if (stackTraceElementArr == null) {
                    return Pair.create("", "");
                }
                if (i <= 0) {
                    i = 1;
                }
                int i2 = i + 3;
                if (i2 >= stackTraceElementArr.length) {
                    i2 = stackTraceElementArr.length - 1;
                }
                StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                if (stackTraceElement == null) {
                    return Pair.create("", "");
                }
                try {
                    byte b = MyBillsEntityDataFactory[21];
                    Object[] objArr5 = new Object[1];
                    a(b, (byte) (b | Ascii.SUB), MyBillsEntityDataFactory[21], objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a((byte) (MyBillsEntityDataFactory[9] - 1), MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[7]), objArr6);
                    return Pair.create(cls3.getMethod((String) objArr6[0], null).invoke(stackTraceElement, null), stackTraceElement.getMethodName());
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
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th3;
        }
    }
}
