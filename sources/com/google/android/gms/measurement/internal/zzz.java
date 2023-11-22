package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzny;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzz extends zzy {
    final /* synthetic */ zzaa zza;
    private final com.google.android.gms.internal.measurement.zzes zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzaa zzaaVar, String str, int i, com.google.android.gms.internal.measurement.zzes zzesVar) {
        super(str, i);
        this.zza = zzaaVar;
        this.zzh = zzesVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final int zza() {
        return this.zzh.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean zzc() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(Long l, Long l2, com.google.android.gms.internal.measurement.zzgl zzglVar, boolean z) {
        zzny.zzc();
        boolean zzs = this.zza.zzs.zzf().zzs(this.zzb, zzeb.zzU);
        boolean zzg = this.zzh.zzg();
        boolean zzh = this.zzh.zzh();
        boolean zzi = this.zzh.zzi();
        boolean z2 = zzg || zzh || zzi;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (!z || z2) {
            com.google.android.gms.internal.measurement.zzel zzb = this.zzh.zzb();
            boolean zzg2 = zzb.zzg();
            if (zzglVar.zzr()) {
                if (!zzb.zzi()) {
                    this.zza.zzs.zzay().zzk().zzb("No number filter for long property. property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
                } else {
                    bool = zzj(zzh(zzglVar.zzb(), zzb.zzc()), zzg2);
                }
            } else if (zzglVar.zzq()) {
                if (!zzb.zzi()) {
                    this.zza.zzs.zzay().zzk().zzb("No number filter for double property. property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
                } else {
                    bool = zzj(zzg(zzglVar.zza(), zzb.zzc()), zzg2);
                }
            } else if (zzglVar.zzt()) {
                if (!zzb.zzk()) {
                    if (!zzb.zzi()) {
                        this.zza.zzs.zzay().zzk().zzb("No string or number filter defined. property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
                    } else if (zzlb.zzx(zzglVar.zzg())) {
                        bool = zzj(zzi(zzglVar.zzg(), zzb.zzc()), zzg2);
                    } else {
                        this.zza.zzs.zzay().zzk().zzc("Invalid user property value for Numeric number filter. property, value", this.zza.zzs.zzj().zzf(zzglVar.zzf()), zzglVar.zzg());
                    }
                } else {
                    bool = zzj(zzf(zzglVar.zzg(), zzb.zzd(), this.zza.zzs.zzay()), zzg2);
                }
            } else {
                this.zza.zzs.zzay().zzk().zzb("User property has no value, property", this.zza.zzs.zzj().zzf(zzglVar.zzf()));
            }
            this.zza.zzs.zzay().zzj().zzb("Property filter result", bool == null ? "null" : bool);
            if (bool == null) {
                return false;
            }
            this.zzd = true;
            if (!zzi || bool.booleanValue()) {
                if (!z || this.zzh.zzg()) {
                    this.zze = bool;
                }
                if (bool.booleanValue() && z2 && zzglVar.zzs()) {
                    long zzc = zzglVar.zzc();
                    if (l != null) {
                        zzc = l.longValue();
                    }
                    if (zzs && this.zzh.zzg() && !this.zzh.zzh() && l2 != null) {
                        zzc = l2.longValue();
                    }
                    if (this.zzh.zzh()) {
                        this.zzg = Long.valueOf(zzc);
                    } else {
                        this.zzf = Long.valueOf(zzc);
                    }
                }
                return true;
            }
            return true;
        }
        this.zza.zzs.zzay().zzj().zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.zzc), this.zzh.zzj() ? Integer.valueOf(this.zzh.zza()) : null);
        return true;
    }
}
