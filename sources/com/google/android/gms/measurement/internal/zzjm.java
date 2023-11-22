package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzjm implements Runnable {
    final /* synthetic */ zzee zza;
    final /* synthetic */ zzjr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjm(zzjr zzjrVar, zzee zzeeVar) {
        this.zzb = zzjrVar;
        this.zza = zzeeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzay().zzj().zza("Connected to service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
