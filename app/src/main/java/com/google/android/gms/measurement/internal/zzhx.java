package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoz;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzhx implements Runnable {
    final /* synthetic */ zzai zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzai zzf;
    final /* synthetic */ zzid zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhx(zzid zzidVar, zzai zzaiVar, long j, int i, long j2, boolean z, zzai zzaiVar2) {
        this.zzg = zzidVar;
        this.zza = zzaiVar;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
        this.zzf = zzaiVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzg.zzV(this.zza);
        this.zzg.zzL(this.zzb, false);
        zzid.zzw(this.zzg, this.zza, this.zzc, this.zzd, true, this.zze);
        zzoz.zzc();
        if (this.zzg.zzs.zzf().zzs(null, zzeb.zzas)) {
            zzid.zzv(this.zzg, this.zza, this.zzf);
        }
    }
}
