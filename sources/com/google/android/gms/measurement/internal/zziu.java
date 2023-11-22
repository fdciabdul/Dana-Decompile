package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zziu implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzlc zzc;
    final /* synthetic */ zzjs zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziu(zzjs zzjsVar, zzq zzqVar, boolean z, zzlc zzlcVar) {
        this.zzd = zzjsVar;
        this.zza = zzqVar;
        this.zzb = z;
        this.zzc = zzlcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzee zzeeVar;
        zzjs zzjsVar = this.zzd;
        zzeeVar = zzjsVar.zzb;
        if (zzeeVar == null) {
            zzjsVar.zzs.zzay().zzd().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zzD(zzeeVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzQ();
    }
}
