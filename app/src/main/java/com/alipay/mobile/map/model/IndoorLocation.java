package com.alipay.mobile.map.model;

/* loaded from: classes6.dex */
public class IndoorLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f7194a;
    private double b;
    private double c;
    private float d;
    private float e;
    private float f;

    public IndoorLocation() {
    }

    public IndoorLocation(double d, double d2) {
        this.b = d;
        this.f7194a = d2;
    }

    public IndoorLocation(double d, double d2, double d3) {
        this.b = d;
        this.f7194a = d2;
        this.c = d3;
    }

    public IndoorLocation(double d, double d2, double d3, float f, float f2, float f3) {
        this.b = d;
        this.f7194a = d2;
        this.c = d3;
        this.d = f;
        this.e = f2;
        this.f = f3;
    }

    public double getLat() {
        return this.f7194a;
    }

    public void setLat(double d) {
        this.f7194a = d;
    }

    public double getLng() {
        return this.b;
    }

    public void setLng(double d) {
        this.b = d;
    }

    public double getFloor() {
        return this.c;
    }

    public void setFloor(double d) {
        this.c = d;
    }

    public float getAccuracy() {
        return this.e;
    }

    public void setAccuracy(float f) {
        this.e = f;
    }

    public float getReliability() {
        return this.f;
    }

    public void setReliability(float f) {
        this.f = f;
    }

    public float getAngle() {
        return this.d;
    }

    public void setAngle(float f) {
        this.d = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("lng:");
        sb.append(this.b);
        sb.append(",lat:");
        sb.append(this.f7194a);
        sb.append(",floor:");
        sb.append(this.c);
        sb.append(",angle:");
        sb.append(this.d);
        sb.append(",accuracy:");
        sb.append(this.e);
        sb.append(",reliability:");
        sb.append(this.f);
        sb.append("]");
        return sb.toString();
    }
}
