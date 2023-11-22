package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzin implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ zzik zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzis zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzis zzisVar, zzik zzikVar, zzik zzikVar2, long j, boolean z) {
        this.zze = zzisVar;
        this.zza = zzikVar;
        this.zzb = zzikVar2;
        this.zzc = j;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
