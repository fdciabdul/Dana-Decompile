package id.dana.nearbyme;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class OtherStoreListActivity_MembersInjector implements MembersInjector<OtherStoreListActivity> {
    public static void getAuthRequestContext(OtherStoreListActivity otherStoreListActivity, OtherStoreListContract.Presenter presenter) {
        otherStoreListActivity.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OtherStoreListActivity otherStoreListActivity, NearbyAnalyticTracker nearbyAnalyticTracker) {
        otherStoreListActivity.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
