package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzho implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzid zzd;

    public zzho(zzid zzidVar, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zzd = zzidVar;
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzs.zzt().zzw(this.zza, null, this.zzb, this.zzc);
    }
}
