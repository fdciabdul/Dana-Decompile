package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.GroundOverlay;

/* loaded from: classes6.dex */
public class AdapterGroundOverlay implements DynamicSDKContext {
    boolean is2dMapSdk;
    GroundOverlay mGoogleMapGroundOverlay;

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.is2dMapSdk;
    }

    public AdapterGroundOverlay(GroundOverlay groundOverlay) {
        this.mGoogleMapGroundOverlay = groundOverlay;
    }

    public void remove() {
        GroundOverlay groundOverlay;
        RVLogger.d("AdapterGroundOverlay", "remove");
        if (!AdapterUtil.isGoogleMapSdk() || (groundOverlay = this.mGoogleMapGroundOverlay) == null) {
            return;
        }
        groundOverlay.remove();
    }

    public void setImage(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        GroundOverlay groundOverlay;
        RVLogger.d("AdapterGroundOverlay", "setImage");
        if (adapterBitmapDescriptor == null) {
            RVLogger.d("AdapterGroundOverlay", "setImage descriptor == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (groundOverlay = this.mGoogleMapGroundOverlay) == null) {
        } else {
            groundOverlay.setImage(adapterBitmapDescriptor.getGoogleMapBitmapDescriptor());
        }
    }

    public void setVisible(boolean z) {
        GroundOverlay groundOverlay;
        StringBuilder sb = new StringBuilder();
        sb.append("setVisible visible = ");
        sb.append(z);
        RVLogger.d("AdapterGroundOverlay", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (groundOverlay = this.mGoogleMapGroundOverlay) == null) {
            return;
        }
        groundOverlay.setVisible(z);
    }

    public boolean isVisible() {
        GroundOverlay groundOverlay;
        RVLogger.d("AdapterGroundOverlay", "isVisible");
        if (!AdapterUtil.isGoogleMapSdk() || (groundOverlay = this.mGoogleMapGroundOverlay) == null) {
            return false;
        }
        return groundOverlay.isVisible();
    }
}
