package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzom implements zzol {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zza2.zzf("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zza2.zzf("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zza2.zzd("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzol
    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
