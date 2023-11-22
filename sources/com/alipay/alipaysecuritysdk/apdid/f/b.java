package com.alipay.alipaysecuritysdk.apdid.f;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* loaded from: classes3.dex */
public final class b {
    public static final byte[] MyBillsEntityDataFactory = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 22;

    /* JADX WARN: Removed duplicated region for block: B:8:0x003b A[Catch: Exception -> 0x0068, TryCatch #0 {Exception -> 0x0068, blocks: (B:2:0x0000, B:6:0x0035, B:8:0x003b, B:9:0x0058), top: B:15:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0058 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #0 {Exception -> 0x0068, blocks: (B:2:0x0000, B:6:0x0035, B:8:0x003b, B:9:0x0058), top: B:15:0x0000 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x005c -> B:11:0x0060). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r13) {
        /*
            java.lang.String r0 = "com.ut.device.UTDevice"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L68
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L68
            byte[] r3 = com.alipay.alipaysecuritysdk.apdid.f.b.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L68
            r4 = 5
            r3 = r3[r4]     // Catch: java.lang.Exception -> L68
            int r3 = r3 + r1
            byte r3 = (byte) r3     // Catch: java.lang.Exception -> L68
            int r4 = r3 + 1
            byte r4 = (byte) r4     // Catch: java.lang.Exception -> L68
            byte r5 = (byte) r4     // Catch: java.lang.Exception -> L68
            byte[] r6 = com.alipay.alipaysecuritysdk.apdid.f.b.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L68
            int r3 = r3 + 4
            int r4 = r4 * 2
            int r4 = 23 - r4
            int r5 = r5 * 2
            int r5 = 97 - r5
            byte[] r7 = new byte[r4]     // Catch: java.lang.Exception -> L68
            int r4 = r4 + (-1)
            r8 = 0
            if (r6 != 0) goto L2f
            r5 = r3
            r11 = r4
            r9 = r7
            r10 = 0
            r7 = r6
            r4 = r2
            r6 = r11
            goto L60
        L2f:
            r9 = r7
            r10 = 0
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r2
        L35:
            int r4 = r4 + r1
            byte r11 = (byte) r5     // Catch: java.lang.Exception -> L68
            r9[r10] = r11     // Catch: java.lang.Exception -> L68
            if (r10 != r6) goto L58
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Exception -> L68
            r4.<init>(r9, r8)     // Catch: java.lang.Exception -> L68
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L68
            r2[r8] = r4     // Catch: java.lang.Exception -> L68
            java.lang.String r2 = "getUtdid"
            java.lang.reflect.Method r0 = r0.getMethod(r2, r3)     // Catch: java.lang.Exception -> L68
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L68
            r1[r8] = r13     // Catch: java.lang.Exception -> L68
            r13 = 0
            java.lang.Object r13 = r0.invoke(r13, r1)     // Catch: java.lang.Exception -> L68
            java.lang.String r13 = (java.lang.String) r13     // Catch: java.lang.Exception -> L68
            goto L73
        L58:
            int r10 = r10 + 1
            r11 = r7[r4]     // Catch: java.lang.Exception -> L68
            r12 = r4
            r4 = r3
            r3 = r5
            r5 = r12
        L60:
            int r3 = r3 + r11
            int r3 = r3 + (-8)
            r12 = r5
            r5 = r3
            r3 = r4
            r4 = r12
            goto L35
        L68:
            r13 = move-exception
            java.lang.String r0 = "SEC_SDK-apdid"
            java.lang.String r1 = "utdid error."
            com.alipay.alipaysecuritysdk.common.c.b.a(r0, r1, r13)
            java.lang.String r13 = ""
        L73:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.alipaysecuritysdk.apdid.f.b.a(android.content.Context):java.lang.String");
    }
}
