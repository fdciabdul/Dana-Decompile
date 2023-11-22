package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes7.dex */
public final class zzgl extends zzke implements zzlm {
    private static final zzgl zza;
    private int zze;
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private float zzj;
    private double zzk;

    static {
        zzgl zzglVar = new zzgl();
        zza = zzglVar;
        zzke.zzbJ(zzgl.class, zzglVar);
    }

    private zzgl() {
    }

    public static zzgk zzd() {
        return (zzgk) zza.zzbx();
    }

    public static /* synthetic */ void zzh(zzgl zzglVar, long j) {
        zzglVar.zze |= 1;
        zzglVar.zzf = j;
    }

    public static /* synthetic */ void zzi(zzgl zzglVar, String str) {
        str.getClass();
        zzglVar.zze |= 2;
        zzglVar.zzg = str;
    }

    public static /* synthetic */ void zzj(zzgl zzglVar, String str) {
        str.getClass();
        zzglVar.zze |= 4;
        zzglVar.zzh = str;
    }

    public static /* synthetic */ void zzk(zzgl zzglVar) {
        zzglVar.zze &= -5;
        zzglVar.zzh = zza.zzh;
    }

    public static /* synthetic */ void zzm(zzgl zzglVar, long j) {
        zzglVar.zze |= 8;
        zzglVar.zzi = j;
    }

    public static /* synthetic */ void zzn(zzgl zzglVar) {
        zzglVar.zze &= -9;
        zzglVar.zzi = 0L;
    }

    public static /* synthetic */ void zzo(zzgl zzglVar, double d) {
        zzglVar.zze |= 32;
        zzglVar.zzk = d;
    }

    public static /* synthetic */ void zzp(zzgl zzglVar) {
        zzglVar.zze &= -33;
        zzglVar.zzk = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final double zza() {
        return this.zzk;
    }

    public final long zzb() {
        return this.zzi;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zzg;
    }

    public final String zzg() {
        return this.zzh;
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
                    return new zzgk(zzfjVar);
                }
                return new zzgl();
            }
            return zzbI(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        return (byte) 1;
    }

    public final boolean zzq() {
        return (this.zze & 32) != 0;
    }

    public final boolean zzr() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzs() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzt() {
        return (this.zze & 4) != 0;
    }
}
