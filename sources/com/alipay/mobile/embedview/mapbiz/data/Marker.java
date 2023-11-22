package com.alipay.mobile.embedview.mapbiz.data;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Marker implements Serializable {
    public Callout callout;
    public boolean clusterEnabled;
    public CustomCallout customCallout;
    public List<Range> displayRanges;
    public FixedPoint fixedPoint;
    public int height;
    public Layout iconLayout;
    public String iconPath;

    /* renamed from: id  reason: collision with root package name */
    public String f7175id;
    public JSONObject label;
    public double latitude;
    public double longitude;
    public JSONObject style;
    public String title;
    public int width;
    public int rotate = 0;
    public double alpha = 1.0d;
    public double anchorX = 0.5d;
    public double anchorY = 1.0d;
    public String iconAppendStr = "";
    public String iconAppendStrColor = "#33B276";
    public int markerLevel = 0;

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if ((obj instanceof Marker) && (str = this.f7175id) != null && (str2 = ((Marker) obj).f7175id) != null) {
            return str.equals(str2);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = this.f7175id;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public boolean isSame(Marker marker) {
        if (this == marker) {
            return true;
        }
        if (marker != null && this.fixedPoint == marker.fixedPoint && this.callout == marker.callout && this.customCallout == marker.customCallout && this.displayRanges == marker.displayRanges && this.latitude == marker.latitude && this.longitude == marker.longitude && TextUtils.equals(this.title, marker.title) && this.clusterEnabled == marker.clusterEnabled && H5MapUtils.isSameJSONObject(this.label, marker.label) && H5MapUtils.isSameJSONObject(this.style, marker.style) && TextUtils.equals(this.iconPath, marker.iconPath) && this.rotate == marker.rotate && this.alpha == marker.alpha && TextUtils.equals(this.iconAppendStr, marker.iconAppendStr) && TextUtils.equals(this.iconAppendStrColor, marker.iconAppendStrColor) && this.markerLevel == marker.markerLevel && this.width == marker.width && this.height == marker.height) {
            Layout layout = this.iconLayout;
            return (layout == null || layout.equals(marker.iconLayout)) && (this.iconLayout != null || marker.iconLayout == null);
        }
        return false;
    }

    public static Map<String, Integer> buildIdMap(List<Marker> list) {
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Marker marker = list.get(i);
                if (marker != null && !TextUtils.isEmpty(marker.f7175id)) {
                    hashMap.put(marker.f7175id, Integer.valueOf(i));
                }
            }
        }
        return hashMap;
    }
}
