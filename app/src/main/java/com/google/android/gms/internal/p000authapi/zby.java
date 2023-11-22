package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;

/* loaded from: classes7.dex */
public abstract class zby extends zbb implements zbz {
    public zby() {
        super("com.google.android.gms.auth.api.identity.internal.IAuthorizationCallback");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    protected final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            Status status = (Status) zbc.zba(parcel, Status.CREATOR);
            AuthorizationResult authorizationResult = (AuthorizationResult) zbc.zba(parcel, AuthorizationResult.CREATOR);
            zbc.zbb(parcel);
            zbb(status, authorizationResult);
            return true;
        }
        return false;
    }
}
