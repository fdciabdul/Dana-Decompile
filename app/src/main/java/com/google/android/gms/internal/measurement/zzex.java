package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes7.dex */
public final class zzex extends zzke implements zzlm {
    private static final zzex zza;
    private int zze;
    private int zzf;
    private boolean zzh;
    private String zzg = "";
    private zzkl zzi = zzke.zzbD();

    static {
        zzex zzexVar = new zzex();
        zza = zzexVar;
        zzke.zzbJ(zzex.class, zzexVar);
    }

    private zzex() {
    }

    public static zzex zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzi.size();
    }

    public final String zzd() {
        return this.zzg;
    }

    public final List zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zzh;
    }

    public final boolean zzg() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 1) != 0;
    }

    public final int zzj() {
        int zza2 = zzew.zza(this.zzf);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 != 0) {
            if (i2 != 2) {
                if (i2 != 3) {
                    zzef zzefVar = null;
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzet(zzefVar);
                }
                return new zzex();
            }
            return zzbI(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", zzev.zza, "zzg", "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
