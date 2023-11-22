package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.alibaba.griver.base.common.utils.FileCache;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.google.android.gms.internal.measurement.zzng;
import com.google.android.gms.internal.measurement.zznj;
import com.google.android.gms.internal.measurement.zznm;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zzns;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzny;
import com.google.android.gms.internal.measurement.zzob;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzok;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzoq;
import com.google.android.gms.internal.measurement.zzot;
import com.google.android.gms.internal.measurement.zzow;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.internal.measurement.zzpc;
import com.google.android.gms.internal.measurement.zzpf;
import com.google.android.gms.internal.measurement.zzpi;
import com.google.android.gms.internal.measurement.zzpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes7.dex */
public final class zzeb {
    public static final zzea zzA;
    public static final zzea zzB;
    public static final zzea zzC;
    public static final zzea zzD;
    public static final zzea zzE;
    public static final zzea zzF;
    public static final zzea zzG;
    public static final zzea zzH;
    public static final zzea zzI;
    public static final zzea zzJ;
    public static final zzea zzK;
    public static final zzea zzL;
    public static final zzea zzM;
    public static final zzea zzN;
    public static final zzea zzO;
    public static final zzea zzP;
    public static final zzea zzQ;
    public static final zzea zzR;
    public static final zzea zzS;
    public static final zzea zzT;
    public static final zzea zzU;
    public static final zzea zzV;
    public static final zzea zzW;
    public static final zzea zzX;
    public static final zzea zzY;
    public static final zzea zzZ;
    public static final zzea zzaA;
    public static final zzea zzaB;
    public static final zzea zzaa;
    public static final zzea zzab;
    public static final zzea zzac;
    public static final zzea zzad;
    public static final zzea zzae;
    public static final zzea zzaf;
    public static final zzea zzag;
    public static final zzea zzah;
    public static final zzea zzai;
    public static final zzea zzaj;
    public static final zzea zzak;
    public static final zzea zzal;
    public static final zzea zzam;
    public static final zzea zzan;
    public static final zzea zzao;
    public static final zzea zzap;
    public static final zzea zzaq;
    public static final zzea zzar;
    public static final zzea zzas;
    public static final zzea zzat;
    public static final zzea zzau;
    public static final zzea zzav;
    public static final zzea zzaw;
    public static final zzea zzax;
    public static final zzea zzay;
    public static final zzea zzaz;
    public static final zzea zzl;
    public static final zzea zzm;
    public static final zzea zzn;
    public static final zzea zzo;
    public static final zzea zzp;
    public static final zzea zzq;
    public static final zzea zzr;
    public static final zzea zzs;
    public static final zzea zzt;
    public static final zzea zzu;
    public static final zzea zzv;
    public static final zzea zzw;
    public static final zzea zzx;
    public static final zzea zzy;
    public static final zzea zzz;
    private static final List zzaC = Collections.synchronizedList(new ArrayList());
    private static final Set zzaD = Collections.synchronizedSet(new HashSet());
    public static final zzea zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbj
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Long.valueOf(zznm.zzb());
        }
    });
    public static final zzea zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbb
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Long.valueOf(zznm.zzl());
        }
    });
    public static final zzea zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbn
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Long.valueOf(zznm.zzd());
        }
    });
    public static final zzea zzd = zza("measurement.config.url_scheme", "https", "https", new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbz
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return zznm.zzK();
        }
    });
    public static final zzea zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcl
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return zznm.zzJ();
        }
    });
    public static final zzea zzf = zza("measurement.upload.max_bundles", 100, 100, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcx
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Integer.valueOf((int) zznm.zzw());
        }
    });
    public static final zzea zzg = zza("measurement.upload.max_batch_size", 65536, 65536, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdj
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Integer.valueOf((int) zznm.zzE());
        }
    });
    public static final zzea zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdr
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Integer.valueOf((int) zznm.zzv());
        }
    });
    public static final zzea zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzds
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Integer.valueOf((int) zznm.zzz());
        }
    });
    public static final zzea zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdt
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Integer.valueOf((int) zznm.zzA());
        }
    });
    public static final zzea zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbu
        @Override // com.google.android.gms.measurement.internal.zzdx
        public final Object zza() {
            zzea zzeaVar = zzeb.zza;
            return Integer.valueOf((int) zznm.zzy());
        }
    });

    static {
        Integer valueOf = Integer.valueOf((int) SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH);
        zzl = zza("measurement.upload.max_public_events_per_day", valueOf, valueOf, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcf
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzB());
            }
        });
        zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcq
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzx());
            }
        });
        zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdb
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzD());
            }
        });
        zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdm
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzg());
            }
        });
        zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return zznm.zzL();
            }
        });
        zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdv
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzs());
            }
        });
        zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzH());
            }
        });
        zzs = zza("measurement.upload.interval", 3600000L, 3600000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzaz
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzu());
            }
        });
        zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzba
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzm());
            }
        });
        zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbc
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zze());
            }
        });
        zzv = zza("measurement.upload.minimum_delay", 500L, 500L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbd
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzk());
            }
        });
        zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbe
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzj());
            }
        });
        zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbf
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzp());
            }
        });
        Long valueOf2 = Long.valueOf((long) FileCache.EXPIRE_TIME);
        zzy = zza("measurement.upload.refresh_blacklisted_config_interval", valueOf2, valueOf2, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbg
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzn());
            }
        });
        zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbh
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzt());
            }
        });
        zzA = zza("measurement.upload.retry_time", 1800000L, 1800000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbi
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzG());
            }
        });
        zzB = zza("measurement.upload.retry_count", 6, 6, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbk
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzF());
            }
        });
        zzC = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbl
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzC());
            }
        });
        zzD = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbm
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzf());
            }
        });
        zzE = zza("measurement.audience.filter_result_max_count", 200, 200, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbo
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzi());
            }
        });
        zzF = zza("measurement.upload.max_public_user_properties", 25, 25, null);
        zzG = zza("measurement.upload.max_event_name_cardinality", 500, 500, null);
        zzH = zza("measurement.upload.max_public_event_params", 25, 25, null);
        Long valueOf3 = Long.valueOf((long) RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
        zzI = zza("measurement.service_client.idle_disconnect_millis", valueOf3, valueOf3, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzo());
            }
        });
        zzJ = zza("measurement.test.boolean_flag", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzoq.zzg());
            }
        });
        zzK = zza("measurement.test.string_flag", "---", "---", new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return zzoq.zzf();
            }
        });
        zzL = zza("measurement.test.long_flag", -1L, -1L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zzoq.zzd());
            }
        });
        zzM = zza("measurement.test.int_flag", -2, -2, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zzoq.zzc());
            }
        });
        Double valueOf4 = Double.valueOf(-3.0d);
        zzN = zza("measurement.test.double_flag", valueOf4, valueOf4, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Double.valueOf(zzoq.zzb());
            }
        });
        zzO = zza("measurement.experiment.max_ids", 50, 50, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzh());
            }
        });
        zzP = zza("measurement.max_bundles_per_iteration", 100, 100, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznm.zzc());
            }
        });
        zzQ = zza("measurement.sdk.attribution.cache.ttl", valueOf2, valueOf2, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzq());
            }
        });
        zzR = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Long.valueOf(zznm.zzr());
            }
        });
        zzS = zza("measurement.collection.log_event_and_bundle_v2", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzot.zzc());
            }
        });
        zzT = zza("measurement.quality.checksum", false, false, null);
        zzU = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzny.zze());
            }
        });
        zzV = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzny.zzd());
            }
        });
        zzW = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzny.zzf());
            }
        });
        zzX = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzpi.zzc());
            }
        });
        zzY = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzok.zzc());
            }
        });
        zzZ = zza("measurement.lifecycle.app_in_background_parameter", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzon.zzc());
            }
        });
        zzaa = zza("measurement.integration.disable_firebase_instance_id", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzpf.zzd());
            }
        });
        zzab = zza("measurement.collection.service.update_with_analytics_fix", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzpl.zzc());
            }
        });
        zzac = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zznv.zzd());
            }
        });
        zzad = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzoe.zzd());
            }
        });
        zzae = zza("measurement.collection.synthetic_data_mitigation", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzpc.zzc());
            }
        });
        zzaf = zza("measurement.service.storage_consent_support_version", 203600, 203600, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Integer.valueOf((int) zznp.zzb());
            }
        });
        zzag = zza("measurement.client.click_identifier_control.dev", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzng.zzc());
            }
        });
        zzah = zza("measurement.service.click_identifier_control", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zznj.zzc());
            }
        });
        zzai = zza("measurement.service.store_null_safelist", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzns.zzd());
            }
        });
        zzaj = zza("measurement.service.store_safelist", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzns.zze());
            }
        });
        zzak = zza("measurement.redaction.no_aiid_in_config_request", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzl());
            }
        });
        zzal = zza("measurement.redaction.config_redacted_fields", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzf());
            }
        });
        zzam = zza("measurement.redaction.upload_redacted_fields", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzo());
            }
        });
        zzan = zza("measurement.redaction.upload_subdomain_override", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzp());
            }
        });
        zzao = zza("measurement.redaction.device_info", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzg());
            }
        });
        zzap = zza("measurement.redaction.user_id", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzq());
            }
        });
        zzaq = zza("measurement.redaction.google_signals", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzk());
            }
        });
        zzar = zza("measurement.collection.enable_session_stitching_token.service", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzoz.zze());
            }
        });
        zzas = zza("measurement.collection.enable_session_stitching_token.client.dev", false, false, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzoz.zzd());
            }
        });
        zzat = zza("measurement.redaction.app_instance_id", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzd());
            }
        });
        zzau = zza("measurement.redaction.populate_ephemeral_app_instance_id", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzj());
            }
        });
        zzav = zza("measurement.redaction.enhanced_uid", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzi());
            }
        });
        zzaw = zza("measurement.redaction.e_tag", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzh());
            }
        });
        zzax = zza("measurement.redaction.client_ephemeral_aiid_generation", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zze());
            }
        });
        zzay = zza("measurement.redaction.retain_major_os_version", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzm());
            }
        });
        zzaz = zza("measurement.redaction.scion_payload_generator", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzow.zzn());
            }
        });
        zzaA = zza("measurement.audience.dynamic_filters.oob_fix", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzob.zzd());
            }
        });
        zzaB = zza("measurement.service.clear_global_params_on_uninstall", true, true, new zzdx() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // com.google.android.gms.measurement.internal.zzdx
            public final Object zza() {
                zzea zzeaVar = zzeb.zza;
                return Boolean.valueOf(zzoh.zzd());
            }
        });
    }

    static zzea zza(String str, Object obj, Object obj2, zzdx zzdxVar) {
        zzea zzeaVar = new zzea(str, obj, obj2, zzdxVar, null);
        zzaC.add(zzeaVar);
        return zzeaVar;
    }

    public static Map zzc(Context context) {
        com.google.android.gms.internal.measurement.zzhe zza2 = com.google.android.gms.internal.measurement.zzhe.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzhp.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzay
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.internal.measurement.zzia.zzd();
            }
        });
        return zza2 == null ? Collections.emptyMap() : zza2.zzc();
    }
}
