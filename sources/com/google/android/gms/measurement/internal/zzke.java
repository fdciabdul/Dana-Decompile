package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzke {
    final /* synthetic */ zzki zza;
    private zzkd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(zzki zzkiVar) {
        this.zza = zzkiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j) {
        Handler handler;
        this.zzb = new zzkd(this, this.zza.zzs.zzav().currentTimeMillis(), j);
        handler = this.zza.zzd;
        handler.postDelayed(this.zzb, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb() {
        Handler handler;
        this.zza.zzg();
        zzkd zzkdVar = this.zzb;
        if (zzkdVar != null) {
            handler = this.zza.zzd;
            handler.removeCallbacks(zzkdVar);
        }
        this.zza.zzs.zzm().zzl.zza(false);
    }
}
