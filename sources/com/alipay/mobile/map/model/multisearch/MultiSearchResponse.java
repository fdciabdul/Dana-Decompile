package com.alipay.mobile.map.model.multisearch;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class MultiSearchResponse implements Serializable {
    public static final long serialVersionUID = 1;
    public int count;
    public String memo;
    public List<MultiPoiInfo> pois;
    public int statusCode;
    public boolean success;
}
