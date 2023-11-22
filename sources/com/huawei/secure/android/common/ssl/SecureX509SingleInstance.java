package com.huawei.secure.android.common.ssl;

/* loaded from: classes8.dex */
public class SecureX509SingleInstance {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {103, 121, -60, -41, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 34;
    private static final String MyBillsEntityDataFactory = "SecureX509SingleInstance";
    private static volatile SecureX509TrustManager PlaceComponentResult;

    private SecureX509SingleInstance() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b A[Catch: all -> 0x007e, TryCatch #0 {, blocks: (B:7:0x000c, B:9:0x0010, B:11:0x0016, B:13:0x002f, B:17:0x0052, B:19:0x005b, B:20:0x0070, B:12:0x0028), top: B:33:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070 A[Catch: all -> 0x007e, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000c, B:9:0x0010, B:11:0x0016, B:13:0x002f, B:17:0x0052, B:19:0x005b, B:20:0x0070, B:12:0x0028), top: B:33:0x000c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0072 -> B:22:0x0075). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.secure.android.common.ssl.SecureX509TrustManager BuiltInFictitiousFunctionClassFactory(android.content.Context r14) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        /*
            if (r14 == 0) goto L87
            com.huawei.secure.android.common.ssl.util.c.getAuthRequestContext(r14)
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r0 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.PlaceComponentResult
            if (r0 != 0) goto L81
            java.lang.Class<com.huawei.secure.android.common.ssl.SecureX509SingleInstance> r0 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.class
            monitor-enter(r0)
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r1 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.PlaceComponentResult     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L7c
            java.io.InputStream r1 = com.huawei.secure.android.common.ssl.util.BksUtil.getAuthRequestContext(r14)     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L28
            java.lang.String r1 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "get assets bks"
            com.huawei.secure.android.common.ssl.util.g.KClassImpl$Data$declaredNonStaticMembers$2(r1, r2)     // Catch: java.lang.Throwable -> L7e
            android.content.res.AssetManager r1 = r14.getAssets()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "hmsrootcas.bks"
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L7e
            goto L2f
        L28:
            java.lang.String r2 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.MyBillsEntityDataFactory     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = "get files bks"
            com.huawei.secure.android.common.ssl.util.g.KClassImpl$Data$declaredNonStaticMembers$2(r2, r3)     // Catch: java.lang.Throwable -> L7e
        L2f:
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r2 = new com.huawei.secure.android.common.ssl.SecureX509TrustManager     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = ""
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L7e
            com.huawei.secure.android.common.ssl.SecureX509SingleInstance.PlaceComponentResult = r2     // Catch: java.lang.Throwable -> L7e
            com.huawei.secure.android.common.ssl.util.d r1 = new com.huawei.secure.android.common.ssl.util.d     // Catch: java.lang.Throwable -> L7e
            r1.<init>()     // Catch: java.lang.Throwable -> L7e
            java.util.concurrent.Executor r2 = android.os.AsyncTask.THREAD_POOL_EXECUTOR     // Catch: java.lang.Throwable -> L7e
            byte[] r3 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Throwable -> L7e
            r4 = 23
            byte[] r5 = new byte[r4]     // Catch: java.lang.Throwable -> L7e
            r6 = 3
            r7 = 97
            r8 = 0
            if (r3 != 0) goto L4e
            r9 = 3
            r10 = 0
            goto L75
        L4e:
            r6 = 97
            r7 = 3
            r9 = 0
        L52:
            int r10 = r9 + 1
            byte r11 = (byte) r6     // Catch: java.lang.Throwable -> L7e
            r12 = 1
            int r7 = r7 + r12
            r5[r9] = r11     // Catch: java.lang.Throwable -> L7e
            if (r10 != r4) goto L70
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L7e
            r3.<init>(r5, r8)     // Catch: java.lang.Throwable -> L7e
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r12)     // Catch: java.lang.Throwable -> L7e
            java.lang.Object[] r3 = (java.lang.Object[]) r3     // Catch: java.lang.Throwable -> L7e
            r3[r8] = r14     // Catch: java.lang.Throwable -> L7e
            r1.executeOnExecutor(r2, r3)     // Catch: java.lang.Throwable -> L7e
            goto L7c
        L70:
            r9 = r3[r7]     // Catch: java.lang.Throwable -> L7e
            r13 = r9
            r9 = r7
            r7 = r13
        L75:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-8)
            r7 = r9
            r9 = r10
            goto L52
        L7c:
            monitor-exit(r0)
            goto L81
        L7e:
            r14 = move-exception
            monitor-exit(r0)
            throw r14
        L81:
            com.huawei.secure.android.common.ssl.util.g.PlaceComponentResult()
            com.huawei.secure.android.common.ssl.SecureX509TrustManager r14 = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.PlaceComponentResult
            return r14
        L87:
            java.lang.NullPointerException r14 = new java.lang.NullPointerException
            java.lang.String r0 = "context is null"
            r14.<init>(r0)
            goto L90
        L8f:
            throw r14
        L90:
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.SecureX509SingleInstance.BuiltInFictitiousFunctionClassFactory(android.content.Context):com.huawei.secure.android.common.ssl.SecureX509TrustManager");
    }
}
