package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzjq implements Runnable {
    final /* synthetic */ zzjr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjq(zzjr zzjrVar) {
        this.zza = zzjrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza.zzb = null;
        this.zza.zza.zzP();
    }
}
