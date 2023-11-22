package com.alipay.mobile.common.lbs;

import android.os.Handler;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class LBSLocationRequest {

    /* renamed from: a  reason: collision with root package name */
    private String f7133a;
    private LBSLocation f;
    private long h;
    private Map<String, Object> l;
    private Handler m;
    private long b = TimeUnit.SECONDS.toMillis(30);
    private long c = TimeUnit.SECONDS.toMillis(31);
    private boolean d = false;
    private int e = 0;
    private boolean g = true;
    private boolean i = true;
    private boolean j = false;
    private int k = 0;

    public boolean isNeedSpeed() {
        return this.j;
    }

    public void setNeedSpeed(boolean z) {
        this.j = z;
    }

    public String getBizType() {
        return this.f7133a;
    }

    public void setBizType(String str) {
        this.f7133a = str;
    }

    public long getCacheTimeInterval() {
        return this.b;
    }

    public void setCacheTimeInterval(long j) {
        this.b = j;
    }

    public long getTimeOut() {
        return this.c;
    }

    public void setTimeOut(long j) {
        this.c = j;
    }

    public int getReGeoLevel() {
        return this.e;
    }

    public void setReGeoLevel(int i) {
        this.e = i;
    }

    public LBSLocation getLocation() {
        return this.f;
    }

    public void setLocation(LBSLocation lBSLocation) {
        this.f = lBSLocation;
    }

    public boolean isHighAccuracy() {
        return this.d;
    }

    public void setIsHighAccuracy(boolean z) {
        this.d = z;
    }

    public boolean isOnceLocation() {
        return this.g;
    }

    public void setOnceLocation(boolean z) {
        this.g = z;
    }

    public long getCallbackInterval() {
        return this.h;
    }

    public void setCallbackInterval(long j) {
        this.h = j;
    }

    public boolean isNeedAddress() {
        return this.i;
    }

    public void setNeedAddress(boolean z) {
        this.i = z;
    }

    public Map<String, Object> getExtraInfo() {
        return this.l;
    }

    public void setExtraInfo(Map<String, Object> map) {
        this.l = map;
    }

    public int getRequestRule() {
        return this.k;
    }

    public void setRequestRule(int i) {
        this.k = i;
    }

    public Handler getmCallBackHandler() {
        return this.m;
    }

    public void setmCallBackHandler(Handler handler) {
        this.m = handler;
    }
}
