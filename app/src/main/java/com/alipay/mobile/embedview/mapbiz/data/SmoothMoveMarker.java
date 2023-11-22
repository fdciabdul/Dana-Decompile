package com.alipay.mobile.embedview.mapbiz.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.embedview.mapbiz.core.H5WktPointBuilder;
import com.alipay.mobile.embedview.mapbiz.utils.WKT;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class SmoothMoveMarker implements Serializable {
    public static final String ACTION_START = "start";
    public static final String ACTION_STOP = "stop";
    public boolean autoFocus;
    public boolean autoFollow;
    public boolean autoRotate;
    public boolean hideMarker;
    public Marker markerData;
    public String markerId;
    public List<Point> points;
    public List<Double> targetDistances;
    public String wktPoints;
    @JSONField(serialize = false)
    public List<Point> wktPointsData;
    public String action = "start";
    public double duration = 5000.0d;
    public double autoRotateThreshold = -1.0d;
    public double autoFocusThreshold = -1.0d;

    public List<Point> obtainPoints() {
        List<Point> list = this.points;
        if (list != null) {
            return list;
        }
        String str = this.wktPoints;
        if (str != null) {
            if (this.wktPointsData == null) {
                this.wktPointsData = WKT.fromLineString(str, H5WktPointBuilder.INSTANCE);
            }
            return this.wktPointsData;
        }
        return null;
    }
}
