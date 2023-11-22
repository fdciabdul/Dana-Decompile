package com.google.android.gms.internal.auth;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class zzfk {
    private static final zzfk zza;
    private static final zzfk zzb;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.auth.zzff, com.google.android.gms.internal.auth.zzfh] */
    static {
        ?? r1 = 0;
        zza = new zzfg(r1);
        zzb = new zzfi(r1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfk(zzfj zzfjVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfk zzc() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfk zzd() {
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zza(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzb(Object obj, Object obj2, long j);
}
