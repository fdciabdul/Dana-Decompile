package com.alipay.mobile.map.model;

/* loaded from: classes6.dex */
public class LBSWifiItemInfo implements Comparable<LBSWifiItemInfo> {

    /* renamed from: a  reason: collision with root package name */
    private String f7196a;
    private String b;
    private int c;

    public String getSsid() {
        return this.f7196a;
    }

    public void setSsid(String str) {
        this.f7196a = str;
    }

    public String getBssid() {
        return this.b;
    }

    public void setBssid(String str) {
        this.b = str;
    }

    public int getLevel() {
        return this.c;
    }

    public void setLevel(int i) {
        this.c = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(LBSWifiItemInfo lBSWifiItemInfo) {
        return lBSWifiItemInfo.c - this.c;
    }
}
