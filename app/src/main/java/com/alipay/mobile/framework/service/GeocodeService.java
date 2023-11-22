package com.alipay.mobile.framework.service;

import android.content.Context;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alipay.mobile.map.exception.GeocodeException;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.SearchPoiRequest;
import com.alipay.mobile.map.model.geocode.GeocodeResult;
import com.alipay.mobile.map.model.geocode.ReGeocodeResult;
import com.alipay.mobile.map.model.multisearch.MultiSearchRequest;
import com.alipay.mobile.map.model.multisearch.MultiSearchResponse;
import com.alipay.mobile.map.model.weather.FutureWeatherResponse;
import com.alipay.mobile.map.model.weather.RealWeatherResponse;
import com.alipay.mobile.map.model.weather.WeatherRequest;
import java.util.List;

/* loaded from: classes6.dex */
public interface GeocodeService extends Proxiable {
    public static final int AREALEVEL_BASIC_GEOFENCE = 12;
    public static final int AREALEVEL_CITY = 4;
    public static final int AREALEVEL_CONTINENT = 1;
    public static final int AREALEVEL_COUNTRY = 2;
    public static final int AREALEVEL_DEFAULT = 0;
    public static final int AREALEVEL_DISTRICT = 5;
    public static final int AREALEVEL_PROVINCE = 3;
    public static final int AREALEVEL_TOWN = 6;

    @Deprecated
    void cityKeywordSearchPoi(Context context, String str, String str2, int i, int i2, OnPoiSearchListener onPoiSearchListener);

    List<GeocodeResult> geocode(String str) throws GeocodeException;

    FutureWeatherResponse getFutureWeatherResult(WeatherRequest weatherRequest);

    MultiSearchResponse getMultiSearchResult(MultiSearchRequest multiSearchRequest);

    RealWeatherResponse getRealWeatherResult(WeatherRequest weatherRequest);

    List<ReGeocodeResult> reGeocode(LatLonPoint latLonPoint, float f) throws GeocodeException;

    List<ReGeocodeResult> reGeocode(LatLonPoint latLonPoint, float f, String str) throws GeocodeException;

    ReGeocodeResult reverse(LatLonPoint latLonPoint, float f, String str) throws GeocodeException;

    ReGeocodeResult reverse(LatLonPoint latLonPoint, float f, String str, int i) throws GeocodeException;

    void reverse(LatLonPoint latLonPoint, float f, String str, int i, OnReGeocodeListener onReGeocodeListener) throws GeocodeException;

    void reverse(LatLonPoint latLonPoint, float f, String str, OnReGeocodeListener onReGeocodeListener) throws GeocodeException;

    void searchpoi(Context context, OnPoiSearchListener onPoiSearchListener, SearchPoiRequest searchPoiRequest);

    void searchpoi(Context context, LatLonPoint latLonPoint, String str, int i, int i2, OnPoiSearchListener onPoiSearchListener);

    void searchpoi(Context context, LatLonPoint latLonPoint, String str, int i, int i2, OnPoiSearchListener onPoiSearchListener, int i3);

    void searchpoi(Context context, String str, OnPoiSearchListener onPoiSearchListener, SearchPoiRequest searchPoiRequest);

    void searchpoi(Context context, String str, LatLonPoint latLonPoint, String str2, int i, int i2, OnPoiSearchListener onPoiSearchListener);

    void searchpoi(Context context, String str, LatLonPoint latLonPoint, String str2, int i, int i2, OnPoiSearchListener onPoiSearchListener, int i3);
}
