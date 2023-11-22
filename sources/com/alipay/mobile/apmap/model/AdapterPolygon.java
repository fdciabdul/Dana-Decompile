package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.google.android.gms.maps.model.Polygon;

/* loaded from: classes6.dex */
public class AdapterPolygon {

    /* renamed from: a  reason: collision with root package name */
    private Polygon f7107a;

    public AdapterPolygon(Polygon polygon) {
        this.f7107a = polygon;
    }

    public Polygon getGoogleMapPolygon() {
        return this.f7107a;
    }

    public void remove() {
        Polygon polygon;
        RVLogger.d("AdapterPolygon", "remove");
        if (!AdapterUtil.isGoogleMapSdk() || (polygon = this.f7107a) == null) {
            return;
        }
        polygon.remove();
    }

    public void setVisible(boolean z) {
        this.f7107a.setVisible(z);
    }

    public boolean isVisible() {
        return this.f7107a.isVisible();
    }
}
