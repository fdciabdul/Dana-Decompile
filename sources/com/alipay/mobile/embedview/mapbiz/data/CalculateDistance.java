package com.alipay.mobile.embedview.mapbiz.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class CalculateDistance implements Serializable {
    public boolean exportPolylines;
    public List<Point> points;
    public int requestType;
    public int responseType;
    public List<Double> targetDistances;
    public String wktPoints;
    public boolean exportTotalDistance = true;
    public boolean async = true;
}
