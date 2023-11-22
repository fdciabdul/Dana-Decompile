package com.huawei.hms.framework.common;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public class RunnableEnhance implements Runnable {
    static final String TRANCELOGO = " -->";
    private String MyBillsEntityDataFactory;
    private Runnable PlaceComponentResult;
    public static final byte[] getAuthRequestContext = {116, 44, -28, -115, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 135;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 12
            int r7 = 16 - r7
            int r6 = r6 * 7
            int r6 = r6 + 99
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r0 = com.huawei.hms.framework.common.RunnableEnhance.getAuthRequestContext
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1c:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r5
        L20:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L38:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + 2
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L20
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.RunnableEnhance.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableEnhance(Runnable runnable) {
        try {
            byte b = (byte) (-getAuthRequestContext[15]);
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), (byte) (-getAuthRequestContext[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (getAuthRequestContext[15] + 1);
            byte b3 = (byte) (-getAuthRequestContext[15]);
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            this.MyBillsEntityDataFactory = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getName();
            this.PlaceComponentResult = runnable;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.PlaceComponentResult.run();
    }

    public String getParentName() {
        return this.MyBillsEntityDataFactory;
    }
}
