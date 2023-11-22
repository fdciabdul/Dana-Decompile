package com.google.android.gms.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzi implements zzk {
    final /* synthetic */ AccountChangeEventsRequest zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(AccountChangeEventsRequest accountChangeEventsRequest) {
        this.zza = accountChangeEventsRequest;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.android.gms.auth.zzl.zzd(java.lang.Object):java.lang.Object
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.NullPointerException
        */
    @Override // com.google.android.gms.auth.zzk
    public final /* synthetic */ java.lang.Object zza(android.os.IBinder r2) throws android.os.RemoteException, java.io.IOException, com.google.android.gms.auth.GoogleAuthException {
        /*
            r1 = this;
            com.google.android.gms.internal.auth.zzf r2 = com.google.android.gms.internal.auth.zze.zzb(r2)
            com.google.android.gms.auth.AccountChangeEventsRequest r0 = r1.zza
            com.google.android.gms.auth.AccountChangeEventsResponse r2 = r2.zzh(r0)
            com.google.android.gms.auth.zzl.zzd(r2)
            java.util.List r2 = r2.getEvents()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.zzi.zza(android.os.IBinder):java.lang.Object");
    }
}
