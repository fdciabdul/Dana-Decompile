package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zznr implements zznq {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.client.consent_state_v1", true);
        zzb = zza2.zzf("measurement.client.3p_consent_state_v1", true);
        zzc = zza2.zzf("measurement.service.consent_state_v1_W36", true);
        zzd = zza2.zzd("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override // com.google.android.gms.internal.measurement.zznq
    public final long zza() {
        return ((Long) zzd.zzb()).longValue();
    }
}
