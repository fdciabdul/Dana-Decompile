package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.CameraPosition;

/* loaded from: classes6.dex */
public class AdapterCameraPosition implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private CameraPosition f7099a;
    private boolean b;
    public float bearing;
    public boolean isAbroad;
    public AdapterLatLng target;
    public float tilt;
    public float zoom;

    public AdapterCameraPosition(AdapterLatLng adapterLatLng, float f, float f2, float f3) {
        StringBuilder sb = new StringBuilder();
        sb.append("AdapterCameraPosition zoom = , zoom = ");
        sb.append(f);
        sb.append(", tilt = ");
        sb.append(f2);
        sb.append(", bearing = ");
        sb.append(f3);
        RVLogger.d("AdapterCameraPosition", sb.toString());
        if (adapterLatLng == null) {
            RVLogger.d("AdapterCameraPosition", "AdapterCameraPosition latLng == null");
        } else if (AdapterUtil.isGoogleMapSdk()) {
            this.f7099a = new CameraPosition(adapterLatLng.getGoogleMapLatLng(), f, f2, f3);
        } else if (adapterLatLng == null) {
            this.b = true;
            RVLogger.d("AdapterCameraPosition", "latLng is null for default");
        } else {
            this.b = adapterLatLng.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            RVLogger.d("AdapterCameraPosition", "AdapterCameraPosition position == null");
            return;
        }
        this.f7099a = cameraPosition;
        this.target = new AdapterLatLng(cameraPosition.target);
        this.zoom = this.f7099a.zoom;
        this.tilt = this.f7099a.tilt;
        this.bearing = this.f7099a.bearing;
        this.isAbroad = false;
    }

    public CameraPosition getGoogleMapCameraPosition() {
        return this.f7099a;
    }
}
