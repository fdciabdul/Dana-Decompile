package com.alipay.mobile.common.lbs;

import android.location.Location;
import com.alipay.mobile.map.model.geocode.ReGeocodeResult;

/* loaded from: classes6.dex */
public class LBSLocation extends Location implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7131a = "LBSLocation";
    private String A;
    private boolean B;
    private boolean C;
    private int D;
    private ReGeocodeResult E;
    private boolean F;
    private long G;
    private double b;
    private double c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    @Deprecated
    private String i;
    private String j;
    private boolean k;
    private String l;
    private String m;
    private String n;

    /* renamed from: o  reason: collision with root package name */
    private String f7132o;
    private String p;
    private String q;
    private String r;
    private String s;
    private float t;
    private String u;
    private String v;
    private Long w;
    private String x;
    private String y;
    private String z;

    public String getCityAdcode() {
        return this.y;
    }

    public void setCityAdcode(String str) {
        this.y = str;
    }

    public String getDistrictAdcode() {
        return this.z;
    }

    public void setDistrictAdcode(String str) {
        this.z = str;
    }

    public boolean isCache() {
        return this.B;
    }

    public void setCache(boolean z) {
        this.B = z;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return this.t;
    }

    @Override // android.location.Location
    public void setAccuracy(float f) {
        this.t = f;
    }

    public LBSLocation(Location location) {
        super(location);
        this.k = false;
        this.D = -1;
        this.F = false;
    }

    public LBSLocation() {
        super("");
        this.k = false;
        this.D = -1;
        this.F = false;
    }

    public long getLocalTime() {
        return this.G;
    }

    public void setLocalTime(long j) {
        this.G = j;
    }

    public String getProvince() {
        return this.f;
    }

    public void setProvince(String str) {
        this.f = str;
    }

    public String getCity() {
        return this.g;
    }

    public void setCity(String str) {
        this.g = str;
    }

    public String getDistrict() {
        return this.h;
    }

    public void setDistrict(String str) {
        this.h = str;
    }

    @Deprecated
    public String getCityCode() {
        return this.i;
    }

    @Deprecated
    public void setCityCode(String str) {
        this.i = str;
    }

    public String getAdCode() {
        return this.j;
    }

    public void setAdCode(String str) {
        this.j = str;
    }

    public boolean getIsGetAMapAPP() {
        return this.k;
    }

    public void setIsGetAMapAPP(boolean z) {
        this.k = z;
    }

    public String getFineLocation() {
        return this.l;
    }

    public void setFineLocation(String str) {
        this.l = str;
    }

    public String getFineLocationkey() {
        return this.m;
    }

    public void setFineLocationkey(String str) {
        this.m = str;
    }

    public String getCorseLocation() {
        return this.n;
    }

    public void setCorseLocation(String str) {
        this.n = str;
    }

    public String getCorseLocationkey() {
        return this.f7132o;
    }

    public void setCorseLocationkey(String str) {
        this.f7132o = str;
    }

    public String getWifiLocation() {
        return this.p;
    }

    public void setWifiLocation(String str) {
        this.p = str;
    }

    public String getWifiLocationkey() {
        return this.q;
    }

    public void setWifiLocationkey(String str) {
        this.q = str;
    }

    public String getCellInfo() {
        return this.r;
    }

    public void setCellInfo(String str) {
        this.r = str;
    }

    public String getCellInfokey() {
        return this.s;
    }

    public void setCellInfokey(String str) {
        this.s = str;
    }

    public void setCountry(String str) {
        this.e = str;
    }

    public String getCountry() {
        return this.e;
    }

    public String getStreet() {
        return this.u;
    }

    public void setStreet(String str) {
        this.u = str;
    }

    public String getAddress() {
        return this.v;
    }

    public void setAddress(String str) {
        this.v = str;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.b;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        this.b = d;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.c;
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        this.c = d;
    }

    public String getEncryptLocation() {
        return this.d;
    }

    public void setEncryptLocation(String str) {
        this.d = str;
    }

    public Long getLocationtime() {
        return this.w;
    }

    public void setLocationtime(Long l) {
        this.w = l;
    }

    public String getAoiname() {
        return this.x;
    }

    public void setAoiname(String str) {
        this.x = str;
    }

    public boolean isReGeocoded() {
        return this.C;
    }

    public void setReGeocoded(boolean z) {
        this.C = z;
    }

    public int getReGeocodeLevel() {
        return this.D;
    }

    public void setReGeocodeLevel(int i) {
        this.D = i;
    }

    public ReGeocodeResult getReGeocodeResult() {
        return this.E;
    }

    public void setReGeocodeResult(ReGeocodeResult reGeocodeResult) {
        this.E = reGeocodeResult;
    }

    public boolean isWifiCompensation() {
        return this.F;
    }

    public void setWifiCompensation(boolean z) {
        this.F = z;
    }

    public String getLocationType() {
        return this.A;
    }

    public void setLocationType(String str) {
        this.A = str;
    }
}
