package com.google.android.gms.measurement.internal;

import java.util.List;

/* loaded from: classes7.dex */
public final class zzfn implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzfp zza;

    public zzfn(zzfp zzfpVar) {
        this.zza = zzfpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzem zzc;
        int i2 = i - 1;
        if (i2 == 0) {
            zzc = this.zza.zzs.zzay().zzc();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzc = this.zza.zzs.zzay().zzj();
            } else if (i2 != 4) {
                zzc = this.zza.zzs.zzay().zzi();
            } else if (z) {
                zzc = this.zza.zzs.zzay().zzm();
            } else if (!z2) {
                zzc = this.zza.zzs.zzay().zzl();
            } else {
                zzc = this.zza.zzs.zzay().zzk();
            }
        } else if (z) {
            zzc = this.zza.zzs.zzay().zzh();
        } else if (!z2) {
            zzc = this.zza.zzs.zzay().zze();
        } else {
            zzc = this.zza.zzs.zzay().zzd();
        }
        int size = list.size();
        if (size == 1) {
            zzc.zzb(str, list.get(0));
        } else if (size == 2) {
            zzc.zzc(str, list.get(0), list.get(1));
        } else if (size == 3) {
            zzc.zzd(str, list.get(0), list.get(1), list.get(2));
        } else {
            zzc.zza(str);
        }
    }
}
