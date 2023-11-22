package com.google.android.gms.internal.measurement;

import android.content.Context;
import javax.annotation.Nullable;

/* loaded from: classes7.dex */
final class zzhb extends zzhy {
    private final Context zza;
    private final zzih zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhb(Context context, @Nullable zzih zzihVar) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = zzihVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhy) {
            zzhy zzhyVar = (zzhy) obj;
            if (this.zza.equals(zzhyVar.zza())) {
                zzih zzihVar = this.zzb;
                if (zzihVar == null) {
                    if (zzhyVar.zzb() != null) {
                        return false;
                    }
                } else if (!zzihVar.equals(zzhyVar.zzb())) {
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
        zzih zzihVar = this.zzb;
        return ((hashCode ^ 1000003) * 1000003) ^ (zzihVar == null ? 0 : zzihVar.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + this.zza.toString() + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhy
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzhy
    @Nullable
    public final zzih zzb() {
        return this.zzb;
    }
}
