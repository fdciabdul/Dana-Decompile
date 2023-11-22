package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzos implements zzor {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;
    public static final zzia zze;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.test.boolean_flag", false);
        zzb = zza2.zzc("measurement.test.double_flag", -3.0d);
        zzc = zza2.zzd("measurement.test.int_flag", -2L);
        zzd = zza2.zzd("measurement.test.long_flag", -1L);
        zze = zza2.zze("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final double zza() {
        return ((Double) zzb.zzb()).doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final long zzb() {
        return ((Long) zzc.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final long zzc() {
        return ((Long) zzd.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final String zzd() {
        return (String) zze.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzor
    public final boolean zze() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
