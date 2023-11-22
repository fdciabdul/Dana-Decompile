package com.alipay.iap.android.aplog.core;

import com.alipay.iap.android.aplog.api.DeviceIdProvider;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class UtdidDeviceIdProvider implements DeviceIdProvider {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {112, Ascii.US, -51, -82, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int MyBillsEntityDataFactory = 84;
    private static final String TAG = "UtdidDeviceIdProvider";

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f A[Catch: Exception -> 0x0066, TryCatch #0 {Exception -> 0x0066, blocks: (B:3:0x0002, B:5:0x000a, B:9:0x0029, B:11:0x002f, B:13:0x0043, B:14:0x0058), top: B:20:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[Catch: Exception -> 0x0066, TRY_LEAVE, TryCatch #0 {Exception -> 0x0066, blocks: (B:3:0x0002, B:5:0x000a, B:9:0x0029, B:11:0x002f, B:13:0x0043, B:14:0x0058), top: B:20:0x0002 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:16:0x005e). Please submit an issue!!! */
    @Override // com.alipay.iap.android.aplog.api.DeviceIdProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getDeviceId() {
        /*
            r13 = this;
            java.lang.String r0 = " "
            java.lang.String r1 = "com.ut.device.UTDevice"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L70
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L66
            byte[] r4 = com.alipay.iap.android.aplog.core.UtdidDeviceIdProvider.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L66
            r5 = 97
            r6 = -1
            r7 = 23
            byte[] r7 = new byte[r7]     // Catch: java.lang.Exception -> L66
            r8 = 22
            r9 = 3
            r5 = r4
            if (r4 != 0) goto L23
            r6 = r7
            r7 = -1
            r10 = 3
            r11 = 22
            r4 = r3
            goto L5e
        L23:
            r9 = r7
            r6 = 97
            r7 = -1
            r10 = 3
            r4 = r3
        L29:
            int r7 = r7 + r2
            byte r11 = (byte) r6     // Catch: java.lang.Exception -> L66
            r9[r7] = r11     // Catch: java.lang.Exception -> L66
            if (r7 != r8) goto L58
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L66
            r6 = 0
            r5.<init>(r9, r6)     // Catch: java.lang.Exception -> L66
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L66
            r3[r6] = r5     // Catch: java.lang.Exception -> L66
            java.lang.String r3 = "getUtdid"
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r4)     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L70
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L66
            com.alipay.iap.android.aplog.api.LogContext r3 = com.alipay.iap.android.aplog.core.LoggerFactory.getLogContext()     // Catch: java.lang.Exception -> L66
            android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L66
            r2[r6] = r3     // Catch: java.lang.Exception -> L66
            r3 = 0
            java.lang.Object r1 = r1.invoke(r3, r2)     // Catch: java.lang.Exception -> L66
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L66
            r0 = r1
            goto L70
        L58:
            int r10 = r10 + r2
            r11 = r5[r10]     // Catch: java.lang.Exception -> L66
            r12 = r9
            r9 = r6
            r6 = r12
        L5e:
            int r11 = -r11
            int r9 = r9 + r11
            int r9 = r9 + (-8)
            r12 = r9
            r9 = r6
            r6 = r12
            goto L29
        L66:
            r1 = move-exception
            com.alipay.iap.android.aplog.core.logger.TraceLogger r2 = com.alipay.iap.android.aplog.core.LoggerFactory.getTraceLogger()
            java.lang.String r3 = "UtdidDeviceIdProvider"
            r2.error(r3, r1)
        L70:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.UtdidDeviceIdProvider.getDeviceId():java.lang.String");
    }
}
