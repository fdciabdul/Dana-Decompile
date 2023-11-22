package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzop implements zzoo {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzd("measurement.id.lifecycle.app_in_background_parameter", 0L);
        zzb = zza2.zzf("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zza2.zzf("measurement.lifecycle.app_in_background_parameter", false);
        zzd = zza2.zzd("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
