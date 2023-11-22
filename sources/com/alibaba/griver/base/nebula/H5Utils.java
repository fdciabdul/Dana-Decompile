package com.alibaba.griver.base.nebula;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class H5Utils {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {107, -40, -73, 40, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int MyBillsEntityDataFactory = 164;
    public static final String TAG = "H5Utils";

    private static void a(int i, byte b, int i2, Object[] objArr) {
        int i3 = (i2 * 5) + 18;
        int i4 = (i * 6) + 97;
        int i5 = (b * 22) + 4;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        byte[] bArr2 = new byte[i3];
        int i6 = -1;
        int i7 = i3 - 1;
        if (bArr == null) {
            i4 = (i4 + (-i5)) - 8;
            i5++;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i7;
            int i10 = i5;
            i4 = (i4 + (-bArr[i5])) - 8;
            i5 = i10 + 1;
            i7 = i9;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
        }
    }

    public static void handleTinyAppKeyEvent(String str, String str2) {
    }

    public static boolean isWebWorkerSupported() {
        return false;
    }

    public static boolean addChooseImageCrossOrigin(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(H5ResourceHandlerUtil.RESOURCE) && str.endsWith("image");
    }

    public static boolean containNebulaAddcors(String str) {
        return !TextUtils.isEmpty(str) && str.indexOf("nebula-addcors") > 0;
    }

    public static SharedPreferences getSharedPreference(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }

    public static int getUid(Context context) {
        try {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[41];
                byte b2 = b;
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                Object[] objArr2 = new Object[1];
                a(b3, b3, KClassImpl$Data$declaredNonStaticMembers$2[41], objArr2);
                if (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).uid != 0) {
                    try {
                        byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[41];
                        byte b5 = b4;
                        Object[] objArr3 = new Object[1];
                        a(b4, b5, (byte) (b5 + 1), objArr3);
                        Class<?> cls2 = Class.forName((String) objArr3[0]);
                        byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] - 1);
                        Object[] objArr4 = new Object[1];
                        a(b6, b6, KClassImpl$Data$declaredNonStaticMembers$2[41], objArr4);
                        return ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(context, null)).uid;
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 1).uid;
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } catch (PackageManager.NameNotFoundException e) {
            RVLogger.e(TAG, "exception detail", e);
            return 0;
        } catch (RuntimeException e2) {
            RVLogger.e(TAG, "exception detail", e2);
            return 0;
        }
    }

    public static String getApplicationDir() {
        Application applicationContext = GriverEnv.getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).applicationInfo.dataDir;
        } catch (Throwable th) {
            GriverLogger.e(TAG, "exception detail", th);
            return null;
        }
    }

    public static int parseInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th) {
            GriverLogger.e(TAG, "parse int exception.", th);
            return 0;
        }
    }
}
