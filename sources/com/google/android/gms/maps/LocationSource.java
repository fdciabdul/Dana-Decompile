package com.google.android.gms.maps;

import android.location.Location;

/* loaded from: classes7.dex */
public interface LocationSource {

    /* loaded from: classes7.dex */
    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
