package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.os.UserManager;

/* loaded from: classes7.dex */
public final class zzha {
    private static UserManager zza;
    private static volatile boolean zzb = !zzb();

    private zzha() {
    }

    public static boolean zzb() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        if (r4.isUserRunning(android.os.Process.myUserHandle()) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003f, code lost:
    
        r8 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.Context r8) {
        /*
            boolean r0 = zzb()
            r1 = 0
            if (r0 == 0) goto L5e
            boolean r0 = com.google.android.gms.internal.measurement.zzha.zzb
            if (r0 == 0) goto Lc
            goto L5e
        Lc:
            java.lang.Class<com.google.android.gms.internal.measurement.zzha> r0 = com.google.android.gms.internal.measurement.zzha.class
            monitor-enter(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzha.zzb     // Catch: java.lang.Throwable -> L5b
            if (r2 == 0) goto L15
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
            goto L5e
        L15:
            r2 = 1
            r3 = 1
        L17:
            r4 = 2
            r5 = 0
            if (r3 > r4) goto L4e
            android.os.UserManager r4 = com.google.android.gms.internal.measurement.zzha.zza     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L29
            java.lang.Class<android.os.UserManager> r4 = android.os.UserManager.class
            java.lang.Object r4 = r8.getSystemService(r4)     // Catch: java.lang.Throwable -> L5b
            android.os.UserManager r4 = (android.os.UserManager) r4     // Catch: java.lang.Throwable -> L5b
            com.google.android.gms.internal.measurement.zzha.zza = r4     // Catch: java.lang.Throwable -> L5b
        L29:
            android.os.UserManager r4 = com.google.android.gms.internal.measurement.zzha.zza     // Catch: java.lang.Throwable -> L5b
            if (r4 != 0) goto L2f
            r8 = 1
            goto L53
        L2f:
            boolean r6 = r4.isUserUnlocked()     // Catch: java.lang.NullPointerException -> L41 java.lang.Throwable -> L5b
            if (r6 != 0) goto L3f
            android.os.UserHandle r6 = android.os.Process.myUserHandle()     // Catch: java.lang.NullPointerException -> L41 java.lang.Throwable -> L5b
            boolean r8 = r4.isUserRunning(r6)     // Catch: java.lang.NullPointerException -> L41 java.lang.Throwable -> L5b
            if (r8 != 0) goto L4e
        L3f:
            r8 = 1
            goto L4f
        L41:
            r4 = move-exception
            java.lang.String r6 = "DirectBootUtils"
            java.lang.String r7 = "Failed to check if user is unlocked."
            com.fullstory.instrumentation.InstrumentInjector.log_w(r6, r7, r4)     // Catch: java.lang.Throwable -> L5b
            com.google.android.gms.internal.measurement.zzha.zza = r5     // Catch: java.lang.Throwable -> L5b
            int r3 = r3 + 1
            goto L17
        L4e:
            r8 = 0
        L4f:
            if (r8 == 0) goto L53
            com.google.android.gms.internal.measurement.zzha.zza = r5     // Catch: java.lang.Throwable -> L5b
        L53:
            if (r8 == 0) goto L57
            com.google.android.gms.internal.measurement.zzha.zzb = r2     // Catch: java.lang.Throwable -> L5b
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
            if (r8 != 0) goto L5e
            return r2
        L5b:
            r8 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L5b
            throw r8
        L5e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzha.zza(android.content.Context):boolean");
    }
}
