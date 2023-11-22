package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import java.security.MessageDigest;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes.dex */
public final class zzn {
    private static volatile zzag zze;
    private static Context zzg;
    static final zzl zza = new zzf(zzj.zze("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    static final zzl zzb = new zzg(zzj.zze("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    static final zzl zzc = new zzh(zzj.zze("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    static final zzl zzd = new zzi(zzj.zze("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    private static final Object zzf = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zza(String str, zzj zzjVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return zzh(str, zzjVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzb(String str, boolean z, boolean z2, boolean z3) {
        return zzi(str, z, false, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzx zzc(String str, boolean z, boolean z2, boolean z3) {
        return zzi(str, z, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String zzd(boolean z, String str, zzj zzjVar) throws Exception {
        String str2 = true != (!z && zzh(str, zzjVar, true, false).zza) ? "not allowed" : "debug cert rejected";
        MessageDigest zza2 = AndroidUtilsLight.zza("SHA-256");
        Preconditions.checkNotNull(zza2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, Hex.bytesToStringLowercase(zza2.digest(zzjVar.zzf())), Boolean.valueOf(z), "12451000.false");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze(Context context) {
        synchronized (zzn.class) {
            if (zzg != null) {
                InstrumentInjector.log_w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzg = context.getApplicationContext();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzf() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzj();
                return zze.zzg();
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                InstrumentInjector.log_e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return false;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzg() {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                zzj();
                return zze.zzi();
            } catch (RemoteException | DynamiteModule.LoadingException e) {
                InstrumentInjector.log_e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return false;
            }
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static zzx zzh(final String str, final zzj zzjVar, final boolean z, boolean z2) {
        try {
            zzj();
            Preconditions.checkNotNull(zzg);
            try {
                return zze.zzh(new zzs(str, zzjVar, z, z2), ObjectWrapper.wrap(zzg.getPackageManager())) ? zzx.zzb() : new zzv(new Callable() { // from class: com.google.android.gms.common.zze
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzn.zzd(z, str, zzjVar);
                    }
                }, null);
            } catch (RemoteException e) {
                InstrumentInjector.log_e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return zzx.zzd("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            InstrumentInjector.log_e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            return zzx.zzd("module init: ".concat(String.valueOf(e2.getMessage())), e2);
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static zzx zzi(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        zzx zzd2;
        zzq zzf2;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.checkNotNull(zzg);
            try {
                zzj();
                zzo zzoVar = new zzo(str, z, false, ObjectWrapper.wrap(zzg), false, true);
                try {
                    if (z4) {
                        zzf2 = zze.zze(zzoVar);
                    } else {
                        zzf2 = zze.zzf(zzoVar);
                    }
                    if (zzf2.zzb()) {
                        zzd2 = zzx.zzf(zzf2.zzc());
                    } else {
                        String zza2 = zzf2.zza();
                        PackageManager.NameNotFoundException nameNotFoundException = zzf2.zzd() == 4 ? new PackageManager.NameNotFoundException() : null;
                        if (zza2 == null) {
                            zza2 = "error checking package certificate";
                        }
                        zzd2 = zzx.zzg(zzf2.zzc(), zzf2.zzd(), zza2, nameNotFoundException);
                    }
                } catch (RemoteException e) {
                    InstrumentInjector.log_e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    zzd2 = zzx.zzd("module call", e);
                }
            } catch (DynamiteModule.LoadingException e2) {
                InstrumentInjector.log_e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                zzd2 = zzx.zzd("module init: ".concat(String.valueOf(e2.getMessage())), e2);
            }
            return zzd2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static void zzj() throws DynamiteModule.LoadingException {
        if (zze != null) {
            return;
        }
        Preconditions.checkNotNull(zzg);
        synchronized (zzf) {
            if (zze == null) {
                zze = zzaf.zzb(DynamiteModule.load(zzg, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
            }
        }
    }
}
