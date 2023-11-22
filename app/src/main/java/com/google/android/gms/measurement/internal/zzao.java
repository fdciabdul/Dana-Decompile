package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzao implements Runnable {
    final /* synthetic */ zzgt zza;
    final /* synthetic */ zzap zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzao(zzap zzapVar, zzgt zzgtVar) {
        this.zzb = zzapVar;
        this.zza = zzgtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzaw();
        if (zzab.zza()) {
            this.zza.zzaz().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0L;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
