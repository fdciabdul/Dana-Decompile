package com.google.android.gms.internal.measurement;

import com.alibaba.ariver.kernel.RVStartParams;
import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class zzbb {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public static zzap zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        Object obj;
        char c;
        String str2;
        double zza;
        double min;
        zzai zzaiVar;
        switch (str.hashCode()) {
            case -1776922004:
                obj = "toString";
                if (str.equals(obj)) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    obj = "toString";
                    c = 0;
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    obj = "toString";
                    c = 2;
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c = '\n';
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 17;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c = 3;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 19;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = 7;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 111185:
                if (str.equals(RVStartParams.BACK_BEHAVIOR_POP)) {
                    c = '\b';
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = 5;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 3452698:
                if (str.equals(LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH)) {
                    c = '\t';
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = 15;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = 16;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    obj = "toString";
                    c = 1;
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = '\r';
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 14;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 11;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = '\f';
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 4;
                    obj = "toString";
                    break;
                }
                obj = "toString";
                c = 65535;
                break;
            default:
                obj = "toString";
                c = 65535;
                break;
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        switch (c) {
            case 0:
                zzap zzd = zzaeVar.zzd();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzap zzb = zzgVar.zzb((zzap) it.next());
                        if (!(zzb instanceof zzag)) {
                            zzae zzaeVar2 = (zzae) zzd;
                            int zzc = zzaeVar2.zzc();
                            if (zzb instanceof zzae) {
                                zzae zzaeVar3 = (zzae) zzb;
                                Iterator zzk = zzaeVar3.zzk();
                                while (zzk.hasNext()) {
                                    Integer num = (Integer) zzk.next();
                                    zzaeVar2.zzq(num.intValue() + zzc, zzaeVar3.zze(num.intValue()));
                                }
                            } else {
                                zzaeVar2.zzq(zzc, zzb);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzd;
            case 1:
                zzh.zzh("every", 1, list);
                zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb2 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() != 0 && zzb(zzaeVar, zzgVar, (zzao) zzb2, false, true).zzc() != zzaeVar.zzc()) {
                    return zzap.zzl;
                }
                return zzap.zzk;
            case 2:
                zzh.zzh("filter", 1, list);
                zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb3 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return new zzae();
                }
                zzap zzd2 = zzaeVar.zzd();
                zzae zzb4 = zzb(zzaeVar, zzgVar, (zzao) zzb3, null, true);
                zzae zzaeVar4 = new zzae();
                Iterator zzk2 = zzb4.zzk();
                while (zzk2.hasNext()) {
                    zzaeVar4.zzq(zzaeVar4.zzc(), ((zzae) zzd2).zze(((Integer) zzk2.next()).intValue()));
                }
                return zzaeVar4;
            case 3:
                zzh.zzh("forEach", 1, list);
                zzap zzb5 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb5 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return zzap.zzf;
                }
                zzb(zzaeVar, zzgVar, (zzao) zzb5, null, null);
                return zzap.zzf;
            case 4:
                zzh.zzj("indexOf", 2, list);
                zzap zzapVar = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar = zzgVar.zzb((zzap) list.get(0));
                }
                if (list.size() > 1) {
                    double zza2 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza2 >= zzaeVar.zzc()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    if (zza2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        double zzc2 = zzaeVar.zzc();
                        Double.isNaN(zzc2);
                        Double.isNaN(zzc2);
                        d = zzc2 + zza2;
                    } else {
                        d = zza2;
                    }
                }
                Iterator zzk3 = zzaeVar.zzk();
                while (zzk3.hasNext()) {
                    int intValue = ((Integer) zzk3.next()).intValue();
                    double d2 = intValue;
                    if (d2 >= d && zzh.zzl(zzaeVar.zze(intValue), zzapVar)) {
                        return new zzah(Double.valueOf(d2));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzj("join", 1, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzm;
                }
                if (list.isEmpty()) {
                    str2 = ",";
                } else {
                    zzap zzb6 = zzgVar.zzb((zzap) list.get(0));
                    str2 = ((zzb6 instanceof zzan) || (zzb6 instanceof zzau)) ? "" : zzb6.zzi();
                }
                return new zzat(zzaeVar.zzj(str2));
            case 6:
                zzh.zzj("lastIndexOf", 2, list);
                zzap zzapVar2 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVar2 = zzgVar.zzb((zzap) list.get(0));
                }
                double zzc3 = zzaeVar.zzc() - 1;
                if (list.size() > 1) {
                    zzap zzb7 = zzgVar.zzb((zzap) list.get(1));
                    if (Double.isNaN(zzb7.zzh().doubleValue())) {
                        zza = zzaeVar.zzc() - 1;
                    } else {
                        zza = zzh.zza(zzb7.zzh().doubleValue());
                    }
                    zzc3 = zza;
                    if (zzc3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        double zzc4 = zzaeVar.zzc();
                        Double.isNaN(zzc4);
                        Double.isNaN(zzc4);
                        zzc3 += zzc4;
                    }
                }
                if (zzc3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int min2 = (int) Math.min(zzaeVar.zzc(), zzc3); min2 >= 0; min2--) {
                    if (zzaeVar.zzs(min2) && zzh.zzl(zzaeVar.zze(min2), zzapVar2)) {
                        return new zzah(Double.valueOf(min2));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zzh("map", 1, list);
                zzap zzb8 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb8 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() == 0) {
                    return new zzae();
                }
                return zzb(zzaeVar, zzgVar, (zzao) zzb8, null, null);
            case '\b':
                zzh.zzh(RVStartParams.BACK_BEHAVIOR_POP, 0, list);
                int zzc5 = zzaeVar.zzc();
                if (zzc5 == 0) {
                    return zzap.zzf;
                }
                int i = zzc5 - 1;
                zzap zze = zzaeVar.zze(i);
                zzaeVar.zzp(i);
                return zze;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzq(zzaeVar.zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            case '\n':
                return zzc(zzaeVar, zzgVar, list, true);
            case 11:
                return zzc(zzaeVar, zzgVar, list, false);
            case '\f':
                zzh.zzh("reverse", 0, list);
                int zzc6 = zzaeVar.zzc();
                if (zzc6 != 0) {
                    for (int i2 = 0; i2 < zzc6 / 2; i2++) {
                        if (zzaeVar.zzs(i2)) {
                            zzap zze2 = zzaeVar.zze(i2);
                            zzaeVar.zzq(i2, null);
                            int i3 = (zzc6 - 1) - i2;
                            if (zzaeVar.zzs(i3)) {
                                zzaeVar.zzq(i2, zzaeVar.zze(i3));
                            }
                            zzaeVar.zzq(i3, zze2);
                        }
                    }
                }
                return zzaeVar;
            case '\r':
                zzh.zzh("shift", 0, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzf;
                }
                zzap zze3 = zzaeVar.zze(0);
                zzaeVar.zzp(0);
                return zze3;
            case 14:
                zzh.zzj("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzd();
                }
                double zzc7 = zzaeVar.zzc();
                double zza3 = zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    Double.isNaN(zzc7);
                    Double.isNaN(zzc7);
                    min = Math.max(zza3 + zzc7, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                } else {
                    min = Math.min(zza3, zzc7);
                }
                if (list.size() == 2) {
                    double zza4 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (zza4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        Double.isNaN(zzc7);
                        Double.isNaN(zzc7);
                        zzc7 = Math.max(zzc7 + zza4, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    } else {
                        zzc7 = Math.min(zzc7, zza4);
                    }
                }
                zzae zzaeVar5 = new zzae();
                for (int i4 = (int) min; i4 < zzc7; i4++) {
                    zzaeVar5.zzq(zzaeVar5.zzc(), zzaeVar.zze(i4));
                }
                return zzaeVar5;
            case 15:
                zzh.zzh("some", 1, list);
                zzap zzb9 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzb9 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzl;
                }
                zzai zzaiVar2 = (zzai) zzb9;
                Iterator zzk4 = zzaeVar.zzk();
                while (zzk4.hasNext()) {
                    int intValue2 = ((Integer) zzk4.next()).intValue();
                    if (zzaeVar.zzs(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue2), new zzah(Double.valueOf(intValue2)), zzaeVar)).zzg().booleanValue()) {
                        return zzap.zzk;
                    }
                }
                return zzap.zzl;
            case 16:
                zzh.zzj("sort", 1, list);
                if (zzaeVar.zzc() >= 2) {
                    List zzm = zzaeVar.zzm();
                    if (list.isEmpty()) {
                        zzaiVar = null;
                    } else {
                        zzap zzb10 = zzgVar.zzb((zzap) list.get(0));
                        if (!(zzb10 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzaiVar = (zzai) zzb10;
                    }
                    Collections.sort(zzm, new zzba(zzaiVar, zzgVar));
                    zzaeVar.zzn();
                    Iterator it3 = zzm.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        zzaeVar.zzq(i5, (zzap) it3.next());
                        i5++;
                    }
                }
                return zzaeVar;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int zza5 = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (zza5 < 0) {
                    zza5 = Math.max(0, zza5 + zzaeVar.zzc());
                } else if (zza5 > zzaeVar.zzc()) {
                    zza5 = zzaeVar.zzc();
                }
                int zzc8 = zzaeVar.zzc();
                zzae zzaeVar6 = new zzae();
                if (list.size() > 1) {
                    int max = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    if (max > 0) {
                        for (int i6 = zza5; i6 < Math.min(zzc8, zza5 + max); i6++) {
                            zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(zza5));
                            zzaeVar.zzp(zza5);
                        }
                    }
                    int i7 = 2;
                    if (list.size() > 2) {
                        int i8 = 2;
                        while (i8 < list.size()) {
                            zzap zzb11 = zzgVar.zzb((zzap) list.get(i8));
                            if (!(zzb11 instanceof zzag)) {
                                zzaeVar.zzo((zza5 + i8) - i7, zzb11);
                                i8++;
                                i7 = 2;
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zza5 < zzc8) {
                        zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(zza5));
                        zzaeVar.zzq(zza5, null);
                        zza5++;
                    }
                }
                return zzaeVar6;
            case 18:
                zzh.zzh(obj, 0, list);
                return new zzat(zzaeVar.zzj(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar7 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzap zzb12 = zzgVar.zzb((zzap) it4.next());
                        if (!(zzb12 instanceof zzag)) {
                            zzaeVar7.zzq(zzaeVar7.zzc(), zzb12);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzc9 = zzaeVar7.zzc();
                    Iterator zzk5 = zzaeVar.zzk();
                    while (zzk5.hasNext()) {
                        Integer num2 = (Integer) zzk5.next();
                        zzaeVar7.zzq(num2.intValue() + zzc9, zzaeVar.zze(num2.intValue()));
                    }
                    zzaeVar.zzn();
                    Iterator zzk6 = zzaeVar7.zzk();
                    while (zzk6.hasNext()) {
                        Integer num3 = (Integer) zzk6.next();
                        zzaeVar.zzq(num3.intValue(), zzaeVar7.zze(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzae zzb(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzk = zzaeVar.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzaeVar.zzs(intValue)) {
                zzap zza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zzg().equals(bool)) {
                    return zzaeVar2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }

    private static zzap zzc(zzae zzaeVar, zzg zzgVar, List list, boolean z) {
        zzap zzapVar;
        zzh.zzi("reduce", 1, list);
        zzh.zzj("reduce", 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        if (!(zzb instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzapVar = zzgVar.zzb((zzap) list.get(1));
            if (zzapVar instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else if (zzaeVar.zzc() == 0) {
            throw new IllegalStateException("Empty array with no initial value error");
        } else {
            zzapVar = null;
        }
        zzai zzaiVar = (zzai) zzb;
        int zzc = zzaeVar.zzc();
        int i = z ? 0 : zzc - 1;
        int i2 = z ? zzc - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (zzapVar == null) {
            zzapVar = zzaeVar.zze(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzaeVar.zzs(i)) {
                zzapVar = zzaiVar.zza(zzgVar, Arrays.asList(zzapVar, zzaeVar.zze(i), new zzah(Double.valueOf(i)), zzaeVar));
                if (zzapVar instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzapVar;
    }
}
