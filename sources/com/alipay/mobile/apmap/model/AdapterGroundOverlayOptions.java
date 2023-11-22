package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.GroundOverlayOptions;

/* loaded from: classes6.dex */
public class AdapterGroundOverlayOptions implements DynamicSDKContext {
    boolean is2dMapSdk;
    GroundOverlayOptions mGoogleMapGroundOverlayOptions;

    public AdapterGroundOverlayOptions(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions = new GroundOverlayOptions();
        } else if (dynamicSDKContext == null) {
            this.is2dMapSdk = true;
            RVLogger.d("AdapterGroundOverlayOptions", "sdk context is null for default");
        } else {
            this.is2dMapSdk = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.is2dMapSdk;
    }

    public GroundOverlayOptions getGoogleMapGroundOverlayOptions() {
        return this.mGoogleMapGroundOverlayOptions;
    }

    public AdapterGroundOverlayOptions anchor(float f, float f2) {
        StringBuilder sb = new StringBuilder();
        sb.append("anchor anchorU = ");
        sb.append(f);
        sb.append(", anchorV = ");
        sb.append(f2);
        RVLogger.d("AdapterGroundOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.anchor(f, f2);
        }
        return this;
    }

    public AdapterGroundOverlayOptions bearing(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("bearing = ");
        sb.append(f);
        RVLogger.d("AdapterGroundOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.bearing(f);
        }
        return this;
    }

    public AdapterGroundOverlayOptions zIndex(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("zIndex = ");
        sb.append(f);
        RVLogger.d("AdapterGroundOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.zIndex(f);
        }
        return this;
    }

    public AdapterGroundOverlayOptions visible(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("visible + ");
        sb.append(z);
        RVLogger.d("AdapterGroundOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.visible(z);
        }
        return this;
    }

    public AdapterGroundOverlayOptions transparency(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("transparency = ");
        sb.append(f);
        RVLogger.d("AdapterGroundOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.transparency(f);
        }
        return this;
    }

    public AdapterGroundOverlayOptions image(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        RVLogger.d("AdapterGroundOverlayOptions", "image");
        if (adapterBitmapDescriptor == null) {
            RVLogger.d("AdapterGroundOverlayOptions", "image == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.image(adapterBitmapDescriptor.getGoogleMapBitmapDescriptor());
        }
        return this;
    }

    public AdapterGroundOverlayOptions positionFromBounds(AdapterLatLngBounds adapterLatLngBounds) {
        RVLogger.d("AdapterGroundOverlayOptions", "positionFromBounds");
        if (adapterLatLngBounds == null) {
            RVLogger.d("AdapterGroundOverlayOptions", "paramLatLngBounds == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapGroundOverlayOptions.positionFromBounds(adapterLatLngBounds.getGoogleMapLatLngBounds());
        }
        return this;
    }
}
