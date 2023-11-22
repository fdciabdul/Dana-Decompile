package com.alipay.mobile.framework.service.impl;

import android.location.Location;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.common.lbs.LBSLocation;
import com.alipay.mobile.common.lbs.LBSLocationRequest;
import com.alipay.mobile.framework.service.LBSLocationManagerService;
import com.alipay.mobile.framework.service.OnLBSLocationListener;
import com.alipay.mobile.framework.service.OnReGeocodeListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes6.dex */
public class LBSLocationManagerServiceImpl implements LBSLocationManagerService {
    @Override // com.alipay.mobile.framework.service.LBSLocationManagerService
    public void locationWithRequest(LBSLocationRequest lBSLocationRequest, OnLBSLocationListener onLBSLocationListener, OnReGeocodeListener onReGeocodeListener) {
    }

    @Override // com.alipay.mobile.framework.service.LBSLocationManagerService
    public void locationWithRequest(LBSLocationRequest lBSLocationRequest, OnReGeocodeListener onReGeocodeListener) {
    }

    @Override // com.alipay.mobile.framework.service.LBSLocationManagerService
    public void stopLocation(OnLBSLocationListener onLBSLocationListener) {
    }

    @Override // com.alipay.mobile.framework.service.LBSLocationManagerService
    public void locationWithRequest(LBSLocationRequest lBSLocationRequest, final OnLBSLocationListener onLBSLocationListener) {
        LocationServices.getFusedLocationProviderClient(GriverEnv.getApplicationContext()).getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() { // from class: com.alipay.mobile.framework.service.impl.LBSLocationManagerServiceImpl.1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Location> task) {
                if (task.isSuccessful()) {
                    Location result = task.getResult();
                    if (result != null) {
                        LBSLocation lBSLocation = new LBSLocation();
                        lBSLocation.setLatitude(result.getLatitude());
                        lBSLocation.setLongitude(result.getLongitude());
                        onLBSLocationListener.onLocationUpdate(lBSLocation);
                        return;
                    }
                    LBSLocation lBSLocation2 = new LBSLocation();
                    lBSLocation2.setLatitude(30.274653d);
                    lBSLocation2.setLongitude(120.126293d);
                    onLBSLocationListener.onLocationUpdate(lBSLocation2);
                    return;
                }
                GriverLogger.d("LBSLocationManagerService", "Current location is null. Using defaults.");
                GriverLogger.e("LBSLocationManagerService", "Exception: %s", task.getException());
            }
        });
    }

    @Override // com.alipay.mobile.framework.service.LBSLocationManagerService
    public LBSLocation getLastKnownLocation() {
        return new LBSLocation();
    }

    @Override // com.alipay.mobile.framework.service.LBSLocationManagerService
    public LBSLocation getLastKnownLocation(LBSLocationRequest lBSLocationRequest) {
        return new LBSLocation();
    }
}
