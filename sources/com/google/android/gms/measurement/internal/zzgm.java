package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzgm implements Runnable {
    final /* synthetic */ zzlc zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgm(zzgq zzgqVar, zzlc zzlcVar, zzq zzqVar) {
        this.zzc = zzgqVar;
        this.zza = zzlcVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkz zzkzVar3;
        zzkzVar = this.zzc.zza;
        zzkzVar.zzA();
        if (this.zza.zza() == null) {
            zzkzVar3 = this.zzc.zza;
            zzkzVar3.zzP(this.zza, this.zzb);
            return;
        }
        zzkzVar2 = this.zzc.zza;
        zzkzVar2.zzW(this.zza, this.zzb);
    }
}
