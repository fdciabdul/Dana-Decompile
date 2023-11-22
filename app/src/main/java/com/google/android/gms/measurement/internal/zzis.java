package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class zzis extends zzf {
    protected zzik zza;
    private volatile zzik zzb;
    private volatile zzik zzc;
    private final Map zzd;
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzik zzg;
    private zzik zzh;
    private boolean zzi;
    private final Object zzj;

    public zzis(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzj = new Object();
        this.zzd = new ConcurrentHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzA(zzik zzikVar, zzik zzikVar2, long j, boolean z, Bundle bundle) {
        long j2;
        zzg();
        boolean z2 = false;
        boolean z3 = (zzikVar2 != null && zzikVar2.zzc == zzikVar.zzc && zzil.zza(zzikVar2.zzb, zzikVar.zzb) && zzil.zza(zzikVar2.zza, zzikVar.zza)) ? false : true;
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            zzlh.zzK(zzikVar, bundle2, true);
            if (zzikVar2 != null) {
                String str = zzikVar2.zza;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = zzikVar2.zzb;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", zzikVar2.zzc);
            }
            if (z2) {
                zzkg zzkgVar = this.zzs.zzu().zzb;
                long j3 = j - zzkgVar.zzb;
                zzkgVar.zzb = j;
                if (j3 > 0) {
                    this.zzs.zzv().zzI(bundle2, j3);
                }
            }
            if (!this.zzs.zzf().zzu()) {
                bundle2.putLong("_mst", 1L);
            }
            String str3 = true != zzikVar.zze ? "auto" : GriverOnPreloadExtension.PARAMS_APP;
            long currentTimeMillis = this.zzs.zzav().currentTimeMillis();
            if (zzikVar.zze) {
                long j4 = zzikVar.zzf;
                if (j4 != 0) {
                    j2 = j4;
                    this.zzs.zzq().zzH(str3, "_vs", j2, bundle2);
                }
            }
            j2 = currentTimeMillis;
            this.zzs.zzq().zzH(str3, "_vs", j2, bundle2);
        }
        if (z2) {
            zzB(this.zza, true, j);
        }
        this.zza = zzikVar;
        if (zzikVar.zze) {
            this.zzh = zzikVar;
        }
        this.zzs.zzt().zzG(zzikVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzB(zzik zzikVar, boolean z, long j) {
        this.zzs.zzd().zzf(this.zzs.zzav().elapsedRealtime());
        if (!this.zzs.zzu().zzb.zzd(zzikVar != null && zzikVar.zzd, z, j) || zzikVar == null) {
            return;
        }
        zzikVar.zzd = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzis zzisVar, Bundle bundle, zzik zzikVar, zzik zzikVar2, long j) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzisVar.zzA(zzikVar, zzikVar2, j, true, zzisVar.zzs.zzv().zzy(null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, null, false));
    }

    private final zzik zzy(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzik zzikVar = (zzik) this.zzd.get(activity);
        if (zzikVar == null) {
            zzik zzikVar2 = new zzik(null, zzl(activity.getClass(), "Activity"), this.zzs.zzv().zzq());
            this.zzd.put(activity, zzikVar2);
            zzikVar = zzikVar2;
        }
        return this.zzg != null ? this.zzg : zzikVar;
    }

    private final void zzz(Activity activity, zzik zzikVar, boolean z) {
        zzik zzikVar2;
        zzik zzikVar3 = this.zzb == null ? this.zzc : this.zzb;
        if (zzikVar.zzb == null) {
            zzikVar2 = new zzik(zzikVar.zza, activity != null ? zzl(activity.getClass(), "Activity") : null, zzikVar.zzc, zzikVar.zze, zzikVar.zzf);
        } else {
            zzikVar2 = zzikVar;
        }
        this.zzc = this.zzb;
        this.zzb = zzikVar2;
        this.zzs.zzaz().zzp(new zzin(this, zzikVar2, zzikVar3, this.zzs.zzav().elapsedRealtime(), z));
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzf() {
        return false;
    }

    public final zzik zzi() {
        return this.zzb;
    }

    public final zzik zzj(boolean z) {
        zza();
        zzg();
        if (z) {
            zzik zzikVar = this.zza;
            return zzikVar != null ? zzikVar : this.zzh;
        }
        return this.zza;
    }

    final String zzl(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        this.zzs.zzf();
        if (length2 > 100) {
            this.zzs.zzf();
            return str2.substring(0, 100);
        }
        return str2;
    }

    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!this.zzs.zzf().zzu() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.zzd.put(activity, new zzik(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (this.zzs.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = this.zzs.zzav().elapsedRealtime();
        if (!this.zzs.zzf().zzu()) {
            this.zzb = null;
            this.zzs.zzaz().zzp(new zzip(this, elapsedRealtime));
            return;
        }
        zzik zzy = zzy(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        this.zzs.zzaz().zzp(new zziq(this, zzy, elapsedRealtime));
    }

    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzs.zzf().zzu()) {
                    this.zzg = null;
                    this.zzs.zzaz().zzp(new zzir(this));
                }
            }
        }
        if (!this.zzs.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzs.zzaz().zzp(new zzio(this));
            return;
        }
        zzz(activity, zzy(activity), false);
        zzd zzd = this.zzs.zzd();
        zzd.zzs.zzaz().zzp(new zzc(zzd, zzd.zzs.zzav().elapsedRealtime()));
    }

    public final void zzv(Activity activity, Bundle bundle) {
        zzik zzikVar;
        if (!this.zzs.zzf().zzu() || bundle == null || (zzikVar = (zzik) this.zzd.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", zzikVar.zzc);
        bundle2.putString("name", zzikVar.zza);
        bundle2.putString("referrer_name", zzikVar.zzb);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
    
        if (r6.length() <= 100) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b4, code lost:
    
        if (r7.length() <= 100) goto L39;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzw(android.app.Activity r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            com.google.android.gms.measurement.internal.zzfy r0 = r4.zzs
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzu()
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.zzfy r5 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzl()
            java.lang.String r6 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r5.zza(r6)
            return
        L1c:
            com.google.android.gms.measurement.internal.zzik r0 = r4.zzb
            if (r0 != 0) goto L30
            com.google.android.gms.measurement.internal.zzfy r5 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzl()
            java.lang.String r6 = "setCurrentScreen cannot be called while no activity active"
            r5.zza(r6)
            return
        L30:
            java.util.Map r1 = r4.zzd
            java.lang.Object r1 = r1.get(r5)
            if (r1 != 0) goto L48
            com.google.android.gms.measurement.internal.zzfy r5 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzl()
            java.lang.String r6 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r5.zza(r6)
            return
        L48:
            if (r7 != 0) goto L54
            java.lang.Class r7 = r5.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r7 = r4.zzl(r7, r1)
        L54:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzil.zza(r1, r7)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzil.zza(r0, r6)
            if (r1 == 0) goto L75
            if (r0 != 0) goto L65
            goto L75
        L65:
            com.google.android.gms.measurement.internal.zzfy r5 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzl()
            java.lang.String r6 = "setCurrentScreen cannot be called with the same class and name"
            r5.zza(r6)
            return
        L75:
            r0 = 100
            if (r6 == 0) goto La3
            int r1 = r6.length()
            if (r1 <= 0) goto L8b
            com.google.android.gms.measurement.internal.zzfy r1 = r4.zzs
            r1.zzf()
            int r1 = r6.length()
            if (r1 > r0) goto L8b
            goto La3
        L8b:
            com.google.android.gms.measurement.internal.zzfy r5 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzl()
            int r6 = r6.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "Invalid screen name length in setCurrentScreen. Length"
            r5.zzb(r7, r6)
            return
        La3:
            if (r7 == 0) goto Lcf
            int r1 = r7.length()
            if (r1 <= 0) goto Lb7
            com.google.android.gms.measurement.internal.zzfy r1 = r4.zzs
            r1.zzf()
            int r1 = r7.length()
            if (r1 > r0) goto Lb7
            goto Lcf
        Lb7:
            com.google.android.gms.measurement.internal.zzfy r5 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzem r5 = r5.zzl()
            int r6 = r7.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = "Invalid class name length in setCurrentScreen. Length"
            r5.zzb(r7, r6)
            return
        Lcf:
            com.google.android.gms.measurement.internal.zzfy r0 = r4.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzj()
            if (r6 != 0) goto Lde
            java.lang.String r1 = "null"
            goto Ldf
        Lde:
            r1 = r6
        Ldf:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r7)
            com.google.android.gms.measurement.internal.zzfy r0 = r4.zzs
            com.google.android.gms.measurement.internal.zzlh r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzik r1 = new com.google.android.gms.measurement.internal.zzik
            long r2 = r0.zzq()
            r1.<init>(r6, r7, r2)
            java.util.Map r6 = r4.zzd
            r6.put(r5, r1)
            r6 = 1
            r4.zzz(r5, r1, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzis.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r2 > 100) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r4 > 100) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzis.zzx(android.os.Bundle, long):void");
    }
}
