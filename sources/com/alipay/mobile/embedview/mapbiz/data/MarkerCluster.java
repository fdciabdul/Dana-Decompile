package com.alipay.mobile.embedview.mapbiz.data;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class MarkerCluster implements Serializable {
    public List<Range> clusterRanges;
    public String replaceCount = "{COUNT}";
    public String desc = "{COUNT}";
    public String referenceParam = "desc";
    public int clusterWidth = 50;
    public int clusterDistance = 50;
}
