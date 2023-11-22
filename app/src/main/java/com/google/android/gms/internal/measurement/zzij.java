package com.google.android.gms.internal.measurement;

import com.j256.ormlite.stmt.query.SimpleComparison;
import javax.annotation.CheckForNull;

/* loaded from: classes7.dex */
final class zzij implements zzih {
    @CheckForNull
    volatile zzih zza;
    volatile boolean zzb;
    @CheckForNull
    Object zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzij(zzih zzihVar) {
        zzihVar.getClass();
        this.zza = zzihVar;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + SimpleComparison.GREATER_THAN_OPERATION;
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
                    zzih zzihVar = this.zza;
                    zzihVar.getClass();
                    Object zza = zzihVar.zza();
                    this.zzc = zza;
                    this.zzb = true;
                    this.zza = null;
                    return zza;
                }
            }
        }
        return this.zzc;
    }
}
