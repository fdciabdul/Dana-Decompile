package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes7.dex */
final class zzgh implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzgq zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgh(zzgq zzgqVar, zzq zzqVar) {
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
        zzq zzqVar = this.zza;
        zzkzVar2.zzaz().zzg();
        zzkzVar2.zzB();
        Preconditions.checkNotEmpty(zzqVar.zza);
        zzkzVar2.zzd(zzqVar);
    }
}
