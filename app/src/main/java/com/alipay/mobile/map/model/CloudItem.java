package com.alipay.mobile.map.model;

import java.util.HashMap;

/* loaded from: classes6.dex */
public class CloudItem {

    /* renamed from: a  reason: collision with root package name */
    private int f7193a;
    private String b;
    private HashMap<String, String> c;
    private int d;
    private LatLonPoint e;
    private String f;
    private String g;
    private String h;
    private String i;

    public int getDescribeContents() {
        return this.f7193a;
    }

    public void setDescribeContents(int i) {
        this.f7193a = i;
    }

    public String getCreateTime() {
        return this.b;
    }

    public void setCreateTime(String str) {
        this.b = str;
    }

    public HashMap<String, String> getCustomeField() {
        return this.c;
    }

    public void setCustomeField(HashMap<String, String> hashMap) {
        this.c = hashMap;
    }

    public int getDistance() {
        return this.d;
    }

    public void setDistance(int i) {
        this.d = i;
    }

    public LatLonPoint getLatLonPoint() {
        return this.e;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public String getPoiID() {
        return this.f;
    }

    public void setPoiID(String str) {
        this.f = str;
    }

    public String getTitle() {
        return this.g;
    }

    public void setTitle(String str) {
        this.g = str;
    }

    public String getSnippet() {
        return this.h;
    }

    public void setSnippet(String str) {
        this.h = str;
    }

    public String getUpdateTime() {
        return this.i;
    }

    public void setUpdateTime(String str) {
        this.i = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof CloudItem) {
            return this.f.equals(((CloudItem) obj).f);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f;
        if (str != null) {
            return str.hashCode();
        }
        return super.hashCode();
    }
}
