package com.google.android.gms.internal.fido;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzdj extends zzdr {
    private final boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdj(boolean z) {
        this.zza = z;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zzd((byte) -32) != zzdrVar.zza()) {
            return zzd((byte) -32) - zzdrVar.zza();
        }
        return (true != this.zza ? 20 : 21) - (true != ((zzdj) zzdrVar).zza ? 20 : 21);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.zza == ((zzdj) obj).zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd((byte) -32)), Boolean.valueOf(this.zza)});
    }

    public final String toString() {
        return Boolean.toString(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.fido.zzdr
    public final int zza() {
        return zzd((byte) -32);
    }
}
