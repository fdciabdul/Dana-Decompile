package com.google.android.gms.internal.fido;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzbc extends zzav implements Set {
    @CheckForNull
    private transient zzaz zza;

    static int zzh(int i) {
        double d;
        int max = Math.max(i, 2);
        if (max >= 751619276) {
            if (max < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int highestOneBit = Integer.highestOneBit(max - 1);
        do {
            highestOneBit += highestOneBit;
            d = highestOneBit;
            Double.isNaN(d);
            Double.isNaN(d);
        } while (d * 0.7d < max);
        return highestOneBit;
    }

    public static zzbc zzk(Object obj, Object obj2) {
        return zzf(2, obj, obj2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbc) && zzg() && ((zzbc) obj).zzg() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzbx.zza(this);
    }

    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzcb iterator();

    boolean zzg() {
        return false;
    }

    public zzaz zzi() {
        zzaz zzazVar = this.zza;
        if (zzazVar == null) {
            zzaz zzj = zzj();
            this.zza = zzj;
            return zzj;
        }
        return zzazVar;
    }

    zzaz zzj() {
        Object[] array = toArray();
        int i = zzaz.zzd;
        return zzaz.zzh(array, array.length);
    }

    private static zzbc zzf(int i, Object... objArr) {
        if (i != 0) {
            if (i == 1) {
                Object obj = objArr[0];
                obj.getClass();
                return new zzby(obj);
            }
            int zzh = zzh(i);
            Object[] objArr2 = new Object[zzh];
            int i2 = zzh - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj2 = objArr[i5];
                zzbq.zza(obj2, i5);
                int hashCode = obj2.hashCode();
                int zza = zzau.zza(hashCode);
                while (true) {
                    int i6 = zza & i2;
                    Object obj3 = objArr2[i6];
                    if (obj3 != null) {
                        if (!obj3.equals(obj2)) {
                            zza++;
                        }
                    } else {
                        objArr[i4] = obj2;
                        objArr2[i6] = obj2;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                Object obj4 = objArr[0];
                obj4.getClass();
                return new zzby(obj4);
            }
            if (zzh(i4) >= zzh / 2) {
                if (i4 <= 0) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new zzbt(objArr, i3, objArr2, i2, i4);
            }
            return zzf(i4, objArr);
        }
        return zzbt.zza;
    }
}
