package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
final class zzlr {
    private static final zzlq zza;
    private static final zzlq zzb;

    static {
        zzlq zzlqVar;
        try {
            zzlqVar = (zzlq) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzlqVar = null;
        }
        zza = zzlqVar;
        zzb = new zzlq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlq zza() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzlq zzb() {
        return zzb;
    }
}
