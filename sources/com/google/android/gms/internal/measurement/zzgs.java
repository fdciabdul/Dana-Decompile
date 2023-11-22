package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes7.dex */
public final class zzgs extends zzke implements zzlm {
    private static final zzgs zza;
    private int zze;
    private zzkl zzf = zzbD();
    private zzgo zzg;

    static {
        zzgs zzgsVar = new zzgs();
        zza = zzgsVar;
        zzke.zzbJ(zzgs.class, zzgsVar);
    }

    private zzgs() {
    }

    public final zzgo zza() {
        zzgo zzgoVar = this.zzg;
        return zzgoVar == null ? zzgo.zzc() : zzgoVar;
    }

    public final List zzc() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    zzgm zzgmVar = null;
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzgr(zzgmVar);
                }
                return new zzgs();
            }
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzgx.class, "zzg"});
        }
        return (byte) 1;
    }
}
