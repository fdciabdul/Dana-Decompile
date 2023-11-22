package com.alipay.mobile.map.model;

import com.alibaba.griver.base.common.logger.GriverLogger;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class LatLonPoint implements Serializable, Cloneable {
    private static final String TAG = "LatLonPoint";
    private static final long serialVersionUID = 1;
    private double latitude;
    private double longitude;

    public LatLonPoint() {
        this.latitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        this.longitude = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public LatLonPoint(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public LatLonPoint m81clone() {
        try {
            return (LatLonPoint) super.clone();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("clone exception, using default, msg=");
            sb.append(e);
            GriverLogger.w(TAG, sb.toString());
            return new LatLonPoint(this.latitude, this.longitude);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getLatitude());
        sb.append(",");
        sb.append(getLongitude());
        return sb.toString();
    }
}
