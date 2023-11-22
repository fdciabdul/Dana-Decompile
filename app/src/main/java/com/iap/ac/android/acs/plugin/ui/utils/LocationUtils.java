package com.iap.ac.android.acs.plugin.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.iap.ac.android.common.log.ACLog;
import id.dana.utils.permission.ManifestPermission;
import java.util.List;

/* loaded from: classes3.dex */
public class LocationUtils {
    public static boolean checkPermission(Context context) {
        boolean z = ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, ManifestPermission.ACCESS_COARSE_LOCATION) == 0;
        StringBuilder sb = new StringBuilder();
        sb.append("LocationUtils#checkPermission, permission ACCESS_COARSE_LOCATION: ");
        sb.append(z);
        ACLog.d("IAPConnectPlugin", sb.toString());
        boolean z2 = ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("LocationUtils#checkPermission, permission ACCESS_FINE_LOCATION: ");
        sb2.append(z2);
        ACLog.d("IAPConnectPlugin", sb2.toString());
        return z && z2;
    }

    public static Location getLocation(Context context) {
        if (!checkPermission(context)) {
            ACLog.e("IAPConnectPlugin", "LocationUtils#getLocation, no location permission");
            return null;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        if (locationManager == null) {
            ACLog.e("IAPConnectPlugin", "LocationUtils#getLocation, location manager is null");
            return null;
        }
        List<String> providers = locationManager.getProviders(true);
        String str = "network";
        if (providers.contains("network")) {
            ACLog.d("IAPConnectPlugin", "LocationUtils#getLocation, network location provider available");
        } else if (providers.contains("gps")) {
            ACLog.d("IAPConnectPlugin", "LocationUtils#getLocation, GPS location provider available");
            str = "gps";
        } else {
            ACLog.e("IAPConnectPlugin", "LocationUtils#getLocation, no location provider available");
            return null;
        }
        Location lastKnownLocation = locationManager.getLastKnownLocation(str);
        if (lastKnownLocation == null) {
            ACLog.e("IAPConnectPlugin", "LocationUtils#getLocation, last known location is null");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("LocationUtils#getLocation, longitude: ");
        sb.append(lastKnownLocation.getLongitude());
        sb.append(", latitude: ");
        sb.append(lastKnownLocation.getLatitude());
        ACLog.d("IAPConnectPlugin", sb.toString());
        return lastKnownLocation;
    }

    public static void requestPermission(Activity activity) {
        ACLog.d("IAPConnectPlugin", "LocationUtils#requestPermission");
        ActivityCompat.BuiltInFictitiousFunctionClassFactory(activity, new String[]{ManifestPermission.ACCESS_COARSE_LOCATION, "android.permission.ACCESS_FINE_LOCATION"}, 124);
    }
}
