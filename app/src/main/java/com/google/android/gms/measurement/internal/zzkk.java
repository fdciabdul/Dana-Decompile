package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzkk extends zzap {
    final /* synthetic */ zzkl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkk(zzkl zzklVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzklVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzap
    public final void zzc() {
        this.zza.zza();
        this.zza.zzs.zzay().zzj().zza("Starting upload from DelayedRunnable");
        this.zza.zzf.zzX();
    }
}
