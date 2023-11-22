package com.xiaomi.push;

import android.os.Looper;
import com.google.common.base.Ascii;

/* loaded from: classes8.dex */
public class u {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.EM, -104, -116, 103, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int getAuthRequestContext = 225;

    public static void BuiltInFictitiousFunctionClassFactory() {
        Thread thread = Looper.getMainLooper().getThread();
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            if (thread == cls.getMethod((String) objArr2[0], null).invoke(null, null)) {
                throw new RuntimeException("can't do this on ui thread");
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = com.xiaomi.push.u.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 * 12
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L30
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r6 = r6 + r3
            int r7 = r7 + 1
            int r6 = r6 + 2
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.u.a(byte, short, short, java.lang.Object[]):void");
    }
}
