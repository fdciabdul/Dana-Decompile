package com.google.android.gms.internal.fido;

import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
abstract class zzbb extends zzbc {
    @Override // com.google.android.gms.internal.fido.zzav, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = zzf().get(entry.getKey());
            return obj2 != null && obj2.equals(entry.getValue());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fido.zzbc, java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzbx.zza(zzf().entrySet());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return zzf().size();
    }

    abstract zzba zzf();

    @Override // com.google.android.gms.internal.fido.zzbc
    final boolean zzg() {
        return false;
    }
}
