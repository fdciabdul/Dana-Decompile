package com.alipay.mobile.embedview.mapbiz.data;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class MapSetting implements Serializable {
    public String customMapStyleSrc;
    public String customTextureSrc;
    public LogoPos logoPosition;
    public MarkerCluster markerCluster;
    public int gestureEnable = -1;
    public int showScale = -1;
    public int showCompass = -1;
    public int tiltGesturesEnabled = -1;
    public int trafficEnabled = -1;
    public int showMapText = -1;
}
