package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsResult;

/* loaded from: classes3.dex */
final class zzbd extends zzap {
    private final BaseImplementation.ResultHolder zza;

    public zzbd(BaseImplementation.ResultHolder resultHolder) {
        Preconditions.checkArgument(resultHolder != null, "listener can't be null.");
        this.zza = resultHolder;
    }

    @Override // com.google.android.gms.internal.location.zzaq
    public final void zzb(LocationSettingsResult locationSettingsResult) {
        this.zza.setResult(locationSettingsResult);
    }
}
