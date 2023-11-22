package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* loaded from: classes7.dex */
final class zzy extends IStatusCallback.Stub {
    private final BaseImplementation.ResultHolder zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(BaseImplementation.ResultHolder resultHolder) {
        this.zza = resultHolder;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        this.zza.setResult(status);
    }
}
