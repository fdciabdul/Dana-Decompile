package com.alipay.mobile.common.logging;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes3.dex */
public class SyncLogUtil {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int MyBillsEntityDataFactory = 95;
    private static boolean debuggable;

    private static void a(byte b, short s, int i, Object[] objArr) {
        int i2 = 23 - (s * 5);
        int i3 = (i * 6) + 97;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i4 = (b * 22) + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i4++;
            i3 = (i4 + (-i6)) - 8;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i4];
            i4++;
            i3 = (i3 + (-b2)) - 8;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    private SyncLogUtil() {
    }

    public static void init(Context context) {
        debuggable = isApkDebuggable(context);
    }

    private static boolean isApkDebuggable(Context context) {
        try {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[41];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (MyBillsEntityDataFactory & 1);
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

    public static boolean isDebuggable() {
        return debuggable;
    }
}
