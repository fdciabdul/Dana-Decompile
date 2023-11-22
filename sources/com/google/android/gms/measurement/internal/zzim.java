package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzim implements Runnable {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzik zzb;
    final /* synthetic */ zzik zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzis zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzim(zzis zzisVar, Bundle bundle, zzik zzikVar, zzik zzikVar2, long j) {
        this.zze = zzisVar;
        this.zza = bundle;
        this.zzb = zzikVar;
        this.zzc = zzikVar2;
        this.zzd = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzis.zzp(this.zze, this.zza, this.zzb, this.zzc, this.zzd);
    }
}
