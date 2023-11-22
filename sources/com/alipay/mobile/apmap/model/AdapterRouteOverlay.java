package com.alipay.mobile.apmap.model;

import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterCameraUpdateFactory;
import com.alipay.mobile.map.model.LatLonPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class AdapterRouteOverlay {
    AdapterLatLng endPoint;
    AdapterAMap mAMap;
    AdapterBitmapDescriptor mPolylineTextureBitmap;
    String mWalkColor;
    AdapterLatLng startPoint;
    int zIndex;

    /* renamed from: a */
    private List<AdapterPolyline> f7111a = new ArrayList();
    float mRouteWidth = 18.0f;

    public void removeFromMap() {
        Iterator<AdapterPolyline> it = this.f7111a.iterator();
        while (it.hasNext()) {
            it.next().remove();
        }
    }

    public void zoomToSpan() {
        if (this.startPoint == null || this.endPoint == null || this.mAMap == null) {
            return;
        }
        try {
            this.mAMap.animateCamera(AdapterCameraUpdateFactory.newLatLngBounds(getLatLngBounds(), 50));
        } catch (Throwable unused) {
        }
    }

    protected AdapterLatLngBounds getLatLngBounds() {
        AdapterLatLngBounds adapterLatLngBounds = new AdapterLatLngBounds(this.mAMap);
        adapterLatLngBounds.include(new AdapterLatLng(this.mAMap, this.startPoint.getLatitude(), this.startPoint.getLongitude()));
        adapterLatLngBounds.include(new AdapterLatLng(this.mAMap, this.endPoint.getLatitude(), this.endPoint.getLongitude()));
        Iterator<AdapterPolyline> it = this.f7111a.iterator();
        while (it.hasNext()) {
            Iterator<AdapterLatLng> it2 = it.next().getPoints().iterator();
            while (it2.hasNext()) {
                adapterLatLngBounds.include(it2.next());
            }
        }
        return adapterLatLngBounds.build();
    }

    protected void addPolyLine(AdapterPolylineOptions adapterPolylineOptions) {
        AdapterPolyline addPolyline;
        if (adapterPolylineOptions == null || (addPolyline = this.mAMap.addPolyline(adapterPolylineOptions)) == null) {
            return;
        }
        this.f7111a.add(addPolyline);
    }

    protected ArrayList<AdapterLatLng> convertArrList(List<LatLonPoint> list) {
        ArrayList<AdapterLatLng> arrayList = new ArrayList<>();
        for (LatLonPoint latLonPoint : list) {
            arrayList.add(new AdapterLatLng(this.mAMap, latLonPoint.getLatitude(), latLonPoint.getLongitude()));
        }
        return arrayList;
    }

    public void setWalkColor(String str) {
        this.mWalkColor = str;
    }

    public void setIcon(AdapterBitmapDescriptor adapterBitmapDescriptor) {
        this.mPolylineTextureBitmap = adapterBitmapDescriptor;
    }

    public void setRouteWidth(float f) {
        this.mRouteWidth = f;
    }

    public void setZIndex(int i) {
        this.zIndex = i;
    }
}
