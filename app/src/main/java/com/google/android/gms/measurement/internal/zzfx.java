package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzfx implements Runnable {
    final /* synthetic */ zzhb zza;
    final /* synthetic */ zzfy zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfx(zzfy zzfyVar, zzhb zzhbVar) {
        this.zzb = zzfyVar;
        this.zza = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfy.zzA(this.zzb, this.zza);
        this.zzb.zzH(this.zza.zzg);
    }
}
