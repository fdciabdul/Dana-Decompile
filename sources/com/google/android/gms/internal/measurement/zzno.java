package com.google.android.gms.internal.measurement;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alibaba.griver.base.common.utils.FileCache;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;

/* loaded from: classes7.dex */
public final class zzno implements zznn {
    public static final zzia zzA;
    public static final zzia zzB;
    public static final zzia zzC;
    public static final zzia zzD;
    public static final zzia zzE;
    public static final zzia zzF;
    public static final zzia zzG;
    public static final zzia zzH;
    public static final zzia zzI;
    public static final zzia zzJ;
    public static final zzia zzK;
    public static final zzia zzL;
    public static final zzia zzM;
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
    public static final zzia zzo;
    public static final zzia zzp;
    public static final zzia zzq;
    public static final zzia zzr;
    public static final zzia zzs;
    public static final zzia zzt;
    public static final zzia zzu;
    public static final zzia zzv;
    public static final zzia zzw;
    public static final zzia zzx;
    public static final zzia zzy;
    public static final zzia zzz;

    static {
        zzhx zza2 = new zzhx(zzhp.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzd("measurement.ad_id_cache_time", 10000L);
        zzb = zza2.zzd("measurement.max_bundles_per_iteration", 100L);
        zzc = zza2.zzd("measurement.config.cache_time", 86400000L);
        zzd = zza2.zze("measurement.log_tag", "FA");
        zze = zza2.zze("measurement.config.url_authority", "app-measurement.com");
        zzf = zza2.zze("measurement.config.url_scheme", "https");
        zzg = zza2.zzd("measurement.upload.debug_upload_interval", 1000L);
        zzh = zza2.zzd("measurement.lifetimevalue.max_currency_tracked", 4L);
        zzi = zza2.zzd("measurement.store.max_stored_events_per_app", 100000L);
        zzj = zza2.zzd("measurement.experiment.max_ids", 50L);
        zzk = zza2.zzd("measurement.audience.filter_result_max_count", 200L);
        zzl = zza2.zzd("measurement.alarm_manager.minimum_interval", 60000L);
        zzm = zza2.zzd("measurement.upload.minimum_delay", 500L);
        zzn = zza2.zzd("measurement.monitoring.sample_period_millis", 86400000L);
        zzo = zza2.zzd("measurement.upload.realtime_upload_interval", 10000L);
        zzp = zza2.zzd("measurement.upload.refresh_blacklisted_config_interval", FileCache.EXPIRE_TIME);
        zzq = zza2.zzd("measurement.config.cache_time.service", 3600000L);
        zzr = zza2.zzd("measurement.service_client.idle_disconnect_millis", RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
        zzs = zza2.zze("measurement.log_tag.service", "FA-SVC");
        zzt = zza2.zzd("measurement.upload.stale_data_deletion_interval", 86400000L);
        zzu = zza2.zzd("measurement.sdk.attribution.cache.ttl", FileCache.EXPIRE_TIME);
        zzv = zza2.zzd("measurement.redaction.app_instance_id.ttl", 7200000L);
        zzw = zza2.zzd("measurement.upload.backoff_period", 43200000L);
        zzx = zza2.zzd("measurement.upload.initial_upload_delay_time", 15000L);
        zzy = zza2.zzd("measurement.upload.interval", 3600000L);
        zzz = zza2.zzd("measurement.upload.max_bundle_size", 65536L);
        zzA = zza2.zzd("measurement.upload.max_bundles", 100L);
        zzB = zza2.zzd("measurement.upload.max_conversions_per_day", 500L);
        zzC = zza2.zzd("measurement.upload.max_error_events_per_day", 1000L);
        zzD = zza2.zzd("measurement.upload.max_events_per_bundle", 1000L);
        zzE = zza2.zzd("measurement.upload.max_events_per_day", 100000L);
        zzF = zza2.zzd("measurement.upload.max_public_events_per_day", ARiverTrackWatchDogEventConstant.DURATION_STARTUP_TIMEOUT);
        zzG = zza2.zzd("measurement.upload.max_queue_time", 2419200000L);
        zzH = zza2.zzd("measurement.upload.max_realtime_events_per_day", 10L);
        zzI = zza2.zzd("measurement.upload.max_batch_size", 65536L);
        zzJ = zza2.zzd("measurement.upload.retry_count", 6L);
        zzK = zza2.zzd("measurement.upload.retry_time", 1800000L);
        zzL = zza2.zze("measurement.upload.url", "https://app-measurement.com/a");
        zzM = zza2.zzd("measurement.upload.window_interval", 3600000L);
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzA() {
        return ((Long) zzF.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzB() {
        return ((Long) zzG.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzC() {
        return ((Long) zzH.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzD() {
        return ((Long) zzI.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzE() {
        return ((Long) zzJ.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzF() {
        return ((Long) zzK.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzG() {
        return ((Long) zzM.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final String zzH() {
        return (String) zze.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final String zzI() {
        return (String) zzf.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final String zzJ() {
        return (String) zzL.zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zza() {
        return ((Long) zza.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzb() {
        return ((Long) zzb.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzc() {
        return ((Long) zzc.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzd() {
        return ((Long) zzg.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zze() {
        return ((Long) zzh.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzf() {
        return ((Long) zzi.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzg() {
        return ((Long) zzj.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzh() {
        return ((Long) zzk.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzi() {
        return ((Long) zzl.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzj() {
        return ((Long) zzm.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzk() {
        return ((Long) zzn.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzl() {
        return ((Long) zzo.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzm() {
        return ((Long) zzp.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzn() {
        return ((Long) zzr.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzo() {
        return ((Long) zzt.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzp() {
        return ((Long) zzu.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzq() {
        return ((Long) zzv.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzr() {
        return ((Long) zzw.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzs() {
        return ((Long) zzx.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzt() {
        return ((Long) zzy.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzu() {
        return ((Long) zzz.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzv() {
        return ((Long) zzA.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzw() {
        return ((Long) zzB.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzx() {
        return ((Long) zzC.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzy() {
        return ((Long) zzD.zzb()).longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznn
    public final long zzz() {
        return ((Long) zzE.zzb()).longValue();
    }
}
