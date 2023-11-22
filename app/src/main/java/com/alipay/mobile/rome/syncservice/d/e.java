package com.alipay.mobile.rome.syncservice.d;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7282a = "e";

    /* JADX WARN: Removed duplicated region for block: B:57:0x0118 A[Catch: Exception -> 0x0114, TRY_LEAVE, TryCatch #5 {Exception -> 0x0114, blocks: (B:53:0x0110, B:57:0x0118), top: B:67:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.List<java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.d.e.a(java.util.List):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0097 A[Catch: Exception -> 0x0093, TRY_LEAVE, TryCatch #8 {Exception -> 0x0093, blocks: (B:43:0x008f, B:47:0x0097), top: B:55:0x008f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r9) {
        /*
            java.lang.String r0 = "executeCommand error="
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            r1 = 0
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.lang.Process r3 = r3.exec(r9)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            java.io.OutputStream r5 = r3.getOutputStream()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
            r4.flush()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            int r9 = r3.waitFor()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            if (r9 != 0) goto L27
            r9 = 1
            r2 = 1
        L27:
            r4.close()     // Catch: java.lang.Exception -> L31
            if (r3 == 0) goto L89
            r3.destroy()     // Catch: java.lang.Exception -> L31
            goto L89
        L31:
            r9 = move-exception
            java.lang.String r1 = com.alipay.mobile.rome.syncservice.d.e.f7282a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            goto L7f
        L3a:
            r9 = move-exception
            r1 = r3
            goto L8b
        L3d:
            r1 = move-exception
            r8 = r3
            r3 = r1
            r1 = r8
            goto L4f
        L42:
            r9 = move-exception
            goto L8d
        L44:
            r4 = move-exception
            r8 = r4
            r4 = r1
            r1 = r3
            r3 = r8
            goto L4f
        L4a:
            r9 = move-exception
            r3 = r1
            goto L8d
        L4d:
            r3 = move-exception
            r4 = r1
        L4f:
            java.lang.String r5 = com.alipay.mobile.rome.syncservice.d.e.f7282a     // Catch: java.lang.Throwable -> L8a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8a
            java.lang.String r7 = "executeCommand "
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8a
            r6.append(r9)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r9 = " e:"
            r6.append(r9)     // Catch: java.lang.Throwable -> L8a
            r6.append(r3)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r9 = r6.toString()     // Catch: java.lang.Throwable -> L8a
            com.alipay.mobile.rome.syncsdk.util.c.d(r5, r9)     // Catch: java.lang.Throwable -> L8a
            if (r4 == 0) goto L72
            r4.close()     // Catch: java.lang.Exception -> L70
            goto L72
        L70:
            r9 = move-exception
            goto L78
        L72:
            if (r1 == 0) goto L89
            r1.destroy()     // Catch: java.lang.Exception -> L70
            goto L89
        L78:
            java.lang.String r1 = com.alipay.mobile.rome.syncservice.d.e.f7282a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
        L7f:
            r3.append(r9)
            java.lang.String r9 = r3.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r1, r9)
        L89:
            return r2
        L8a:
            r9 = move-exception
        L8b:
            r3 = r1
            r1 = r4
        L8d:
            if (r1 == 0) goto L95
            r1.close()     // Catch: java.lang.Exception -> L93
            goto L95
        L93:
            r1 = move-exception
            goto L9b
        L95:
            if (r3 == 0) goto Lac
            r3.destroy()     // Catch: java.lang.Exception -> L93
            goto Lac
        L9b:
            java.lang.String r2 = com.alipay.mobile.rome.syncservice.d.e.f7282a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r2, r0)
        Lac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.d.e.a(java.lang.String):boolean");
    }
}
