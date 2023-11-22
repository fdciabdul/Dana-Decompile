package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.animation.AdapterAnimation;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class AdapterMarker implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private Marker f7104a;
    private boolean b;

    public float getZIndex() {
        return 0.0f;
    }

    public void setZIndex(float f) {
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterMarker(Marker marker) {
        this.f7104a = marker;
    }

    public Object getObject() {
        RVLogger.d("AdapterMarker", "getObject");
        if (AdapterUtil.isGoogleMapSdk()) {
            Marker marker = this.f7104a;
            if (marker != null) {
                return marker.getTag();
            }
            return new Object();
        }
        return null;
    }

    public boolean isInfoWindowShown() {
        Marker marker;
        RVLogger.d("AdapterMarker", "isInfoWindowShown");
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return false;
        }
        return marker.isInfoWindowShown();
    }

    public void showInfoWindow() {
        Marker marker;
        RVLogger.d("AdapterMarker", "showInfoWindow");
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.showInfoWindow();
    }

    public void hideInfoWindow() {
        Marker marker;
        RVLogger.d("AdapterMarker", "hideInfoWindow");
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.hideInfoWindow();
    }

    public void setIcon(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        Marker marker;
        RVLogger.d("AdapterMarker", "setIcon");
        if (adapterBitmapDescriptor == null) {
            RVLogger.d("AdapterMarker", "setIcon descriptor == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
        } else {
            try {
                marker.setIcon(adapterBitmapDescriptor.getGoogleMapBitmapDescriptor());
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("setIcon error, e: ");
                sb.append(e);
                RVLogger.w("AdapterMarker", sb.toString());
            }
        }
    }

    public AdapterLatLng getPosition() {
        RVLogger.d("AdapterMarker", "getPosition");
        try {
            if (AdapterUtil.isGoogleMapSdk()) {
                Marker marker = this.f7104a;
                if (marker != null && marker.getPosition() != null) {
                    return new AdapterLatLng(this, this.f7104a.getPosition().latitude, this.f7104a.getPosition().longitude);
                }
                return new AdapterLatLng(this, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
            }
            return null;
        } catch (Exception e) {
            RVLogger.e("AdapterMarker", e);
            return new AdapterLatLng(this, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    public String getTitle() {
        RVLogger.d("AdapterMarker", "getPosition");
        if (AdapterUtil.isGoogleMapSdk()) {
            Marker marker = this.f7104a;
            return marker != null ? marker.getTitle() : "";
        }
        return null;
    }

    public String getSnippet() {
        RVLogger.d("AdapterMarker", "getSnippet");
        if (AdapterUtil.isGoogleMapSdk()) {
            Marker marker = this.f7104a;
            return marker != null ? marker.getSnippet() : "";
        }
        return null;
    }

    public void setVisible(boolean z) {
        Marker marker;
        StringBuilder sb = new StringBuilder();
        sb.append("setVisible bo = ");
        sb.append(z);
        RVLogger.d("AdapterMarker", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.setVisible(z);
    }

    public void setTitle(String str) {
        Marker marker;
        StringBuilder sb = new StringBuilder();
        sb.append("setTitle title = ");
        sb.append(str);
        RVLogger.d("AdapterMarker", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.setTitle(str);
    }

    public void setSnippet(String str) {
        Marker marker;
        StringBuilder sb = new StringBuilder();
        sb.append("setSnippet snippet = ");
        sb.append(str);
        RVLogger.d("AdapterMarker", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.setSnippet(str);
    }

    public void setRotateAngle(float f) {
        Marker marker;
        StringBuilder sb = new StringBuilder();
        sb.append("setRotateAngle rotateAngle = ");
        sb.append(f);
        RVLogger.d("AdapterMarker", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.setRotation(f);
    }

    public float getRotateAngle() {
        RVLogger.d("AdapterMarker", "getRotateAngle");
        if (AdapterUtil.isGoogleMapSdk()) {
            return 0.0f;
        }
        is2dMapSdk();
        return 0.0f;
    }

    public void setObject(Object obj) {
        Marker marker;
        RVLogger.d("AdapterMarker", "setObject");
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.setTag(obj);
    }

    public ArrayList<AdapterBitmapDescriptor> getIcons() {
        return a();
    }

    private ArrayList<AdapterBitmapDescriptor> a() {
        RVLogger.d("AdapterMarker", "initFromBitmapDescriptor");
        ArrayList<AdapterBitmapDescriptor> arrayList = new ArrayList<>();
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterMarker", "initFromBitmapDescriptor google map sdk not support");
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        RVLogger.d("AdapterMarker", "equals");
        if (AdapterUtil.isGoogleMapSdk()) {
            Marker marker = this.f7104a;
            if (marker != null) {
                return marker.equals(obj);
            }
            return false;
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isVisible() {
        Marker marker;
        RVLogger.d("AdapterMarker", "isVisible");
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return false;
        }
        return marker.isVisible();
    }

    public void setPosition(AdapterLatLng adapterLatLng) {
        Marker marker;
        if (adapterLatLng == null) {
            RVLogger.d("AdapterMarker", "setPosition latLng == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
        } else {
            marker.setPosition(adapterLatLng.getGoogleMapLatLng());
        }
    }

    public void setPositionByPixels(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("setPositionByPixels var1 = ");
        sb.append(i);
        sb.append(", var2 = ");
        sb.append(i2);
        RVLogger.d("AdapterMarker", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterMarker", "setPositionByPixels google map sdk not support");
        }
    }

    public String getId() {
        RVLogger.d("AdapterMarker", "getId");
        if (AdapterUtil.isGoogleMapSdk()) {
            Marker marker = this.f7104a;
            return marker != null ? marker.getId() : "";
        }
        return null;
    }

    public void remove() {
        Marker marker;
        RVLogger.d("AdapterMarker", "remove");
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.remove();
    }

    public void destroy() {
        RVLogger.d("AdapterMarker", "destroy");
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterMarker", "destroy google map sdk not support");
        }
    }

    public void setAnimation(AdapterAnimation adapterAnimation) {
        RVLogger.d("AdapterMarker", "setAnimation");
        if (adapterAnimation == null) {
            RVLogger.d("AdapterMarker", "setAnimation animation == null");
        } else if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterMarker", "setAnimation google map sdk not support");
        } else {
            is2dMapSdk();
        }
    }

    public void startAnimation() {
        RVLogger.d("AdapterMarker", "startAnimation");
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterMarker", "startAnimation google map sdk not support");
        }
    }

    public void setFlat(boolean z) {
        Marker marker;
        StringBuilder sb = new StringBuilder();
        sb.append("setFlat flat = ");
        sb.append(z);
        RVLogger.d("AdapterMarker", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (marker = this.f7104a) == null) {
            return;
        }
        marker.setFlat(z);
    }
}
