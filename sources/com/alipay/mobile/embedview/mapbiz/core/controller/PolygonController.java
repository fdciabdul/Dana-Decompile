package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.graphics.Color;
import android.text.TextUtils;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterPolygonOptions;
import com.alipay.mobile.embedview.mapbiz.core.H5MapPolygon;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.data.Polygon;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class PolygonController extends H5MapController {

    /* renamed from: a */
    private List<H5MapPolygon> f7164a;
    private boolean b;

    public PolygonController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7164a = new CopyOnWriteArrayList();
    }

    private void a() {
        if (this.f7164a.size() == 0) {
            return;
        }
        for (H5MapPolygon h5MapPolygon : this.f7164a) {
            if (h5MapPolygon.polygonContext != null) {
                h5MapPolygon.polygonContext.remove();
            }
        }
        this.f7164a.clear();
    }

    public void setPolygons(AdapterAMap adapterAMap, List<Polygon> list) {
        a();
        if (list == null || list.size() == 0) {
            return;
        }
        for (Polygon polygon : list) {
            if (polygon != null && polygon.points != null) {
                AdapterPolygonOptions adapterPolygonOptions = new AdapterPolygonOptions(adapterAMap);
                Iterator<Point> it = polygon.points.iterator();
                while (it.hasNext()) {
                    adapterPolygonOptions.add(it.next().getLatLng(adapterAMap));
                }
                if (!TextUtils.isEmpty(polygon.color)) {
                    adapterPolygonOptions.strokeColor(H5MapUtils.convertRGBAColor(polygon.color));
                } else {
                    adapterPolygonOptions.strokeColor(Color.parseColor("#FF0000"));
                }
                if (polygon.width > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    adapterPolygonOptions.strokeWidth((float) this.mMapContainer.metricsController.convertDp(polygon.width));
                }
                if (!TextUtils.isEmpty(polygon.fillColor)) {
                    adapterPolygonOptions.fillColor(H5MapUtils.convertRGBAColor(polygon.fillColor));
                } else {
                    adapterPolygonOptions.fillColor(0);
                }
                this.f7164a.add(new H5MapPolygon(polygon, adapterAMap.addPolygon(adapterPolygonOptions)));
            }
        }
        onPolygonsChanged();
        if (this.b) {
            onCameraChanged(adapterAMap.getCameraPosition(), false);
        }
    }

    public void onPolygonsChanged() {
        this.b = false;
        if (this.f7164a.size() != 0) {
            Iterator<H5MapPolygon> it = this.f7164a.iterator();
            while (it.hasNext()) {
                if (it.next().isWatchCamera()) {
                    this.b = true;
                    return;
                }
            }
        }
    }

    public void onCameraChanging(AdapterCameraPosition adapterCameraPosition) {
        synchronized (this) {
            if (this.b) {
                Iterator<H5MapPolygon> it = this.f7164a.iterator();
                while (it.hasNext()) {
                    it.next().onCameraChanged(adapterCameraPosition);
                }
            }
        }
    }

    public void onCameraChanged(AdapterCameraPosition adapterCameraPosition, boolean z) {
        synchronized (this) {
            if (this.b) {
                Iterator<H5MapPolygon> it = this.f7164a.iterator();
                while (it.hasNext()) {
                    it.next().onCameraChanged(adapterCameraPosition);
                }
            }
        }
    }
}
