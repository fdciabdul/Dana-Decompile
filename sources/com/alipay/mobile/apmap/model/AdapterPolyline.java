package com.alipay.mobile.apmap.model;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class AdapterPolyline implements DynamicSDKContext {

    /* renamed from: a  reason: collision with root package name */
    private Polyline f7109a;
    private boolean b;

    public AdapterPolyline(Polyline polyline) {
        this.f7109a = polyline;
        StringBuilder sb = new StringBuilder();
        sb.append("mGoogleMapPolyline is null =");
        sb.append(this.f7109a == null);
        RVLogger.d("AdapterPolyline", sb.toString());
    }

    @Override // com.alipay.mobile.apmap.util.DynamicSDKContext
    public boolean is2dMapSdk() {
        return this.b;
    }

    public void remove() {
        Polyline polyline;
        RVLogger.d("AdapterPolyline", "remove");
        if (!AdapterUtil.isGoogleMapSdk() || (polyline = this.f7109a) == null) {
            return;
        }
        polyline.remove();
    }

    public List<AdapterLatLng> getPoints() {
        Polyline polyline;
        RVLogger.d("AdapterPolyline", "getPoints");
        ArrayList arrayList = new ArrayList();
        if (AdapterUtil.isGoogleMapSdk() && (polyline = this.f7109a) != null && polyline.getPoints() != null) {
            Iterator<LatLng> it = this.f7109a.getPoints().iterator();
            while (it.hasNext()) {
                arrayList.add(new AdapterLatLng(it.next()));
            }
        }
        return arrayList;
    }

    public void setPoints(List<AdapterLatLng> list) {
        RVLogger.d("AdapterPolyline", "setPoints");
        if (list == null) {
            RVLogger.d("AdapterPolyline", "setPoints points == null");
        } else if (!AdapterUtil.isGoogleMapSdk() || this.f7109a == null) {
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<AdapterLatLng> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getGoogleMapLatLng());
            }
            this.f7109a.setPoints(arrayList);
        }
    }

    public void setVisible(boolean z) {
        Polyline polyline;
        StringBuilder sb = new StringBuilder();
        sb.append("setVisible visible = ");
        sb.append(z);
        RVLogger.d("AdapterPolyline", sb.toString());
        if (!AdapterUtil.isGoogleMapSdk() || (polyline = this.f7109a) == null) {
            return;
        }
        polyline.setVisible(z);
    }

    public boolean isVisible() {
        Polyline polyline;
        RVLogger.d("AdapterPolyline", "isVisible");
        if (!AdapterUtil.isGoogleMapSdk() || (polyline = this.f7109a) == null) {
            return false;
        }
        return polyline.isVisible();
    }

    public void setCustomTexture(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        RVLogger.d("AdapterPolyline", "setCustomTexture");
        if (adapterBitmapDescriptor == null) {
            RVLogger.d("AdapterPolyline", "setCustomTexture descriptor == null");
        } else {
            AdapterUtil.isGoogleMapSdk();
        }
    }
}
