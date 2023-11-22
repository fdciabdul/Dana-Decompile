package com.iap.ac.android.container.utils;

/* loaded from: classes3.dex */
public class ResourceUtils {
    private static final String TAG = "ResourceUtils";

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r7 == null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String readRawFromResource(int r7, android.content.res.Resources r8) {
        /*
            java.lang.String r0 = "readRawFromResource InputStream close error!"
            java.lang.String r1 = "ResourceUtils"
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 0
            java.io.InputStream r7 = r8.openRawResource(r7)     // Catch: java.lang.Throwable -> L39
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L37
            r8.<init>(r7)     // Catch: java.lang.Throwable -> L37
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L37
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L37
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L37
            r8.<init>()     // Catch: java.lang.Throwable -> L37
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L37
        L21:
            if (r6 == 0) goto L30
            r8.append(r6)     // Catch: java.lang.Throwable -> L37
            r6 = 10
            r8.append(r6)     // Catch: java.lang.Throwable -> L37
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L37
            goto L21
        L30:
            java.lang.String r4 = r8.toString()     // Catch: java.lang.Throwable -> L37
            if (r7 == 0) goto L4b
            goto L43
        L37:
            r8 = move-exception
            goto L3b
        L39:
            r8 = move-exception
            r7 = r4
        L3b:
            java.lang.String r5 = "readRawFromResource error! "
            com.iap.ac.android.common.log.ACLog.e(r1, r5, r8)     // Catch: java.lang.Throwable -> L66
            if (r7 == 0) goto L4b
        L43:
            r7.close()     // Catch: java.lang.Throwable -> L47
            goto L4b
        L47:
            r7 = move-exception
            com.iap.ac.android.common.log.ACLog.e(r1, r0, r7)
        L4b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "readRaw elapse "
            r7.append(r8)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r2
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.iap.ac.android.common.log.ACLog.d(r1, r7)
            return r4
        L66:
            r8 = move-exception
            if (r7 == 0) goto L71
            r7.close()     // Catch: java.lang.Throwable -> L6d
            goto L71
        L6d:
            r7 = move-exception
            com.iap.ac.android.common.log.ACLog.e(r1, r0, r7)
        L71:
            goto L73
        L72:
            throw r8
        L73:
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.container.utils.ResourceUtils.readRawFromResource(int, android.content.res.Resources):java.lang.String");
    }
}
