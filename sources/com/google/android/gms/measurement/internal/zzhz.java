package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzhz implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzid zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhz(zzid zzidVar, boolean z) {
        this.zzb = zzidVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zzJ = this.zzb.zzs.zzJ();
        boolean zzI = this.zzb.zzs.zzI();
        this.zzb.zzs.zzF(this.zza);
        if (zzI == this.zza) {
            this.zzb.zzs.zzay().zzj().zzb("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzs.zzJ() == zzJ || this.zzb.zzs.zzJ() != this.zzb.zzs.zzI()) {
            this.zzb.zzs.zzay().zzl().zzc("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzJ));
        }
        this.zzb.zzab();
    }
}
