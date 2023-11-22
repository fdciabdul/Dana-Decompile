package com.google.android.gms.internal.measurement;

/* loaded from: classes7.dex */
public class zzkr {
    private static final zzjq zzb = zzjq.zza;
    protected volatile zzll zza;
    private volatile zzjd zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkr) {
            zzkr zzkrVar = (zzkr) obj;
            zzll zzllVar = this.zza;
            zzll zzllVar2 = zzkrVar.zza;
            if (zzllVar == null && zzllVar2 == null) {
                return zzb().equals(zzkrVar.zzb());
            }
            if (zzllVar == null || zzllVar2 == null) {
                if (zzllVar != null) {
                    zzkrVar.zzc(zzllVar.zzbO());
                    return zzllVar.equals(zzkrVar.zza);
                }
                zzc(zzllVar2.zzbO());
                return this.zza.equals(zzllVar2);
            }
            return zzllVar.equals(zzllVar2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzja) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzbw();
        }
        return 0;
    }

    public final zzjd zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                return this.zzc;
            }
            if (this.zza == null) {
                this.zzc = zzjd.zzb;
            } else {
                this.zzc = this.zza.zzbs();
            }
            return this.zzc;
        }
    }

    protected final void zzc(zzll zzllVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza == null) {
                try {
                    this.zza = zzllVar;
                    this.zzc = zzjd.zzb;
                } catch (zzko unused) {
                    this.zza = zzllVar;
                    this.zzc = zzjd.zzb;
                }
            }
        }
    }
}
