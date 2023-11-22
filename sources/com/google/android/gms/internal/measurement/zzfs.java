package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes7.dex */
public final class zzfs extends zzke implements zzlm {
    private static final zzfs zza;
    private int zze;
    private zzkl zzf = zzbD();
    private String zzg = "";
    private long zzh;
    private long zzi;
    private int zzj;

    static {
        zzfs zzfsVar = new zzfs();
        zza = zzfsVar;
        zzke.zzbJ(zzfs.class, zzfsVar);
    }

    private zzfs() {
    }

    public static zzfr zze() {
        return (zzfr) zza.zzbx();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzj(zzfs zzfsVar, int i, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzfsVar.zzv();
        zzfsVar.zzf.set(i, zzfwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzk(zzfs zzfsVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzfsVar.zzv();
        zzfsVar.zzf.add(zzfwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzm(zzfs zzfsVar, Iterable iterable) {
        zzfsVar.zzv();
        zzin.zzbt(iterable, zzfsVar.zzf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzo(zzfs zzfsVar, int i) {
        zzfsVar.zzv();
        zzfsVar.zzf.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzp(zzfs zzfsVar, String str) {
        str.getClass();
        zzfsVar.zze |= 1;
        zzfsVar.zzg = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzq(zzfs zzfsVar, long j) {
        zzfsVar.zze |= 2;
        zzfsVar.zzh = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzr(zzfs zzfsVar, long j) {
        zzfsVar.zze |= 4;
        zzfsVar.zzi = j;
    }

    private final void zzv() {
        zzkl zzklVar = this.zzf;
        if (zzklVar.zzc()) {
            return;
        }
        this.zzf = zzke.zzbE(zzklVar);
    }

    public final int zza() {
        return this.zzj;
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final zzfw zzg(int i) {
        return (zzfw) this.zzf.get(i);
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
                    return new zzfr(zzfjVar);
                }
                return new zzfs();
            }
            return zzbI(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", zzfw.class, "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }

    public final boolean zzs() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzt() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzu() {
        return (this.zze & 2) != 0;
    }
}
