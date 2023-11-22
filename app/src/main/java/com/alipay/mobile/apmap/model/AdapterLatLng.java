package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes2.dex */
public class AdapterLatLng implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private LatLng f7102a;
    private boolean b;

    public AdapterLatLng(LatLng latLng) {
        this.f7102a = latLng;
    }

    public AdapterLatLng(DynamicSDKContext dynamicSDKContext, double d, double d2) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7102a = new LatLng(d, d2);
        } else if (dynamicSDKContext == null) {
            this.b = true;
            RVLogger.d("AdapterLatLng", "sdk context is null for default");
        } else {
            this.b = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public LatLng getGoogleMapLatLng() {
        return this.f7102a;
    }

    public double getLatitude() {
        LatLng latLng;
        return (!AdapterUtil.isGoogleMapSdk() || (latLng = this.f7102a) == null) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : latLng.latitude;
    }

    public double getLongitude() {
        LatLng latLng;
        return (!AdapterUtil.isGoogleMapSdk() || (latLng = this.f7102a) == null) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : latLng.longitude;
    }
}
