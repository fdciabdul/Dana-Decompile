package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzhv implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzid zzb;

    public zzhv(zzid zzidVar, AtomicReference atomicReference) {
        this.zzb = zzidVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Double.valueOf(this.zzb.zzs.zzf().zza(this.zzb.zzs.zzh().zzl(), zzeb.zzN)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
