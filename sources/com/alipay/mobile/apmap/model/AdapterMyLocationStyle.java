package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;

/* loaded from: classes6.dex */
public class AdapterMyLocationStyle implements DynamicSDKContext {
    public static final int LOCATION_TYPE_FOLLOW = 2;
    public static final int LOCATION_TYPE_FOLLOW_NO_CENTER = 6;
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_LOCATION_ROTATE = 4;
    public static final int LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER = 5;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int LOCATION_TYPE_MAP_ROTATE_NO_CENTER = 7;
    public static final int LOCATION_TYPE_SHOW = 0;

    /* renamed from: a  reason: collision with root package name */
    private boolean f7106a;

    public AdapterMyLocationStyle(DynamicSDKContext dynamicSDKContext) {
        if (dynamicSDKContext == null) {
            this.f7106a = true;
            RVLogger.d("AdapterMyLocationStyle", "sdk context is null for default");
            return;
        }
        this.f7106a = dynamicSDKContext.is2dMapSdk();
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.f7106a;
    }

    public void myLocationIcon(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        AdapterUtil.isGoogleMapSdk();
    }

    public void strokeColor(int i) {
        AdapterUtil.isGoogleMapSdk();
    }

    public void strokeWidth(float f) {
        AdapterUtil.isGoogleMapSdk();
    }

    public void radiusFillColor(int i) {
        AdapterUtil.isGoogleMapSdk();
    }

    public void myLocationType(int i) {
        AdapterUtil.isGoogleMapSdk();
    }
}
