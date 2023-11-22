package id.dana.nearbyme;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes9.dex */
public final class NearbyMerchantLocationSearchView_MembersInjector implements MembersInjector<NearbyMerchantLocationSearchView> {
    public static void BuiltInFictitiousFunctionClassFactory(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView, NearbyMerchantLocationSearchContract.Presenter presenter) {
        nearbyMerchantLocationSearchView.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(NearbyMerchantLocationSearchView nearbyMerchantLocationSearchView, NearbyAnalyticTracker nearbyAnalyticTracker) {
        nearbyMerchantLocationSearchView.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
