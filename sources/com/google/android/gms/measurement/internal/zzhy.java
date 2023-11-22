package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzhy implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzai zze;
    final /* synthetic */ zzid zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhy(zzid zzidVar, zzai zzaiVar, int i, long j, boolean z, zzai zzaiVar2) {
        this.zzf = zzidVar;
        this.zza = zzaiVar;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
        this.zze = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zzV(this.zza);
        zzid.zzw(this.zzf, this.zza, this.zzb, this.zzc, false, this.zzd);
        zzoz.zzc();
        if (this.zzf.zzs.zzf().zzs(null, zzeb.zzas)) {
            zzid.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
