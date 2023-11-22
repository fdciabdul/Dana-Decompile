package com.alipay.mobile.embedview.mapbiz.data;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.util.DynamicSDKContext;
import com.alipay.mobile.embedview.mapbiz.utils.Resettable;
import com.alipay.mobile.embedview.mapbiz.utils.WKT;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Point implements Resettable, WKT.WKTPoint, Serializable {
    @JSONField(serialize = false)
    private AdapterLatLng latLng;
    public double latitude;
    public double longitude;

    public Point() {
    }

    public Point(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public AdapterLatLng getLatLng(DynamicSDKContext dynamicSDKContext) {
        if (this.latLng == null) {
            this.latLng = new AdapterLatLng(dynamicSDKContext, this.latitude, this.longitude);
        }
        return this.latLng;
    }

    public static List<AdapterLatLng> toLatLangPoints(DynamicSDKContext dynamicSDKContext, List<Point> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i).getLatLng(dynamicSDKContext));
        }
        return arrayList;
    }

    public static List<Point> toPoints(List<AdapterLatLng> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdapterLatLng adapterLatLng = list.get(i);
            arrayList.add(new Point(adapterLatLng.getLatitude(), adapterLatLng.getLongitude()));
        }
        return arrayList;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.utils.WKT.WKTPoint
    public double latitude() {
        return this.latitude;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.utils.WKT.WKTPoint
    public double longitude() {
        return this.longitude;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.utils.Resettable
    public void reset() {
        this.latLng = null;
    }
}
