package com.google.android.gms.internal.auth;

/* loaded from: classes7.dex */
final class zzen {
    private static final zzel zza = new zzem();
    private static final zzel zzb;

    static {
        zzel zzelVar;
        try {
            zzelVar = (zzel) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzelVar = null;
        }
        zzb = zzelVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzel zza() {
        zzel zzelVar = zzb;
        if (zzelVar != null) {
            return zzelVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzel zzb() {
        return zza;
    }
}
