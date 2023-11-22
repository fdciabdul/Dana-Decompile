package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzgp implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzgq zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgp(zzgq zzgqVar, String str, String str2, String str3, long j) {
        this.zze = zzgqVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkz zzkzVar2;
        String str = this.zza;
        if (str == null) {
            zzkzVar2 = this.zze.zza;
            zzkzVar2.zzR(this.zzb, null);
            return;
        }
        zzik zzikVar = new zzik(this.zzc, str, this.zzd);
        zzkzVar = this.zze.zza;
        zzkzVar.zzR(this.zzb, zzikVar);
    }
}
