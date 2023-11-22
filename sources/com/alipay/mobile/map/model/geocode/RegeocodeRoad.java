package com.alipay.mobile.map.model.geocode;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.map.model.LatLonPoint;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class RegeocodeRoad implements Serializable, Cloneable {
    private static final String TAG = "RegeocodeRoad";
    private static final long serialVersionUID = -5476825043508110971L;
    private String direction;
    private float distance;

    /* renamed from: id  reason: collision with root package name */
    private String f7202id;
    private LatLonPoint latLngPoint;
    private String name;

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

    public String getId() {
        return this.f7202id;
    }

    public void setId(String str) {
        this.f7202id = str;
    }

    public LatLonPoint getLatLngPoint() {
        return this.latLngPoint;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.latLngPoint = latLonPoint;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public RegeocodeRoad m84clone() {
        RegeocodeRoad regeocodeRoad;
        Exception e;
        LatLonPoint latLonPoint = null;
        try {
            regeocodeRoad = (RegeocodeRoad) super.clone();
            try {
                if (getLatLngPoint() != null) {
                    latLonPoint = getLatLngPoint().m81clone();
                }
                regeocodeRoad.setLatLngPoint(latLonPoint);
            } catch (Exception e2) {
                e = e2;
                StringBuilder sb = new StringBuilder();
                sb.append("clone exceptin, msg=");
                sb.append(e);
                RVLogger.e(TAG, sb.toString());
                return regeocodeRoad;
            }
        } catch (Exception e3) {
            regeocodeRoad = null;
            e = e3;
        }
        return regeocodeRoad;
    }
}
