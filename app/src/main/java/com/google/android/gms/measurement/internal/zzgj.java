package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzgj implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgj(zzgq zzgqVar, zzaw zzawVar, zzq zzqVar) {
        this.zzc = zzgqVar;
        this.zza = zzawVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
