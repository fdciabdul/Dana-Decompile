package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/* loaded from: classes3.dex */
public interface IGmsCallbacks extends IInterface {
    void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) throws RemoteException;

    void zzb(int i, Bundle bundle) throws RemoteException;

    void zzc(int i, IBinder iBinder, zzk zzkVar) throws RemoteException;
}
