package com.alipay.mobile.map.model.geocode;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class Crossroad implements Serializable, Cloneable {
    private static final String TAG = "Crossroad";
    private static final long serialVersionUID = -3847306204647810363L;
    private String direction;
    private String distance;
    private String firstRoadId;
    private String firstRoadName;
    private String secondRoadId;
    private String secondRoadName;

    public String getDirection() {
        return this.direction;
    }

    public void setDirection(String str) {
        this.direction = str;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public String getFirstRoadId() {
        return this.firstRoadId;
    }

    public void setFirstRoadId(String str) {
        this.firstRoadId = str;
    }

    public String getFirstRoadName() {
        return this.firstRoadName;
    }

    public void setFirstRoadName(String str) {
        this.firstRoadName = str;
    }

    public String getSecondRoadId() {
        return this.secondRoadId;
    }

    public void setSecondRoadId(String str) {
        this.secondRoadId = str;
    }

    public String getSecondRoadName() {
        return this.secondRoadName;
    }

    public void setSecondRoadName(String str) {
        this.secondRoadName = str;
    }

    /* renamed from: clone  reason: merged with bridge method [inline-methods] */
    public Crossroad m82clone() {
        try {
            return (Crossroad) super.clone();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("clone exceptin, msg=");
            sb.append(e);
            RVLogger.e(TAG, sb.toString());
            return null;
        }
    }
}
