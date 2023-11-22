package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class PackageManagerCompat {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {108, -22, 67, 3, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int MyBillsEntityDataFactory = 34;
    private static String PlaceComponentResult = "";

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 * 6
            int r6 = 103 - r6
            int r8 = r8 * 5
            int r8 = 23 - r8
            byte[] r0 = com.huawei.hms.framework.common.PackageManagerCompat.BuiltInFictitiousFunctionClassFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L33
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r6 = r6 + r8
            int r6 = r6 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.PackageManagerCompat.a(byte, int, byte, java.lang.Object[]):void");
    }

    public static String getAppPackageName(Context context) {
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 16384).packageName;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w("PackageUtils", "Failed to get Package managers Package Info");
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (!TextUtils.isEmpty(PlaceComponentResult)) {
            return PlaceComponentResult;
        }
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return PlaceComponentResult;
        }
        try {
            PlaceComponentResult = String.valueOf(packageManager.getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            Logger.w("PackageUtils", "Failed to get Package managers Package Info");
        }
        return PlaceComponentResult;
    }

    private static Bundle MyBillsEntityDataFactory(Context context) {
        PackageManager packageManager;
        Bundle bundle = Bundle.EMPTY;
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return bundle;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
            return (applicationInfo == null || applicationInfo.metaData == null) ? bundle : applicationInfo.metaData;
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Logger.w("PackageUtils", "NameNotFoundException:", e);
            return bundle;
        }
    }

    public static String getMetaDataFromApp(Context context, String str, String str2) {
        Bundle MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(context);
        return MyBillsEntityDataFactory2 != null ? MyBillsEntityDataFactory2.getString(str, str2) : str2;
    }

    private static Bundle PlaceComponentResult(Context context) {
        if (ContextHolder.getKitContext() != null) {
            context = ContextHolder.getKitContext();
        }
        if (context == null) {
            Logger.v("PackageUtils", "the kitContext is null");
            return Bundle.EMPTY;
        }
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[8] - 1);
            Object[] objArr = new Object[1];
            a(b, (byte) (-b), BuiltInFictitiousFunctionClassFactory[41], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = BuiltInFictitiousFunctionClassFactory[41];
            byte b3 = BuiltInFictitiousFunctionClassFactory[4];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 & 3), objArr2);
            if (cls.getMethod((String) objArr2[0], null).invoke(context, null) == null) {
                Logger.v("PackageUtils", "the kit applicationInfo is null");
                return Bundle.EMPTY;
            }
            try {
                byte b4 = (byte) (BuiltInFictitiousFunctionClassFactory[8] - 1);
                Object[] objArr3 = new Object[1];
                a(b4, (byte) (-b4), BuiltInFictitiousFunctionClassFactory[41], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b5 = BuiltInFictitiousFunctionClassFactory[41];
                byte b6 = BuiltInFictitiousFunctionClassFactory[4];
                Object[] objArr4 = new Object[1];
                a(b5, b6, (byte) (b6 & 3), objArr4);
                Bundle bundle = ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(context, null)).metaData;
                return bundle == null ? Bundle.EMPTY : bundle;
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

    public static String getMetaDataFromKit(Context context, String str, String str2) {
        try {
            Bundle PlaceComponentResult2 = PlaceComponentResult(context);
            return PlaceComponentResult2 == null ? str2 : PlaceComponentResult2.getString(str, str2);
        } catch (RuntimeException unused) {
            Logger.v("PackageUtils", "the kit metaData is runtimeException");
            return str2;
        }
    }

    public static Map<String, String> getMetaDataMapFromKitOrApp(Context context, String str) {
        HashMap hashMap = new HashMap();
        Bundle PlaceComponentResult2 = PlaceComponentResult(context);
        if (PlaceComponentResult2 == null || PlaceComponentResult2.isEmpty()) {
            PlaceComponentResult2 = MyBillsEntityDataFactory(context);
        }
        Bundle PlaceComponentResult3 = PlaceComponentResult(context);
        if (PlaceComponentResult3 == null || PlaceComponentResult3.isEmpty()) {
            PlaceComponentResult3 = MyBillsEntityDataFactory(context);
        }
        for (String str2 : PlaceComponentResult3.keySet()) {
            if (str2.startsWith(str)) {
                String string = PlaceComponentResult2.getString(str2);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str2.substring(str.length()), string);
                }
            }
        }
        return hashMap;
    }

    public static String getMetaDataFromKitOrApp(Context context, String str, String str2) {
        Bundle PlaceComponentResult2 = PlaceComponentResult(context);
        if (PlaceComponentResult2 == null || PlaceComponentResult2.isEmpty()) {
            PlaceComponentResult2 = MyBillsEntityDataFactory(context);
        }
        return PlaceComponentResult2.getString(str, str2);
    }
}
