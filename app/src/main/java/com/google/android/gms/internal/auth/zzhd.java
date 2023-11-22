package com.google.android.gms.internal.auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes7.dex */
public final class zzhd extends AbstractList implements RandomAccess, zzfe {
    private final zzfe zza;

    public zzhd(zzfe zzfeVar) {
        this.zza = zzfeVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return ((zzfd) this.zza).get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzhc(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new zzhb(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.auth.zzfe
    public final zzfe zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.auth.zzfe
    public final List zzg() {
        return this.zza.zzg();
    }
}
