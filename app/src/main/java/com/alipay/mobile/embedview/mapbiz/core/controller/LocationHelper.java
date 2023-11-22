package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.location.Location;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.map.R;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;

/* loaded from: classes6.dex */
public class LocationHelper {

    /* renamed from: a  reason: collision with root package name */
    private AdapterMarker f7155a;

    public void moveToLocation(final Context context, final AdapterAMap adapterAMap, Location location) {
        if (context == null || adapterAMap == null || location == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("location success[");
        sb.append(location.getLatitude());
        sb.append(",");
        sb.append(location.getLongitude());
        sb.append("]");
        RVLogger.d("LocationHelper", sb.toString());
        final AdapterLatLng adapterLatLng = new AdapterLatLng(adapterAMap, location.getLatitude(), location.getLongitude());
        adapterAMap.animateCamera(AdapterCameraUpdateFactory.newLatLngZoom(adapterLatLng, H5MapContainer.SCALE_DEFAULT), new AdapterAMap.AdapterCancelableCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LocationHelper.1
            @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterCancelableCallback
            public void onCancel() {
            }

            @Override // com.alipay.mobile.apmap.AdapterAMap.AdapterCancelableCallback
            public void onFinish() {
                if (LocationHelper.this.f7155a == null) {
                    Context context2 = context;
                    if (context2 == null) {
                        return;
                    }
                    AdapterMarkerOptions adapterMarkerOptions = new AdapterMarkerOptions(adapterAMap);
                    adapterMarkerOptions.icon(AdapterBitmapDescriptorFactory.fromBitmap(adapterAMap, H5MapUtils.resizeBitmap(BitmapFactory.decodeResource(context2.getResources(), R.drawable.griver_map_location), DensityUtil.dip2px(context2, 30.0f), DensityUtil.dip2px(context2, 30.0f)))).anchor(0.5f, 0.5f).setFlat(true).position(new AdapterLatLng(adapterAMap, adapterLatLng.getLatitude(), adapterLatLng.getLongitude()));
                    LocationHelper.this.f7155a = adapterAMap.addMarker(adapterMarkerOptions);
                    RVLogger.d(H5MapContainer.TAG, "add locationMarker");
                }
                if (LocationHelper.this.f7155a != null) {
                    LocationHelper.this.f7155a.setPosition(new AdapterLatLng(adapterAMap, adapterLatLng.getLatitude(), adapterLatLng.getLongitude()));
                }
            }
        });
    }
}
