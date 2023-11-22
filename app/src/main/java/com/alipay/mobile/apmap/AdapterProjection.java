package com.alipay.mobile.apmap;

import android.graphics.Point;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterVisibleRegion;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.Projection;

/* loaded from: classes6.dex */
public class AdapterProjection implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private Projection f7095a;
    private boolean b;

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterProjection(Projection projection) {
        this.f7095a = projection;
    }

    public Point toScreenLocation(AdapterLatLng adapterLatLng) {
        Projection projection;
        if (adapterLatLng == null || !AdapterUtil.isGoogleMapSdk() || (projection = this.f7095a) == null) {
            return null;
        }
        return projection.toScreenLocation(adapterLatLng.getGoogleMapLatLng());
    }

    public AdapterLatLng fromScreenLocation(Point point) {
        if (point != null && AdapterUtil.isGoogleMapSdk()) {
            Projection projection = this.f7095a;
            return new AdapterLatLng(projection != null ? projection.fromScreenLocation(point) : null);
        }
        return null;
    }

    public AdapterVisibleRegion getVisibleRegion() {
        if (this.f7095a != null) {
            return new AdapterVisibleRegion(this.f7095a.getVisibleRegion());
        }
        return null;
    }
}
