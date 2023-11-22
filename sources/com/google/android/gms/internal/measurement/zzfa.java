package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzfa extends zzke implements zzlm {
    private static final zzfa zza;
    private int zze;
    private String zzf = "";
    private zzkl zzg = zzbD();
    private boolean zzh;

    static {
        zzfa zzfaVar = new zzfa();
        zza = zzfaVar;
        zzke.zzbJ(zzfa.class, zzfaVar);
    }

    private zzfa() {
    }

    public final String zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    zzey zzeyVar = null;
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzez(zzeyVar);
                }
                return new zzfa();
            }
            return zzbI(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", zzfg.class, "zzh"});
        }
        return (byte) 1;
    }
}
