package com.alipay.mobile.framework.service;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alipay.mobile.common.lbs.LBSLocation;
import com.alipay.mobile.common.lbs.LBSLocationRequest;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public interface LBSLocationManagerService extends Proxiable {
    public static final int ALIPAY_ERRCODE_DISABLE_NOTLOGIN = 80;
    @Deprecated
    public static final int AREALEVEL_BASIC_GEOFENCE = 12;
    public static final int AREALEVEL_CITY = 4;
    public static final int AREALEVEL_CONTINENT = 1;
    public static final int AREALEVEL_COUNTRY = 2;
    @Deprecated
    public static final int AREALEVEL_DEFAULT = 0;
    public static final int AREALEVEL_DISTRICT = 5;
    public static final int AREALEVEL_PROVINCE = 3;
    public static final int AREALEVEL_STREET = 7;
    public static final int AREALEVEL_STREET_WITH_POIS = 8;
    public static final int AREALEVEL_TOWN = 6;
    public static final String EXTRA_INFO_LOCATION_LATEST_KEY = "EXTRA_INFO_LOCATION_LATEST";
    public static final long LAST_LOCATION_CACHETIME = TimeUnit.DAYS.toMillis(30);
    public static final int RESULT_WRAPPER_ERRORCODE = 81;

    @Deprecated
    LBSLocation getLastKnownLocation();

    LBSLocation getLastKnownLocation(LBSLocationRequest lBSLocationRequest);

    void locationWithRequest(LBSLocationRequest lBSLocationRequest, OnLBSLocationListener onLBSLocationListener);

    void locationWithRequest(LBSLocationRequest lBSLocationRequest, OnLBSLocationListener onLBSLocationListener, OnReGeocodeListener onReGeocodeListener);

    void locationWithRequest(LBSLocationRequest lBSLocationRequest, OnReGeocodeListener onReGeocodeListener);

    void stopLocation(OnLBSLocationListener onLBSLocationListener);
}
