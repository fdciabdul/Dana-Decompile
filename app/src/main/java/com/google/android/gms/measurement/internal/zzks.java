package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzks implements Callable {
    final /* synthetic */ zzq zza;
    final /* synthetic */ zzkz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzks(zzkz zzkzVar, zzq zzqVar) {
        this.zzb = zzkzVar;
        this.zza = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        if (!this.zzb.zzh((String) Preconditions.checkNotNull(this.zza.zza)).zzi(zzah.ANALYTICS_STORAGE) || !zzai.zzb(this.zza.zzv).zzi(zzah.ANALYTICS_STORAGE)) {
            this.zzb.zzay().zzj().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        return this.zzb.zzd(this.zza).zzu();
    }
}
