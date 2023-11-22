package com.appsflyer;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import com.appsflyer.internal.aa;
import com.iap.ac.android.common.utils.security.RSAHelper;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public class AFKeystoreWrapper {
    public KeyStore AFInAppEventParameterName;
    private Context AFKeystoreWrapper;
    public final Object values = new Object();
    public String AFInAppEventType = "";
    public int valueOf = 0;

    public AFKeystoreWrapper(Context context) {
        this.AFKeystoreWrapper = context;
        AFLogger.AFKeystoreWrapper("Initialising KeyStore..");
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.AFInAppEventParameterName = keyStore;
            keyStore.load(null);
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
            AFLogger.AFInAppEventType("Couldn't load keystore instance of type: AndroidKeyStore", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        r1 = r4.split(",");
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r1.length != 3) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002b, code lost:
    
        com.appsflyer.AFLogger.AFKeystoreWrapper("Found a matching AF key with alias:\n".concat(java.lang.String.valueOf(r4)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        r2 = r1[1].trim().split("=");
        r1 = r1[2].trim().split("=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        if (r2.length != 2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0055, code lost:
    
        if (r1.length != 2) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        r7.AFInAppEventType = r2[1].trim();
        r7.valueOf = java.lang.Integer.parseInt(r1[1].trim());
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
    
        r3 = new java.lang.StringBuilder("Couldn't list KeyStore Aliases: ");
        r3.append(r1.getClass().getName());
        com.appsflyer.AFLogger.AFInAppEventType(r3.toString(), r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean AFInAppEventParameterName() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.values
            monitor-enter(r0)
            java.security.KeyStore r1 = r7.AFInAppEventParameterName     // Catch: java.lang.Throwable -> L8c
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L8a
            java.util.Enumeration r1 = r1.aliases()     // Catch: java.lang.Throwable -> L70
        Ld:
            boolean r4 = r1.hasMoreElements()     // Catch: java.lang.Throwable -> L70
            if (r4 == 0) goto L8a
            java.lang.Object r4 = r1.nextElement()     // Catch: java.lang.Throwable -> L70
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L70
            if (r4 == 0) goto Ld
            boolean r5 = values(r4)     // Catch: java.lang.Throwable -> L70
            if (r5 == 0) goto Ld
            java.lang.String r1 = ","
            java.lang.String[] r1 = r4.split(r1)     // Catch: java.lang.Throwable -> L70
            int r5 = r1.length     // Catch: java.lang.Throwable -> L70
            r6 = 3
            if (r5 != r6) goto L8a
            java.lang.String r5 = "Found a matching AF key with alias:\n"
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Throwable -> L70
            java.lang.String r4 = r5.concat(r4)     // Catch: java.lang.Throwable -> L70
            com.appsflyer.AFLogger.AFKeystoreWrapper(r4)     // Catch: java.lang.Throwable -> L70
            r2 = r1[r3]     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r4 = "="
            java.lang.String[] r2 = r2.split(r4)     // Catch: java.lang.Throwable -> L6d
            r4 = 2
            r1 = r1[r4]     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r5 = "="
            java.lang.String[] r1 = r1.split(r5)     // Catch: java.lang.Throwable -> L6d
            int r5 = r2.length     // Catch: java.lang.Throwable -> L6d
            if (r5 != r4) goto L6b
            int r5 = r1.length     // Catch: java.lang.Throwable -> L6d
            if (r5 != r4) goto L6b
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L6d
            r7.AFInAppEventType = r2     // Catch: java.lang.Throwable -> L6d
            r1 = r1[r3]     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Throwable -> L6d
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L6d
            r7.valueOf = r1     // Catch: java.lang.Throwable -> L6d
        L6b:
            r2 = 1
            goto L8a
        L6d:
            r1 = move-exception
            r2 = 1
            goto L71
        L70:
            r1 = move-exception
        L71:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = "Couldn't list KeyStore Aliases: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L8c
            java.lang.Class r4 = r1.getClass()     // Catch: java.lang.Throwable -> L8c
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L8c
            r3.append(r4)     // Catch: java.lang.Throwable -> L8c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L8c
            com.appsflyer.AFLogger.AFInAppEventType(r3, r1)     // Catch: java.lang.Throwable -> L8c
        L8a:
            monitor-exit(r0)
            return r2
        L8c:
            r1 = move-exception
            monitor-exit(r0)
            goto L90
        L8f:
            throw r1
        L90:
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AFKeystoreWrapper.AFInAppEventParameterName():boolean");
    }

    public final void AFInAppEventType(String str) {
        AFLogger.AFKeystoreWrapper("Creating a new key with alias: ".concat(String.valueOf(str)));
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 5);
            synchronized (this.values) {
                if (!this.AFInAppEventParameterName.containsAlias(str)) {
                    AlgorithmParameterSpec algorithmParameterSpec = null;
                    if (Build.VERSION.SDK_INT >= 23) {
                        algorithmParameterSpec = new KeyGenParameterSpec.Builder(str, 3).setCertificateSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setCertificateSerialNumber(BigInteger.ONE).setCertificateNotBefore(calendar.getTime()).setCertificateNotAfter(calendar2.getTime()).build();
                    } else if (Build.VERSION.SDK_INT >= 18 && !aa.values()) {
                        algorithmParameterSpec = new KeyPairGeneratorSpec.Builder(this.AFKeystoreWrapper).setAlias(str).setSubject(new X500Principal("CN=AndroidSDK, O=AppsFlyer")).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    }
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(RSAHelper.DEFAULT_ALGORITHM, "AndroidKeyStore");
                    keyPairGenerator.initialize(algorithmParameterSpec);
                    keyPairGenerator.generateKeyPair();
                } else {
                    AFLogger.AFKeystoreWrapper("Alias already exists: ".concat(String.valueOf(str)));
                }
            }
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("Exception ");
            sb.append(th.getMessage());
            sb.append(" occurred");
            AFLogger.AFInAppEventType(sb.toString(), th);
        }
    }

    private static boolean values(String str) {
        return str.startsWith("com.appsflyer");
    }

    public final String AFInAppEventType() {
        StringBuilder sb = new StringBuilder();
        sb.append("com.appsflyer,");
        synchronized (this.values) {
            sb.append("KSAppsFlyerId=");
            sb.append(this.AFInAppEventType);
            sb.append(",");
            sb.append("KSAppsFlyerRICounter=");
            sb.append(this.valueOf);
        }
        return sb.toString();
    }

    public final String values() {
        String str;
        synchronized (this.values) {
            str = this.AFInAppEventType;
        }
        return str;
    }

    public final int valueOf() {
        int i;
        synchronized (this.values) {
            i = this.valueOf;
        }
        return i;
    }
}
