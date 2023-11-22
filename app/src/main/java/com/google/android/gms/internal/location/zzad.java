package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class zzad extends zzae {
    final /* synthetic */ com.google.android.gms.location.zzbx zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(zzaf zzafVar, GoogleApiClient googleApiClient, com.google.android.gms.location.zzbx zzbxVar) {
        super(googleApiClient);
        this.zza = zzbxVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        com.google.android.gms.location.zzbx zzbxVar = this.zza;
        Preconditions.checkNotNull(zzbxVar, "removeGeofencingRequest can't be null.");
        Preconditions.checkNotNull(this, "ResultHolder not provided.");
        ((zzam) ((zzbe) anyClient).getService()).zzm(zzbxVar, new zzba(this));
    }
}
