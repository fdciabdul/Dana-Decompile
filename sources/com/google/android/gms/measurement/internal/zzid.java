package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.measurement.zznv;
import com.google.android.gms.internal.measurement.zzoe;
import com.google.android.gms.internal.measurement.zzoz;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes7.dex */
public final class zzid extends zzf {
    protected zzic zza;
    final zzs zzb;
    protected boolean zzc;
    private zzgy zzd;
    private final Set zze;
    private boolean zzf;
    private final AtomicReference zzg;
    private final Object zzh;
    private zzai zzi;
    private int zzj;
    private final AtomicLong zzk;
    private long zzl;
    private int zzm;
    private final zzlg zzn;
    public static final byte[] PlaceComponentResult = {83, 16, 71, 115, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int MyBillsEntityDataFactory = 13;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzid(zzfy zzfyVar) {
        super(zzfyVar);
        this.zze = new CopyOnWriteArraySet();
        this.zzh = new Object();
        this.zzc = true;
        this.zzn = new zzhr(this);
        this.zzg = new AtomicReference();
        this.zzi = new zzai(null, null);
        this.zzj = 100;
        this.zzl = -1L;
        this.zzm = 100;
        this.zzk = new AtomicLong(0L);
        this.zzb = new zzs(zzfyVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0024). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r6 = com.google.android.gms.measurement.internal.zzid.PlaceComponentResult
            r7 = 23
            byte[] r8 = new byte[r7]
            r0 = 97
            r1 = 0
            r2 = 3
            if (r6 != 0) goto L10
            r3 = 23
            r5 = 0
            goto L24
        L10:
            r3 = 0
        L11:
            int r2 = r2 + 1
            byte r4 = (byte) r0
            int r5 = r3 + 1
            r8[r3] = r4
            if (r5 != r7) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r8, r1)
            r9[r1] = r6
            return
        L22:
            r3 = r6[r2]
        L24:
            int r0 = r0 + r3
            int r0 = r0 + (-8)
            r3 = r5
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzid.a(byte, byte, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(Boolean bool, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zzb("Setting app measurement enabled (FE)", bool);
        this.zzs.zzm().zzh(bool);
        if (z) {
            zzfd zzm = this.zzs.zzm();
            zzfy zzfyVar = zzm.zzs;
            zzm.zzg();
            SharedPreferences.Editor edit = zzm.zza().edit();
            if (bool != null) {
                edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
            } else {
                edit.remove("measurement_enabled_from_api");
            }
            edit.apply();
        }
        if (this.zzs.zzK() || !(bool == null || bool.booleanValue())) {
            zzab();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzab() {
        zzg();
        String zza = this.zzs.zzm().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zzY(GriverOnPreloadExtension.PARAMS_APP, "_npa", null, this.zzs.zzav().currentTimeMillis());
            } else {
                zzY(GriverOnPreloadExtension.PARAMS_APP, "_npa", Long.valueOf(true != SummaryActivity.CHECKED.equals(zza) ? 0L : 1L), this.zzs.zzav().currentTimeMillis());
            }
        }
        if (!this.zzs.zzJ() || !this.zzc) {
            this.zzs.zzay().zzc().zza("Updating Scion state (FE)");
            this.zzs.zzt().zzI();
            return;
        }
        this.zzs.zzay().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzz();
        zzoe.zzc();
        if (this.zzs.zzf().zzs(null, zzeb.zzad)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzs.zzaz().zzp(new zzhg(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzv(zzid zzidVar, zzai zzaiVar, zzai zzaiVar2) {
        boolean z;
        zzah[] zzahVarArr = {zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE};
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = false;
                break;
            }
            zzah zzahVar = zzahVarArr[i];
            if (!zzaiVar2.zzi(zzahVar) && zzaiVar.zzi(zzahVar)) {
                z = true;
                break;
            }
            i++;
        }
        boolean zzl = zzaiVar.zzl(zzaiVar2, zzah.ANALYTICS_STORAGE, zzah.AD_STORAGE);
        if (z || zzl) {
            zzidVar.zzs.zzh().zzo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzw(zzid zzidVar, zzai zzaiVar, int i, long j, boolean z, boolean z2) {
        zzidVar.zzg();
        zzidVar.zza();
        if (j > zzidVar.zzl || !zzai.zzj(zzidVar.zzm, i)) {
            zzfd zzm = zzidVar.zzs.zzm();
            zzfy zzfyVar = zzm.zzs;
            zzm.zzg();
            if (zzm.zzl(i)) {
                SharedPreferences.Editor edit = zzm.zza().edit();
                edit.putString("consent_settings", zzaiVar.zzh());
                edit.putInt("consent_source", i);
                edit.apply();
                zzidVar.zzl = j;
                zzidVar.zzm = i;
                zzidVar.zzs.zzt().zzF(z);
                if (z2) {
                    zzidVar.zzs.zzt().zzu(new AtomicReference());
                    return;
                }
                return;
            }
            zzidVar.zzs.zzay().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
            return;
        }
        zzidVar.zzs.zzay().zzi().zzb("Dropped out-of-date consent setting, proposed settings", zzaiVar);
    }

    public final void zzA(String str, String str2, Bundle bundle) {
        long currentTimeMillis = this.zzs.zzav().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str2 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str2);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        this.zzs.zzaz().zzp(new zzhn(this, bundle2));
    }

    public final void zzB() {
        if (!(this.zzs.zzau().getApplicationContext() instanceof Application) || this.zza == null) {
            return;
        }
        ((Application) this.zzs.zzau().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzC(Bundle bundle) {
        if (bundle == null) {
            this.zzs.zzm().zzr.zzb(new Bundle());
            return;
        }
        Bundle zza = this.zzs.zzm().zzr.zza();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null || (obj instanceof String) || (obj instanceof Long) || (obj instanceof Double)) {
                if (zzlh.zzah(str)) {
                    this.zzs.zzay().zzl().zzb("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza.remove(str);
                } else {
                    zzlh zzv = this.zzs.zzv();
                    this.zzs.zzf();
                    if (zzv.zzaa("param", str, 100, obj)) {
                        this.zzs.zzv().zzO(zza, str, obj);
                    }
                }
            } else {
                if (this.zzs.zzv().zzaf(obj)) {
                    this.zzs.zzv().zzN(this.zzn, null, 27, null, null, 0);
                }
                this.zzs.zzay().zzl().zzc("Invalid default event parameter type. Name, value", str, obj);
            }
        }
        this.zzs.zzv();
        int zzc = this.zzs.zzf().zzc();
        if (zza.size() > zzc) {
            int i = 0;
            for (String str2 : new TreeSet(zza.keySet())) {
                i++;
                if (i > zzc) {
                    zza.remove(str2);
                }
            }
            this.zzs.zzv().zzN(this.zzn, null, 26, null, null, 0);
            this.zzs.zzay().zzl().zza("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        this.zzs.zzm().zzr.zzb(zza);
        this.zzs.zzt().zzH(zza);
    }

    public final void zzD(String str, String str2, Bundle bundle) {
        zzE(str, str2, bundle, true, true, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzE(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? GriverOnPreloadExtension.PARAMS_APP : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (str2 != FirebaseAnalytics.Event.SCREEN_VIEW && (str2 == null || !str2.equals(FirebaseAnalytics.Event.SCREEN_VIEW))) {
            zzM(str3, str2, j, bundle2, z2, !z2 || this.zzd == null || zzlh.zzah(str2), z, null);
        } else {
            this.zzs.zzs().zzx(bundle2, j);
        }
    }

    public final void zzF(String str, String str2, Bundle bundle, String str3) {
        zzfy.zzO();
        zzM("auto", str2, this.zzs.zzav().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG(String str, String str2, Bundle bundle) {
        zzg();
        zzH(str, str2, this.zzs.zzav().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzH(String str, String str2, long j, Bundle bundle) {
        zzg();
        zzI(str, str2, j, bundle, true, this.zzd == null || zzlh.zzah(str2), true, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzI(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        boolean z4;
        String str4;
        long j2;
        String str5;
        String str6;
        Bundle[] bundleArr;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzg();
        zza();
        if (!this.zzs.zzJ()) {
            this.zzs.zzay().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List zzn = this.zzs.zzh().zzn();
        if (zzn != null && !zzn.contains(str2)) {
            this.zzs.zzay().zzc().zzc("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.zzf) {
            this.zzf = true;
            try {
                Class<?> cls = !this.zzs.zzN() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, this.zzs.zzau().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                try {
                    byte b = (byte) 0;
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    cls.getDeclaredMethod("initialize", Class.forName((String) objArr[0])).invoke(null, this.zzs.zzau());
                } catch (Exception e) {
                    this.zzs.zzay().zzk().zzb("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                this.zzs.zzay().zzi().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2) && bundle.containsKey("gclid")) {
            this.zzs.zzaw();
            zzY("auto", "_lgclid", bundle.getString("gclid"), this.zzs.zzav().currentTimeMillis());
        }
        this.zzs.zzaw();
        if (z && zzlh.zzal(str2)) {
            this.zzs.zzv().zzL(bundle, this.zzs.zzm().zzr.zza());
        }
        if (!z3) {
            this.zzs.zzaw();
            if (!"_iap".equals(str2)) {
                zzlh zzv = this.zzs.zzv();
                int i = 2;
                if (zzv.zzac("event", str2)) {
                    if (zzv.zzZ("event", zzgv.zza, zzgv.zzb, str2)) {
                        zzv.zzs.zzf();
                        if (zzv.zzY("event", 40, str2)) {
                            i = 0;
                        }
                    } else {
                        i = 13;
                    }
                }
                if (i != 0) {
                    this.zzs.zzay().zze().zzb("Invalid public event name. Event will not be logged (FE)", this.zzs.zzj().zzd(str2));
                    zzlh zzv2 = this.zzs.zzv();
                    this.zzs.zzf();
                    this.zzs.zzv().zzN(this.zzn, null, i, "_ev", zzv2.zzD(str2, 40, true), str2 != null ? str2.length() : 0);
                    return;
                }
            }
        }
        this.zzs.zzaw();
        zzik zzj = this.zzs.zzs().zzj(false);
        if (zzj != null && !bundle.containsKey("_sc")) {
            zzj.zzd = true;
        }
        zzlh.zzK(zzj, bundle, z && !z3);
        boolean equals = "am".equals(str);
        boolean zzah = zzlh.zzah(str2);
        if (!z || this.zzd == null || zzah) {
            z4 = equals;
        } else if (!equals) {
            this.zzs.zzay().zzc().zzc("Passing event to registered event handler (FE)", this.zzs.zzj().zzd(str2), this.zzs.zzj().zzb(bundle));
            Preconditions.checkNotNull(this.zzd);
            this.zzd.interceptEvent(str, str2, bundle, j);
            return;
        } else {
            z4 = true;
        }
        if (this.zzs.zzM()) {
            int zzh = this.zzs.zzv().zzh(str2);
            if (zzh != 0) {
                this.zzs.zzay().zze().zzb("Invalid event name. Event will not be logged (FE)", this.zzs.zzj().zzd(str2));
                zzlh zzv3 = this.zzs.zzv();
                this.zzs.zzf();
                this.zzs.zzv().zzN(this.zzn, str3, zzh, "_ev", zzv3.zzD(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            Bundle zzy = this.zzs.zzv().zzy(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z3);
            Preconditions.checkNotNull(zzy);
            this.zzs.zzaw();
            if (this.zzs.zzs().zzj(false) != null && "_ae".equals(str2)) {
                zzkg zzkgVar = this.zzs.zzu().zzb;
                long elapsedRealtime = zzkgVar.zzc.zzs.zzav().elapsedRealtime();
                long j3 = elapsedRealtime - zzkgVar.zzb;
                zzkgVar.zzb = elapsedRealtime;
                if (j3 > 0) {
                    this.zzs.zzv().zzI(zzy, j3);
                }
            }
            zznv.zzc();
            if (this.zzs.zzf().zzs(null, zzeb.zzac)) {
                if (!"auto".equals(str) && "_ssr".equals(str2)) {
                    zzlh zzv4 = this.zzs.zzv();
                    String string = zzy.getString("_ffr");
                    if (Strings.isEmptyOrWhitespace(string)) {
                        string = null;
                    } else if (string != null) {
                        string = string.trim();
                    }
                    if (zzlf.zza(string, zzv4.zzs.zzm().zzo.zza())) {
                        zzv4.zzs.zzay().zzc().zza("Not logging duplicate session_start_with_rollout event");
                        return;
                    }
                    zzv4.zzs.zzm().zzo.zzb(string);
                } else if ("_ae".equals(str2)) {
                    String zza = this.zzs.zzv().zzs.zzm().zzo.zza();
                    if (!TextUtils.isEmpty(zza)) {
                        zzy.putString("_ffr", zza);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzy);
            if (this.zzs.zzm().zzj.zza() > 0 && this.zzs.zzm().zzk(j) && this.zzs.zzm().zzl.zzb()) {
                this.zzs.zzay().zzj().zza("Current session is expired, remove the session number, ID, and engagement time");
                str4 = "_ae";
                j2 = 0;
                zzY("auto", "_sid", null, this.zzs.zzav().currentTimeMillis());
                zzY("auto", "_sno", null, this.zzs.zzav().currentTimeMillis());
                zzY("auto", "_se", null, this.zzs.zzav().currentTimeMillis());
            } else {
                str4 = "_ae";
                j2 = 0;
            }
            if (zzy.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, j2) == 1) {
                this.zzs.zzay().zzj().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                this.zzs.zzu().zza.zzb(j, true);
            }
            ArrayList arrayList2 = new ArrayList(zzy.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str7 = (String) arrayList2.get(i2);
                if (str7 != null) {
                    this.zzs.zzv();
                    Object obj = zzy.get(str7);
                    if (obj instanceof Bundle) {
                        bundleArr = new Bundle[]{(Bundle) obj};
                    } else if (obj instanceof Parcelable[]) {
                        Parcelable[] parcelableArr = (Parcelable[]) obj;
                        bundleArr = (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList3 = (ArrayList) obj;
                        bundleArr = (Bundle[]) arrayList3.toArray(new Bundle[arrayList3.size()]);
                    } else {
                        bundleArr = null;
                    }
                    if (bundleArr != null) {
                        zzy.putParcelableArray(str7, bundleArr);
                    }
                }
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Bundle bundle2 = (Bundle) arrayList.get(i3);
                if (i3 != 0) {
                    str6 = "_ep";
                    str5 = str;
                } else {
                    str5 = str;
                    str6 = str2;
                }
                bundle2.putString("_o", str5);
                if (z2) {
                    bundle2 = this.zzs.zzv().zzt(bundle2);
                }
                Bundle bundle3 = bundle2;
                this.zzs.zzt().zzA(new zzaw(str6, new zzau(bundle3), str, j), str3);
                if (!z4) {
                    Iterator it = this.zze.iterator();
                    while (it.hasNext()) {
                        ((zzgz) it.next()).onEvent(str, str2, new Bundle(bundle3), j);
                    }
                }
            }
            this.zzs.zzaw();
            if (this.zzs.zzs().zzj(false) == null || !str4.equals(str2)) {
                return;
            }
            this.zzs.zzu().zzb.zzd(true, true, this.zzs.zzav().elapsedRealtime());
        }
    }

    public final void zzJ(zzgz zzgzVar) {
        zza();
        Preconditions.checkNotNull(zzgzVar);
        if (this.zze.add(zzgzVar)) {
            return;
        }
        this.zzs.zzay().zzk().zza("OnEventListener already registered");
    }

    public final void zzK(long j) {
        this.zzg.set(null);
        this.zzs.zzaz().zzp(new zzhl(this, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzL(long j, boolean z) {
        zzg();
        zza();
        this.zzs.zzay().zzc().zza("Resetting analytics data (FE)");
        zzki zzu = this.zzs.zzu();
        zzu.zzg();
        zzkh zzkhVar = zzu.zza;
        zzu.zzb.zza();
        zzoz.zzc();
        if (this.zzs.zzf().zzs(null, zzeb.zzas)) {
            this.zzs.zzh().zzo();
        }
        boolean zzJ = this.zzs.zzJ();
        zzfd zzm = this.zzs.zzm();
        zzm.zzc.zzb(j);
        if (!TextUtils.isEmpty(zzm.zzs.zzm().zzo.zza())) {
            zzm.zzo.zzb(null);
        }
        zzoe.zzc();
        if (zzm.zzs.zzf().zzs(null, zzeb.zzad)) {
            zzm.zzj.zzb(0L);
        }
        if (!zzm.zzs.zzf().zzv()) {
            zzm.zzi(!zzJ);
        }
        zzm.zzp.zzb(null);
        zzm.zzq.zzb(0L);
        zzm.zzr.zzb(null);
        if (z) {
            this.zzs.zzt().zzC();
        }
        zzoe.zzc();
        if (this.zzs.zzf().zzs(null, zzeb.zzad)) {
            this.zzs.zzu().zza.zza();
        }
        this.zzc = !zzJ;
    }

    final void zzN(String str, String str2, long j, Object obj) {
        this.zzs.zzaz().zzp(new zzhj(this, str, str2, obj, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzO(String str) {
        this.zzg.set(str);
    }

    public final void zzP(Bundle bundle) {
        zzQ(bundle, this.zzs.zzav().currentTimeMillis());
    }

    public final void zzQ(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            this.zzs.zzay().zzk().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzgu.zza(bundle2, "app_id", String.class, null);
        zzgu.zza(bundle2, "origin", String.class, null);
        zzgu.zza(bundle2, "name", String.class, null);
        zzgu.zza(bundle2, "value", Object.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgu.zza(bundle2, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (this.zzs.zzv().zzl(string) == 0) {
            if (this.zzs.zzv().zzd(string, obj) == 0) {
                Object zzB = this.zzs.zzv().zzB(string, obj);
                if (zzB == null) {
                    this.zzs.zzay().zzd().zzc("Unable to normalize conditional user property value", this.zzs.zzj().zzf(string), obj);
                    return;
                }
                zzgu.zzb(bundle2, zzB);
                long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
                if (!TextUtils.isEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME))) {
                    this.zzs.zzf();
                    if (j2 > 15552000000L || j2 < 1) {
                        this.zzs.zzay().zzd().zzc("Invalid conditional user property timeout", this.zzs.zzj().zzf(string), Long.valueOf(j2));
                        return;
                    }
                }
                long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                this.zzs.zzf();
                if (j3 > 15552000000L || j3 < 1) {
                    this.zzs.zzay().zzd().zzc("Invalid conditional user property time to live", this.zzs.zzj().zzf(string), Long.valueOf(j3));
                    return;
                } else {
                    this.zzs.zzaz().zzp(new zzhm(this, bundle2));
                    return;
                }
            }
            this.zzs.zzay().zzd().zzc("Invalid conditional user property value", this.zzs.zzj().zzf(string), obj);
            return;
        }
        this.zzs.zzay().zzd().zzb("Invalid conditional user property name", this.zzs.zzj().zzf(string));
    }

    public final void zzR(Bundle bundle, int i, long j) {
        zza();
        String zzg = zzai.zzg(bundle);
        if (zzg != null) {
            this.zzs.zzay().zzl().zzb("Ignoring invalid consent setting", zzg);
            this.zzs.zzay().zzl().zza("Valid consent values are 'granted', 'denied'");
        }
        zzS(zzai.zza(bundle), i, j);
    }

    public final void zzS(zzai zzaiVar, int i, long j) {
        zzai zzaiVar2;
        boolean z;
        boolean z2;
        boolean z3;
        zzai zzaiVar3 = zzaiVar;
        zza();
        if (i == -10 || zzaiVar.zze() != null || zzaiVar.zzf() != null) {
            synchronized (this.zzh) {
                zzaiVar2 = this.zzi;
                z = true;
                z2 = false;
                if (zzai.zzj(i, this.zzj)) {
                    boolean zzk = zzaiVar3.zzk(this.zzi);
                    if (zzaiVar3.zzi(zzah.ANALYTICS_STORAGE) && !this.zzi.zzi(zzah.ANALYTICS_STORAGE)) {
                        z2 = true;
                    }
                    zzaiVar3 = zzaiVar3.zzd(this.zzi);
                    this.zzi = zzaiVar3;
                    this.zzj = i;
                    z3 = z2;
                    z2 = zzk;
                } else {
                    z = false;
                    z3 = false;
                }
            }
            if (!z) {
                this.zzs.zzay().zzi().zzb("Ignoring lower-priority consent settings, proposed settings", zzaiVar3);
                return;
            }
            long andIncrement = this.zzk.getAndIncrement();
            if (z2) {
                this.zzg.set(null);
                this.zzs.zzaz().zzq(new zzhx(this, zzaiVar3, j, i, andIncrement, z3, zzaiVar2));
                return;
            }
            zzhy zzhyVar = new zzhy(this, zzaiVar3, i, andIncrement, z3, zzaiVar2);
            if (i == 30 || i == -10) {
                this.zzs.zzaz().zzq(zzhyVar);
                return;
            } else {
                this.zzs.zzaz().zzp(zzhyVar);
                return;
            }
        }
        this.zzs.zzay().zzl().zza("Discarding empty consent settings");
    }

    public final void zzT(zzgy zzgyVar) {
        zzgy zzgyVar2;
        zzg();
        zza();
        if (zzgyVar != null && zzgyVar != (zzgyVar2 = this.zzd)) {
            Preconditions.checkState(zzgyVar2 == null, "EventInterceptor already set.");
        }
        this.zzd = zzgyVar;
    }

    public final void zzU(Boolean bool) {
        zza();
        this.zzs.zzaz().zzp(new zzhw(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzV(zzai zzaiVar) {
        zzg();
        boolean z = (zzaiVar.zzi(zzah.ANALYTICS_STORAGE) && zzaiVar.zzi(zzah.AD_STORAGE)) || this.zzs.zzt().zzM();
        if (z != this.zzs.zzK()) {
            this.zzs.zzG(z);
            zzfd zzm = this.zzs.zzm();
            zzfy zzfyVar = zzm.zzs;
            zzm.zzg();
            Boolean valueOf = zzm.zza().contains("measurement_enabled_from_api") ? Boolean.valueOf(zzm.zza().getBoolean("measurement_enabled_from_api", true)) : null;
            if (!z || valueOf == null || valueOf.booleanValue()) {
                zzaa(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zzW(String str, String str2, Object obj, boolean z) {
        zzX("auto", "_ldl", obj, true, this.zzs.zzav().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzY(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zza();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    Long valueOf = Long.valueOf(true != "false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 0L : 1L);
                    this.zzs.zzm().zzh.zzb(valueOf.longValue() == 1 ? SummaryActivity.CHECKED : "false");
                    obj = valueOf;
                    str2 = "_npa";
                }
            }
            if (obj == null) {
                this.zzs.zzm().zzh.zzb("unset");
                str2 = "_npa";
            }
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.zzs.zzJ()) {
            this.zzs.zzay().zzj().zza("User property not set since app measurement is disabled");
        } else if (this.zzs.zzM()) {
            this.zzs.zzt().zzK(new zzlc(str4, j, obj2, str));
        }
    }

    public final void zzZ(zzgz zzgzVar) {
        zza();
        Preconditions.checkNotNull(zzgzVar);
        if (this.zze.remove(zzgzVar)) {
            return;
        }
        this.zzs.zzay().zzk().zza("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final int zzh(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzs.zzf();
        return 25;
    }

    public final Boolean zzi() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) this.zzs.zzaz().zzd(atomicReference, 15000L, "boolean test flag value", new zzhp(this, atomicReference));
    }

    public final Double zzj() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) this.zzs.zzaz().zzd(atomicReference, 15000L, "double test flag value", new zzhv(this, atomicReference));
    }

    public final Integer zzl() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) this.zzs.zzaz().zzd(atomicReference, 15000L, "int test flag value", new zzhu(this, atomicReference));
    }

    public final Long zzm() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) this.zzs.zzaz().zzd(atomicReference, 15000L, "long test flag value", new zzht(this, atomicReference));
    }

    public final String zzo() {
        return (String) this.zzg.get();
    }

    public final String zzp() {
        zzik zzi = this.zzs.zzs().zzi();
        if (zzi != null) {
            return zzi.zzb;
        }
        return null;
    }

    public final String zzq() {
        zzik zzi = this.zzs.zzs().zzi();
        if (zzi != null) {
            return zzi.zza;
        }
        return null;
    }

    public final String zzr() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) this.zzs.zzaz().zzd(atomicReference, 15000L, "String test flag value", new zzhs(this, atomicReference));
    }

    public final ArrayList zzs(String str, String str2) {
        if (!this.zzs.zzaz().zzs()) {
            this.zzs.zzaw();
            if (zzab.zza()) {
                this.zzs.zzay().zzd().zza("Cannot get conditional user properties from main thread");
                return new ArrayList(0);
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzs.zzaz().zzd(atomicReference, RangedBeacon.DEFAULT_MAX_TRACKING_AGE, "get conditional user properties", new zzho(this, atomicReference, null, str, str2));
            List list = (List) atomicReference.get();
            if (list == null) {
                this.zzs.zzay().zzd().zzb("Timed out waiting for get conditional user properties", null);
                return new ArrayList();
            }
            return zzlh.zzH(list);
        }
        this.zzs.zzay().zzd().zza("Cannot get conditional user properties from analytics worker thread");
        return new ArrayList(0);
    }

    public final List zzt(boolean z) {
        zza();
        this.zzs.zzay().zzj().zza("Getting user properties (FE)");
        if (!this.zzs.zzaz().zzs()) {
            this.zzs.zzaw();
            if (zzab.zza()) {
                this.zzs.zzay().zzd().zza("Cannot get all user properties from main thread");
                return Collections.emptyList();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzs.zzaz().zzd(atomicReference, RangedBeacon.DEFAULT_MAX_TRACKING_AGE, "get user properties", new zzhk(this, atomicReference, z));
            List list = (List) atomicReference.get();
            if (list == null) {
                this.zzs.zzay().zzd().zzb("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyList();
            }
            return list;
        }
        this.zzs.zzay().zzd().zza("Cannot get all user properties from analytics worker thread");
        return Collections.emptyList();
    }

    public final Map zzu(String str, String str2, boolean z) {
        if (!this.zzs.zzaz().zzs()) {
            this.zzs.zzaw();
            if (zzab.zza()) {
                this.zzs.zzay().zzd().zza("Cannot get user properties from main thread");
                return Collections.emptyMap();
            }
            AtomicReference atomicReference = new AtomicReference();
            this.zzs.zzaz().zzd(atomicReference, RangedBeacon.DEFAULT_MAX_TRACKING_AGE, "get user properties", new zzhq(this, atomicReference, null, str, str2, z));
            List<zzlc> list = (List) atomicReference.get();
            if (list == null) {
                this.zzs.zzay().zzd().zzb("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzlc zzlcVar : list) {
                Object zza = zzlcVar.zza();
                if (zza != null) {
                    arrayMap.put(zzlcVar.zzb, zza);
                }
            }
            return arrayMap;
        }
        this.zzs.zzay().zzd().zza("Cannot get user properties from analytics worker thread");
        return Collections.emptyMap();
    }

    public final void zzz() {
        zzg();
        zza();
        if (this.zzs.zzM()) {
            if (this.zzs.zzf().zzs(null, zzeb.zzX)) {
                zzag zzf = this.zzs.zzf();
                zzf.zzs.zzaw();
                Boolean zzk = zzf.zzk("google_analytics_deferred_deep_link_enabled");
                if (zzk != null && zzk.booleanValue()) {
                    this.zzs.zzay().zzc().zza("Deferred Deep Link feature enabled.");
                    this.zzs.zzaz().zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhf
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzid zzidVar = zzid.this;
                            zzidVar.zzg();
                            if (!zzidVar.zzs.zzm().zzm.zzb()) {
                                long zza = zzidVar.zzs.zzm().zzn.zza();
                                zzidVar.zzs.zzm().zzn.zzb(1 + zza);
                                zzidVar.zzs.zzf();
                                if (zza >= 5) {
                                    zzidVar.zzs.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                    zzidVar.zzs.zzm().zzm.zza(true);
                                    return;
                                }
                                zzidVar.zzs.zzE();
                                return;
                            }
                            zzidVar.zzs.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
                        }
                    });
                }
            }
            this.zzs.zzt().zzq();
            this.zzc = false;
            zzfd zzm = this.zzs.zzm();
            zzm.zzg();
            String string = zzm.zza().getString("previous_os_version", null);
            zzm.zzs.zzg().zzu();
            String str = Build.VERSION.RELEASE;
            if (!TextUtils.isEmpty(str) && !str.equals(string)) {
                SharedPreferences.Editor edit = zzm.zza().edit();
                edit.putString("previous_os_version", str);
                edit.apply();
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.zzs.zzg().zzu();
            if (string.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", string);
            zzG("auto", "_ou", bundle);
        }
    }

    protected final void zzM(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2 = new Bundle(bundle);
        for (String str4 : bundle2.keySet()) {
            Object obj = bundle2.get(str4);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str4, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        Parcelable parcelable = parcelableArr[i];
                        if (parcelable instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelable);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        this.zzs.zzaz().zzp(new zzhi(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    public final void zzX(String str, String str2, Object obj, boolean z, long j) {
        int i;
        String str3 = str == null ? GriverOnPreloadExtension.PARAMS_APP : str;
        if (!z) {
            zzlh zzv = this.zzs.zzv();
            if (zzv.zzac("user property", str2)) {
                if (zzv.zzZ("user property", zzgx.zza, null, str2)) {
                    zzv.zzs.zzf();
                    if (zzv.zzY("user property", 24, str2)) {
                        i = 0;
                    }
                } else {
                    i = 15;
                }
            }
            i = 6;
        } else {
            i = this.zzs.zzv().zzl(str2);
        }
        if (i != 0) {
            zzlh zzv2 = this.zzs.zzv();
            this.zzs.zzf();
            this.zzs.zzv().zzN(this.zzn, null, i, "_ev", zzv2.zzD(str2, 24, true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int zzd = this.zzs.zzv().zzd(str2, obj);
            if (zzd == 0) {
                Object zzB = this.zzs.zzv().zzB(str2, obj);
                if (zzB != null) {
                    zzN(str3, str2, j, zzB);
                    return;
                }
                return;
            }
            zzlh zzv3 = this.zzs.zzv();
            this.zzs.zzf();
            this.zzs.zzv().zzN(this.zzn, null, zzd, "_ev", zzv3.zzD(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? obj.toString().length() : 0);
        } else {
            zzN(str3, str2, j, null);
        }
    }
}
