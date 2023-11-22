package com.alipay.mobile.map.model.multisearch;

/* loaded from: classes6.dex */
public class MultiSearchRequest {
    public String appKey;
    public String city;
    public String keyWords;
    public double latitude;
    public double longitude;
    public int questType;
    public int radius;
    public String types;
    public int page = 1;
    public int offset = 10;
    public String sortRule = "distance";
}
