package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zziq implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzis zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zzis zzisVar, zzik zzikVar, long j) {
        this.zzc = zzisVar;
        this.zza = zzikVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzB(this.zza, false, this.zzb);
        zzis zzisVar = this.zzc;
        zzisVar.zza = null;
        zzisVar.zzs.zzt().zzG(null);
    }
}
