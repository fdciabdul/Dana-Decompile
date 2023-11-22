package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzoj implements zzoi {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;
    public static final zzia zze;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.client.global_params", true);
        zzb = zza2.zzf("measurement.service.global_params_in_payload", true);
        zzc = zza2.zzf("measurement.service.clear_global_params_on_uninstall", true);
        zzd = zza2.zzf("measurement.service.global_params", true);
        zze = zza2.zzd("measurement.id.service.global_params", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoi
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzoi
    public final boolean zzb() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
