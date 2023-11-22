package com.appsflyer.internal;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c {
        static final u AFInAppEventParameterName = new u();
    }

    u() {
    }

    private static boolean AFInAppEventParameterName(Context context, String[] strArr) {
        for (String str : strArr) {
            if (aa.AFInAppEventParameterName(context, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        if (60000 < (r3.getTime() - r11.getTime())) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.location.Location valueOf(android.content.Context r11) {
        /*
            r10 = this;
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            r1 = 0
            java.lang.String r2 = "location"
            java.lang.Object r2 = r11.getSystemService(r2)     // Catch: java.lang.Throwable -> L55
            android.location.LocationManager r2 = (android.location.LocationManager) r2     // Catch: java.lang.Throwable -> L55
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            java.lang.String[] r3 = new java.lang.String[]{r0, r3}     // Catch: java.lang.Throwable -> L55
            boolean r3 = AFInAppEventParameterName(r11, r3)     // Catch: java.lang.Throwable -> L55
            if (r3 == 0) goto L1e
            java.lang.String r3 = "network"
            android.location.Location r3 = r2.getLastKnownLocation(r3)     // Catch: java.lang.Throwable -> L55
            goto L1f
        L1e:
            r3 = r1
        L1f:
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L55
            boolean r11 = AFInAppEventParameterName(r11, r0)     // Catch: java.lang.Throwable -> L55
            if (r11 == 0) goto L30
            java.lang.String r11 = "gps"
            android.location.Location r11 = r2.getLastKnownLocation(r11)     // Catch: java.lang.Throwable -> L55
            goto L31
        L30:
            r11 = r1
        L31:
            if (r11 != 0) goto L37
            if (r3 != 0) goto L37
            r3 = r1
            goto L52
        L37:
            if (r11 != 0) goto L3c
            if (r3 == 0) goto L3c
            goto L52
        L3c:
            if (r3 != 0) goto L40
            if (r11 != 0) goto L51
        L40:
            long r4 = r3.getTime()     // Catch: java.lang.Throwable -> L55
            long r6 = r11.getTime()     // Catch: java.lang.Throwable -> L55
            r8 = 60000(0xea60, double:2.9644E-319)
            long r4 = r4 - r6
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 >= 0) goto L51
            goto L52
        L51:
            r3 = r11
        L52:
            if (r3 == 0) goto L55
            r1 = r3
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.u.valueOf(android.content.Context):android.location.Location");
    }
}
