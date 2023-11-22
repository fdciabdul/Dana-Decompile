package com.alipay.mobile.map.model;

/* loaded from: classes6.dex */
public class SearchPoiRequest {

    /* renamed from: a  reason: collision with root package name */
    private LatLonPoint f7200a;
    private String g;
    private float h;
    private String b = "";
    private int c = 20;
    private int d = 0;
    private int e = 1500;
    private boolean f = false;
    private String i = "";

    public String getTypes() {
        return this.g;
    }

    public void setTypes(String str) {
        this.g = str;
    }

    public float getAccuracy() {
        return this.h;
    }

    public void setAccuracy(float f) {
        this.h = f;
    }

    public String getCity() {
        return this.i;
    }

    public void setCity(String str) {
        this.i = str;
    }

    public LatLonPoint getLatlng() {
        return this.f7200a;
    }

    public void setLatlng(LatLonPoint latLonPoint) {
        this.f7200a = latLonPoint;
    }

    public String getKeywords() {
        return this.b;
    }

    public void setKeywords(String str) {
        this.b = str;
    }

    public int getPagesize() {
        return this.c;
    }

    public void setPagesize(int i) {
        this.c = i;
    }

    public int getPagenum() {
        return this.d;
    }

    public void setPagenum(int i) {
        this.d = i;
    }

    public int getRadius() {
        return this.e;
    }

    public void setRadius(int i) {
        this.e = i;
    }

    public boolean isByfoursquare() {
        return this.f;
    }

    public void setByfoursquare(boolean z) {
        this.f = z;
    }
}
