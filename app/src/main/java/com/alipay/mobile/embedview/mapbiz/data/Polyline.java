package com.alipay.mobile.embedview.mapbiz.data;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.embedview.mapbiz.core.H5WktPointBuilder;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.embedview.mapbiz.utils.Resettable;
import com.alipay.mobile.embedview.mapbiz.utils.WKT;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class Polyline implements Resettable, Serializable {
    public String color;
    public List<String> colorList;
    public String iconPath;
    public double iconWidth;

    /* renamed from: id  reason: collision with root package name */
    public String f7177id;
    public List<Point> points;
    public String polylineId;
    public double width;
    public String wktPoints;
    @JSONField(serialize = false)
    public List<Point> wktPointsData;
    public boolean dottedLine = false;
    public int zIndex = -1;

    public String obtainId() {
        String str = this.polylineId;
        return str != null ? str : this.f7177id;
    }

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

    @Override // com.alipay.mobile.embedview.mapbiz.utils.Resettable
    public void reset() {
        H5MapUtils.reset(this.points);
        H5MapUtils.reset(this.wktPointsData);
    }

    public boolean isSameStyle(Polyline polyline) {
        if (this == polyline) {
            return true;
        }
        if (polyline != null && this.width == polyline.width && this.iconWidth == polyline.iconWidth && this.dottedLine == polyline.dottedLine && this.zIndex == polyline.zIndex && TextUtils.equals(this.color, polyline.color) && TextUtils.equals(this.iconPath, polyline.iconPath)) {
            List<String> list = this.colorList;
            List<String> list2 = polyline.colorList;
            return list == list2 || (list != null && list.equals(list2));
        }
        return false;
    }
}
