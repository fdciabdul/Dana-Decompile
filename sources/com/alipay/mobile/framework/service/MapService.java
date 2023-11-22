package com.alipay.mobile.framework.service;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.map.model.LatLonPoint;

/* loaded from: classes6.dex */
public abstract class MapService {
    public abstract double calculateDistance(LatLonPoint latLonPoint, LatLonPoint latLonPoint2);

    public abstract View getMapView(Context context);

    public abstract View getMapView(Context context, AttributeSet attributeSet);
}
