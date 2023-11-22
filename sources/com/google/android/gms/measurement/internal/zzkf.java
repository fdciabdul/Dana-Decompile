package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzkf extends zzap {
    final /* synthetic */ zzkg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkf(zzkg zzkgVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzkgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        zzkg zzkgVar = this.zza;
        zzkgVar.zzc.zzg();
        zzkgVar.zzd(false, false, zzkgVar.zzc.zzs.zzav().elapsedRealtime());
        zzkgVar.zzc.zzs.zzd().zzf(zzkgVar.zzc.zzs.zzav().elapsedRealtime());
    }
}
