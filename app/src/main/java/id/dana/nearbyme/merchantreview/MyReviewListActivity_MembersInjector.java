package id.dana.nearbyme.merchantreview;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class MyReviewListActivity_MembersInjector implements MembersInjector<MyReviewListActivity> {
    public static void PlaceComponentResult(MyReviewListActivity myReviewListActivity, Lazy<MyReviewContract.Presenter> lazy) {
        myReviewListActivity.presenter = lazy;
    }

    public static void getAuthRequestContext(MyReviewListActivity myReviewListActivity, NearbyAnalyticTracker nearbyAnalyticTracker) {
        myReviewListActivity.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
