package com.iap.ac.android.acs.operation.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class DeviceUtils {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {75, 108, -123, 87, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int getAuthRequestContext = 17;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 5
            int r7 = 23 - r7
            int r9 = r9 * 6
            int r9 = r9 + 97
            int r8 = r8 * 22
            int r8 = 26 - r8
            byte[] r0 = com.iap.ac.android.acs.operation.utils.DeviceUtils.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r10 = r10 + r7
            int r7 = r9 + 1
            int r9 = r10 + (-8)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.operation.utils.DeviceUtils.a(byte, int, int, java.lang.Object[]):void");
    }

    public static boolean isApkInDebug(Context context) {
        try {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[41];
                Object[] objArr = new Object[1];
                a(b, (byte) (b + 1), KClassImpl$Data$declaredNonStaticMembers$2[41], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (getAuthRequestContext & 7);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[41];
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr2);
                return (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).flags & 2) != 0;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
