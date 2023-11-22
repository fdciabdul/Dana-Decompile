package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzhh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzid zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhh(zzid zzidVar, long j) {
        this.zzb = zzidVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzs.zzm().zzf.zzb(this.zza);
        this.zzb.zzs.zzay().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
