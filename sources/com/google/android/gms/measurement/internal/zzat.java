package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

/* loaded from: classes7.dex */
final class zzat implements Iterator, j$.util.Iterator {
    final Iterator zza;
    final /* synthetic */ zzau zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(zzau zzauVar) {
        Bundle bundle;
        this.zzb = zzauVar;
        bundle = zzauVar.zza;
        this.zza = bundle.keySet().iterator();
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
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator
    /* renamed from: zza  reason: merged with bridge method [inline-methods] */
    public final String next() {
        return (String) this.zza.next();
    }
}
