package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public abstract class H5MapController {
    protected H5MapContainer mMapContainer;

    public H5MapController(H5MapContainer h5MapContainer) {
        this.mMapContainer = h5MapContainer;
    }

    public H5MapContainer getMapContainer() {
        return this.mMapContainer;
    }
}
