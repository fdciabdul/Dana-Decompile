package com.google.android.gms.internal.fido;

import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class zzdk extends zzdr {
    private final zzcz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdk(zzcz zzczVar) {
        this.zza = zzczVar;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzdr zzdrVar = (zzdr) obj;
        if (zzd(SignedBytes.MAX_POWER_OF_TWO) != zzdrVar.zza()) {
            return zzd(SignedBytes.MAX_POWER_OF_TWO) - zzdrVar.zza();
        }
        zzdk zzdkVar = (zzdk) zzdrVar;
        zzcz zzczVar = this.zza;
        int zzd = zzczVar.zzd();
        zzcz zzczVar2 = zzdkVar.zza;
        if (zzd != zzczVar2.zzd()) {
            return zzczVar.zzd() - zzczVar2.zzd();
        }
        return zzco.zza().compare(zzczVar.zzm(), zzdkVar.zza.zzm());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzdk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd(SignedBytes.MAX_POWER_OF_TWO)), this.zza});
    }

    public final String toString() {
        zzch zzd = zzch.zzf().zzd();
        byte[] zzm = this.zza.zzm();
        return "h'" + zzd.zzg(zzm, 0, zzm.length) + "'";
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    protected final int zza() {
        return zzd(SignedBytes.MAX_POWER_OF_TWO);
    }

    public final zzcz zzc() {
        return this.zza;
    }
}
