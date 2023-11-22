package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzht implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzid zzb;

    public zzht(zzid zzidVar, AtomicReference atomicReference) {
        this.zzb = zzidVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                this.zza.set(Long.valueOf(this.zzb.zzs.zzf().zzi(this.zzb.zzs.zzh().zzl(), zzeb.zzL)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
