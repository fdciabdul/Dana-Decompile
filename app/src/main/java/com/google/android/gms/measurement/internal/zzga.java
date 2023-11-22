package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzga implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(zzgq zzgqVar, zzac zzacVar, zzq zzqVar) {
        this.zzc = zzgqVar;
        this.zza = zzacVar;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkz zzkzVar3;
        zzkzVar = this.zzc.zza;
        zzkzVar.zzA();
        if (this.zza.zzc.zza() == null) {
            zzkzVar3 = this.zzc.zza;
            zzkzVar3.zzO(this.zza, this.zzb);
            return;
        }
        zzkzVar2 = this.zzc.zza;
        zzkzVar2.zzU(this.zza, this.zzb);
    }
}
