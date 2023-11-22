package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes7.dex */
public final class zzag extends zzgr {
    private Boolean zza;
    private zzaf zzb;
    private Boolean zzc;
    public static final byte[] getAuthRequestContext = {62, -79, -77, -78, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4, -6, -23, 43, -55, -8, -4, -5, -2, -6, -27, 3, -14, -7, Ascii.GS, -45, 0, -17};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 77;

    public zzag(zzfy zzfyVar) {
        super(zzfyVar);
        this.zzb = new zzaf() { // from class: com.google.android.gms.measurement.internal.zzae
            @Override // com.google.android.gms.measurement.internal.zzaf
            public final String zza(String str, String str2) {
                return null;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.google.android.gms.measurement.internal.zzag.getAuthRequestContext
            int r7 = r7 * 5
            int r7 = r7 + 18
            int r6 = r6 * 22
            int r6 = 26 - r6
            int r8 = r8 * 6
            int r8 = 103 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2e
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r4 = -r4
            int r6 = r6 + 1
            int r7 = r7 + r4
            int r7 = r7 + (-8)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.a(short, int, byte, java.lang.Object[]):void");
    }

    public static final long zzA() {
        return ((Long) zzeb.zzC.zza(null)).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            this.zzs.zzay().zzd().zzb("Could not find SystemProperties class", e);
            return "";
        } catch (IllegalAccessException e2) {
            this.zzs.zzay().zzd().zzb("Could not access SystemProperties.get()", e2);
            return "";
        } catch (NoSuchMethodException e3) {
            this.zzs.zzay().zzd().zzb("Could not find SystemProperties.get() method", e3);
            return "";
        } catch (InvocationTargetException e4) {
            this.zzs.zzay().zzd().zzb("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static final long zzz() {
        return ((Long) zzeb.zzc.zza(null)).longValue();
    }

    public final double zza(String str, zzea zzeaVar) {
        if (str == null) {
            return ((Double) zzeaVar.zza(null)).doubleValue();
        }
        String zza = this.zzb.zza(str, zzeaVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Double) zzeaVar.zza(null)).doubleValue();
        }
        try {
            return ((Double) zzeaVar.zza(Double.valueOf(Double.parseDouble(zza)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzeaVar.zza(null)).doubleValue();
        }
    }

    public final int zzb(String str) {
        return zzf(str, zzeb.zzG, 500, 2000);
    }

    public final int zzc() {
        zzlh zzv = this.zzs.zzv();
        Boolean zzj = zzv.zzs.zzt().zzj();
        if (zzv.zzm() < 201500) {
            return (zzj == null || zzj.booleanValue()) ? 25 : 100;
        }
        return 100;
    }

    public final int zzd(String str) {
        return zzf(str, zzeb.zzH, 25, 100);
    }

    public final int zze(String str, zzea zzeaVar) {
        if (str == null) {
            return ((Integer) zzeaVar.zza(null)).intValue();
        }
        String zza = this.zzb.zza(str, zzeaVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Integer) zzeaVar.zza(null)).intValue();
        }
        try {
            return ((Integer) zzeaVar.zza(Integer.valueOf(Integer.parseInt(zza)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzeaVar.zza(null)).intValue();
        }
    }

    public final int zzf(String str, zzea zzeaVar, int i, int i2) {
        return Math.max(Math.min(zze(str, zzeaVar), i2), i);
    }

    public final long zzh() {
        this.zzs.zzaw();
        return 73000L;
    }

    public final long zzi(String str, zzea zzeaVar) {
        if (str == null) {
            return ((Long) zzeaVar.zza(null)).longValue();
        }
        String zza = this.zzb.zza(str, zzeaVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Long) zzeaVar.zza(null)).longValue();
        }
        try {
            return ((Long) zzeaVar.zza(Long.valueOf(Long.parseLong(zza)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzeaVar.zza(null)).longValue();
        }
    }

    final Bundle zzj() {
        try {
            if (this.zzs.zzau().getPackageManager() != null) {
                ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzs.zzau()).getApplicationInfo(this.zzs.zzau().getPackageName(), 128);
                if (applicationInfo == null) {
                    this.zzs.zzay().zzd().zza("Failed to load metadata: ApplicationInfo is null");
                    return null;
                }
                return applicationInfo.metaData;
            }
            this.zzs.zzay().zzd().zza("Failed to load metadata: PackageManager is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            this.zzs.zzay().zzd().zzb("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final Boolean zzk(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzj = zzj();
        if (zzj == null) {
            this.zzs.zzay().zzd().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (zzj.containsKey(str)) {
            return Boolean.valueOf(zzj.getBoolean(str));
        } else {
            return null;
        }
    }

    public final String zzl() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzm() {
        return zzB("debug.deferred.deeplink", "");
    }

    public final String zzn() {
        this.zzs.zzaw();
        return "FA";
    }

    public final String zzo(String str, zzea zzeaVar) {
        if (str == null) {
            return (String) zzeaVar.zza(null);
        }
        return (String) zzeaVar.zza(this.zzb.zza(str, zzeaVar.zzb()));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzp(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzj()
            r1 = 0
            if (r0 != 0) goto L1c
            com.google.android.gms.measurement.internal.zzfy r4 = r3.zzs
            com.google.android.gms.measurement.internal.zzeo r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzem r4 = r4.zzd()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
            goto L22
        L1c:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L24
        L22:
            r4 = r1
            goto L2c
        L24:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L2c:
            if (r4 == 0) goto L58
            com.google.android.gms.measurement.internal.zzfy r0 = r3.zzs     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.Context r0 = r0.zzau()     // Catch: android.content.res.Resources.NotFoundException -> L48
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L48
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L48
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            if (r4 != 0) goto L43
            return r1
        L43:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L48
            return r4
        L48:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfy r0 = r3.zzs
            com.google.android.gms.measurement.internal.zzeo r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzem r0 = r0.zzd()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.zzp(java.lang.String):java.util.List");
    }

    public final void zzq(zzaf zzafVar) {
        this.zzb = zzafVar;
    }

    public final boolean zzr() {
        Boolean zzk = zzk("google_analytics_adid_collection_enabled");
        return zzk == null || zzk.booleanValue();
    }

    public final boolean zzs(String str, zzea zzeaVar) {
        if (str == null) {
            return ((Boolean) zzeaVar.zza(null)).booleanValue();
        }
        String zza = this.zzb.zza(str, zzeaVar.zzb());
        if (TextUtils.isEmpty(zza)) {
            return ((Boolean) zzeaVar.zza(null)).booleanValue();
        }
        return ((Boolean) zzeaVar.zza(Boolean.valueOf("1".equals(zza)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean zzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        return zzk == null || zzk.booleanValue();
    }

    public final boolean zzv() {
        this.zzs.zzaw();
        Boolean zzk = zzk("firebase_analytics_collection_deactivated");
        return zzk != null && zzk.booleanValue();
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzk = zzk("app_measurement_lite");
            this.zza = zzk;
            if (zzk == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzs.zzN();
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    Context zzau = this.zzs.zzau();
                    try {
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 & 3);
                        byte b2 = b;
                        boolean z = true;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = getAuthRequestContext[41];
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ApplicationInfo applicationInfo = (ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(zzau, null);
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            if (str == null || !str.equals(myProcessName)) {
                                z = false;
                            }
                            this.zzc = Boolean.valueOf(z);
                        }
                        if (this.zzc == null) {
                            this.zzc = Boolean.TRUE;
                            this.zzs.zzay().zzd().zza("My process not in the list of running processes");
                        }
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }
}
