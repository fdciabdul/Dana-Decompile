package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class zzkz {
    private static final zzkz zza;
    private static final zzkz zzb;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.measurement.zzkw, com.google.android.gms.internal.measurement.zzku] */
    static {
        ?? r1 = 0;
        zza = new zzkv(r1);
        zzb = new zzkx(r1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkz(zzky zzkyVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkz zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzkz zzd() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, Object obj2, long j);
}
