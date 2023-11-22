package com.alipay.mobile.embedview.mapbiz.line;

import com.alipay.mobile.apmap.AdapterAMapUtils;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.line.LineSegment;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class MovableLine {

    /* renamed from: a  reason: collision with root package name */
    private List<AdapterLatLng> f7180a;
    private int b = 0;
    private double c = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    private Map<AdapterLatLng, Object> d = new HashMap();
    private List<AdapterLatLng> e = new ArrayList();
    private double f;

    public MovableLine(List<AdapterLatLng> list) {
        this.f7180a = list;
    }

    public void move(double d) {
        if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return;
        }
        LineSegment build = new LineSegment.Builder().beginIndex(this.b).beginOffsetDistance(this.c).line(this.f7180a).distance(d).build();
        int i = build.endIndex;
        List<AdapterLatLng> list = build.segment;
        int size = this.e.size();
        if (size != 0 && list.size() != 0) {
            int i2 = size - 1;
            if (this.e.get(i2) == list.get(0)) {
                this.e.remove(i2);
                size = this.e.size();
            }
        }
        for (int i3 = size - 2; i3 >= 0; i3--) {
            if (!this.d.containsKey(this.e.get(i3))) {
                this.e.remove(i3);
            }
        }
        this.e.addAll(list);
        this.f += d;
        int size2 = this.f7180a.size();
        for (int i4 = this.b; i4 <= i && i4 < size2; i4++) {
            this.d.put(this.f7180a.get(i4), null);
        }
        if (this.b <= i) {
            this.b = i;
            this.c = build.endOffsetDistance;
        }
    }

    public List<AdapterLatLng> tryMove(double d) {
        LineSegment build = new LineSegment.Builder().beginIndex(this.b).beginOffsetDistance(this.c).line(this.f7180a).distance(d).build();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.e);
        arrayList.addAll(build.segment);
        return arrayList;
    }

    public List<AdapterLatLng> subLine(double d) {
        ArrayList arrayList = new ArrayList();
        if (this.f != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.e.size() != 0) {
            double d2 = this.f;
            if (d >= d2) {
                arrayList.addAll(this.e);
            } else {
                AdapterLatLng adapterLatLng = null;
                double d3 = d2 - d;
                int size = this.e.size() - 1;
                int i = 0;
                while (true) {
                    if (size < 0) {
                        size = i;
                        break;
                    } else if (d3 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || size == 0) {
                        break;
                    } else {
                        AdapterLatLng adapterLatLng2 = this.e.get(size);
                        AdapterLatLng adapterLatLng3 = this.e.get(size - 1);
                        double calculateLineDistance = AdapterAMapUtils.calculateLineDistance(adapterLatLng2, adapterLatLng3);
                        if (d3 < calculateLineDistance) {
                            adapterLatLng = H5MapUtils.getPointOnLine(adapterLatLng2, adapterLatLng3, d3);
                        }
                        d3 -= calculateLineDistance;
                        i = size;
                        size--;
                    }
                }
                arrayList.addAll(this.e.subList(0, size + 1));
                if (adapterLatLng != null) {
                    arrayList.add(adapterLatLng);
                }
            }
        }
        return arrayList;
    }

    public List<AdapterLatLng> getCurrentLine() {
        return this.e;
    }

    public double getCurrentDistance() {
        return this.f;
    }

    public int indexOffset() {
        return this.b;
    }
}
