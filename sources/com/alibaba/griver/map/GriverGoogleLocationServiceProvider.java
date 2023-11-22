package com.alibaba.griver.map;

import android.content.Context;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.map.GriverGoogleLocationCallBack;
import com.alibaba.griver.api.common.map.GriverGoogleLocationService;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.map.utils.GPUtils;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import id.dana.twilio.identityverification.TwilioIdentityVerificationActivity;

/* loaded from: classes6.dex */
public class GriverGoogleLocationServiceProvider implements GriverGoogleLocationService {
    public static final String LOCATION_GRIVER_MAP = "GriverMapLocationManager";

    /* renamed from: a  reason: collision with root package name */
    private static LocationCallback f6647a;
    private static boolean b;

    @Override // com.alibaba.griver.api.common.map.GriverGoogleLocationService
    public void getLocation(Context context, JSONObject jSONObject, final GriverGoogleLocationCallBack griverGoogleLocationCallBack) {
        if (!b && ReflectUtils.classExist("com.google.android.gms.location.FusedLocationProviderClient") && GPUtils.isPlayStoreInstalled(context)) {
            GriverLogger.d(LOCATION_GRIVER_MAP, "use google location.");
            final FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
            final LocationRequest create = LocationRequest.create();
            create.setPriority(100);
            create.setInterval(20000L);
            create.setMaxWaitTime(jSONObject.getInteger(TwilioIdentityVerificationActivity.CHALLENGE_INFO_TIMEOUT).intValue() * 1000);
            f6647a = new LocationCallback() { // from class: com.alibaba.griver.map.GriverGoogleLocationServiceProvider.1
                @Override // com.google.android.gms.location.LocationCallback
                public void onLocationResult(LocationResult locationResult) {
                    if (locationResult == null) {
                        griverGoogleLocationCallBack.success(null);
                    } else if (locationResult.getLocations().size() > 0 && locationResult.getLocations().get(0) != null) {
                        griverGoogleLocationCallBack.success(locationResult.getLocations().get(0));
                        fusedLocationProviderClient.removeLocationUpdates(GriverGoogleLocationServiceProvider.f6647a);
                    } else {
                        GriverLogger.e(GriverGoogleLocationServiceProvider.LOCATION_GRIVER_MAP, "Google location failed because of location is null");
                        griverGoogleLocationCallBack.success(null);
                    }
                }

                @Override // com.google.android.gms.location.LocationCallback
                public void onLocationAvailability(LocationAvailability locationAvailability) {
                    super.onLocationAvailability(locationAvailability);
                    if (locationAvailability.isLocationAvailable()) {
                        return;
                    }
                    boolean unused = GriverGoogleLocationServiceProvider.b = true;
                    GriverLogger.d(GriverGoogleLocationServiceProvider.LOCATION_GRIVER_MAP, "location again ues system location.");
                    griverGoogleLocationCallBack.fail(10);
                }
            };
            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.map.GriverGoogleLocationServiceProvider.2
                @Override // java.lang.Runnable
                public void run() {
                    fusedLocationProviderClient.requestLocationUpdates(create, GriverGoogleLocationServiceProvider.f6647a, Looper.myLooper());
                }
            });
            return;
        }
        griverGoogleLocationCallBack.fail(20);
    }
}
