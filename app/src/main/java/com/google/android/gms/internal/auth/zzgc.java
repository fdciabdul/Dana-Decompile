package com.google.android.gms.internal.auth;

/* loaded from: classes7.dex */
final class zzgc {
    private static final zzgb zza;
    private static final zzgb zzb;

    static {
        zzgb zzgbVar;
        try {
            zzgbVar = (zzgb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgbVar = null;
        }
        zza = zzgbVar;
        zzb = new zzgb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgb zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgb zzb() {
        return zzb;
    }
}
