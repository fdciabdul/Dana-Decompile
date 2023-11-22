package com.appsflyer.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import java.io.File;
import java.lang.ref.WeakReference;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public final class an {
    private static String AFInAppEventType;

    public static String AFKeystoreWrapper(WeakReference<Context> weakReference) {
        synchronized (an.class) {
            if (weakReference.get() == null) {
                return AFInAppEventType;
            }
            if (AFInAppEventType == null) {
                String string = weakReference.get() != null ? ae.values(weakReference.get()).getString("AF_INSTALLATION", null) : null;
                if (string != null) {
                    AFInAppEventType = string;
                } else {
                    try {
                        File file = new File(weakReference.get().getFilesDir(), "AF_INSTALLATION");
                        if (file.exists()) {
                            AFInAppEventType = valueOf(file);
                            file.delete();
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            StringBuilder sb = new StringBuilder();
                            sb.append(currentTimeMillis);
                            sb.append("-");
                            sb.append(Math.abs(new SecureRandom().nextLong()));
                            AFInAppEventType = sb.toString();
                        }
                        String str = AFInAppEventType;
                        SharedPreferences.Editor edit = ae.values(weakReference.get()).edit();
                        edit.putString("AF_INSTALLATION", str);
                        edit.apply();
                    } catch (Exception e) {
                        AFLogger.AFInAppEventType("Error getting AF unique ID", e);
                    }
                }
                if (AFInAppEventType != null) {
                    AppsFlyerProperties.getInstance().set("uid", AFInAppEventType);
                }
            }
            return AFInAppEventType;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String valueOf(java.io.File r6) {
        /*
            java.lang.String r0 = "Exception while trying to close the InstallationFile"
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            java.lang.String r3 = "r"
            r2.<init>(r6, r3)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f
            long r3 = r2.length()     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            int r6 = (int) r3     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            r2.readFully(r6)     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L22
            r2.close()     // Catch: java.io.IOException -> L20 java.lang.Throwable -> L22
            r2.close()     // Catch: java.io.IOException -> L1b
            goto L41
        L1b:
            r1 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType(r0, r1)
            goto L41
        L20:
            r1 = move-exception
            goto L28
        L22:
            r6 = move-exception
            goto L4d
        L24:
            r6 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
        L28:
            r5 = r2
            r2 = r6
            r6 = r1
            r1 = r5
            goto L31
        L2d:
            r6 = move-exception
            goto L4c
        L2f:
            r6 = move-exception
            r2 = r1
        L31:
            java.lang.String r3 = "Exception while reading InstallationFile: "
            com.appsflyer.AFLogger.AFInAppEventType(r3, r6)     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L40
            r1.close()     // Catch: java.io.IOException -> L3c
            goto L40
        L3c:
            r6 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType(r0, r6)
        L40:
            r6 = r2
        L41:
            if (r6 != 0) goto L46
            r6 = 0
            byte[] r6 = new byte[r6]
        L46:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r6)
            return r0
        L4c:
            r2 = r1
        L4d:
            if (r2 == 0) goto L57
            r2.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r1 = move-exception
            com.appsflyer.AFLogger.AFInAppEventType(r0, r1)
        L57:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.an.valueOf(java.io.File):java.lang.String");
    }
}
