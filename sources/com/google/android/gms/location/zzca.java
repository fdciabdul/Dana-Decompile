package com.google.android.gms.location;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes7.dex */
final class zzca implements BaseImplementation.ResultHolder {
    private final TaskCompletionSource zza;

    public zzca(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        this.zza.setException(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* synthetic */ void setResult(Object obj) {
        LocationSettingsResult locationSettingsResult = (LocationSettingsResult) obj;
        Status status = locationSettingsResult.getStatus();
        if (status.isSuccess()) {
            this.zza.setResult(new LocationSettingsResponse(locationSettingsResult));
        } else if (status.hasResolution()) {
            this.zza.setException(new ResolvableApiException(status));
        } else {
            this.zza.setException(new ApiException(status));
        }
    }
}
