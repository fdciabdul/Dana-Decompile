package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzgk implements Runnable {
    final /* synthetic */ zzaw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzgq zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgk(zzgq zzgqVar, zzaw zzawVar, String str) {
        this.zzc = zzgqVar;
        this.zza = zzawVar;
        this.zzb = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        zzkzVar = this.zzc.zza;
        zzkzVar.zzA();
        zzkzVar2 = this.zzc.zza;
        zzkzVar2.zzF(this.zza, this.zzb);
    }
}
