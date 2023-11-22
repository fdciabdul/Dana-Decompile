package com.google.android.gms.internal.measurement;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes7.dex */
final class zzii implements Serializable, zzih {
    final zzih zza;
    volatile transient boolean zzb;
    @CheckForNull
    transient Object zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzii(zzih zzihVar) {
        zzihVar.getClass();
        this.zza = zzihVar;
    }

    public final String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (this.zzb) {
            obj = "<supplier that returned " + this.zzc + SimpleComparison.GREATER_THAN_OPERATION;
        } else {
            obj = this.zza;
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzih
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    Object zza = this.zza.zza();
                    this.zzc = zza;
                    this.zzb = true;
                    return zza;
                }
            }
        }
        return this.zzc;
    }
}
