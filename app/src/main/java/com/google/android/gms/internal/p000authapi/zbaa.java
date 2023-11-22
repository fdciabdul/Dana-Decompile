package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;

/* loaded from: classes7.dex */
public final class zbaa extends zba implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zbaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbz zbzVar, AuthorizationRequest authorizationRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbzVar);
        zbc.zbc(zba, authorizationRequest);
        zbb(1, zba);
    }
}
