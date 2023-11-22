package com.alipay.mobile.rome.syncsdk.util;

/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7270a = "k";

    /* JADX WARN: Removed duplicated region for block: B:62:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(byte[] r7) {
        /*
            java.lang.String r0 = " ]"
            java.lang.String r1 = "gZipBytes: [ Exception "
            r2 = 0
            if (r7 == 0) goto Lcd
            int r3 = r7.length
            if (r3 <= 0) goto Lcd
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream
            r3.<init>()
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4d
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4d
            r5 = 0
            int r6 = r7.length     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            r4.write(r7, r5, r6)     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            r4.finish()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            byte[] r2 = r3.toByteArray()     // Catch: java.lang.Throwable -> L46 java.io.IOException -> L49
            r4.close()     // Catch: java.io.IOException -> L24
            goto L39
        L24:
            r7 = move-exception
            java.lang.String r4 = com.alipay.mobile.rome.syncsdk.util.k.f7270a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            r5.append(r7)
            r5.append(r0)
            java.lang.String r7 = r5.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r4, r7)
        L39:
            r3.close()     // Catch: java.io.IOException -> L3d
            goto L97
        L3d:
            r7 = move-exception
            java.lang.String r3 = com.alipay.mobile.rome.syncsdk.util.k.f7270a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            goto L8a
        L46:
            r7 = move-exception
            r2 = r4
            goto L98
        L49:
            r7 = move-exception
            goto L4f
        L4b:
            r7 = move-exception
            goto L98
        L4d:
            r7 = move-exception
            r4 = r2
        L4f:
            java.lang.String r5 = com.alipay.mobile.rome.syncsdk.util.k.f7270a     // Catch: java.lang.Throwable -> L46
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L46
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L46
            r6.append(r7)     // Catch: java.lang.Throwable -> L46
            r6.append(r0)     // Catch: java.lang.Throwable -> L46
            java.lang.String r7 = r6.toString()     // Catch: java.lang.Throwable -> L46
            com.alipay.mobile.rome.syncsdk.util.c.d(r5, r7)     // Catch: java.lang.Throwable -> L46
            if (r4 == 0) goto L7e
            r4.close()     // Catch: java.io.IOException -> L69
            goto L7e
        L69:
            r7 = move-exception
            java.lang.String r4 = com.alipay.mobile.rome.syncsdk.util.k.f7270a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            r5.append(r7)
            r5.append(r0)
            java.lang.String r7 = r5.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r4, r7)
        L7e:
            r3.close()     // Catch: java.io.IOException -> L82
            goto L97
        L82:
            r7 = move-exception
            java.lang.String r3 = com.alipay.mobile.rome.syncsdk.util.k.f7270a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
        L8a:
            r4.append(r7)
            r4.append(r0)
            java.lang.String r7 = r4.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r3, r7)
        L97:
            return r2
        L98:
            if (r2 == 0) goto Lb3
            r2.close()     // Catch: java.io.IOException -> L9e
            goto Lb3
        L9e:
            r2 = move-exception
            java.lang.String r4 = com.alipay.mobile.rome.syncsdk.util.k.f7270a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r1)
            r5.append(r2)
            r5.append(r0)
            java.lang.String r2 = r5.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r4, r2)
        Lb3:
            r3.close()     // Catch: java.io.IOException -> Lb7
            goto Lcc
        Lb7:
            r2 = move-exception
            java.lang.String r3 = com.alipay.mobile.rome.syncsdk.util.k.f7270a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            r4.append(r2)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r3, r0)
        Lcc:
            throw r7
        Lcd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.util.k.a(byte[]):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] b(byte[] r8) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.util.k.b(byte[]):byte[]");
    }
}
