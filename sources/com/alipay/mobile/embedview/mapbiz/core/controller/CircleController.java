package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterCircle;
import com.alipay.mobile.apmap.model.AdapterCircleOptions;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.data.Circle;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class CircleController extends H5MapController {

    /* renamed from: a */
    private List<AdapterCircle> f7148a;

    public CircleController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7148a = new CopyOnWriteArrayList();
    }

    public void clear() {
        if (this.f7148a.size() == 0) {
            return;
        }
        Iterator<AdapterCircle> it = this.f7148a.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
        this.f7148a.clear();
    }

    public void setCircles(AdapterAMap adapterAMap, List<Circle> list) {
        clear();
        if (list == null) {
            return;
        }
        for (Circle circle : list) {
            AdapterCircleOptions center = new AdapterCircleOptions(adapterAMap).center(new AdapterLatLng(adapterAMap, circle.latitude, circle.longitude));
            center.strokeColor(H5MapUtils.convertRGBAColor(circle.color));
            center.fillColor(H5MapUtils.convertRGBAColor(circle.fillColor));
            if (circle.strokeWidth != -1.0d) {
                center.strokeWidth((float) this.mMapContainer.metricsController.convertDp(circle.strokeWidth));
            }
            center.radius(circle.radius);
            this.f7148a.add(adapterAMap.addCircle(center));
        }
    }
}
