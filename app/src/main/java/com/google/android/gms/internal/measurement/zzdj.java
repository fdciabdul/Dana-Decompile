package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdj extends zzdt {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbz zzb;
    final /* synthetic */ zzee zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdj(zzee zzeeVar, String str, zzbz zzbzVar) {
        super(zzeeVar, true);
        this.zzc = zzeeVar;
        this.zza = str;
        this.zzb = zzbzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzdt
    final void zza() throws RemoteException {
        zzcc zzccVar;
        zzccVar = this.zzc.zzj;
        ((zzcc) Preconditions.checkNotNull(zzccVar)).getMaxUserProperties(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzdt
    protected final void zzb() {
        this.zzb.zzd(null);
    }
}
