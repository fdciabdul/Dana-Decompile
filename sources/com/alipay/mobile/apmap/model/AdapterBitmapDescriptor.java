package com.alipay.mobile.apmap.model;

import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.BitmapDescriptor;

/* loaded from: classes6.dex */
public class AdapterBitmapDescriptor implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private BitmapDescriptor f7098a;
    private boolean b;

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public AdapterBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.f7098a = bitmapDescriptor;
    }

    public BitmapDescriptor getGoogleMapBitmapDescriptor() {
        return this.f7098a;
    }
}
