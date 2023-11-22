package com.alipay.mobile.apmap.util;

/* loaded from: classes6.dex */
public class SimpleSDKContext implements DynamicSDKContext {
    protected boolean is2dMapSdk;

    public SimpleSDKContext() {
        this.is2dMapSdk = true;
    }

    public SimpleSDKContext(DynamicSDKContext dynamicSDKContext) {
        this.is2dMapSdk = dynamicSDKContext == null || dynamicSDKContext.is2dMapSdk();
    }

    public SimpleSDKContext(boolean z) {
        this.is2dMapSdk = z;
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.is2dMapSdk;
    }
}
