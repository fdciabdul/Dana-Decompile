package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzgf extends zzke implements zzlm {
    private static final zzgf zza;
    private int zze;
    private int zzf = 1;
    private zzkl zzg = zzbD();

    static {
        zzgf zzgfVar = new zzgf();
        zza = zzgfVar;
        zzke.zzbJ(zzgf.class, zzgfVar);
    }

    private zzgf() {
    }

    public static zzgd zza() {
        return (zzgd) zza.zzbx();
    }

    public static /* synthetic */ void zzc(zzgf zzgfVar, zzfu zzfuVar) {
        zzfuVar.getClass();
        zzkl zzklVar = zzgfVar.zzg;
        if (!zzklVar.zzc()) {
            zzgfVar.zzg = zzke.zzbE(zzklVar);
        }
        zzgfVar.zzg.add(zzfuVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    zzfj zzfjVar = null;
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzgd(zzfjVar);
                }
                return new zzgf();
            }
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zze", "zzf", zzge.zza, "zzg", zzfu.class});
        }
        return (byte) 1;
    }
}
