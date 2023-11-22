package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzoy implements zzox {
    public static final zzia zza;
    public static final zzia zzb;
    public static final zzia zzc;
    public static final zzia zzd;
    public static final zzia zze;
    public static final zzia zzf;
    public static final zzia zzg;
    public static final zzia zzh;
    public static final zzia zzi;
    public static final zzia zzj;
    public static final zzia zzk;
    public static final zzia zzl;
    public static final zzia zzm;
    public static final zzia zzn;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.redaction.app_instance_id", true);
        zzb = zza2.zzf("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzc = zza2.zzf("measurement.redaction.config_redacted_fields", true);
        zzd = zza2.zzf("measurement.redaction.device_info", true);
        zze = zza2.zzf("measurement.redaction.e_tag", true);
        zzf = zza2.zzf("measurement.redaction.enhanced_uid", true);
        zzg = zza2.zzf("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzh = zza2.zzf("measurement.redaction.google_signals", true);
        zzi = zza2.zzf("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zza2.zzf("measurement.redaction.retain_major_os_version", true);
        zzk = zza2.zzf("measurement.redaction.scion_payload_generator", true);
        zzl = zza2.zzf("measurement.redaction.upload_redacted_fields", true);
        zzm = zza2.zzf("measurement.redaction.upload_subdomain_override", true);
        zzn = zza2.zzf("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzd() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zze() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzf() {
        return ((Boolean) zze.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzg() {
        return ((Boolean) zzf.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzh() {
        return ((Boolean) zzg.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzi() {
        return ((Boolean) zzh.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzj() {
        return ((Boolean) zzi.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzk() {
        return ((Boolean) zzj.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzl() {
        return ((Boolean) zzk.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzm() {
        return ((Boolean) zzl.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzn() {
        return ((Boolean) zzm.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzox
    public final boolean zzo() {
        return ((Boolean) zzn.zzb()).booleanValue();
    }
}
