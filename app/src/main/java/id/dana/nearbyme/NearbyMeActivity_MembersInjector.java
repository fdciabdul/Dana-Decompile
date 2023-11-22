package id.dana.nearbyme;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.utils.MapHelper;

/* loaded from: classes9.dex */
public final class NearbyMeActivity_MembersInjector implements MembersInjector<NearbyMeActivity> {
    public static void getAuthRequestContext(NearbyMeActivity nearbyMeActivity, MapHelper mapHelper) {
        nearbyMeActivity.mapHelper = mapHelper;
    }

    public static void PlaceComponentResult(NearbyMeActivity nearbyMeActivity, NearbyAnalyticTracker nearbyAnalyticTracker) {
        nearbyMeActivity.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NearbyMeActivity nearbyMeActivity, NearbyMeContract.Presenter presenter) {
        nearbyMeActivity.presenter = presenter;
    }
}
