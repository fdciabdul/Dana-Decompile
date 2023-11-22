package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

@Deprecated
/* loaded from: classes7.dex */
public class StatsUtils {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {0, Byte.MIN_VALUE, -111, -10, 6, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 7;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 15
            int r7 = 20 - r7
            int r8 = r8 + 105
            int r9 = r9 * 4
            int r9 = 16 - r9
            byte[] r0 = com.google.android.gms.common.stats.StatsUtils.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L38
        L1a:
            r3 = 0
        L1b:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L38:
            int r9 = -r9
            int r7 = r7 + 1
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.stats.StatsUtils.a(int, byte, byte, java.lang.Object[]):void");
    }

    public static String getEventKey(PowerManager.WakeLock wakeLock, String str) {
        long myPid = Process.myPid();
        try {
            Object[] objArr = {wakeLock};
            Object[] objArr2 = new Object[1];
            a(BuiltInFictitiousFunctionClassFactory[0], BuiltInFictitiousFunctionClassFactory[6], BuiltInFictitiousFunctionClassFactory[0], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b = BuiltInFictitiousFunctionClassFactory[6];
            byte b2 = BuiltInFictitiousFunctionClassFactory[0];
            Object[] objArr3 = new Object[1];
            a(b, b2, b2, objArr3);
            long intValue = ((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue();
            if (true == TextUtils.isEmpty(str)) {
                str = "";
            }
            return String.valueOf(String.valueOf((myPid << 32) | intValue)).concat(String.valueOf(str));
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
