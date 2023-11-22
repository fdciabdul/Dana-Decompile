package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zza implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzd zzdVar, String str, long j) {
        this.zzc = zzdVar;
        this.zza = str;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd.zza(this.zzc, this.zza, this.zzb);
    }
}
