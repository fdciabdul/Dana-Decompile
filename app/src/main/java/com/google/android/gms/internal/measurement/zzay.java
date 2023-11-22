package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes7.dex */
public final class zzay extends zzaw {
    public zzay() {
        this.zza.add(zzbl.EQUALS);
        this.zza.add(zzbl.GREATER_THAN);
        this.zza.add(zzbl.GREATER_THAN_EQUALS);
        this.zza.add(zzbl.IDENTITY_EQUALS);
        this.zza.add(zzbl.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbl.LESS_THAN);
        this.zza.add(zzbl.LESS_THAN_EQUALS);
        this.zza.add(zzbl.NOT_EQUALS);
    }

    private static boolean zzc(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar.getClass().equals(zzapVar2.getClass())) {
            if ((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) {
                return true;
            }
            if (zzapVar instanceof zzah) {
                return (Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue()) || zzapVar.zzh().doubleValue() != zzapVar2.zzh().doubleValue()) ? false : true;
            } else if (zzapVar instanceof zzat) {
                return zzapVar.zzi().equals(zzapVar2.zzi());
            } else {
                if (zzapVar instanceof zzaf) {
                    return zzapVar.zzg().equals(zzapVar2.zzg());
                }
                return zzapVar == zzapVar2;
            }
        } else if (((zzapVar instanceof zzau) || (zzapVar instanceof zzan)) && ((zzapVar2 instanceof zzau) || (zzapVar2 instanceof zzan))) {
            return true;
        } else {
            boolean z = zzapVar instanceof zzah;
            if (!z || !(zzapVar2 instanceof zzat)) {
                boolean z2 = zzapVar instanceof zzat;
                if (!z2 || !(zzapVar2 instanceof zzah)) {
                    if (zzapVar instanceof zzaf) {
                        return zzc(new zzah(zzapVar.zzh()), zzapVar2);
                    }
                    if (zzapVar2 instanceof zzaf) {
                        return zzc(zzapVar, new zzah(zzapVar2.zzh()));
                    }
                    if ((!z2 && !z) || !(zzapVar2 instanceof zzal)) {
                        if ((zzapVar instanceof zzal) && ((zzapVar2 instanceof zzat) || (zzapVar2 instanceof zzah))) {
                            return zzc(new zzat(zzapVar.zzi()), zzapVar2);
                        }
                        return false;
                    }
                    return zzc(zzapVar, new zzat(zzapVar2.zzi()));
                }
                return zzc(new zzah(zzapVar.zzh()), zzapVar2);
            }
            return zzc(zzapVar, new zzah(zzapVar2.zzh()));
        }
    }

    private static boolean zzd(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzi());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzi());
        }
        if ((zzapVar instanceof zzat) && (zzapVar2 instanceof zzat)) {
            return zzapVar.zzi().compareTo(zzapVar2.zzi()) < 0;
        }
        double doubleValue = zzapVar.zzh().doubleValue();
        double doubleValue2 = zzapVar2.zzh().doubleValue();
        return (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || (doubleValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && doubleValue2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || ((doubleValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && doubleValue2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || Double.compare(doubleValue, doubleValue2) >= 0)) ? false : true;
    }

    private static boolean zze(zzap zzapVar, zzap zzapVar2) {
        if (zzapVar instanceof zzal) {
            zzapVar = new zzat(zzapVar.zzi());
        }
        if (zzapVar2 instanceof zzal) {
            zzapVar2 = new zzat(zzapVar2.zzi());
        }
        return (((zzapVar instanceof zzat) && (zzapVar2 instanceof zzat)) || !(Double.isNaN(zzapVar.zzh().doubleValue()) || Double.isNaN(zzapVar2.zzh().doubleValue()))) && !zzd(zzapVar2, zzapVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        boolean zzc;
        boolean zzc2;
        zzh.zzh(zzh.zze(str).name(), 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal == 48) {
                zzc2 = zzc(zzb, zzb2);
            } else if (ordinal == 42) {
                zzc = zzd(zzb, zzb2);
            } else if (ordinal == 43) {
                zzc = zze(zzb, zzb2);
            } else {
                switch (ordinal) {
                    case 37:
                        zzc = zzd(zzb2, zzb);
                        break;
                    case 38:
                        zzc = zze(zzb2, zzb);
                        break;
                    case 39:
                        zzc = zzh.zzl(zzb, zzb2);
                        break;
                    case 40:
                        zzc2 = zzh.zzl(zzb, zzb2);
                        break;
                    default:
                        return super.zzb(str);
                }
            }
            zzc = !zzc2;
        } else {
            zzc = zzc(zzb, zzb2);
        }
        return zzc ? zzap.zzk : zzap.zzl;
    }
}
