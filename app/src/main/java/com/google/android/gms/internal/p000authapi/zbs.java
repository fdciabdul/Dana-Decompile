package com.google.android.gms.internal.p000authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* loaded from: classes7.dex */
public interface zbs extends IInterface {
    void zbb(Status status, Credential credential) throws RemoteException;

    void zbc(Status status) throws RemoteException;

    void zbd(Status status, String str) throws RemoteException;
}
