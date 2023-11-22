package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzdm extends zzdr {
    private final long zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdm(long j) {
        this.zza = j;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zza() != zzdrVar.zza()) {
            return zza() - zzdrVar.zza();
        }
        long abs = Math.abs(this.zza);
        long abs2 = Math.abs(((zzdm) zzdrVar).zza);
        if (abs < abs2) {
            return -1;
        }
        return abs > abs2 ? 1 : 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.zza == ((zzdm) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zza()), Long.valueOf(this.zza)});
    }

    public final String toString() {
        return Long.toString(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzd(this.zza >= 0 ? (byte) 0 : (byte) 32);
    }

    public final long zzc() {
        return this.zza;
    }
}
