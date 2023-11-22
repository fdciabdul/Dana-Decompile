package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzhw implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzid zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhw(zzid zzidVar, Boolean bool) {
        this.zzb = zzidVar;
        this.zza = bool;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzaa(this.zza, true);
    }
}
