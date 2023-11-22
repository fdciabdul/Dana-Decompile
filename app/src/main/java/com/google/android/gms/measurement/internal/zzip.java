package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
public final class zzip implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzis zzb;

    public zzip(zzis zzisVar, long j) {
        this.zzb = zzisVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
