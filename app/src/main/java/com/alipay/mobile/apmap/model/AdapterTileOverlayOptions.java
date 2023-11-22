package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.TileOverlayOptions;

/* loaded from: classes6.dex */
public class AdapterTileOverlayOptions implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7113a;
    TileOverlayOptions mGoogleMapTileOverlayOptions;

    public AdapterTileOverlayOptions(DynamicSDKContext dynamicSDKContext) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapTileOverlayOptions = new TileOverlayOptions();
        } else if (dynamicSDKContext == null) {
            this.f7113a = true;
            RVLogger.d("AdapterTileOverlayOptions", "sdk context is null for default");
        } else {
            this.f7113a = dynamicSDKContext.is2dMapSdk();
        }
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.f7113a;
    }

    public AdapterTileOverlayOptions diskCacheEnabled(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("diskCacheEnabled enabled = ");
        sb.append(z);
        RVLogger.d("AdapterTileOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterTileOverlayOptions", "diskCacheEnabled google map sdk not support");
        }
        return this;
    }

    public AdapterTileOverlayOptions diskCacheDir(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("diskCacheDir path = ");
        sb.append(str);
        RVLogger.d("AdapterTileOverlayOptions", sb.toString());
        if (str != null && AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterTileOverlayOptions", "diskCacheDir google map sdk not support");
        }
        return this;
    }

    public AdapterTileOverlayOptions diskCacheSize(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("diskCacheSize kiloBytes = ");
        sb.append(i);
        RVLogger.d("AdapterTileOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterTileOverlayOptions", "diskCacheSize google map sdk not support");
        }
        return this;
    }

    public AdapterTileOverlayOptions memoryCacheEnabled(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("memoryCacheEnabled enabled = ");
        sb.append(z);
        RVLogger.d("AdapterTileOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterTileOverlayOptions", "memoryCacheEnabled google map sdk not support");
        }
        return this;
    }

    public AdapterTileOverlayOptions memCacheSize(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("memCacheSize kiloBytes = ");
        sb.append(i);
        RVLogger.d("AdapterTileOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            RVLogger.d("AdapterTileOverlayOptions", "memCacheSize google map sdk not support");
        }
        return this;
    }

    public AdapterTileOverlayOptions zIndex(float f) {
        StringBuilder sb = new StringBuilder();
        sb.append("zIndex = ");
        sb.append(f);
        RVLogger.d("AdapterTileOverlayOptions", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapTileOverlayOptions.zIndex(f);
        }
        return this;
    }

    public AdapterTileOverlayOptions tileProvider(AdapterUrlTileProvider adapterUrlTileProvider) {
        RVLogger.d("AdapterTileOverlayOptions", "tileProvider");
        if (adapterUrlTileProvider == null) {
            RVLogger.d("AdapterTileOverlayOptions", "tileProvider tileProvider == null");
            return this;
        }
        if (AdapterUtil.isGoogleMapSdk()) {
            this.mGoogleMapTileOverlayOptions.tileProvider(adapterUrlTileProvider.getGoogleMapUrlTileProvider());
        }
        return this;
    }

    public TileOverlayOptions getGoogleMapTileOverlayOptions() {
        return this.mGoogleMapTileOverlayOptions;
    }
}
