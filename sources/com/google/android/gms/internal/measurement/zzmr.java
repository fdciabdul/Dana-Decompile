package com.google.android.gms.internal.measurement;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* loaded from: classes7.dex */
final class zzmr implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzms zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmr(zzms zzmsVar) {
        zzkt zzktVar;
        this.zzb = zzmsVar;
        zzktVar = zzmsVar.zza;
        this.zza = zzktVar.iterator();
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
