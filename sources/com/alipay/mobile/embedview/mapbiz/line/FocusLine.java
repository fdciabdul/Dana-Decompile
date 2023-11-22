package com.alipay.mobile.embedview.mapbiz.line;

import com.alipay.mobile.apmap.model.AdapterLatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class FocusLine {

    /* renamed from: a  reason: collision with root package name */
    private double f7178a;
    private double b;
    private int c;
    private List<AdapterLatLng> d;

    public FocusLine(int i) {
        this.c = i <= 1 ? 1 : i;
        this.d = new ArrayList();
    }

    public void add(AdapterLatLng adapterLatLng) {
        if (adapterLatLng == null) {
            return;
        }
        this.f7178a += adapterLatLng.getLatitude();
        this.b += adapterLatLng.getLongitude();
        this.d.add(adapterLatLng);
        if (this.d.size() > this.c) {
            AdapterLatLng adapterLatLng2 = this.d.get(0);
            this.f7178a -= adapterLatLng2.getLatitude();
            this.b -= adapterLatLng2.getLongitude();
            this.d.remove(0);
        }
    }

    public AdapterLatLng getFocusPoint() {
        int size = this.d.size();
        if (size == 0) {
            return null;
        }
        AdapterLatLng adapterLatLng = this.d.get(0);
        double d = this.f7178a;
        double d2 = size;
        Double.isNaN(d2);
        double d3 = this.b;
        Double.isNaN(d2);
        return new AdapterLatLng(adapterLatLng, d / d2, d3 / d2);
    }
}
