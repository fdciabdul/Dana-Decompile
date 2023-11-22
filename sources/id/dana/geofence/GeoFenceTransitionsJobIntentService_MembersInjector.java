package id.dana.geofence;

import dagger.MembersInjector;

/* loaded from: classes5.dex */
public final class GeoFenceTransitionsJobIntentService_MembersInjector implements MembersInjector<GeoFenceTransitionsJobIntentService> {
    public static void getAuthRequestContext(GeoFenceTransitionsJobIntentService geoFenceTransitionsJobIntentService, GeoFencePresenter geoFencePresenter) {
        geoFenceTransitionsJobIntentService.geoFencePresenter = geoFencePresenter;
    }

    public static void getAuthRequestContext(GeoFenceTransitionsJobIntentService geoFenceTransitionsJobIntentService, GeofenceManager geofenceManager) {
        geoFenceTransitionsJobIntentService.geofenceManager = geofenceManager;
    }
}
