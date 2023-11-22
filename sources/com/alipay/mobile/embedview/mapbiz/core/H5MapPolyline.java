package com.alipay.mobile.embedview.mapbiz.core;

import android.text.TextUtils;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterPolyline;
import com.alipay.mobile.embedview.mapbiz.data.Polyline;
import java.util.List;

/* loaded from: classes6.dex */
public class H5MapPolyline {
    public final List<AdapterPolyline> context;

    /* renamed from: id  reason: collision with root package name */
    public String f7142id;
    public Polyline polyline;

    public H5MapPolyline(Polyline polyline, List<AdapterPolyline> list) {
        this.context = list;
        this.polyline = polyline;
        String obtainId = polyline.obtainId();
        this.f7142id = obtainId;
        if (TextUtils.isEmpty(obtainId)) {
            this.f7142id = H5MapIDAssistant.INSTANCE.obtainID();
        }
    }

    public void setPoints(List<AdapterLatLng> list) {
        List<AdapterPolyline> list2;
        if (list == null || (list2 = this.context) == null) {
            return;
        }
        for (AdapterPolyline adapterPolyline : list2) {
            if (adapterPolyline != null) {
                adapterPolyline.setPoints(list);
            }
        }
    }

    public void remove() {
        List<AdapterPolyline> list = this.context;
        if (list != null) {
            for (AdapterPolyline adapterPolyline : list) {
                if (adapterPolyline != null) {
                    adapterPolyline.remove();
                }
            }
        }
    }
}
