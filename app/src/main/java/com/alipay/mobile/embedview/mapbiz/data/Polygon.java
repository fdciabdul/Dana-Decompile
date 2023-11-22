package com.alipay.mobile.embedview.mapbiz.data;

import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.embedview.mapbiz.utils.Resettable;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class Polygon implements Resettable, Serializable {
    public String color;
    public List<Range> displayRanges;
    public String fillColor;
    public List<Point> points;
    public double width;

    @Override // com.alipay.mobile.embedview.mapbiz.utils.Resettable
    public void reset() {
        H5MapUtils.reset(this.points);
    }
}
