package id.dana.drawable.search;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.NearbyMerchantLocationSearchContract;
import id.dana.drawable.search.NearbySearchContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class NearbySearchFragment_MembersInjector implements MembersInjector<NearbySearchFragment> {
    public static void BuiltInFictitiousFunctionClassFactory(NearbySearchFragment nearbySearchFragment, NearbySearchContract.Presenter presenter) {
        nearbySearchFragment.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(NearbySearchFragment nearbySearchFragment, NearbyMerchantLocationSearchContract.Presenter presenter) {
        nearbySearchFragment.searchPresenter = presenter;
    }

    public static void getAuthRequestContext(NearbySearchFragment nearbySearchFragment, NearbyAnalyticTracker nearbyAnalyticTracker) {
        nearbySearchFragment.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(NearbySearchFragment nearbySearchFragment, PhotoGalleryContract.Presenter presenter) {
        nearbySearchFragment.photoPreviewPresenter = presenter;
    }
}
