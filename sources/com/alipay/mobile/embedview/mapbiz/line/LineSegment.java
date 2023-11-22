package com.alipay.mobile.embedview.mapbiz.line;

import com.alipay.mobile.apmap.AdapterAMapUtils;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class LineSegment {
    public int beginIndex;
    public double beginOffsetDistance;
    public double distance;
    public int endIndex;
    public double endOffsetDistance;
    public List<AdapterLatLng> line;
    public List<AdapterLatLng> segment;

    private LineSegment() {
    }

    public LineSegment create() {
        int size;
        this.segment = new ArrayList();
        int i = this.beginIndex;
        if (i <= 0) {
            i = 0;
        }
        this.beginIndex = i;
        this.endIndex = i;
        List<AdapterLatLng> list = this.line;
        if (list == null || (size = list.size()) == 0) {
            return this;
        }
        if (size != 1) {
            double d = this.distance;
            if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                double d2 = d + this.beginOffsetDistance;
                int i2 = this.beginIndex;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    AdapterLatLng adapterLatLng = this.line.get(i2);
                    this.segment.add(adapterLatLng);
                    if (d2 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || i2 == size - 1) {
                        break;
                    }
                    i2++;
                    AdapterLatLng adapterLatLng2 = this.line.get(i2);
                    double calculateLineDistance = AdapterAMapUtils.calculateLineDistance(adapterLatLng, adapterLatLng2);
                    if (d2 < calculateLineDistance) {
                        this.endOffsetDistance = d2;
                        this.segment.add(H5MapUtils.getPointOnLine(adapterLatLng, adapterLatLng2, d2));
                        break;
                    }
                    d2 -= calculateLineDistance;
                    this.endIndex++;
                }
                return this;
            }
        }
        this.segment.add(this.line.get(0));
        return this;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private LineSegment f7179a = new LineSegment();

        public final Builder line(List<AdapterLatLng> list) {
            this.f7179a.line = list;
            return this;
        }

        public final Builder distance(double d) {
            this.f7179a.distance = d;
            return this;
        }

        public final Builder beginIndex(int i) {
            this.f7179a.beginIndex = i;
            return this;
        }

        public final Builder beginOffsetDistance(double d) {
            this.f7179a.beginOffsetDistance = d;
            return this;
        }

        public final LineSegment build() {
            return this.f7179a.create();
        }
    }
}
