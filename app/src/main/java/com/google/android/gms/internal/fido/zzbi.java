package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzbi extends zzbj implements NavigableSet, zzbz {
    final transient Comparator zza;
    @CheckForNull
    transient zzbi zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbi(Comparator comparator) {
        this.zza = comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbu zzq(Comparator comparator) {
        if (zzbp.zza.equals(comparator)) {
            return zzbu.zzc;
        }
        int i = zzaz.zzd;
        return new zzbu(zzbs.zza, comparator);
    }

    @Override // java.util.SortedSet, com.google.android.gms.internal.fido.zzbz
    public final Comparator comparator() {
        return this.zza;
    }

    @Override // java.util.SortedSet
    public Object first() {
        return iterator().next();
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.fido.zzbc, com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzcb iterator();

    abstract zzbi zzf();

    @Override // java.util.NavigableSet
    /* renamed from: zzl  reason: merged with bridge method [inline-methods] */
    public final zzbi descendingSet() {
        zzbi zzbiVar = this.zzb;
        if (zzbiVar == null) {
            zzbi zzf = zzf();
            this.zzb = zzf;
            zzf.zzb = this;
            return zzf;
        }
        return zzbiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract zzbi zzm(Object obj, boolean z);

    abstract zzbi zzo(Object obj, boolean z, Object obj2, boolean z2);

    abstract zzbi zzp(Object obj, boolean z);

    @Override // java.util.NavigableSet
    /* renamed from: zzr  reason: merged with bridge method [inline-methods] */
    public abstract zzcb descendingIterator();

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        obj.getClass();
        return zzm(obj, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        obj.getClass();
        return zzp(obj, true);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object ceiling(Object obj) {
        obj.getClass();
        return zzbk.zza(zzp(obj, true), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object floor(Object obj) {
        obj.getClass();
        return zzbm.zza(zzm(obj, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object higher(Object obj) {
        obj.getClass();
        return zzbk.zza(zzp(obj, false), null);
    }

    @Override // java.util.NavigableSet
    @CheckForNull
    public Object lower(Object obj) {
        obj.getClass();
        return zzbm.zza(zzm(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        obj.getClass();
        return zzm(obj, z);
    }

    @Override // java.util.NavigableSet
    public final /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        obj.getClass();
        return zzp(obj, z);
    }

    @Override // java.util.NavigableSet
    /* renamed from: zzn  reason: merged with bridge method [inline-methods] */
    public final zzbi subSet(Object obj, boolean z, Object obj2, boolean z2) {
        obj.getClass();
        obj2.getClass();
        zzap.zzc(this.zza.compare(obj, obj2) <= 0);
        return zzo(obj, z, obj2, z2);
    }
}
