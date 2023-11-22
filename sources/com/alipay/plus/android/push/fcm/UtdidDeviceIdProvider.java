package com.alipay.plus.android.push.fcm;

/* loaded from: classes3.dex */
public class UtdidDeviceIdProvider {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {88, 72, 91, 85, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 175;
    private static final String TAG = "UtdidDeviceIdProvider";

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[Catch: Exception -> 0x0062, TryCatch #0 {Exception -> 0x0062, blocks: (B:5:0x0005, B:7:0x000d, B:11:0x002c, B:13:0x0033, B:15:0x0046, B:16:0x0053), top: B:21:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #0 {Exception -> 0x0062, blocks: (B:5:0x0005, B:7:0x000d, B:11:0x002c, B:13:0x0033, B:15:0x0046, B:16:0x0053), top: B:21:0x0005 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0055 -> B:18:0x0058). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDeviceId(android.app.Application r14) {
        /*
            java.lang.String r0 = " "
            if (r14 != 0) goto L5
            return r0
        L5:
            java.lang.String r1 = "com.ut.device.UTDevice"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L62
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L62
            r4 = 97
            byte[] r5 = com.alipay.plus.android.push.fcm.UtdidDeviceIdProvider.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L62
            r6 = 23
            byte[] r6 = new byte[r6]     // Catch: java.lang.Exception -> L62
            r7 = 22
            r8 = 4
            r9 = 0
            r4 = r3
            if (r5 != 0) goto L26
            r10 = r6
            r11 = 22
            r12 = 0
            r6 = r5
            r5 = 4
            goto L58
        L26:
            r8 = r6
            r10 = 4
            r11 = 0
            r6 = r5
            r5 = 97
        L2c:
            byte r12 = (byte) r5     // Catch: java.lang.Exception -> L62
            r8[r11] = r12     // Catch: java.lang.Exception -> L62
            int r12 = r11 + 1
            if (r11 != r7) goto L53
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L62
            r5.<init>(r8, r9)     // Catch: java.lang.Exception -> L62
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L62
            r3[r9] = r5     // Catch: java.lang.Exception -> L62
            java.lang.String r3 = "getUtdid"
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r4)     // Catch: java.lang.Exception -> L62
            if (r1 == 0) goto L62
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L62
            r2[r9] = r14     // Catch: java.lang.Exception -> L62
            r14 = 0
            java.lang.Object r14 = r1.invoke(r14, r2)     // Catch: java.lang.Exception -> L62
            java.lang.String r14 = (java.lang.String) r14     // Catch: java.lang.Exception -> L62
            r0 = r14
            goto L62
        L53:
            r11 = r6[r10]     // Catch: java.lang.Exception -> L62
            r13 = r10
            r10 = r8
            r8 = r13
        L58:
            int r11 = -r11
            int r8 = r8 + r2
            int r5 = r5 + r11
            int r5 = r5 + (-8)
            r11 = r12
            r13 = r10
            r10 = r8
            r8 = r13
            goto L2c
        L62:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.plus.android.push.fcm.UtdidDeviceIdProvider.getDeviceId(android.app.Application):java.lang.String");
    }
}
