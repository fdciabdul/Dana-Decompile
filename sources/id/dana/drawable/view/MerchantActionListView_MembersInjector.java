package id.dana.drawable.view;

import dagger.MembersInjector;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class MerchantActionListView_MembersInjector implements MembersInjector<MerchantActionListView> {
    public static void PlaceComponentResult(MerchantActionListView merchantActionListView, MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        merchantActionListView.merchantDetailAnalyticTracker = merchantDetailAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(MerchantActionListView merchantActionListView, NearbyAnalyticTracker nearbyAnalyticTracker) {
        merchantActionListView.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
