package id.dana.nearbyme.homeshopping.tutorial;

import dagger.MembersInjector;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class HomeShoppingTutorialFragment_MembersInjector implements MembersInjector<HomeShoppingTutorialFragment> {
    public static void MyBillsEntityDataFactory(HomeShoppingTutorialFragment homeShoppingTutorialFragment, NearbyAnalyticTracker nearbyAnalyticTracker) {
        homeShoppingTutorialFragment.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
