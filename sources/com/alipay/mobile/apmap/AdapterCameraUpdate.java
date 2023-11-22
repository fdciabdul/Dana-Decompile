package com.alipay.mobile.apmap;

import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.CameraUpdate;

/* loaded from: classes6.dex */
public class AdapterCameraUpdate implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private CameraUpdate f7093a;
    private boolean b;

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterCameraUpdate(CameraUpdate cameraUpdate) {
        this.f7093a = cameraUpdate;
    }

    public CameraUpdate getGoogleMapCameraUpdate() {
        return this.f7093a;
    }
}
