package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
final class zzjz implements zzlj {
    private static final zzjz zza = new zzjz();

    private zzjz() {
    }

    public static zzjz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzli zzb(Class cls) {
        if (!zzke.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzli) zzke.zzbz(cls.asSubclass(zzke.class)).zzl(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzc(Class cls) {
        return zzke.class.isAssignableFrom(cls);
    }
}
