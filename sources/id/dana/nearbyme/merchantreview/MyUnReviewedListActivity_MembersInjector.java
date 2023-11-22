package id.dana.nearbyme.merchantreview;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.nearbyme.MyReviewContract;

/* loaded from: classes5.dex */
public final class MyUnReviewedListActivity_MembersInjector implements MembersInjector<MyUnReviewedListActivity> {
    public static void PlaceComponentResult(MyUnReviewedListActivity myUnReviewedListActivity, Lazy<MyReviewContract.Presenter> lazy) {
        myUnReviewedListActivity.presenter = lazy;
    }
}
