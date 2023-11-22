package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.MarkerOptions;

/* loaded from: classes6.dex */
public class AdapterMarkerOptions implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private MarkerOptions f7105a;
    private boolean b;

    public AdapterMarkerOptions(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a = new MarkerOptions();
        } else if (dynamicSDKContext == null) {
            this.b = true;
            RVLogger.d("AdapterMarkerOptions", "sdk context is null for default");
        } else {
            this.b = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterMarkerOptions anchor(float f, float f2) {
        StringBuilder sb = new StringBuilder();
        sb.append("anchor var1 = ");
        sb.append(f);
        sb.append(", var2 = ");
        sb.append(f2);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.anchor(f, f2);
        }
        return this;
    }

    public AdapterMarkerOptions position(AdapterLatLng adapterLatLng) {
        RVLogger.d("AdapterMarkerOptions", "position");
        if (adapterLatLng == null) {
            RVLogger.d("AdapterMarkerOptions", "position latLng == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.position(adapterLatLng.getGoogleMapLatLng());
        }
        return this;
    }

    public AdapterMarkerOptions icon(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        RVLogger.d("AdapterMarkerOptions", "icon");
        if (adapterBitmapDescriptor == null) {
            RVLogger.d("AdapterMarkerOptions", "icon descriptor == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.icon(adapterBitmapDescriptor.getGoogleMapBitmapDescriptor());
        }
        return this;
    }

    public AdapterMarkerOptions draggable(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("draggable bo = ");
        sb.append(z);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.draggable(z);
        }
        return this;
    }

    public AdapterMarkerOptions zIndex(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("zIndex var1 = ");
        sb.append(f);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.zIndex(f);
        }
        return this;
    }

    public AdapterMarkerOptions title(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("title = ");
        sb.append(str);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.title(str);
        }
        return this;
    }

    public AdapterMarkerOptions snippet(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("snippet var1 = ");
        sb.append(str);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.snippet(str);
        }
        return this;
    }

    public AdapterMarkerOptions visible(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("visible var1 = ");
        sb.append(z);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.visible(z);
        }
        return this;
    }

    public AdapterMarkerOptions setFlat(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setFlat flat = ");
        sb.append(z);
        RVLogger.d("AdapterMarkerOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7105a.flat(z);
        }
        return this;
    }

    public MarkerOptions getGoogleMapMarkerOptions() {
        return this.f7105a;
    }

    public int hashCode() {
        RVLogger.d("AdapterMarkerOptions", "hashCode");
        if (AdapterUtil.isGoogleMapSdk()) {
            return this.f7105a.hashCode();
        }
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        RVLogger.d("AdapterMarkerOptions", "equals");
        if (AdapterUtil.isGoogleMapSdk()) {
            return this.f7105a.equals(obj);
        }
        return super.equals(obj);
    }
}
