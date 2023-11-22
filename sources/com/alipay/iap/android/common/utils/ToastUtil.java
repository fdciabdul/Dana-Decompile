package com.alipay.iap.android.common.utils;

import android.content.Context;
import android.widget.Toast;
import com.alibaba.ariver.resource.parser.tar.TarHeader;

/* loaded from: classes6.dex */
public class ToastUtil {
    private static long currentThreadID = 1;
    private static Toast toast;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 134;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 12
            int r7 = r7 + 4
            int r9 = r9 * 3
            int r9 = r9 + 13
            byte[] r0 = com.alipay.iap.android.common.utils.ToastUtil.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L35
        L19:
            r3 = 0
        L1a:
            r6 = r9
            r9 = r8
            r8 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L35:
            int r10 = r10 + r8
            int r8 = r10 + 2
            int r7 = r7 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.iap.android.common.utils.ToastUtil.a(byte, short, short, java.lang.Object[]):void");
    }

    private ToastUtil() {
    }

    public static Toast showMsg(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            if (toast != null) {
                long j = currentThreadID;
                try {
                    byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
                    Object[] objArr = new Object[1];
                    a(b, (byte) (b - 1), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                    Object[] objArr2 = new Object[1];
                    a(b2, b3, (byte) (b3 - 1), objArr2);
                    if (j == ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getId()) {
                        toast.setText(str);
                        toast.show();
                        return toast;
                    }
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            }
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr3 = new Object[1];
            a(b4, (byte) (b4 - 1), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
            byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[15];
            Object[] objArr4 = new Object[1];
            a(b5, b6, (byte) (b6 - 1), objArr4);
            currentThreadID = ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).getId();
            toast.show();
            return toast;
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
        Toast makeText = Toast.makeText(context.getApplicationContext(), str, 0);
        toast = makeText;
        makeText.setGravity(17, 0, 0);
    }
}
