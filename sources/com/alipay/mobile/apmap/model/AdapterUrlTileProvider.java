package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.net.URL;

/* loaded from: classes6.dex */
public abstract class AdapterUrlTileProvider implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7114a;
    UrlTileProvider mGoogleMapUrlTileProvider;

    public abstract URL getTileUrlAdapter(int i, int i2, int i3);

    public AdapterUrlTileProvider(DynamicSDKContext dynamicSDKContext, int i, int i2) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapUrlTileProvider = new UrlTileProvider(i, i2) { // from class: com.alipay.mobile.apmap.model.AdapterUrlTileProvider.1
                @Override // com.google.android.gms.maps.model.UrlTileProvider
                public URL getTileUrl(int i3, int i4, int i5) {
                    return AdapterUrlTileProvider.this.getTileUrlAdapter(i3, i4, i5);
                }
            };
        } else if (dynamicSDKContext == null) {
            this.f7114a = true;
            RVLogger.d("AdapterUrlTileProvider", "sdk context is null for default");
        } else {
            this.f7114a = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.f7114a;
    }

    public UrlTileProvider getGoogleMapUrlTileProvider() {
        return this.mGoogleMapUrlTileProvider;
    }
}
