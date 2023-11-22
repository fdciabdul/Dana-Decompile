package id.dana.drawable.otherstore;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class OtherStoreResultView_MembersInjector implements MembersInjector<OtherStoreResultView> {
    public static void MyBillsEntityDataFactory(OtherStoreResultView otherStoreResultView, OtherStoreListContract.Presenter presenter) {
        otherStoreResultView.otherStorePresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(OtherStoreResultView otherStoreResultView, NearbyAnalyticTracker nearbyAnalyticTracker) {
        otherStoreResultView.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
