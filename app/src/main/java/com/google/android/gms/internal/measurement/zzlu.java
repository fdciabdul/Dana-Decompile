package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: classes7.dex */
final class zzlu extends zzio implements RandomAccess {
    private static final zzlu zza;
    private Object[] zzb;
    private int zzc;

    static {
        zzlu zzluVar = new zzlu(new Object[0], 0);
        zza = zzluVar;
        zzluVar.zzb();
    }

    zzlu() {
        this(new Object[10], 0);
    }

    public static zzlu zze() {
        return zza;
    }

    private final String zzf(int i) {
        return "Index:" + i + ", Size:" + this.zzc;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        zzbP();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i));
        }
        Object[] objArr = this.zzb;
        if (i2 < objArr.length) {
            System.arraycopy(objArr, i, objArr, i + 1, i2 - i);
        } else {
            Object[] objArr2 = new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            System.arraycopy(this.zzb, i, objArr2, i + 1, this.zzc - i);
            this.zzb = objArr2;
        }
        this.zzb[i] = obj;
        this.zzc++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zzg(i);
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        zzbP();
        zzg(i);
        Object[] objArr = this.zzb;
        Object obj = objArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(objArr, i + 1, objArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        zzbP();
        zzg(i);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        this.modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final /* synthetic */ zzkl zzd(int i) {
        if (i < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzlu(Arrays.copyOf(this.zzb, i), this.zzc);
    }

    private zzlu(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzio, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzbP();
        int i = this.zzc;
        Object[] objArr = this.zzb;
        if (i == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        objArr2[i2] = obj;
        this.modCount++;
        return true;
    }
}
