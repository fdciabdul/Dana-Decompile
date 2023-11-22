package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdate;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.apmap.model.AdapterLatLngBounds;
import com.alipay.mobile.embedview.mapbiz.data.IncludePadding;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class IncludePointsController extends H5MapController {
    public IncludePointsController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public void setIncludePoints(List<Point> list, IncludePadding includePadding, boolean z) {
        AdapterAMap map;
        AdapterCameraUpdate newLatLngBoundsRect;
        if (list == null || list.size() == 0 || (map = this.mMapContainer.getMap()) == null) {
            return;
        }
        if (list.size() == 1) {
            newLatLngBoundsRect = AdapterCameraUpdateFactory.changeLatLng(list.get(0).getLatLng(map));
        } else {
            AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(map);
            Iterator<Point> it = list.iterator();
            while (it.hasNext()) {
                adapterLatLngBounds.include(it.next().getLatLng(map));
            }
            AdapterLatLngBounds build = adapterLatLngBounds.build();
            if (includePadding == null) {
                newLatLngBoundsRect = AdapterCameraUpdateFactory.newLatLngBounds(build, (int) this.mMapContainer.metricsController.convertDp(48.0d));
            } else {
                newLatLngBoundsRect = AdapterCameraUpdateFactory.newLatLngBoundsRect(build, (int) this.mMapContainer.metricsController.convertDp(includePadding.left), (int) this.mMapContainer.metricsController.convertDp(includePadding.right), (int) this.mMapContainer.metricsController.convertDp(includePadding.top), (int) this.mMapContainer.metricsController.convertDp(includePadding.bottom));
            }
        }
        if (newLatLngBoundsRect == null) {
            RVLogger.e(H5MapContainer.TAG, "no camera update for include points");
        } else if (z) {
            map.animateCamera(newLatLngBoundsRect);
        } else {
            map.moveCamera(newLatLngBoundsRect);
        }
        this.mMapContainer.renderController.onIncludePointsChange();
    }
}
