package com.google.android.gms.internal.auth;

import com.j256.ormlite.stmt.query.SimpleComparison;
import javax.annotation.CheckForNull;

/* loaded from: classes7.dex */
final class zzdl implements zzdj {
    @CheckForNull
    volatile zzdj zza;
    volatile boolean zzb;
    @CheckForNull
    Object zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdl(zzdj zzdjVar) {
        zzdjVar.getClass();
        this.zza = zzdjVar;
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

    @Override // com.google.android.gms.internal.auth.zzdj
    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzdj zzdjVar = this.zza;
                    zzdjVar.getClass();
                    Object zza = zzdjVar.zza();
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
