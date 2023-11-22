package com.alipay.mobile.embedview.mapbiz.data;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.embedview.mapbiz.utils.Resettable;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class MapData implements Resettable, Serializable {
    public List<Circle> circles;
    public JSONObject command;
    public List<Control> controls;
    public String customMapStyle;
    @JSONField(name = "custom-map-style")
    public String customMapStyleX;
    public String element;
    @JSONField(name = "enable-satellite")
    public Boolean enableSatellite;
    @JSONField(name = "ground-overlays")
    public List<GroundOverlay> groundOverlays;
    @JSONField(name = "include-padding")
    public IncludePadding includePadding;
    @JSONField(name = "include-points")
    public List<Point> includePoints;
    @JSONField(name = "include-points-animation")
    public boolean includePointsAnimation;
    public double latitude;
    public List<Point> limitRegion;
    @JSONField(name = "limit-region")
    public List<Point> limitRegionX;
    public double longitude;
    public List<Marker> markers;
    public List<Panel> panels;
    public List<Polygon> polygon;
    public List<Polyline> polyline;
    public MapSetting setting;
    @JSONField(name = "show-location")
    public boolean showLocation;
    public Float skew;
    public SkewAnim skewAnim;
    @JSONField(name = "tile-overlay")
    public TileOverlay tileOverlay;
    public float scale = H5MapContainer.SCALE_DEFAULT;
    public float rotate = -1.0f;

    public static MapData check(MapData mapData) {
        String str;
        List<Point> list;
        if (mapData == null) {
            return mapData;
        }
        if (mapData.limitRegion == null && (list = mapData.limitRegionX) != null) {
            mapData.limitRegion = list;
        }
        if (mapData.customMapStyle == null && (str = mapData.customMapStyleX) != null) {
            mapData.customMapStyle = str;
        }
        return mapData;
    }

    public static float valueOfSkew(Float f) {
        if (f != null) {
            float floatValue = f.floatValue();
            if (floatValue >= 0.0f) {
                return floatValue;
            }
            return 0.0f;
        }
        return -1.0f;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.utils.Resettable
    public void reset() {
        List<Point> list = this.limitRegionX;
        if (list != null) {
            H5MapUtils.reset(list);
        }
        List<Point> list2 = this.limitRegion;
        if (list2 != null) {
            H5MapUtils.reset(list2);
        }
        List<GroundOverlay> list3 = this.groundOverlays;
        if (list3 != null) {
            H5MapUtils.reset(list3);
        }
        List<Polyline> list4 = this.polyline;
        if (list4 != null) {
            H5MapUtils.reset(list4);
        }
        List<Point> list5 = this.includePoints;
        if (list5 != null) {
            H5MapUtils.reset(list5);
        }
        List<Polygon> list6 = this.polygon;
        if (list6 != null) {
            H5MapUtils.reset(list6);
        }
    }
}
