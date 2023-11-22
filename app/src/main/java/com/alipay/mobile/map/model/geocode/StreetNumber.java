package com.alipay.mobile.map.model.geocode;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.map.model.LatLonPoint;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class StreetNumber implements Serializable, Cloneable {
    private static final String TAG = "StreetNumber";
    private static final long serialVersionUID = 4190326962112365979L;
    private String direction;
    private float distance;
    private LatLonPoint latLonPoint;
    private String number;
    private String street;

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public float getDistance() {
        return this.distance;
    }

    public void setDistance(float f) {
        this.distance = f;
    }

    public LatLonPoint getLatLonPoint() {
        return this.latLonPoint;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.latLonPoint = latLonPoint;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String str) {
        this.number = str;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public StreetNumber m85clone() {
        StreetNumber streetNumber;
        Exception e;
        LatLonPoint latLonPoint = null;
        try {
            streetNumber = (StreetNumber) super.clone();
            try {
                if (getLatLonPoint() != null) {
                    latLonPoint = getLatLonPoint().m81clone();
                }
                streetNumber.setLatLonPoint(latLonPoint);
            } catch (Exception e2) {
                e = e2;
                StringBuilder sb = new StringBuilder();
                sb.append("clone exceptin, msg=");
                sb.append(e);
                RVLogger.e(TAG, sb.toString());
                return streetNumber;
            }
        } catch (Exception e3) {
            streetNumber = null;
            e = e3;
        }
        return streetNumber;
    }
}
