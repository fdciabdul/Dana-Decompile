package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public final class zzfu extends zzke implements zzlm {
    private static final zzfu zza;
    private int zze;
    private String zzf = "";
    private long zzg;

    static {
        zzfu zzfuVar = new zzfu();
        zza = zzfuVar;
        zzke.zzbJ(zzfu.class, zzfuVar);
    }

    private zzfu() {
    }

    public static zzft zza() {
        return (zzft) zza.zzbx();
    }

    public static /* synthetic */ void zzc(zzfu zzfuVar, String str) {
        str.getClass();
        zzfuVar.zze |= 1;
        zzfuVar.zzf = str;
    }

    public static /* synthetic */ void zzd(zzfu zzfuVar, long j) {
        zzfuVar.zze |= 2;
        zzfuVar.zzg = j;
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
                    return new zzft(zzfjVar);
                }
                return new zzfu();
            }
            return zzbI(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        return (byte) 1;
    }
}
