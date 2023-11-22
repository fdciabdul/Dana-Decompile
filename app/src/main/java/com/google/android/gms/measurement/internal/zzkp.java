package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzkp implements Runnable {
    final /* synthetic */ zzla zza;
    final /* synthetic */ zzkz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkp(zzkz zzkzVar, zzla zzlaVar) {
        this.zzb = zzkzVar;
        this.zza = zzlaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}
