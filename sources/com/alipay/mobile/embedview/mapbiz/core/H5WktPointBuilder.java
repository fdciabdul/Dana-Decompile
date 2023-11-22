package com.alipay.mobile.embedview.mapbiz.core;

import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.utils.WKT;

/* loaded from: classes2.dex */
public class H5WktPointBuilder implements WKT.WKTPoint.Builder {
    public static final H5WktPointBuilder INSTANCE = new H5WktPointBuilder();

    private H5WktPointBuilder() {
    }

    @Override // com.alipay.mobile.embedview.mapbiz.utils.WKT.WKTPoint.Builder
    public WKT.WKTPoint build(double d, double d2) {
        return new Point(d, d2);
    }
}
