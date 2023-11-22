package com.google.android.gms.internal.location;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzbx extends zzbu implements List, RandomAccess {
    private static final zzca zza = new zzbv(zzby.zza, 0);

    static zzbx zzi(Object[] objArr, int i) {
        if (i == 0) {
            return zzby.zza;
        }
        return new zzby(objArr, i);
    }

    public static zzbx zzj(Collection collection) {
        if (collection instanceof zzbu) {
            zzbx zzd = ((zzbu) collection).zzd();
            if (zzd.zzf()) {
                Object[] array = zzd.toArray();
                return zzi(array, array.length);
            }
            return zzd;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            if (array2[i] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i);
                throw new NullPointerException(sb.toString());
            }
        }
        return zzi(array2, length);
    }

    public static zzbx zzk() {
        return zzby.zza;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (list instanceof RandomAccess) {
                for (int i = 0; i < size; i++) {
                    if (!zzbq.zza(get(i), list.get(i))) {
                        return false;
                    }
                }
            } else {
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (!it2.hasNext() || !zzbq.zza(it.next(), it2.next())) {
                        return false;
                    }
                }
                if (it2.hasNext()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.location.zzbu, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.location.zzbu
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.location.zzbu
    @Deprecated
    public final zzbx zzd() {
        return this;
    }

    @Override // com.google.android.gms.internal.location.zzbu
    /* renamed from: zze */
    public final zzbz iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzh  reason: merged with bridge method [inline-methods] */
    public zzbx subList(int i, int i2) {
        zzbr.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 != 0) {
            return new zzbw(this, i, i3);
        }
        return zzby.zza;
    }

    @Override // java.util.List
    /* renamed from: zzl  reason: merged with bridge method [inline-methods] */
    public final zzca listIterator(int i) {
        zzbr.zzb(i, size(), "index");
        return isEmpty() ? zza : new zzbv(this, i);
    }
}
