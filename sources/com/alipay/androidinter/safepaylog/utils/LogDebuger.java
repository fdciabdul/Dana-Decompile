package com.alipay.androidinter.safepaylog.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes6.dex */
public class LogDebuger {
    private static boolean DEBUG;
    public static final byte[] getAuthRequestContext = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int PlaceComponentResult = 194;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 22
            int r7 = 25 - r7
            int r8 = r8 * 5
            int r8 = r8 + 18
            byte[] r0 = com.alipay.androidinter.safepaylog.utils.LogDebuger.getAuthRequestContext
            int r6 = r6 * 6
            int r6 = 103 - r6
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r7 = r7 + 1
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L39:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.androidinter.safepaylog.utils.LogDebuger.a(short, int, int, java.lang.Object[]):void");
    }

    public static void initialize(Context context) {
        if (context == null) {
            return;
        }
        DEBUG = isDebug(context);
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    private static boolean isDebug(Context context) {
        try {
            try {
                byte b = (byte) (getAuthRequestContext[5] - 1);
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = getAuthRequestContext[41];
                byte b4 = b3;
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                return (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).flags & 2) != 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Exception unused) {
            return false;
        }
    }
}
