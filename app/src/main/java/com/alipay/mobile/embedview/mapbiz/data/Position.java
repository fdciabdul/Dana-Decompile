package com.alipay.mobile.embedview.mapbiz.data;

import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class Position implements Serializable {
    public Double bottom;
    public double height;
    public Double left;
    public Double right;
    public Double top;
    public double width;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return H5MapUtils.equals(position.left, this.left) && H5MapUtils.equals(position.top, this.top) && H5MapUtils.equals(position.right, this.right) && H5MapUtils.equals(position.bottom, this.bottom) && Double.compare(position.width, this.width) == 0 && Double.compare(position.height, this.height) == 0;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
