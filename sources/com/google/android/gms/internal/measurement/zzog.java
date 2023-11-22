package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzog implements zzof {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zza2.zzf("measurement.client.sessions.check_on_startup", true);
        zzc = zza2.zzf("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzof
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
