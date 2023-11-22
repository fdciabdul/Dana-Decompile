package com.alipay.mobile.apmap.model;

import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.SimpleSDKContext;
import com.google.android.gms.maps.model.VisibleRegion;

/* loaded from: classes6.dex */
public class AdapterVisibleRegion extends SimpleSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private VisibleRegion f7115a;

    public AdapterVisibleRegion(VisibleRegion visibleRegion) {
        this.f7115a = visibleRegion;
    }

    public AdapterLatLngBounds latLngBounds() {
        VisibleRegion visibleRegion;
        if (!AdapterUtil.isGoogleMapSdk() || (visibleRegion = this.f7115a) == null) {
            return null;
        }
        return new AdapterLatLngBounds(visibleRegion.latLngBounds, null);
    }
}
