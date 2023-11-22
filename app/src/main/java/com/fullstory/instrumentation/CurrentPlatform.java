package com.fullstory.instrumentation;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public class CurrentPlatform {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {77, -56, -115, -110, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int PlaceComponentResult = 3;
    public static final int SDK_INT_FIXED;
    public static int TARGET_SDK = -1;
    public static final int UNSET = -1;

    static {
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT >= 23 && Build.VERSION.PREVIEW_SDK_INT > 0) {
            i++;
        }
        SDK_INT_FIXED = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 22
            int r7 = 26 - r7
            int r8 = r8 * 6
            int r8 = r8 + 97
            byte[] r0 = com.fullstory.instrumentation.CurrentPlatform.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 * 5
            int r6 = r6 + 18
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
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
            int r7 = r8 + 1
            int r8 = r9 + (-8)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fullstory.instrumentation.CurrentPlatform.a(short, byte, short, java.lang.Object[]):void");
    }

    public static void init(Context context) {
        if (TARGET_SDK != -1) {
            return;
        }
        try {
            try {
                byte b = (byte) (PlaceComponentResult - 2);
                Object[] objArr = new Object[1];
                a(b, b, BuiltInFictitiousFunctionClassFactory[41], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = BuiltInFictitiousFunctionClassFactory[41];
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr2);
                TARGET_SDK = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).targetSdkVersion;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        } catch (Throwable unused) {
        }
    }
}
