package com.alipay.mobile.apmap;

import android.location.Location;

/* loaded from: classes6.dex */
public interface AdapterLocationSource {

    /* loaded from: classes6.dex */
    public interface OnAdapterLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void activate(OnAdapterLocationChangedListener onAdapterLocationChangedListener);

    void deactivate();
}
