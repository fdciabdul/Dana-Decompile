package com.google.android.gms.internal.fido;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzat extends zzbr implements Serializable {
    final Comparator zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(Comparator comparator) {
        comparator.getClass();
        this.zza = comparator;
    }

    @Override // com.google.android.gms.internal.fido.zzbr, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
