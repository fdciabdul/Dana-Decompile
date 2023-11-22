package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: classes7.dex */
final class zzmv extends zzmw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzk(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzj(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zzc(Object obj, long j, boolean z) {
        if (zzmx.zzb) {
            zzmx.zzD(obj, j, r3 ? (byte) 1 : (byte) 0);
        } else {
            zzmx.zzE(obj, j, r3 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zzd(Object obj, long j, byte b) {
        if (zzmx.zzb) {
            zzmx.zzD(obj, j, b);
        } else {
            zzmx.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zze(Object obj, long j, double d) {
        zzo(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final void zzf(Object obj, long j, float f) {
        zzn(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.zzmw
    public final boolean zzg(Object obj, long j) {
        if (zzmx.zzb) {
            return zzmx.zzt(obj, j);
        }
        return zzmx.zzu(obj, j);
    }
}
