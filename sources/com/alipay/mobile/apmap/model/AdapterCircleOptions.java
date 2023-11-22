package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.alipay.mobile.zebra.data.TextData;
import com.google.android.gms.maps.model.CircleOptions;

/* loaded from: classes6.dex */
public class AdapterCircleOptions implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private CircleOptions f7101a;
    private boolean b;

    public AdapterCircleOptions(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7101a = new CircleOptions();
        } else if (dynamicSDKContext == null) {
            this.b = true;
            RVLogger.d("AdapterCircleOptions", "sdk context is null for default");
        } else {
            this.b = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterCircleOptions center(AdapterLatLng adapterLatLng) {
        RVLogger.d("AdapterCircleOptions", TextData.ALIGN_CENTER);
        if (adapterLatLng == null) {
            RVLogger.d("AdapterCircleOptions", "center latLng == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7101a.center(adapterLatLng.getGoogleMapLatLng());
        }
        return this;
    }

    public AdapterCircleOptions radius(double d) {
        StringBuilder sb = new StringBuilder();
        sb.append("radius = ");
        sb.append(d);
        RVLogger.d("AdapterCircleOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7101a.radius(d);
        }
        return this;
    }

    public AdapterCircleOptions strokeWidth(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("strokeWidth = ");
        sb.append(f);
        RVLogger.d("AdapterCircleOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7101a.strokeWidth(f);
        }
        return this;
    }

    public AdapterCircleOptions strokeColor(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("strokeColor = ");
        sb.append(i);
        RVLogger.d("AdapterCircleOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7101a.strokeColor(i);
        }
        return this;
    }

    public AdapterCircleOptions fillColor(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("fillColor color = ");
        sb.append(i);
        RVLogger.d("AdapterCircleOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7101a.fillColor(i);
        }
        return this;
    }

    public CircleOptions getGoogleMapCircleOptions() {
        return this.f7101a;
    }
}
