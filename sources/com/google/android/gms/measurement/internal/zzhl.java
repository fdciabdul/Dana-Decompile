package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzhl implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzid zzb;

    public zzhl(zzid zzidVar, long j) {
        this.zzb = zzidVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzL(this.zza, true);
        this.zzb.zzs.zzt().zzu(new AtomicReference());
    }
}
