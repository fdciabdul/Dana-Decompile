package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes7.dex */
public final class zzfe extends zzke implements zzlm {
    private static final zzfe zza;
    private int zze;
    private long zzf;
    private int zzh;
    private boolean zzm;
    private String zzg = "";
    private zzkl zzi = zzbD();
    private zzkl zzj = zzbD();
    private zzkl zzk = zzbD();
    private String zzl = "";
    private zzkl zzn = zzbD();
    private zzkl zzo = zzbD();
    private String zzp = "";

    static {
        zzfe zzfeVar = new zzfe();
        zza = zzfeVar;
        zzke.zzbJ(zzfe.class, zzfeVar);
    }

    private zzfe() {
    }

    public static zzfd zze() {
        return (zzfd) zza.zzbx();
    }

    public static zzfe zzg() {
        return zza;
    }

    public static /* synthetic */ void zzo(zzfe zzfeVar, int i, zzfc zzfcVar) {
        zzfcVar.getClass();
        zzkl zzklVar = zzfeVar.zzj;
        if (!zzklVar.zzc()) {
            zzfeVar.zzj = zzke.zzbE(zzklVar);
        }
        zzfeVar.zzj.set(i, zzfcVar);
    }

    public final int zza() {
        return this.zzn.size();
    }

    public final int zzb() {
        return this.zzj.size();
    }

    public final long zzc() {
        return this.zzf;
    }

    public final zzfc zzd(int i) {
        return (zzfc) this.zzj.get(i);
    }

    public final String zzh() {
        return this.zzg;
    }

    public final String zzi() {
        return this.zzp;
    }

    public final List zzj() {
        return this.zzk;
    }

    public final List zzk() {
        return this.zzo;
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
                    return new zzfd(zzeyVar);
                }
                return new zzfe();
            }
            return zzbI(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", zzfi.class, "zzj", zzfc.class, "zzk", zzeh.class, "zzl", "zzm", "zzn", zzgs.class, "zzo", zzfa.class, "zzp"});
        }
        return (byte) 1;
    }

    public final List zzm() {
        return this.zzn;
    }

    public final List zzn() {
        return this.zzi;
    }

    public final boolean zzq() {
        return this.zzm;
    }

    public final boolean zzr() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzs() {
        return (this.zze & 1) != 0;
    }
}
