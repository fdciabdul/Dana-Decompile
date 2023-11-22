package com.google.android.gms.auth;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzh implements zzk {
    final /* synthetic */ String zza;
    final /* synthetic */ Bundle zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.auth.zzl.zzd(java.lang.Object):java.lang.Object
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    @Override // com.google.android.gms.auth.zzk
    public final /* synthetic */ java.lang.Object zza(android.os.IBinder r3) throws android.os.RemoteException, java.io.IOException, com.google.android.gms.auth.GoogleAuthException {
        /*
            r2 = this;
            com.google.android.gms.internal.auth.zzf r3 = com.google.android.gms.internal.auth.zze.zzb(r3)
            java.lang.String r0 = r2.zza
            android.os.Bundle r1 = r2.zzb
            android.os.Bundle r3 = r3.zzd(r0, r1)
            com.google.android.gms.auth.zzl.zzd(r3)
            java.lang.String r0 = "Error"
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "booleanResult"
            boolean r3 = r3.getBoolean(r1)
            if (r3 == 0) goto L1f
            r3 = 0
            return r3
        L1f:
            com.google.android.gms.auth.GoogleAuthException r3 = new com.google.android.gms.auth.GoogleAuthException
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzh.zza(android.os.IBinder):java.lang.Object");
    }
}
