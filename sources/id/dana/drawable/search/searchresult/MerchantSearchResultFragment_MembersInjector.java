package id.dana.drawable.search.searchresult;

import dagger.MembersInjector;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class MerchantSearchResultFragment_MembersInjector implements MembersInjector<MerchantSearchResultFragment> {
    public static void getAuthRequestContext(MerchantSearchResultFragment merchantSearchResultFragment, NearbyAnalyticTracker nearbyAnalyticTracker) {
        merchantSearchResultFragment.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
