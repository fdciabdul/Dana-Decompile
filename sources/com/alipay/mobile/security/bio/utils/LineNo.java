package com.alipay.mobile.security.bio.utils;

import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public class LineNo {
    public static final byte[] PlaceComponentResult = {Ascii.EM, -104, -116, 103, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int MyBillsEntityDataFactory = 134;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 * 12
            int r8 = 28 - r8
            byte[] r0 = com.alipay.mobile.security.bio.utils.LineNo.PlaceComponentResult
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + r8
            int r6 = r6 + 2
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.security.bio.utils.LineNo.a(short, byte, int, java.lang.Object[]):void");
    }

    public static int getLineNumber() {
        try {
            byte b = PlaceComponentResult[21];
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(PlaceComponentResult[8], PlaceComponentResult[15], (byte) (-PlaceComponentResult[6]), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                byte b3 = PlaceComponentResult[21];
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = (byte) (PlaceComponentResult[9] - 1);
                byte b6 = PlaceComponentResult[15];
                Object[] objArr4 = new Object[1];
                a(b5, b6, b6, objArr4);
                return ((StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null))[2].getLineNumber();
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

    public static String getFileName() {
        try {
            byte b = PlaceComponentResult[21];
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(PlaceComponentResult[8], PlaceComponentResult[15], (byte) (-PlaceComponentResult[6]), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                byte b3 = PlaceComponentResult[21];
                byte b4 = b3;
                Object[] objArr3 = new Object[1];
                a(b3, b4, b4, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = (byte) (PlaceComponentResult[9] - 1);
                byte b6 = PlaceComponentResult[15];
                Object[] objArr4 = new Object[1];
                a(b5, b6, b6, objArr4);
                return ((StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null))[2].getFileName();
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
}
