package com.alibaba.ariver.kernel.common.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.exthub.common.ExtHubLogger;
import com.google.common.base.Ascii;

/* loaded from: classes3.dex */
public class RVKernelUtils {
    public static final String TAG = "AriverKernel";

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f6164a;
    public static final byte[] getAuthRequestContext = {33, -64, 37, -91, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 51;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 6
            int r7 = r7 + 97
            int r9 = r9 * 5
            int r9 = r9 + 18
            int r8 = r8 * 22
            int r8 = r8 + 4
            byte[] r0 = com.alibaba.ariver.kernel.common.utils.RVKernelUtils.getAuthRequestContext
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r9) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L37:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + (-8)
            int r7 = r7 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.kernel.common.utils.RVKernelUtils.b(short, int, int, java.lang.Object[]):void");
    }

    public static boolean isDebug() {
        if (f6164a == null) {
            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            try {
                if (applicationContext == null) {
                    return false;
                }
                try {
                    byte b = getAuthRequestContext[41];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    b(b, b2, (byte) (b2 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 5);
                    Object[] objArr2 = new Object[1];
                    b(b3, b3, getAuthRequestContext[41], objArr2);
                    f6164a = Boolean.valueOf((((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(applicationContext, null)).flags & 2) != 0);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                ExtHubLogger.e("AriverKernel", "exception detail", th2);
            }
        }
        if (f6164a == null) {
            f6164a = Boolean.FALSE;
        }
        return f6164a.booleanValue();
    }

    public static String getClientVersion() {
        try {
            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Resources getResources() {
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources("com-alibaba-ariver-ariver");
    }
}
