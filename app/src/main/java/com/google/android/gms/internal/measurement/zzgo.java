package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes7.dex */
public final class zzgo extends zzke implements zzlm {
    private static final zzgo zza;
    private zzkl zze = zzbD();

    static {
        zzgo zzgoVar = new zzgo();
        zza = zzgoVar;
        zzke.zzbJ(zzgo.class, zzgoVar);
    }

    private zzgo() {
    }

    public static zzgo zzc() {
        return zza;
    }

    public final int zza() {
        return this.zze.size();
    }

    public final List zzd() {
        return this.zze;
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
                    return new zzgn(zzgmVar);
                }
                return new zzgo();
            }
            return zzbI(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzgq.class});
        }
        return (byte) 1;
    }
}
