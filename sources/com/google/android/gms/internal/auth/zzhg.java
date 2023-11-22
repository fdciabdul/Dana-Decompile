package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* loaded from: classes7.dex */
final class zzhg extends zzhh {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhg(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzj(obj, j));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzi(obj, j));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final void zzc(Object obj, long j, boolean z) {
        if (zzhi.zza) {
            zzhi.zzi(obj, j, z);
        } else {
            zzhi.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final void zzd(Object obj, long j, double d) {
        zzn(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final void zze(Object obj, long j, float f) {
        zzm(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.auth.zzhh
    public final boolean zzf(Object obj, long j) {
        if (zzhi.zza) {
            return zzhi.zzq(obj, j);
        }
        return zzhi.zzr(obj, j);
    }
}
