package com.alipay.mobile.embedview.mapbiz.core;

import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterPolygon;
import com.alipay.mobile.embedview.mapbiz.data.Polygon;
import com.alipay.mobile.embedview.mapbiz.data.Range;
import java.util.List;

/* loaded from: classes6.dex */
public class H5MapPolygon {

    /* renamed from: a  reason: collision with root package name */
    private List<Range> f7141a;
    private boolean b = true;
    public final Polygon polygon;
    public final AdapterPolygon polygonContext;

    public H5MapPolygon(Polygon polygon, AdapterPolygon adapterPolygon) {
        this.polygon = polygon;
        this.polygonContext = adapterPolygon;
        if (polygon != null) {
            this.f7141a = polygon.displayRanges;
        }
    }

    public boolean isWatchCamera() {
        Polygon polygon = this.polygon;
        return (polygon == null || polygon.displayRanges == null || this.polygon.displayRanges.size() <= 0) ? false : true;
    }

    public void onCameraChanged(AdapterCameraPosition adapterCameraPosition) {
        boolean canDisplay = Range.canDisplay(adapterCameraPosition.zoom, this.f7141a);
        AdapterPolygon adapterPolygon = this.polygonContext;
        if (adapterPolygon == null || this.b == canDisplay) {
            return;
        }
        this.b = canDisplay;
        adapterPolygon.setVisible(canDisplay);
    }
}
