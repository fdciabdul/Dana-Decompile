package id.dana.utils;

import android.app.Application;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.model.LatLng;
import id.dana.base.BaseActivity;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import pl.charmas.android.reactivelocation2.ReactiveLocationProvider;
import pl.charmas.android.reactivelocation2.observables.location.LastKnownLocationObservableOnSubscribe;
import pl.charmas.android.reactivelocation2.observables.location.LocationUpdatesObservableOnSubscribe;

/* loaded from: classes2.dex */
public class LocationUtil {
    private LocationUtil() {
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        return PermissionHelper.MyBillsEntityDataFactory(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    public static Location KClassImpl$Data$declaredNonStaticMembers$2(LatLng latLng) {
        double d = latLng.latitude;
        double d2 = latLng.longitude;
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d2);
        return location;
    }

    public static Location PlaceComponentResult(double d, double d2) {
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d2);
        return location;
    }

    public static boolean getAuthRequestContext(Context context) {
        if (context != null) {
            return PlaceComponentResult(context);
        }
        return false;
    }

    private static boolean PlaceComponentResult(Context context) {
        if (OSUtil.PrepareContext()) {
            return ((LocationManager) context.getSystemService("location")).isLocationEnabled();
        }
        if (!OSUtil.PlaceComponentResult()) {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
        }
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    public static LatLng getAuthRequestContext(Location location) {
        if (location != null) {
            return new LatLng(location.getLatitude(), location.getLongitude());
        }
        return new LatLng(-6.17476d, 106.827072d);
    }

    public static LatLng KClassImpl$Data$declaredNonStaticMembers$2() {
        return new LatLng(-6.17476d, 106.827072d);
    }

    public static void MyBillsEntityDataFactory(BaseActivity baseActivity, IntentSender intentSender) {
        try {
            baseActivity.startIntentSenderForResult(intentSender, 100, null, 0, 0, 0, null);
        } catch (IntentSender.SendIntentException unused) {
        }
    }

    public static double MyBillsEntityDataFactory(Location location, Location location2) {
        double distanceTo = location2.distanceTo(location);
        Double.isNaN(distanceTo);
        return distanceTo / 1000.0d;
    }

    /* loaded from: classes2.dex */
    public static class LocationRequestBuilder {
        public final ReactiveLocationProvider BuiltInFictitiousFunctionClassFactory;
        public final LocationSettingsRequest.Builder MyBillsEntityDataFactory = new LocationSettingsRequest.Builder();

        public LocationRequestBuilder(Application application) {
            this.BuiltInFictitiousFunctionClassFactory = new ReactiveLocationProvider(application);
        }

        @Deprecated
        public LocationRequestBuilder(Context context) {
            this.BuiltInFictitiousFunctionClassFactory = new ReactiveLocationProvider(context);
        }

        public final Observable<Location> BuiltInFictitiousFunctionClassFactory() {
            try {
                ReactiveLocationProvider reactiveLocationProvider = this.BuiltInFictitiousFunctionClassFactory;
                LocationRequest create = LocationRequest.create();
                create.setPriority(100);
                create.setInterval(2000L);
                create.setFastestInterval(2000L);
                Observable<Location> BuiltInFictitiousFunctionClassFactory = LocationUpdatesObservableOnSubscribe.BuiltInFictitiousFunctionClassFactory(reactiveLocationProvider.MyBillsEntityDataFactory, reactiveLocationProvider.KClassImpl$Data$declaredNonStaticMembers$2, create);
                ReactiveLocationProvider reactiveLocationProvider2 = this.BuiltInFictitiousFunctionClassFactory;
                return BuiltInFictitiousFunctionClassFactory.startWith(LastKnownLocationObservableOnSubscribe.MyBillsEntityDataFactory(reactiveLocationProvider2.MyBillsEntityDataFactory, reactiveLocationProvider2.KClassImpl$Data$declaredNonStaticMembers$2));
            } catch (SecurityException unused) {
                return null;
            }
        }

        public static LocationRequest PlaceComponentResult() {
            LocationRequest create = LocationRequest.create();
            create.setPriority(100);
            create.setInterval(2000L);
            create.setFastestInterval(2000L);
            return create;
        }

        public final Observable<Location> KClassImpl$Data$declaredNonStaticMembers$2() {
            ReactiveLocationProvider reactiveLocationProvider = this.BuiltInFictitiousFunctionClassFactory;
            LocationRequest create = LocationRequest.create();
            create.setPriority(100);
            create.setInterval(2000L);
            create.setFastestInterval(2000L);
            Observable<Location> timeout = LocationUpdatesObservableOnSubscribe.BuiltInFictitiousFunctionClassFactory(reactiveLocationProvider.MyBillsEntityDataFactory, reactiveLocationProvider.KClassImpl$Data$declaredNonStaticMembers$2, create).timeout(3L, TimeUnit.SECONDS);
            ReactiveLocationProvider reactiveLocationProvider2 = this.BuiltInFictitiousFunctionClassFactory;
            return timeout.onErrorResumeNext(LastKnownLocationObservableOnSubscribe.MyBillsEntityDataFactory(reactiveLocationProvider2.MyBillsEntityDataFactory, reactiveLocationProvider2.KClassImpl$Data$declaredNonStaticMembers$2));
        }
    }

    public static Location getAuthRequestContext() {
        Location location = new Location("");
        location.setLatitude(-6.17476d);
        location.setLongitude(106.827072d);
        return location;
    }

    public static double BuiltInFictitiousFunctionClassFactory(double d, double d2, double d3, double d4) {
        Location location = new Location("");
        location.setLatitude(d);
        location.setLongitude(d2);
        Location location2 = new Location("");
        location2.setLatitude(d3);
        location2.setLongitude(d4);
        double distanceTo = location.distanceTo(location2);
        Double.isNaN(distanceTo);
        return distanceTo / 1000.0d;
    }
}
