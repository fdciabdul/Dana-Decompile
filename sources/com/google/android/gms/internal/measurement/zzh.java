package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public final class zzh {
    public static double zza(double d) {
        if (Double.isNaN(d)) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (Double.isInfinite(d) || d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d;
        }
        double d2 = d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : -1;
        double floor = Math.floor(Math.abs(d));
        Double.isNaN(d2);
        Double.isNaN(d2);
        return d2 * floor;
    }

    public static int zzb(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 0;
        }
        double d2 = d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : -1;
        double floor = Math.floor(Math.abs(d));
        Double.isNaN(d2);
        Double.isNaN(d2);
        return (int) ((d2 * floor) % 4.294967296E9d);
    }

    public static int zzc(zzg zzgVar) {
        int zzb = zzb(zzgVar.zzd("runtime.counter").zzh().doubleValue() + 1.0d);
        if (zzb > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        zzgVar.zzg("runtime.counter", new zzah(Double.valueOf(zzb)));
        return zzb;
    }

    public static long zzd(double d) {
        return zzb(d) & 4294967295L;
    }

    public static zzbl zze(String str) {
        zzbl zza = (str == null || str.isEmpty()) ? null : zzbl.zza(Integer.parseInt(str));
        if (zza != null) {
            return zza;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static Object zzf(zzap zzapVar) {
        if (zzap.zzg.equals(zzapVar)) {
            return null;
        }
        if (zzap.zzf.equals(zzapVar)) {
            return "";
        }
        if (zzapVar instanceof zzam) {
            return zzg((zzam) zzapVar);
        }
        if (zzapVar instanceof zzae) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((zzae) zzapVar).iterator();
            while (it.hasNext()) {
                Object zzf = zzf((zzap) it.next());
                if (zzf != null) {
                    arrayList.add(zzf);
                }
            }
            return arrayList;
        } else if (!zzapVar.zzh().isNaN()) {
            return zzapVar.zzh();
        } else {
            return zzapVar.zzi();
        }
    }

    public static Map zzg(zzam zzamVar) {
        HashMap hashMap = new HashMap();
        for (String str : zzamVar.zzb()) {
            Object zzf = zzf(zzamVar.zzf(str));
            if (zzf != null) {
                hashMap.put(str, zzf);
            }
        }
        return hashMap;
    }

    public static void zzh(String str, int i, List list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void zzi(String str, int i, List list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void zzj(String str, int i, List list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static boolean zzk(zzap zzapVar) {
        if (zzapVar == null) {
            return false;
        }
        Double zzh = zzapVar.zzh();
        return !zzh.isNaN() && zzh.doubleValue() >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && zzh.equals(Double.valueOf(Math.floor(zzh.doubleValue())));
    }

    public static boolean zzl(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar.getClass().equals(zzapVar2.getClass())) {
            if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
                return true;
            }
            if (zzapVar instanceof zzah) {
                if (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue())) {
                    return false;
                }
                return zzapVar.zzh().equals(zzapVar2.zzh());
            } else if (zzapVar instanceof zzat) {
                return zzapVar.zzi().equals(zzapVar2.zzi());
            } else {
                if (zzapVar instanceof zzaf) {
                    return zzapVar.zzg().equals(zzapVar2.zzg());
                }
                return zzapVar == zzapVar2;
            }
        }
        return false;
    }
}
