package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzfd extends zzgs {
    static final Pair zza = new Pair("", 0L);
    public zzfb zzb;
    public final zzez zzc;
    public final zzez zzd;
    public final zzfc zze;
    public final zzez zzf;
    public final zzex zzg;
    public final zzfc zzh;
    public final zzex zzi;
    public final zzez zzj;
    public boolean zzk;
    public final zzex zzl;
    public final zzex zzm;
    public final zzez zzn;
    public final zzfc zzo;
    public final zzfc zzp;
    public final zzez zzq;
    public final zzey zzr;
    private SharedPreferences zzt;
    private String zzu;
    private boolean zzv;
    private long zzw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfd(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzf = new zzez(this, "session_timeout", 1800000L);
        this.zzg = new zzex(this, "start_new_session", true);
        this.zzj = new zzez(this, "last_pause_time", 0L);
        this.zzh = new zzfc(this, "non_personalized_ads", null);
        this.zzi = new zzex(this, "allow_remote_dynamite", false);
        this.zzc = new zzez(this, "first_open_time", 0L);
        this.zzd = new zzez(this, "app_install_time", 0L);
        this.zze = new zzfc(this, "app_instance_id", null);
        this.zzl = new zzex(this, "app_backgrounded", false);
        this.zzm = new zzex(this, "deep_link_retrieval_complete", false);
        this.zzn = new zzez(this, "deep_link_retrieval_attempts", 0L);
        this.zzo = new zzfc(this, "firebase_feature_rollouts", null);
        this.zzp = new zzfc(this, "deferred_attribution_cache", null);
        this.zzq = new zzez(this, "deferred_attribution_cache_timestamp", 0L);
        this.zzr = new zzey(this, "default_event_parameters", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final SharedPreferences zza() {
        zzg();
        zzu();
        Preconditions.checkNotNull(this.zzt);
        return this.zzt;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    protected final void zzaA() {
        SharedPreferences sharedPreferences = this.zzs.zzau().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzt = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzk = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzt.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzs.zzf();
        this.zzb = new zzfb(this, "health_monitor", Math.max(0L, ((Long) zzeb.zzb.zza(null)).longValue()), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair zzb(String str) {
        zzg();
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        String str2 = this.zzu;
        if (str2 == null || elapsedRealtime >= this.zzw) {
            this.zzw = elapsedRealtime + this.zzs.zzf().zzi(str, zzeb.zza);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzs.zzau());
                this.zzu = "";
                String id2 = advertisingIdInfo.getId();
                if (id2 != null) {
                    this.zzu = id2;
                }
                this.zzv = advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (Exception e) {
                this.zzs.zzay().zzc().zzb("Unable to get advertising id", e);
                this.zzu = "";
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(this.zzu, Boolean.valueOf(this.zzv));
        }
        return new Pair(str2, Boolean.valueOf(this.zzv));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzai zzc() {
        zzg();
        return zzai.zzb(zza().getString("consent_settings", "G1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    protected final boolean zzf() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzi(boolean z) {
        zzg();
        this.zzs.zzay().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzj() {
        SharedPreferences sharedPreferences = this.zzt;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzk(long j) {
        return j - this.zzf.zza() > this.zzj.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzl(int i) {
        return zzai.zzj(i, zza().getInt("consent_source", 100));
    }
}
