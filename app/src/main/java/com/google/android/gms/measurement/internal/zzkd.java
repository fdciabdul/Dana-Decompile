package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzkd implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzke zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkd(zzke zzkeVar, long j, long j2) {
        this.zzc = zzkeVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkc
            @Override // java.lang.Runnable
            public final void run() {
                zzkd zzkdVar = zzkd.this;
                zzke zzkeVar = zzkdVar.zzc;
                long j = zzkdVar.zza;
                long j2 = zzkdVar.zzb;
                zzkeVar.zza.zzg();
                zzkeVar.zza.zzs.zzay().zzc().zza("Application going to the background");
                zzkeVar.zza.zzs.zzm().zzl.zza(true);
                Bundle bundle = new Bundle();
                if (!zzkeVar.zza.zzs.zzf().zzu()) {
                    zzkeVar.zza.zzb.zzb(j2);
                    zzkeVar.zza.zzb.zzd(false, false, j2);
                }
                zzkeVar.zza.zzs.zzq().zzH("auto", "_ab", j, bundle);
            }
        });
    }
}
