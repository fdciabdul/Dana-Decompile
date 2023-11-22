package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class AdapterPolylineOptions implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private PolylineOptions f7110a;
    private boolean b;

    public AdapterPolylineOptions(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7110a = new PolylineOptions();
        } else if (dynamicSDKContext == null) {
            this.b = true;
            RVLogger.d("AdapterPolylineOptions", "sdk context is null for default");
        } else {
            this.b = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterPolylineOptions width(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("width var1 = ");
        sb.append(f);
        RVLogger.d("AdapterPolylineOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7110a.width(f);
        }
        return this;
    }

    public AdapterPolylineOptions setCustomTexture(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        RVLogger.d("AdapterPolylineOptions", "setCustomTexture");
        if (adapterBitmapDescriptor == null) {
            RVLogger.d("AdapterPolylineOptions", "setCustomTexture var1 == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterPolylineOptions", "setCustomTexture google map sdk not support");
        }
        return this;
    }

    public AdapterPolylineOptions colorValues(List<Integer> list) {
        RVLogger.d("AdapterPolylineOptions", "colorValues");
        if (list == null) {
            RVLogger.d("AdapterPolylineOptions", "colorValues var1 == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterPolylineOptions", "colorValues google map sdk not support");
        }
        return this;
    }

    public AdapterPolylineOptions color(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("color var1 = ");
        sb.append(i);
        RVLogger.d("AdapterPolylineOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7110a.color(i);
        }
        return this;
    }

    public AdapterPolylineOptions setDottedLine(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("setDottedLine var1 = ");
        sb.append(z);
        RVLogger.d("AdapterPolylineOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterPolylineOptions", "setDottedLine google map sdk not support");
        }
        return this;
    }

    public AdapterPolylineOptions add(AdapterLatLng adapterLatLng) {
        RVLogger.d("AdapterPolylineOptions", ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD);
        if (adapterLatLng == null) {
            RVLogger.d("AdapterPolylineOptions", "add var1 == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7110a.add(adapterLatLng.getGoogleMapLatLng());
        }
        return this;
    }

    public AdapterPolylineOptions addAll(List<AdapterLatLng> list) {
        RVLogger.d("AdapterPolylineOptions", "addAll");
        if (AdapterUtil.isGoogleMapSdk() && list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                AdapterLatLng adapterLatLng = list.get(i);
                if (adapterLatLng != null && adapterLatLng.getGoogleMapLatLng() != null) {
                    arrayList.add(adapterLatLng.getGoogleMapLatLng());
                }
            }
            this.f7110a.addAll(arrayList);
        }
        return this;
    }

    public AdapterPolylineOptions zIndex(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("zIndex = ");
        sb.append(f);
        RVLogger.d("AdapterPolylineOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7110a.zIndex(f);
        }
        return this;
    }

    public PolylineOptions getGoogleMapPolylineOptions() {
        return this.f7110a;
    }
}
