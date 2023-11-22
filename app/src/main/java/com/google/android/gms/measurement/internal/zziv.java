package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zziv implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzjs zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziv(zzjs zzjsVar, AtomicReference atomicReference, zzq zzqVar, boolean z) {
        this.zzd = zzjsVar;
        this.zza = atomicReference;
        this.zzb = zzqVar;
        this.zzc = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzjs zzjsVar;
        zzee zzeeVar;
        synchronized (this.zza) {
            try {
                try {
                    zzjsVar = this.zzd;
                    zzeeVar = zzjsVar.zzb;
                } catch (RemoteException e) {
                    this.zzd.zzs.zzay().zzd().zzb("Failed to get all user properties; remote exception", e);
                    atomicReference = this.zza;
                }
                if (zzeeVar == null) {
                    zzjsVar.zzs.zzay().zzd().zza("Failed to get all user properties; not connected to service");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzeeVar.zze(this.zzb, this.zzc));
                this.zzd.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
