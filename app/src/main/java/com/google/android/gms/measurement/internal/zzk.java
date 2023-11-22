package com.google.android.gms.measurement.internal;

/* loaded from: classes7.dex */
final class zzk implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcf zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ AppMeasurementDynamiteService zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcf zzcfVar, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzcfVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza.zzt().zzy(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
