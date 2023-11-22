package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzpb implements zzpa {
    public static final zzia zza;
    public static final zzia zzb;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.collection.enable_session_stitching_token.client.dev", false);
        zzb = zza2.zzf("measurement.collection.enable_session_stitching_token.service", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzpa
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzpa
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpa
    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }
}
