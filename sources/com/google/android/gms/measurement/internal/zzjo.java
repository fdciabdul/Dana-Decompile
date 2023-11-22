package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzjo implements Runnable {
    final /* synthetic */ zzee zza;
    final /* synthetic */ zzjr zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjo(zzjr zzjrVar, zzee zzeeVar) {
        this.zzb = zzjrVar;
        this.zza = zzeeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzay().zzc().zza("Connected to remote service");
                this.zzb.zza.zzJ(this.zza);
            }
        }
    }
}
