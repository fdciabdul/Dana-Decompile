package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.LatLngBounds;

/* loaded from: classes6.dex */
public class AdapterLatLngBounds implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private LatLngBounds f7103a;
    private LatLngBounds.Builder b;
    private boolean c;

    public AdapterLatLngBounds(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.b = new LatLngBounds.Builder();
        } else if (dynamicSDKContext == null) {
            this.c = true;
            RVLogger.d("AdapterLatLngBounds", "sdk context is null for default");
        } else {
            this.c = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.c;
    }

    public AdapterLatLngBounds(LatLngBounds latLngBounds, LatLngBounds.Builder builder) {
        this.f7103a = latLngBounds;
        this.b = builder;
        StringBuilder sb = new StringBuilder();
        sb.append("mGoogleMapLatLngBounds is null =");
        sb.append(this.f7103a == null);
        sb.append(", mGoogleMapLatLngBoundsBuild is null =");
        sb.append(this.b == null);
        RVLogger.d("AdapterLatLngBounds", sb.toString());
    }

    public void include(AdapterLatLng adapterLatLng) {
        LatLngBounds.Builder builder;
        RVLogger.d("AdapterLatLngBounds", "include");
        if (adapterLatLng == null) {
            RVLogger.d("AdapterLatLngBounds", "include latLng == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (builder = this.b) == null) {
        } else {
            builder.include(adapterLatLng.getGoogleMapLatLng());
        }
    }

    public AdapterLatLngBounds build() {
        LatLngBounds.Builder builder;
        RVLogger.d("AdapterLatLngBounds", "build");
        if (!AdapterUtil.isGoogleMapSdk() || (builder = this.b) == null) {
            return null;
        }
        return new AdapterLatLngBounds(builder.build(), this.b);
    }

    public AdapterLatLng southwest() {
        RVLogger.d("AdapterLatLngBounds", "southwest");
        AdapterUtil.isGoogleMapSdk();
        return null;
    }

    public AdapterLatLng northeast() {
        RVLogger.d("AdapterLatLngBounds", "southwest");
        AdapterUtil.isGoogleMapSdk();
        return null;
    }

    public LatLngBounds getGoogleMapLatLngBounds() {
        LatLngBounds.Builder builder = this.b;
        if (builder != null) {
            return builder.build();
        }
        return null;
    }
}
