package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zznv;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class zzfy implements zzgt {
    private static volatile zzfy zzd;
    private zzef zzA;
    private Boolean zzC;
    private long zzD;
    private volatile Boolean zzE;
    private volatile boolean zzF;
    private int zzG;
    protected Boolean zza;
    protected Boolean zzb;
    final long zzc;
    private final Context zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final boolean zzi;
    private final zzab zzj;
    private final zzag zzk;
    private final zzfd zzl;
    private final zzeo zzm;
    private final zzfv zzn;
    private final zzki zzo;
    private final zzlh zzp;
    private final zzej zzq;
    private final Clock zzr;
    private final zzis zzs;
    private final zzid zzt;
    private final zzd zzu;
    private final zzih zzv;
    private final String zzw;
    private zzeh zzx;
    private zzjs zzy;
    private zzaq zzz;
    private boolean zzB = false;
    private final AtomicInteger zzH = new AtomicInteger(0);

    zzfy(zzhb zzhbVar) {
        long currentTimeMillis;
        Bundle bundle;
        Preconditions.checkNotNull(zzhbVar);
        Context context = zzhbVar.zza;
        zzab zzabVar = new zzab(context);
        this.zzj = zzabVar;
        zzdy.zza = zzabVar;
        this.zze = context;
        this.zzf = zzhbVar.zzb;
        this.zzg = zzhbVar.zzc;
        this.zzh = zzhbVar.zzd;
        this.zzi = zzhbVar.zzh;
        this.zzE = zzhbVar.zze;
        this.zzw = zzhbVar.zzj;
        this.zzF = true;
        com.google.android.gms.internal.measurement.zzcl zzclVar = zzhbVar.zzg;
        if (zzclVar != null && (bundle = zzclVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zza = (Boolean) obj;
            }
            Object obj2 = zzclVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzb = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzia.zze(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzr = defaultClock;
        Long l = zzhbVar.zzi;
        if (l != null) {
            currentTimeMillis = l.longValue();
        } else {
            currentTimeMillis = defaultClock.currentTimeMillis();
        }
        this.zzc = currentTimeMillis;
        this.zzk = new zzag(this);
        zzfd zzfdVar = new zzfd(this);
        zzfdVar.zzv();
        this.zzl = zzfdVar;
        zzeo zzeoVar = new zzeo(this);
        zzeoVar.zzv();
        this.zzm = zzeoVar;
        zzlh zzlhVar = new zzlh(this);
        zzlhVar.zzv();
        this.zzp = zzlhVar;
        this.zzq = new zzej(new zzha(zzhbVar, this));
        this.zzu = new zzd(this);
        zzis zzisVar = new zzis(this);
        zzisVar.zzb();
        this.zzs = zzisVar;
        zzid zzidVar = new zzid(this);
        zzidVar.zzb();
        this.zzt = zzidVar;
        zzki zzkiVar = new zzki(this);
        zzkiVar.zzb();
        this.zzo = zzkiVar;
        zzih zzihVar = new zzih(this);
        zzihVar.zzv();
        this.zzv = zzihVar;
        zzfv zzfvVar = new zzfv(this);
        zzfvVar.zzv();
        this.zzn = zzfvVar;
        com.google.android.gms.internal.measurement.zzcl zzclVar2 = zzhbVar.zzg;
        boolean z = zzclVar2 == null || zzclVar2.zzb == 0;
        if (context.getApplicationContext() instanceof Application) {
            zzid zzq = zzq();
            if (zzq.zzs.zze.getApplicationContext() instanceof Application) {
                Application application = (Application) zzq.zzs.zze.getApplicationContext();
                if (zzq.zza == null) {
                    zzq.zza = new zzic(zzq, null);
                }
                if (z) {
                    application.unregisterActivityLifecycleCallbacks(zzq.zza);
                    application.registerActivityLifecycleCallbacks(zzq.zza);
                    zzq.zzs.zzay().zzj().zza("Registered activity lifecycle callback");
                }
            }
        } else {
            zzay().zzk().zza("Application context is not an Application");
        }
        zzfvVar.zzp(new zzfx(this, zzhbVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzA(zzfy zzfyVar, zzhb zzhbVar) {
        zzfyVar.zzaz().zzg();
        zzfyVar.zzk.zzn();
        zzaq zzaqVar = new zzaq(zzfyVar);
        zzaqVar.zzv();
        zzfyVar.zzz = zzaqVar;
        zzef zzefVar = new zzef(zzfyVar, zzhbVar.zzf);
        zzefVar.zzb();
        zzfyVar.zzA = zzefVar;
        zzeh zzehVar = new zzeh(zzfyVar);
        zzehVar.zzb();
        zzfyVar.zzx = zzehVar;
        zzjs zzjsVar = new zzjs(zzfyVar);
        zzjsVar.zzb();
        zzfyVar.zzy = zzjsVar;
        zzfyVar.zzp.zzw();
        zzfyVar.zzl.zzw();
        zzfyVar.zzA.zzc();
        zzem zzi = zzfyVar.zzay().zzi();
        zzfyVar.zzk.zzh();
        zzi.zzb("App measurement initialized, version", 73000L);
        zzfyVar.zzay().zzi().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzl = zzefVar.zzl();
        if (TextUtils.isEmpty(zzfyVar.zzf)) {
            if (zzfyVar.zzv().zzae(zzl)) {
                zzfyVar.zzay().zzi().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzfyVar.zzay().zzi().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(String.valueOf(zzl)));
            }
        }
        zzfyVar.zzay().zzc().zza("Debug-level message logging enabled");
        if (zzfyVar.zzG != zzfyVar.zzH.get()) {
            zzfyVar.zzay().zzd().zzc("Not all components initialized", Integer.valueOf(zzfyVar.zzG), Integer.valueOf(zzfyVar.zzH.get()));
        }
        zzfyVar.zzB = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzO() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    private static final void zzP(zzgr zzgrVar) {
        if (zzgrVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static final void zzQ(zzf zzfVar) {
        if (zzfVar != null) {
            if (!zzfVar.zze()) {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzfVar.getClass()))));
            }
            return;
        }
        throw new IllegalStateException("Component not created");
    }

    private static final void zzR(zzgs zzgsVar) {
        if (zzgsVar != null) {
            if (!zzgsVar.zzx()) {
                throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(String.valueOf(zzgsVar.getClass()))));
            }
            return;
        }
        throw new IllegalStateException("Component not created");
    }

    public static zzfy zzp(Context context, com.google.android.gms.internal.measurement.zzcl zzclVar, Long l) {
        Bundle bundle;
        if (zzclVar != null && (zzclVar.zze == null || zzclVar.zzf == null)) {
            zzclVar = new com.google.android.gms.internal.measurement.zzcl(zzclVar.zza, zzclVar.zzb, zzclVar.zzc, zzclVar.zzd, null, null, zzclVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzd == null) {
            synchronized (zzfy.class) {
                if (zzd == null) {
                    zzd = new zzfy(new zzhb(context, zzclVar, l));
                }
            }
        } else if (zzclVar != null && (bundle = zzclVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzd);
            zzd.zzE = Boolean.valueOf(zzclVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzB() {
        this.zzH.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        if (i != 200 && i != 204) {
            if (i == 304) {
                i = SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE;
            }
            zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
        }
        if (th == null) {
            zzm().zzm.zza(true);
            if (bArr == null || bArr.length == 0) {
                zzay().zzc().zza("Deferred Deep Link response empty.");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                String optString = jSONObject.optString("deeplink", "");
                String optString2 = jSONObject.optString("gclid", "");
                double optDouble = jSONObject.optDouble("timestamp", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                if (TextUtils.isEmpty(optString)) {
                    zzay().zzc().zza("Deferred Deep Link is empty.");
                    return;
                }
                zzlh zzv = zzv();
                zzfy zzfyVar = zzv.zzs;
                if (!TextUtils.isEmpty(optString) && (queryIntentActivities = zzv.zzs.zze.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) != null && !queryIntentActivities.isEmpty()) {
                    Bundle bundle = new Bundle();
                    bundle.putString("gclid", optString2);
                    bundle.putString("_cis", "ddp");
                    this.zzt.zzG("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle);
                    zzlh zzv2 = zzv();
                    if (TextUtils.isEmpty(optString)) {
                        return;
                    }
                    try {
                        SharedPreferences.Editor edit = zzv2.zzs.zze.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                        edit.putString("deeplink", optString);
                        edit.putLong("timestamp", Double.doubleToRawLongBits(optDouble));
                        if (edit.commit()) {
                            zzv2.zzs.zze.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                            return;
                        }
                        return;
                    } catch (RuntimeException e) {
                        zzv2.zzs.zzay().zzd().zzb("Failed to persist Deferred Deep Link. exception", e);
                        return;
                    }
                }
                zzay().zzk().zzc("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            } catch (JSONException e2) {
                zzay().zzd().zzb("Failed to parse the Deferred Deep Link response. exception", e2);
                return;
            }
        }
        zzay().zzk().zzc("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzD() {
        this.zzG++;
    }

    public final void zzE() {
        zzaz().zzg();
        zzR(zzr());
        String zzl = zzh().zzl();
        Pair zzb = zzm().zzb(zzl);
        if (!this.zzk.zzr() || ((Boolean) zzb.second).booleanValue() || TextUtils.isEmpty((CharSequence) zzb.first)) {
            zzay().zzc().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        zzih zzr = zzr();
        zzr.zzu();
        ConnectivityManager connectivityManager = (ConnectivityManager) zzr.zzs.zze.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            zzay().zzk().zza("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        zzlh zzv = zzv();
        zzh().zzs.zzk.zzh();
        URL zzE = zzv.zzE(73000L, zzl, (String) zzb.first, zzm().zzn.zza() - 1);
        if (zzE != null) {
            zzih zzr2 = zzr();
            zzfw zzfwVar = new zzfw(this);
            zzr2.zzg();
            zzr2.zzu();
            Preconditions.checkNotNull(zzE);
            Preconditions.checkNotNull(zzfwVar);
            zzr2.zzs.zzaz().zzo(new zzig(zzr2, zzl, zzE, null, null, zzfwVar, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzF(boolean z) {
        this.zzE = Boolean.valueOf(z);
    }

    public final void zzG(boolean z) {
        zzaz().zzg();
        this.zzF = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzH(com.google.android.gms.internal.measurement.zzcl zzclVar) {
        zzai zzaiVar;
        zzaz().zzg();
        zzai zzc = zzm().zzc();
        zzfd zzm = zzm();
        zzfy zzfyVar = zzm.zzs;
        zzm.zzg();
        int i = 100;
        int i2 = zzm.zza().getInt("consent_source", 100);
        zzag zzagVar = this.zzk;
        zzfy zzfyVar2 = zzagVar.zzs;
        Boolean zzk = zzagVar.zzk("google_analytics_default_allow_ad_storage");
        zzag zzagVar2 = this.zzk;
        zzfy zzfyVar3 = zzagVar2.zzs;
        Boolean zzk2 = zzagVar2.zzk("google_analytics_default_allow_analytics_storage");
        if ((zzk != null || zzk2 != null) && zzm().zzl(-10)) {
            zzaiVar = new zzai(zzk, zzk2);
            i = -10;
        } else {
            if (TextUtils.isEmpty(zzh().zzm()) || (i2 != 0 && i2 != 30 && i2 != 10 && i2 != 30 && i2 != 30 && i2 != 40)) {
                if (TextUtils.isEmpty(zzh().zzm()) && zzclVar != null && zzclVar.zzg != null && zzm().zzl(30)) {
                    zzaiVar = zzai.zza(zzclVar.zzg);
                    if (!zzaiVar.equals(zzai.zza)) {
                        i = 30;
                    }
                }
            } else {
                zzq().zzS(zzai.zza, -10, this.zzc);
            }
            zzaiVar = null;
        }
        if (zzaiVar != null) {
            zzq().zzS(zzaiVar, i, this.zzc);
            zzc = zzaiVar;
        }
        zzq().zzV(zzc);
        if (zzm().zzc.zza() == 0) {
            zzay().zzj().zzb("Persisting first open", Long.valueOf(this.zzc));
            zzm().zzc.zzb(this.zzc);
        }
        zzq().zzb.zzc();
        if (zzM()) {
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                zzlh zzv = zzv();
                String zzm2 = zzh().zzm();
                zzfd zzm3 = zzm();
                zzm3.zzg();
                String string = zzm3.zza().getString("gmp_app_id", null);
                String zzk3 = zzh().zzk();
                zzfd zzm4 = zzm();
                zzm4.zzg();
                if (zzv.zzam(zzm2, string, zzk3, zzm4.zza().getString("admob_app_id", null))) {
                    zzay().zzi().zza("Rechecking which service to use due to a GMP App Id change");
                    zzfd zzm5 = zzm();
                    zzm5.zzg();
                    Boolean zzd2 = zzm5.zzd();
                    SharedPreferences.Editor edit = zzm5.zza().edit();
                    edit.clear();
                    edit.apply();
                    if (zzd2 != null) {
                        zzm5.zzh(zzd2);
                    }
                    zzi().zzj();
                    this.zzy.zzs();
                    this.zzy.zzr();
                    zzm().zzc.zzb(this.zzc);
                    zzm().zze.zzb(null);
                }
                zzfd zzm6 = zzm();
                String zzm7 = zzh().zzm();
                zzm6.zzg();
                SharedPreferences.Editor edit2 = zzm6.zza().edit();
                edit2.putString("gmp_app_id", zzm7);
                edit2.apply();
                zzfd zzm8 = zzm();
                String zzk4 = zzh().zzk();
                zzm8.zzg();
                SharedPreferences.Editor edit3 = zzm8.zza().edit();
                edit3.putString("admob_app_id", zzk4);
                edit3.apply();
            }
            if (!zzm().zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                zzm().zze.zzb(null);
            }
            zzq().zzO(zzm().zze.zza());
            zznv.zzc();
            if (this.zzk.zzs(null, zzeb.zzac)) {
                try {
                    zzv().zzs.zze.getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
                } catch (ClassNotFoundException unused) {
                    if (!TextUtils.isEmpty(zzm().zzo.zza())) {
                        zzay().zzk().zza("Remote config removed with active feature rollouts");
                        zzm().zzo.zzb(null);
                    }
                }
            }
            if (!TextUtils.isEmpty(zzh().zzm()) || !TextUtils.isEmpty(zzh().zzk())) {
                boolean zzJ = zzJ();
                if (!zzm().zzj() && !this.zzk.zzv()) {
                    zzm().zzi(!zzJ);
                }
                if (zzJ) {
                    zzq().zzz();
                }
                zzu().zza.zza();
                zzt().zzu(new AtomicReference());
                zzt().zzH(zzm().zzr.zza());
            }
        } else if (zzJ()) {
            if (!zzv().zzad("android.permission.INTERNET")) {
                zzay().zzd().zza("App is missing INTERNET permission");
            }
            if (!zzv().zzad("android.permission.ACCESS_NETWORK_STATE")) {
                zzay().zzd().zza("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!Wrappers.packageManager(this.zze).isCallerInstantApp() && !this.zzk.zzx()) {
                if (!zzlh.zzaj(this.zze)) {
                    zzay().zzd().zza("AppMeasurementReceiver not registered/enabled");
                }
                if (!zzlh.zzak(this.zze, false)) {
                    zzay().zzd().zza("AppMeasurementService not registered/enabled");
                }
            }
            zzay().zzd().zza("Uploading is not possible. App measurement disabled");
        }
        zzm().zzi.zza(true);
    }

    public final boolean zzI() {
        return this.zzE != null && this.zzE.booleanValue();
    }

    public final boolean zzJ() {
        return zza() == 0;
    }

    public final boolean zzK() {
        zzaz().zzg();
        return this.zzF;
    }

    @Pure
    public final boolean zzL() {
        return TextUtils.isEmpty(this.zzf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzM() {
        if (this.zzB) {
            zzaz().zzg();
            Boolean bool = this.zzC;
            if (bool == null || this.zzD == 0 || (!bool.booleanValue() && Math.abs(this.zzr.elapsedRealtime() - this.zzD) > 1000)) {
                this.zzD = this.zzr.elapsedRealtime();
                boolean z = true;
                Boolean valueOf = Boolean.valueOf(zzv().zzad("android.permission.INTERNET") && zzv().zzad("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zze).isCallerInstantApp() || this.zzk.zzx() || (zzlh.zzaj(this.zze) && zzlh.zzak(this.zze, false))));
                this.zzC = valueOf;
                if (valueOf.booleanValue()) {
                    if (!zzv().zzX(zzh().zzm(), zzh().zzk()) && TextUtils.isEmpty(zzh().zzk())) {
                        z = false;
                    }
                    this.zzC = Boolean.valueOf(z);
                }
            }
            return this.zzC.booleanValue();
        }
        throw new IllegalStateException("AppMeasurement is not initialized");
    }

    @Pure
    public final boolean zzN() {
        return this.zzi;
    }

    public final int zza() {
        zzaz().zzg();
        if (this.zzk.zzv()) {
            return 1;
        }
        Boolean bool = this.zzb;
        if (bool == null || !bool.booleanValue()) {
            zzaz().zzg();
            if (this.zzF) {
                Boolean zzd2 = zzm().zzd();
                if (zzd2 != null) {
                    return zzd2.booleanValue() ? 0 : 3;
                }
                zzag zzagVar = this.zzk;
                zzab zzabVar = zzagVar.zzs.zzj;
                Boolean zzk = zzagVar.zzk("firebase_analytics_collection_enabled");
                if (zzk != null) {
                    return zzk.booleanValue() ? 0 : 4;
                }
                Boolean bool2 = this.zza;
                return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.zzE == null || this.zzE.booleanValue()) ? 0 : 7;
            }
            return 8;
        }
        return 2;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final Context zzau() {
        return this.zze;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final Clock zzav() {
        return this.zzr;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final zzab zzaw() {
        return this.zzj;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final zzeo zzay() {
        zzR(this.zzm);
        return this.zzm;
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    @Pure
    public final zzfv zzaz() {
        zzR(this.zzn);
        return this.zzn;
    }

    @Pure
    public final zzd zzd() {
        zzd zzdVar = this.zzu;
        if (zzdVar != null) {
            return zzdVar;
        }
        throw new IllegalStateException("Component not created");
    }

    @Pure
    public final zzag zzf() {
        return this.zzk;
    }

    @Pure
    public final zzaq zzg() {
        zzR(this.zzz);
        return this.zzz;
    }

    @Pure
    public final zzef zzh() {
        zzQ(this.zzA);
        return this.zzA;
    }

    @Pure
    public final zzeh zzi() {
        zzQ(this.zzx);
        return this.zzx;
    }

    @Pure
    public final zzej zzj() {
        return this.zzq;
    }

    public final zzeo zzl() {
        zzeo zzeoVar = this.zzm;
        if (zzeoVar == null || !zzeoVar.zzx()) {
            return null;
        }
        return zzeoVar;
    }

    @Pure
    public final zzfd zzm() {
        zzP(this.zzl);
        return this.zzl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SideEffectFree
    public final zzfv zzo() {
        return this.zzn;
    }

    @Pure
    public final zzid zzq() {
        zzQ(this.zzt);
        return this.zzt;
    }

    @Pure
    public final zzih zzr() {
        zzR(this.zzv);
        return this.zzv;
    }

    @Pure
    public final zzis zzs() {
        zzQ(this.zzs);
        return this.zzs;
    }

    @Pure
    public final zzjs zzt() {
        zzQ(this.zzy);
        return this.zzy;
    }

    @Pure
    public final zzki zzu() {
        zzQ(this.zzo);
        return this.zzo;
    }

    @Pure
    public final zzlh zzv() {
        zzP(this.zzp);
        return this.zzp;
    }

    @Pure
    public final String zzw() {
        return this.zzf;
    }

    @Pure
    public final String zzx() {
        return this.zzg;
    }

    @Pure
    public final String zzy() {
        return this.zzh;
    }

    @Pure
    public final String zzz() {
        return this.zzw;
    }
}
