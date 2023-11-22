package com.alipay.mobile.embedview.mapbiz.data;

import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.utils.WKT;
import java.util.List;

/* loaded from: classes6.dex */
public class SmoothMovePolyline extends Polyline {
    public static final String ACTION_START = "start";
    public static final String ACTION_STOP = "stop";
    public String action = "start";
    public double duration = 5000.0d;

    public Polyline toPolyline() {
        return this;
    }

    public Polyline toPolyline(List<AdapterLatLng> list) {
        Polyline polyline = new Polyline();
        polyline.wktPointsData = Point.toPoints(list);
        polyline.wktPoints = WKT.toLineString(polyline.wktPointsData);
        polyline.color = this.color;
        polyline.width = this.width;
        polyline.iconWidth = this.iconWidth;
        polyline.dottedLine = this.dottedLine;
        polyline.zIndex = this.zIndex;
        polyline.iconPath = this.iconPath;
        polyline.colorList = this.colorList;
        return polyline;
    }
}
