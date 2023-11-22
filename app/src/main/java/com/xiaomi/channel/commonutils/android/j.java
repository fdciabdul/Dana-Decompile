package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.xiaomi.push.z;

/* loaded from: classes8.dex */
public class j {
    private static Context BuiltInFictitiousFunctionClassFactory;
    public static final byte[] getAuthRequestContext = {18, -87, -121, -123, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int PlaceComponentResult = 139;

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        try {
            try {
                byte b = (byte) (PlaceComponentResult & 5);
                Object[] objArr = new Object[1];
                a(b, b, getAuthRequestContext[41], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = getAuthRequestContext[41];
                byte b3 = b2;
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
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return false;
        }
    }

    public static void MyBillsEntityDataFactory(Context context) {
        BuiltInFictitiousFunctionClassFactory = context.getApplicationContext();
    }

    public static boolean MyBillsEntityDataFactory() {
        return TextUtils.equals((String) z.PlaceComponentResult("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    public static int PlaceComponentResult() {
        try {
            Class<?> PlaceComponentResult2 = PlaceComponentResult(null, "miui.os.Build");
            if (PlaceComponentResult2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return PlaceComponentResult2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Class<?> PlaceComponentResult(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            try {
                return context.getClassLoader().loadClass(str);
            } catch (Throwable unused) {
            }
        }
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", th);
        }
    }

    private static void a(short s, short s2, byte b, Object[] objArr) {
        int i = 103 - (s * 6);
        byte[] bArr = getAuthRequestContext;
        int i2 = (b * 22) + 4;
        int i3 = (s2 * 5) + 18;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i = (i5 + (-i)) - 8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i2++;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i5;
            i = (i + (-bArr[i2])) - 8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i2++;
            i5 = i7;
        }
    }
}
