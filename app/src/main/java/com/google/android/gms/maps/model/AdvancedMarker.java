package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes3.dex */
public class AdvancedMarker extends Marker {
    public AdvancedMarker(com.google.android.gms.internal.maps.zzad zzadVar) {
        super(zzadVar);
    }

    public View getIconView() {
        try {
            return (View) ObjectWrapper.unwrap(this.zza.zzh());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setIconView(View view) {
        if (view == null || view.getParent() == null) {
            try {
                this.zza.zzu(ObjectWrapper.wrap(view));
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        throw new IllegalArgumentException("View already has a parent, can not be used as Marker");
    }
}
