package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzoa implements zznz {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zza2.zzf("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zza2.zzf("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zza2.zzf("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznz
    public final boolean zzd() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }
}
