package com.alipay.mobile.embedview.mapbiz.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.embedview.mapbiz.utils.Resettable;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes2.dex */
public class GroundOverlay implements Resettable, Serializable {
    public float alpha;
    public String image;
    @JSONField(name = "include-points")
    public List<Point> includePoints;
    public int zIndex;

    @Override // com.alipay.mobile.embedview.mapbiz.utils.Resettable
    public void reset() {
        H5MapUtils.reset(this.includePoints);
    }
}
