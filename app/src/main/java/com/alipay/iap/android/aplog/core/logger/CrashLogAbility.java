package com.alipay.iap.android.aplog.core.logger;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.log.crash.CrashLog;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes6.dex */
public class CrashLogAbility {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 85;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = com.alipay.iap.android.aplog.core.logger.CrashLogAbility.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 * 12
            int r7 = 16 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L30
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.aplog.core.logger.CrashLogAbility.a(int, int, int, java.lang.Object[]):void");
    }

    public static CrashLog makeCrashLog(String str, String str2) {
        CrashLog crashLog = new CrashLog();
        crashLog.setJavaCrash(false);
        crashLog.putExtParam("callStack", str);
        crashLog.putExtParam("crashInfo", str2);
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            crashLog.putExtParam("thread", ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName());
            return crashLog;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }
}
