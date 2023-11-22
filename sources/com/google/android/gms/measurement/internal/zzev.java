package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzev implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzew zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzev(zzew zzewVar, boolean z) {
        this.zzb = zzewVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkz zzkzVar;
        zzkzVar = this.zzb.zzb;
        zzkzVar.zzJ(this.zza);
    }
}
