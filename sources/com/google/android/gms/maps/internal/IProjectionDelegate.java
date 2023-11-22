package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: classes3.dex */
public interface IProjectionDelegate extends IInterface {
    LatLng fromScreenLocation(IObjectWrapper iObjectWrapper) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    IObjectWrapper toScreenLocation(LatLng latLng) throws RemoteException;

    IObjectWrapper toScreenLocationWithAltitude(LatLng latLng, float f) throws RemoteException;
}
