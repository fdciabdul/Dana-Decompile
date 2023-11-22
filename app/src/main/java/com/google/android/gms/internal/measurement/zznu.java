package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zznu implements zznt {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.event_safelist", true);
        zzb = zza2.zzf("measurement.service.store_null_safelist", true);
        zzc = zza2.zzf("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznt
    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
