package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.Circle;

/* loaded from: classes6.dex */
public class AdapterCircle implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private Circle f7100a;
    private boolean b;

    public AdapterCircle(Circle circle) {
        this.f7100a = circle;
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public void remove() {
        Circle circle;
        RVLogger.d("AdapterCircle", "remove");
        if (!AdapterUtil.isGoogleMapSdk() || (circle = this.f7100a) == null) {
            return;
        }
        circle.remove();
    }
}
