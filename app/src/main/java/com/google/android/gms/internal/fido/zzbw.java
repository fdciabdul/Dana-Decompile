package com.google.android.gms.internal.fido;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class zzbw extends zzbr implements Serializable {
    final zzbr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbw(zzbr zzbrVar) {
        this.zza = zzbrVar;
    }

    @Override // com.google.android.gms.internal.fido.zzbr, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbw) {
            return this.zza.equals(((zzbw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    @Override // com.google.android.gms.internal.fido.zzbr
    public final zzbr zza() {
        return this.zza;
    }
}
