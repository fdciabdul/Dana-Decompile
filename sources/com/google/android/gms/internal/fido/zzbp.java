package com.google.android.gms.internal.fido;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class zzbp extends zzbr implements Serializable {
    static final zzbp zza = new zzbp();

    private zzbp() {
    }

    @Override // com.google.android.gms.internal.fido.zzbr, java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    @Override // com.google.android.gms.internal.fido.zzbr
    public final zzbr zza() {
        return zzbv.zza;
    }
}
