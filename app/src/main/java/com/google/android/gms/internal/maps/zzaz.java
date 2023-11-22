package com.google.android.gms.internal.maps;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* loaded from: classes7.dex */
public abstract class zzaz extends zzaw implements List, RandomAccess {
    private static final zzbg zza = new zzax(zzbc.zza, 0);
    public static final /* synthetic */ int zzd = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaz zzg(Object[] objArr, int i) {
        if (i == 0) {
            return zzbc.zza;
        }
        return new zzbc(objArr, i);
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
                    if (!zzar.zza(get(i), list.get(i))) {
                        return false;
                    }
                }
            } else {
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (!it2.hasNext() || !zzar.zza(it.next(), it2.next())) {
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

    @Override // com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
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

    @Override // com.google.android.gms.internal.maps.zzaw
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    /* renamed from: zzd */
    public final zzbf iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: zzf  reason: merged with bridge method [inline-methods] */
    public zzaz subList(int i, int i2) {
        zzas.zzc(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 != 0) {
            return new zzay(this, i, i3);
        }
        return zzbc.zza;
    }

    @Override // java.util.List
    /* renamed from: zzh  reason: merged with bridge method [inline-methods] */
    public final zzbg listIterator(int i) {
        zzas.zzb(i, size(), "index");
        return isEmpty() ? zza : new zzax(this, i);
    }
}
