package com.appsflyer.internal;

import android.net.NetworkInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {
        static final y valueOf = new y();
    }

    y() {
    }

    private static boolean valueOf(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d {
        final String AFInAppEventType;
        final String AFKeystoreWrapper;
        final String valueOf;

        d(String str, String str2, String str3) {
            this.AFKeystoreWrapper = str;
            this.valueOf = str2;
            this.AFInAppEventType = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        if (r2.getType() == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.appsflyer.internal.y.d AFKeystoreWrapper(android.content.Context r10) {
        /*
            java.lang.String r0 = "unknown"
            r1 = 0
            java.lang.String r2 = "connectivity"
            java.lang.Object r2 = r10.getSystemService(r2)     // Catch: java.lang.Throwable -> L91
            android.net.ConnectivityManager r2 = (android.net.ConnectivityManager) r2     // Catch: java.lang.Throwable -> L91
            if (r2 == 0) goto L6a
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L91
            r4 = 21
            r5 = 0
            r6 = 1
            if (r4 > r3) goto L39
            android.net.Network[] r3 = r2.getAllNetworks()     // Catch: java.lang.Throwable -> L91
            int r4 = r3.length     // Catch: java.lang.Throwable -> L91
        L1a:
            if (r5 >= r4) goto L6a
            r7 = r3[r5]     // Catch: java.lang.Throwable -> L91
            android.net.NetworkInfo r7 = r2.getNetworkInfo(r7)     // Catch: java.lang.Throwable -> L91
            boolean r8 = valueOf(r7)     // Catch: java.lang.Throwable -> L91
            if (r8 == 0) goto L36
            int r2 = r7.getType()     // Catch: java.lang.Throwable -> L91
            if (r6 != r2) goto L2f
            goto L5f
        L2f:
            int r2 = r7.getType()     // Catch: java.lang.Throwable -> L91
            if (r2 != 0) goto L6a
            goto L68
        L36:
            int r5 = r5 + 1
            goto L1a
        L39:
            android.net.NetworkInfo r3 = r2.getNetworkInfo(r6)     // Catch: java.lang.Throwable -> L91
            boolean r3 = valueOf(r3)     // Catch: java.lang.Throwable -> L91
            if (r3 == 0) goto L44
            goto L5f
        L44:
            android.net.NetworkInfo r3 = r2.getNetworkInfo(r5)     // Catch: java.lang.Throwable -> L91
            boolean r3 = valueOf(r3)     // Catch: java.lang.Throwable -> L91
            if (r3 == 0) goto L4f
            goto L68
        L4f:
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L91
            boolean r3 = valueOf(r2)     // Catch: java.lang.Throwable -> L91
            if (r3 == 0) goto L6a
            int r3 = r2.getType()     // Catch: java.lang.Throwable -> L91
            if (r6 != r3) goto L62
        L5f:
            java.lang.String r0 = "WIFI"
            goto L6a
        L62:
            int r2 = r2.getType()     // Catch: java.lang.Throwable -> L91
            if (r2 != 0) goto L6a
        L68:
            java.lang.String r0 = "MOBILE"
        L6a:
            java.lang.String r2 = "phone"
            java.lang.Object r10 = r10.getSystemService(r2)     // Catch: java.lang.Throwable -> L91
            android.telephony.TelephonyManager r10 = (android.telephony.TelephonyManager) r10     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = r10.getSimOperatorName()     // Catch: java.lang.Throwable -> L91
            java.lang.String r1 = r10.getNetworkOperatorName()     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L82
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Throwable -> L8c
            if (r3 == 0) goto L9b
        L82:
            r3 = 2
            int r10 = r10.getPhoneType()     // Catch: java.lang.Throwable -> L8c
            if (r3 != r10) goto L9b
            java.lang.String r1 = "CDMA"
            goto L9b
        L8c:
            r10 = move-exception
            r9 = r2
            r2 = r1
            r1 = r9
            goto L93
        L91:
            r10 = move-exception
            r2 = r1
        L93:
            java.lang.String r3 = "Exception while collecting network info. "
            com.appsflyer.AFLogger.AFInAppEventType(r3, r10)
            r9 = r2
            r2 = r1
            r1 = r9
        L9b:
            com.appsflyer.internal.y$d r10 = new com.appsflyer.internal.y$d
            r10.<init>(r0, r1, r2)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.y.AFKeystoreWrapper(android.content.Context):com.appsflyer.internal.y$d");
    }
}
