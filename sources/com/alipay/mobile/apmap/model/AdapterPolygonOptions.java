package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.android.gms.maps.model.PolygonOptions;

/* loaded from: classes6.dex */
public class AdapterPolygonOptions implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private PolygonOptions f7108a;
    private boolean b;

    public AdapterPolygonOptions(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7108a = new PolygonOptions();
        } else if (dynamicSDKContext == null) {
            this.b = true;
            RVLogger.d("AdapterPolygonOptions", "sdk context is null for default");
        } else {
            this.b = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterPolygonOptions add(AdapterLatLng adapterLatLng) {
        RVLogger.d("AdapterPolygonOptions", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD);
        if (adapterLatLng == null) {
            RVLogger.d("AdapterPolygonOptions", "add latLng == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7108a.add(adapterLatLng.getGoogleMapLatLng());
        }
        return this;
    }

    public AdapterPolygonOptions fillColor(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("fillColor color = ");
        sb.append(i);
        RVLogger.d("AdapterPolygonOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7108a.fillColor(i);
        }
        return this;
    }

    public AdapterPolygonOptions strokeColor(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("strokeColor color = ");
        sb.append(i);
        RVLogger.d("AdapterPolygonOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7108a.strokeColor(i);
        }
        return this;
    }

    public AdapterPolygonOptions strokeWidth(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("strokeWidth var1 = ");
        sb.append(f);
        RVLogger.d("AdapterPolygonOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7108a.strokeWidth(f);
        }
        return this;
    }

    public PolygonOptions getGoogleMapPolygonOptions() {
        return this.f7108a;
    }
}
