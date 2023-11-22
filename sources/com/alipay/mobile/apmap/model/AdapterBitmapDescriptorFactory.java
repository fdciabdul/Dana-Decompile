package com.alipay.mobile.apmap.model;

import android.graphics.Bitmap;
import android.view.View;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes6.dex */
public class AdapterBitmapDescriptorFactory {
    public static AdapterBitmapDescriptor fromBitmap(DynamicSDKContext dynamicSDKContext, Bitmap bitmap) {
        RVLogger.d("AdapterBitmapDescriptorFactory", "fromBitmap");
        if (bitmap == null) {
            RVLogger.d("AdapterBitmapDescriptorFactory", "fromBitmap bitmap == null");
            return null;
        } else if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterBitmapDescriptor(BitmapDescriptorFactory.fromBitmap(bitmap));
        } else {
            return null;
        }
    }

    public static AdapterBitmapDescriptor fromView(DynamicSDKContext dynamicSDKContext, View view) {
        RVLogger.d("AdapterBitmapDescriptorFactory", "fromView");
        if (view == null) {
            RVLogger.d("AdapterBitmapDescriptorFactory", "fromBitmap view == null");
            return null;
        }
        AdapterUtil.isGoogleMapSdk();
        return null;
    }

    public static AdapterBitmapDescriptor fromResource(DynamicSDKContext dynamicSDKContext, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("fromResource var0 = ");
        sb.append(i);
        RVLogger.d("AdapterBitmapDescriptorFactory", sb.toString());
        if (AdapterUtil.isGoogleMapSdk()) {
            return new AdapterBitmapDescriptor(BitmapDescriptorFactory.fromResource(i));
        }
        return null;
    }
}
