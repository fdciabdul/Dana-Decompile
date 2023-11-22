package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes7.dex */
public class BaseUtils {
    public static final byte[] MyBillsEntityDataFactory = {76, 9, -56, 93, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int BuiltInFictitiousFunctionClassFactory = 132;

    public static String BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        return i.BuiltInFictitiousFunctionClassFactory(context).BuiltInFictitiousFunctionClassFactory(str);
    }

    public static String[] BuiltInFictitiousFunctionClassFactory(Context context) {
        SharedPreferences sharedPreferences = i.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext;
        String string = sharedPreferences != null ? sharedPreferences.getString("subjectId", "") : "";
        return TextUtils.isEmpty(string) ? new String[0] : string.split(",");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        return i.BuiltInFictitiousFunctionClassFactory(context).KClassImpl$Data$declaredNonStaticMembers$2("_proxy_init");
    }

    public static void MyBillsEntityDataFactory(Context context, String str, String str2) {
        i.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext(str, str2);
    }

    public static void PlaceComponentResult(Context context) {
        i.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory("subjectId");
    }

    public static void PlaceComponentResult(Context context, String str) {
        i.BuiltInFictitiousFunctionClassFactory(context).MyBillsEntityDataFactory(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 5
            int r7 = 23 - r7
            byte[] r0 = com.huawei.hms.aaid.utils.BaseUtils.MyBillsEntityDataFactory
            int r8 = r8 * 22
            int r8 = 26 - r8
            int r6 = r6 * 6
            int r6 = 103 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1b:
            r3 = 0
        L1c:
            r5 = r8
            r8 = r6
            r6 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r6 = -r6
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-8)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.aaid.utils.BaseUtils.a(byte, short, short, java.lang.Object[]):void");
    }

    public static boolean getAuthRequestContext(Context context) {
        String authRequestContext = p.getAuthRequestContext(context);
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
            byte b2 = MyBillsEntityDataFactory[41];
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = MyBillsEntityDataFactory[41];
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 + 1), MyBillsEntityDataFactory[41], objArr2);
            String str = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).processName;
            StringBuilder sb = new StringBuilder();
            sb.append("main process name: ");
            sb.append(str);
            sb.append(", current process name: ");
            sb.append(authRequestContext);
            HMSLog.i("BaseUtils", sb.toString());
            return str.equals(authRequestContext);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public static String MyBillsEntityDataFactory(Context context, String str) {
        SharedPreferences sharedPreferences = i.BuiltInFictitiousFunctionClassFactory(context).getAuthRequestContext;
        return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
    }
}
