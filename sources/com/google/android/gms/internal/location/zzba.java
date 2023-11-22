package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.GeofenceStatusCodes;

/* loaded from: classes3.dex */
final class zzba extends zzaj {
    private final BaseImplementation.ResultHolder zza;

    public zzba(BaseImplementation.ResultHolder resultHolder) {
        Preconditions.checkArgument(resultHolder != null, "listener can't be null.");
        this.zza = resultHolder;
    }

    private final void zze(int i) {
        BaseImplementation.ResultHolder resultHolder = this.zza;
        int i2 = GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
        if (i != 0 && (i < 1000 || i >= 1006)) {
            i = 13;
        }
        resultHolder.setResult(new Status(i));
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzb(int i, String[] strArr) {
        zze(i);
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzc(int i, PendingIntent pendingIntent) {
        zze(i);
    }

    @Override // com.google.android.gms.internal.location.zzak
    public final void zzd(int i, String[] strArr) {
        zze(i);
    }
}
