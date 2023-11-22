package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.TileOverlay;

/* loaded from: classes6.dex */
public class AdapterTileOverlay implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7112a;
    TileOverlay mGoogleMapTileOverlay;

    public AdapterTileOverlay(TileOverlay tileOverlay) {
        this.mGoogleMapTileOverlay = tileOverlay;
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.f7112a;
    }

    public void remove() {
        TileOverlay tileOverlay;
        RVLogger.d("AdapterTileOverlay", "remove");
        if (!AdapterUtil.isGoogleMapSdk() || (tileOverlay = this.mGoogleMapTileOverlay) == null) {
            return;
        }
        tileOverlay.remove();
    }
}
