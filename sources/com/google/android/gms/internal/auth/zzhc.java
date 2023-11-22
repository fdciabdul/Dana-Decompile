package com.google.android.gms.internal.auth;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* loaded from: classes7.dex */
final class zzhc implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzhd zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhc(zzhd zzhdVar) {
        zzfe zzfeVar;
        this.zzb = zzhdVar;
        zzfeVar = zzhdVar.zza;
        this.zza = zzfeVar.iterator();
    }

    @Override // j$.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.getAuthRequestContext(this, consumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.PlaceComponentResult(consumer));
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
