package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbu extends zzbi {
    static final zzbu zzc;
    final transient zzaz zzd;

    static {
        int i = zzaz.zzd;
        zzc = new zzbu(zzbs.zza, zzbp.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbu(zzaz zzazVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzazVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.NavigableSet
    @CheckForNull
    public final Object ceiling(Object obj) {
        int zzt = zzt(obj, true);
        if (zzt == this.zzd.size()) {
            return null;
        }
        return this.zzd.get(zzt);
    }

    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            try {
                return Collections.binarySearch(this.zzd, obj, this.zza) >= 0;
            } catch (ClassCastException unused) {
                return false;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzbo) {
            collection = ((zzbo) collection).zza();
        }
        if (!zzca.zza(((zzbi) this).zza, collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        zzcc listIterator = this.zzd.listIterator(0);
        Iterator it = collection.iterator();
        if (!listIterator.hasNext()) {
            return false;
        }
        Object next = it.next();
        E next2 = listIterator.next();
        while (true) {
            try {
                int compare = ((zzbi) this).zza.compare(next2, next);
                if (compare >= 0) {
                    if (compare != 0) {
                        break;
                    } else if (!it.hasNext()) {
                        return true;
                    } else {
                        next = it.next();
                    }
                } else if (!listIterator.hasNext()) {
                    return false;
                } else {
                    next2 = listIterator.next();
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fido.zzbc, java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.zzd.size() != set.size()) {
                return false;
            }
            if (isEmpty()) {
                return true;
            }
            if (zzca.zza(this.zza, set)) {
                Iterator it = set.iterator();
                try {
                    zzcc listIterator = this.zzd.listIterator(0);
                    while (listIterator.hasNext()) {
                        E next = listIterator.next();
                        Object next2 = it.next();
                        if (next2 == null || ((zzbi) this).zza.compare(next, next2) != 0) {
                            return false;
                        }
                    }
                    return true;
                } catch (ClassCastException | NoSuchElementException unused) {
                    return false;
                }
            }
            return containsAll(set);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.SortedSet
    public final Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.zzd.get(0);
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.NavigableSet
    @CheckForNull
    public final Object floor(Object obj) {
        int zzs = zzs(obj, true) - 1;
        if (zzs == -1) {
            return null;
        }
        return this.zzd.get(zzs);
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.NavigableSet
    @CheckForNull
    public final Object higher(Object obj) {
        int zzt = zzt(obj, false);
        if (zzt == this.zzd.size()) {
            return null;
        }
        return this.zzd.get(zzt);
    }

    @Override // com.google.android.gms.internal.fido.zzbi, com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.SortedSet
    public final Object last() {
        if (!isEmpty()) {
            return this.zzd.get(r0.size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.NavigableSet
    @CheckForNull
    public final Object lower(Object obj) {
        int zzs = zzs(obj, false) - 1;
        if (zzs == -1) {
            return null;
        }
        return this.zzd.get(zzs);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzav
    public final int zza(Object[] objArr, int i) {
        return this.zzd.zza(objArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzb() {
        return this.zzd.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzav
    public final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.fido.zzbi, com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav
    /* renamed from: zzd */
    public final zzcb iterator() {
        return this.zzd.listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzav
    @CheckForNull
    public final Object[] zze() {
        return this.zzd.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzbi
    final zzbi zzf() {
        Comparator reverseOrder = Collections.reverseOrder(this.zza);
        if (isEmpty()) {
            return zzq(reverseOrder);
        }
        return new zzbu(this.zzd.zzf(), reverseOrder);
    }

    @Override // com.google.android.gms.internal.fido.zzbc
    public final zzaz zzi() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzbi
    public final zzbi zzm(Object obj, boolean z) {
        return zzu(0, zzs(obj, z));
    }

    @Override // com.google.android.gms.internal.fido.zzbi
    final zzbi zzo(Object obj, boolean z, Object obj2, boolean z2) {
        return zzp(obj, z).zzm(obj2, z2);
    }

    @Override // com.google.android.gms.internal.fido.zzbi
    final zzbi zzp(Object obj, boolean z) {
        return zzu(zzt(obj, z), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.fido.zzbi, java.util.NavigableSet
    /* renamed from: zzr */
    public final zzcb descendingIterator() {
        return this.zzd.zzf().listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzs(Object obj, boolean z) {
        zzaz zzazVar = this.zzd;
        obj.getClass();
        int binarySearch = Collections.binarySearch(zzazVar, obj, ((zzbi) this).zza);
        return binarySearch >= 0 ? z ? binarySearch + 1 : binarySearch : binarySearch ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzt(Object obj, boolean z) {
        zzaz zzazVar = this.zzd;
        obj.getClass();
        int binarySearch = Collections.binarySearch(zzazVar, obj, ((zzbi) this).zza);
        return binarySearch >= 0 ? z ? binarySearch : binarySearch + 1 : binarySearch ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbu zzu(int i, int i2) {
        if (i == 0) {
            if (i2 == this.zzd.size()) {
                return this;
            }
            i = 0;
        }
        if (i < i2) {
            return new zzbu(this.zzd.subList(i, i2), this.zza);
        }
        return zzq(this.zza);
    }
}
