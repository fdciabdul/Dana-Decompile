package id.dana.explore.view;

import dagger.MembersInjector;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;

/* loaded from: classes5.dex */
public final class ExploreOnlineMerchantView_MembersInjector implements MembersInjector<ExploreOnlineMerchantView> {
    public static void MyBillsEntityDataFactory(ExploreOnlineMerchantView exploreOnlineMerchantView, OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker) {
        exploreOnlineMerchantView.tracker = onlineMerchantAnalyticTracker;
    }
}
