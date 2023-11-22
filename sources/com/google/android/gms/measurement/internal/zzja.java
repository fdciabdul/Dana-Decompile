package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzja implements Runnable {
    final /* synthetic */ zzik zza;
    final /* synthetic */ zzjs zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzja(zzjs zzjsVar, zzik zzikVar) {
        this.zzb = zzjsVar;
        this.zza = zzikVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzee zzeeVar;
        zzjs zzjsVar = this.zzb;
        zzeeVar = zzjsVar.zzb;
        if (zzeeVar == null) {
            zzjsVar.zzs.zzay().zzd().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzik zzikVar = this.zza;
            if (zzikVar == null) {
                zzeeVar.zzq(0L, null, null, zzjsVar.zzs.zzau().getPackageName());
            } else {
                zzeeVar.zzq(zzikVar.zzc, zzikVar.zza, zzikVar.zzb, zzjsVar.zzs.zzau().getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e) {
            this.zzb.zzs.zzay().zzd().zzb("Failed to send current screen to the service", e);
        }
    }
}
