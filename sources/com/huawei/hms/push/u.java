package com.huawei.hms.push;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes8.dex */
public class u {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {105, 42, 72, -81, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 21;

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        if (new PushPreferences(context, "push_notify_flag").KClassImpl$Data$declaredNonStaticMembers$2("notify_msg_enable")) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            return getAuthRequestContext(context);
        }
        if (i >= 19) {
            return getAuthRequestContext(context);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 6
            int r7 = 103 - r7
            byte[] r0 = com.huawei.hms.push.u.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 4
            int r8 = r8 * 5
            int r8 = 23 - r8
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
            byte r4 = (byte) r7
            int r6 = r6 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L33:
            int r7 = r7 + r8
            int r7 = r7 + (-8)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.push.u.a(byte, int, int, java.lang.Object[]):void");
    }

    private static boolean getAuthRequestContext(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[41] - 1);
            Object[] objArr = new Object[1];
            a(b, (byte) (-b), BuiltInFictitiousFunctionClassFactory[41], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) KClassImpl$Data$declaredNonStaticMembers$2;
            byte b3 = BuiltInFictitiousFunctionClassFactory[41];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 + 1), objArr2);
            ApplicationInfo applicationInfo = (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null);
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls2 = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls2.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls2.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
                return true;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
