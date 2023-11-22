package com.alipay.mobile.map.model;

/* loaded from: classes6.dex */
public class WifiItemInfo implements Comparable<WifiItemInfo> {

    /* renamed from: a  reason: collision with root package name */
    private String f7201a;
    private String b;
    private Integer c;

    public String getMac() {
        return this.f7201a;
    }

    public void setMac(String str) {
        this.f7201a = str;
    }

    public String getSsid() {
        return this.b;
    }

    public void setSsid(String str) {
        this.b = str;
    }

    public Integer getLevel() {
        return this.c;
    }

    public void setLevel(Integer num) {
        this.c = num;
    }

    @Override // java.lang.Comparable
    public int compareTo(WifiItemInfo wifiItemInfo) {
        return wifiItemInfo.getLevel().compareTo(getLevel());
    }
}
