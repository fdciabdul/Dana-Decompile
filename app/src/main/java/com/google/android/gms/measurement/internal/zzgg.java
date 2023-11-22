package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzgg implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzgq zzgqVar, zzq zzqVar) {
        this.zzb = zzgqVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkzVar = this.zzb.zza;
        zzkzVar.zzA();
        zzkzVar2 = this.zzb.zza;
        zzkzVar2.zzQ(this.zza);
    }
}
