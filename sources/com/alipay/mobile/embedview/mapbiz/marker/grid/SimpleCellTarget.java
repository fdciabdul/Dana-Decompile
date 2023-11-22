package com.alipay.mobile.embedview.mapbiz.marker.grid;

import android.graphics.Point;

/* loaded from: classes6.dex */
public class SimpleCellTarget extends Point implements CellTarget {
    @Override // com.alipay.mobile.embedview.mapbiz.marker.grid.CellTarget
    public Point toPoint() {
        return this;
    }

    public SimpleCellTarget() {
    }

    public SimpleCellTarget(int i, int i2) {
        super(i, i2);
    }
}
