package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzka implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzki zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzka(zzki zzkiVar, long j) {
        this.zzb = zzkiVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzki.zzl(this.zzb, this.zza);
    }
}
