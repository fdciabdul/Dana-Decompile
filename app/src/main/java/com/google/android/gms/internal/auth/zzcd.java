package com.google.android.gms.internal.auth;

import android.content.Context;
import javax.annotation.Nullable;

/* loaded from: classes7.dex */
final class zzcd extends zzda {
    private final Context zza;
    private final zzdj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcd(Context context, @Nullable zzdj zzdjVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = zzdjVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzda) {
            zzda zzdaVar = (zzda) obj;
            if (this.zza.equals(zzdaVar.zza())) {
                zzdj zzdjVar = this.zzb;
                if (zzdjVar == null) {
                    if (zzdaVar.zzb() != null) {
                        return false;
                    }
                } else if (!zzdjVar.equals(zzdaVar.zzb())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zza.hashCode();
        zzdj zzdjVar = this.zzb;
        return ((hashCode ^ 1000003) * 1000003) ^ (zzdjVar == null ? 0 : zzdjVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.zza.toString() + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzda
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.auth.zzda
    @Nullable
    public final zzdj zzb() {
        return this.zzb;
    }
}
