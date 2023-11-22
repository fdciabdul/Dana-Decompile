package com.alipay.iap.android.lbs;

import android.location.Location;

/* loaded from: classes.dex */
public class LBSLocation extends Location {

    /* renamed from: a  reason: collision with root package name */
    private long f6991a;
    private int b;

    public LBSLocation() {
        super("");
        this.f6991a = 0L;
        this.b = LBSLocationErrorCode.LocationErrorSuccess.getErrorCode();
    }

    public LBSLocation(Location location) {
        super(location);
        this.f6991a = 0L;
        this.b = LBSLocationErrorCode.LocationErrorSuccess.getErrorCode();
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public int getErrorCode() {
        return this.b;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return super.getLatitude();
    }

    @Override // android.location.Location
    public double getLongitude() {
        return super.getLongitude();
    }

    @Override // android.location.Location
    public long getTime() {
        return super.getTime();
    }

    public long getTimeCost() {
        return this.f6991a;
    }

    public String getType() {
        return super.getProvider();
    }

    @Override // android.location.Location
    public void setAccuracy(float f) {
        super.setAccuracy(f);
    }

    public void setErrorCode(int i) {
        this.b = i;
    }

    @Override // android.location.Location
    public void setLatitude(double d) {
        super.setLatitude(d);
    }

    @Override // android.location.Location
    public void setLongitude(double d) {
        super.setLongitude(d);
    }

    @Override // android.location.Location
    public void setTime(long j) {
        super.setTime(j);
    }

    public void setTimeCost(long j) {
        this.f6991a = j;
    }

    public void setType(String str) {
        super.setProvider(str);
    }
}
