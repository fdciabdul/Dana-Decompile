package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzjh implements Runnable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzaw zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzjs zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjh(zzjs zzjsVar, boolean z, zzq zzqVar, boolean z2, zzaw zzawVar, String str) {
        this.zze = zzjsVar;
        this.zza = zzqVar;
        this.zzb = z2;
        this.zzc = zzawVar;
        this.zzd = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzee zzeeVar;
        zzjs zzjsVar = this.zze;
        zzeeVar = zzjsVar.zzb;
        if (zzeeVar == null) {
            zzjsVar.zzs.zzay().zzd().zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zze.zzD(zzeeVar, this.zzb ? null : this.zzc, this.zza);
        this.zze.zzQ();
    }
}
