package com.alipay.iap.android.lbs.a.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.lbs.LBSLocation;
import com.alipay.iap.android.lbs.LBSLocationErrorCode;
import com.alipay.iap.android.lbs.LBSLocationListener;
import com.alipay.iap.android.lbs.LBSLocationRequest;
import id.dana.utils.permission.ManifestPermission;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a implements com.alipay.iap.android.lbs.b.a {
    private LBSLocationRequest b = new LBSLocationRequest();
    private LBSLocationRequest c = new LBSLocationRequest();
    private LBSLocationListener d = new LBSLocationListener() { // from class: com.alipay.iap.android.lbs.a.a.a.1
        @Override // com.alipay.iap.android.lbs.LBSLocationListener
        public void onLocationError(LBSLocationErrorCode lBSLocationErrorCode) {
        }

        @Override // com.alipay.iap.android.lbs.LBSLocationListener
        public void onLocationUpdate(LBSLocation lBSLocation) {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private Map<LBSLocationListener, b> f6995a = new ConcurrentHashMap();

    public a() {
        this.b.cacheValidTime = 0L;
        this.b.isHighAccuracy = true;
        this.c.cacheValidTime = 0L;
        this.c.isHighAccuracy = false;
        LoggerWrapper.d("LBSLocationManagerNative", "LBSLocationManagerNative constructor");
    }

    private LBSLocation a(Context context, String str, String str2) {
        StringBuilder sb;
        String obj;
        if (com.alipay.iap.android.lbs.c.b.b(context, str) && com.alipay.iap.android.lbs.c.b.a(context, str2) == LBSLocationErrorCode.LocationErrorSuccess) {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                obj = "getLastKnowLocation, locationManager is null";
                LoggerWrapper.e("LBSLocationManagerNative", obj);
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(str2);
            if (lastKnownLocation != null) {
                LBSLocation lBSLocation = new LBSLocation(lastKnownLocation);
                com.alipay.iap.android.lbs.c.b.a("LBSLocationManagerNative", "getLastKnownLocation, location:", lBSLocation);
                return lBSLocation;
            }
            sb = new StringBuilder();
            sb.append("getLastKnownLocation, provider ");
            sb.append(str2);
            sb.append(" returns null location");
        } else {
            sb = new StringBuilder();
            sb.append("getLastKnownLocation, No authentication or disabled for provider ");
            sb.append(str2);
        }
        obj = sb.toString();
        LoggerWrapper.e("LBSLocationManagerNative", obj);
        return null;
    }

    private void a(Context context, LBSLocationRequest lBSLocationRequest, boolean z, LBSLocationListener lBSLocationListener) {
        StringBuilder sb;
        String str;
        if (lBSLocationListener == null) {
            sb = new StringBuilder();
            str = "requestLocationUpdateInternal with null listener, isOnceLocation=";
        } else if (context != null) {
            synchronized (this.f6995a) {
                if (!z) {
                    if (this.f6995a.containsKey(lBSLocationListener)) {
                        LoggerWrapper.e("LBSLocationManagerNative", "requestLocationUpdateContinuous with repeat listener");
                        return;
                    }
                }
                b bVar = new b(context, this, lBSLocationRequest, lBSLocationListener, z);
                if (!z) {
                    this.f6995a.put(lBSLocationListener, bVar);
                }
                bVar.a();
                return;
            }
        } else {
            lBSLocationListener.onLocationError(LBSLocationErrorCode.LocationErrorParamInvalid);
            sb = new StringBuilder();
            str = "requestLocationUpdateInternal with null context, isOnceLocation=";
        }
        sb.append(str);
        sb.append(z);
        LoggerWrapper.e("LBSLocationManagerNative", sb.toString());
    }

    @Override // com.alipay.iap.android.lbs.b.a
    public final LBSLocation a(Context context, LBSLocationRequest lBSLocationRequest) {
        LBSLocationErrorCode lBSLocationErrorCode;
        int errorCode;
        long currentTimeMillis = System.currentTimeMillis();
        if (lBSLocationRequest == null) {
            lBSLocationRequest = new LBSLocationRequest();
        }
        LBSLocation a2 = a(context, "android.permission.ACCESS_FINE_LOCATION", "gps");
        if (a2 != null) {
            a2.setTimeCost(System.currentTimeMillis() - currentTimeMillis);
        }
        LBSLocation a3 = a(context, ManifestPermission.ACCESS_COARSE_LOCATION, "network");
        if (a3 != null) {
            a3.setTimeCost(System.currentTimeMillis() - currentTimeMillis);
        }
        if ((a3 != null && a2 != null && a3.getTime() > a2.getTime()) || a2 == null) {
            a2 = a3;
        }
        if (a2 != null && System.currentTimeMillis() - a2.getTime() > lBSLocationRequest.cacheValidTime) {
            a(context);
            a2.setErrorCode(LBSLocationErrorCode.LocationErrorExpired.getErrorCode());
        }
        if (a2 == null) {
            a(context);
            a2 = new LBSLocation();
            a2.setLatitude(-360.0d);
            a2.setLongitude(-360.0d);
            a2.setAccuracy(0.0f);
            a2.setType("");
            a2.setTime(0L);
            a2.setTimeCost(0L);
            if (com.alipay.iap.android.lbs.c.b.b(context, ManifestPermission.ACCESS_COARSE_LOCATION)) {
                LBSLocationErrorCode a4 = com.alipay.iap.android.lbs.c.b.a(context, "network");
                if (a4 == LBSLocationErrorCode.LocationErrorSuccess || a4 == LBSLocationErrorCode.LocationErrorPositionDisabled) {
                    lBSLocationErrorCode = (a4 == LBSLocationErrorCode.LocationErrorPositionDisabled && com.alipay.iap.android.lbs.c.b.a(context, "gps") == LBSLocationErrorCode.LocationErrorPositionDisabled) ? LBSLocationErrorCode.LocationErrorPositionDisabled : LBSLocationErrorCode.LocationErrorNullLocation;
                } else {
                    errorCode = a4.getErrorCode();
                    a2.setErrorCode(errorCode);
                }
            } else {
                lBSLocationErrorCode = LBSLocationErrorCode.LocationErrorNoAuthorization;
            }
            errorCode = lBSLocationErrorCode.getErrorCode();
            a2.setErrorCode(errorCode);
        }
        return a2;
    }

    @Override // com.alipay.iap.android.lbs.b.a
    public final void a(Context context) {
        a(context, this.b, true, this.d);
        a(context, this.c, true, this.d);
    }

    @Override // com.alipay.iap.android.lbs.b.a
    public final void a(Context context, LBSLocationListener lBSLocationListener) {
        if (context == null || lBSLocationListener == null) {
            LoggerWrapper.e("LBSLocationManagerNative", "removeLocationUpdates with null context or listener");
            return;
        }
        LoggerWrapper.e("LBSLocationManagerNative", "removeLocationUpdate in LBSLocationManagerNative");
        synchronized (this.f6995a) {
            if (this.f6995a.containsKey(lBSLocationListener)) {
                this.f6995a.get(lBSLocationListener).b();
                this.f6995a.remove(lBSLocationListener);
            }
        }
    }

    @Override // com.alipay.iap.android.lbs.b.a
    public final void a(Context context, LBSLocationRequest lBSLocationRequest, LBSLocationListener lBSLocationListener) {
        LBSLocation a2 = a(context, lBSLocationRequest);
        if (lBSLocationRequest == null) {
            lBSLocationRequest = new LBSLocationRequest();
        }
        if (!com.alipay.iap.android.lbs.c.b.a(a2, lBSLocationRequest)) {
            a(context, lBSLocationRequest, true, lBSLocationListener);
            return;
        }
        lBSLocationListener.onLocationUpdate(a2);
        com.alipay.iap.android.lbs.c.b.a("LBSLocationManagerNative", "requestLocationUpdate with cached Location:", a2);
    }

    public final void a(LBSLocationListener lBSLocationListener) {
        if (lBSLocationListener == null) {
            return;
        }
        synchronized (this.f6995a) {
            this.f6995a.remove(lBSLocationListener);
        }
    }

    @Override // com.alipay.iap.android.lbs.b.a
    public final void b(Context context, LBSLocationRequest lBSLocationRequest, LBSLocationListener lBSLocationListener) {
        a(context, lBSLocationRequest, false, lBSLocationListener);
    }
}
