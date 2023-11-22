package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Process;
import com.appsflyer.AFLogger;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes.dex */
public final class aa {
    public static boolean AFInAppEventParameterName(Context context, Intent intent) {
        return context.getPackageManager().queryIntentServices(intent, 0).size() > 0;
    }

    public static boolean AFInAppEventParameterName(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        int checkPermission = context.checkPermission(str, Process.myPid(), Process.myUid());
        StringBuilder sb = new StringBuilder("is Permission Available: ");
        sb.append(str);
        sb.append("; res: ");
        sb.append(checkPermission);
        AFLogger.AFInAppEventParameterName(sb.toString());
        return checkPermission == 0;
    }

    public static boolean values() {
        return Build.BRAND.equals("OPPO");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r2.equals("c") != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> AFKeystoreWrapper(android.content.Context r11, java.util.Map<java.lang.String, java.lang.String> r12, android.net.Uri r13) {
        /*
            java.lang.String r0 = "install_time"
            java.util.Set r1 = r13.getQueryParameterNames()
            java.util.Iterator r1 = r1.iterator()
        La:
            boolean r2 = r1.hasNext()
            java.lang.String r3 = "agency"
            java.lang.String r4 = "media_source"
            r5 = 0
            if (r2 == 0) goto L68
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r13.getQueryParameter(r2)
            boolean r7 = r12.containsKey(r2)
            if (r7 != 0) goto L63
            int r7 = r2.hashCode()
            r8 = -1420799080(0xffffffffab505398, float:-7.4012454E-13)
            r9 = 1
            r10 = 2
            if (r7 == r8) goto L4c
            r8 = 99
            if (r7 == r8) goto L43
            r5 = 110987(0x1b18b, float:1.55526E-40)
            if (r7 != r5) goto L56
            java.lang.String r5 = "pid"
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L56
            r5 = 1
            goto L57
        L43:
            java.lang.String r7 = "c"
            boolean r7 = r2.equals(r7)
            if (r7 == 0) goto L56
            goto L57
        L4c:
            java.lang.String r5 = "af_prt"
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L56
            r5 = 2
            goto L57
        L56:
            r5 = -1
        L57:
            if (r5 == 0) goto L60
            if (r5 == r9) goto L5e
            if (r5 != r10) goto L63
            goto L64
        L5e:
            r3 = r4
            goto L64
        L60:
            java.lang.String r3 = "campaign"
            goto L64
        L63:
            r3 = r2
        L64:
            r12.put(r3, r6)
            goto La
        L68:
            boolean r1 = r12.containsKey(r0)     // Catch: java.lang.Exception -> L9b
            if (r1 != 0) goto La1
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat     // Catch: java.lang.Exception -> L9b
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r6 = java.util.Locale.US     // Catch: java.lang.Exception -> L9b
            r1.<init>(r2, r6)     // Catch: java.lang.Exception -> L9b
            android.content.pm.PackageManager r2 = r11.getPackageManager()     // Catch: java.lang.Exception -> L9b
            java.lang.String r11 = r11.getPackageName()     // Catch: java.lang.Exception -> L9b
            android.content.pm.PackageInfo r11 = r2.getPackageInfo(r11, r5)     // Catch: java.lang.Exception -> L9b
            long r5 = r11.firstInstallTime     // Catch: java.lang.Exception -> L9b
            java.lang.String r11 = "UTC"
            java.util.TimeZone r11 = j$.util.DesugarTimeZone.BuiltInFictitiousFunctionClassFactory(r11)     // Catch: java.lang.Exception -> L9b
            r1.setTimeZone(r11)     // Catch: java.lang.Exception -> L9b
            java.util.Date r11 = new java.util.Date     // Catch: java.lang.Exception -> L9b
            r11.<init>(r5)     // Catch: java.lang.Exception -> L9b
            java.lang.String r11 = r1.format(r11)     // Catch: java.lang.Exception -> L9b
            r12.put(r0, r11)     // Catch: java.lang.Exception -> L9b
            goto La1
        L9b:
            r11 = move-exception
            java.lang.String r0 = "Could not fetch install time. "
            com.appsflyer.AFLogger.AFInAppEventType(r0, r11)
        La1:
            java.lang.String r11 = "af_deeplink"
            boolean r11 = r12.containsKey(r11)
            if (r11 == 0) goto Lb6
            java.lang.String r11 = "af_status"
            boolean r0 = r12.containsKey(r11)
            if (r0 != 0) goto Lb6
            java.lang.String r0 = "Non-organic"
            r12.put(r11, r0)
        Lb6:
            boolean r11 = r12.containsKey(r3)
            if (r11 == 0) goto Lbf
            r12.remove(r4)
        Lbf:
            java.lang.String r11 = r13.getPath()
            if (r11 == 0) goto Lca
            java.lang.String r0 = "path"
            r12.put(r0, r11)
        Lca:
            java.lang.String r11 = r13.getScheme()
            if (r11 == 0) goto Ld5
            java.lang.String r0 = "scheme"
            r12.put(r0, r11)
        Ld5:
            java.lang.String r11 = r13.getHost()
            if (r11 == 0) goto Le0
            java.lang.String r13 = "host"
            r12.put(r13, r11)
        Le0:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aa.AFKeystoreWrapper(android.content.Context, java.util.Map, android.net.Uri):java.util.Map");
    }

    public static String values(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException, CertificateException, NoSuchAlgorithmException {
        Signature[] signatureArr = packageManager.getPackageInfo(str, 64).signatures;
        if (signatureArr == null) {
            return null;
        }
        X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()));
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        messageDigest.update(x509Certificate.getEncoded());
        return String.format("%032X", new BigInteger(1, messageDigest.digest()));
    }

    public static long values(Context context, String str) {
        try {
            return Build.VERSION.SDK_INT >= 28 ? context.getPackageManager().getPackageInfo(str, 0).getLongVersionCode() : r1.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.AFInAppEventType(e.getMessage(), e);
            return 0L;
        }
    }

    public static String AFKeystoreWrapper(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            AFLogger.AFInAppEventType(e.getMessage(), e);
            return "";
        }
    }
}
