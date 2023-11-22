package com.alipay.mobile.map.model.weather;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes6.dex */
public class FutureWeatherResponse implements Serializable {
    public static final long serialVersionUID = 1;
    public String cityAdcode;
    public String cityName;
    public String memo;
    public String reportTime;
    public int statusCode;
    public boolean success;
    public List<FutureWeatherInfo> weatherInfoList;
}
