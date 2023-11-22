package com.alipay.mobile.framework.service.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.apmap.AdapterAMapUtils;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.SimpleSDKContext;
import com.alipay.mobile.framework.service.MapService;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.widget.impl.APMapViewImpl;

/* loaded from: classes6.dex */
public class MapServiceImpl extends MapService {
    @Override // com.alipay.mobile.framework.service.MapService
    public double calculateDistance(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
        SimpleSDKContext simpleSDKContext = new SimpleSDKContext(AdapterUtil.is2dMapSdk());
        return AdapterAMapUtils.calculateLineDistance(new AdapterLatLng(simpleSDKContext, latLonPoint.getLatitude(), latLonPoint.getLongitude()), new AdapterLatLng(simpleSDKContext, latLonPoint2.getLatitude(), latLonPoint2.getLongitude()));
    }

    @Override // com.alipay.mobile.framework.service.MapService
    public View getMapView(Context context) {
        return new APMapViewImpl(context);
    }

    @Override // com.alipay.mobile.framework.service.MapService
    public View getMapView(Context context, AttributeSet attributeSet) {
        return new APMapViewImpl(context, attributeSet);
    }
}
