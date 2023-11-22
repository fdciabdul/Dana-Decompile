package id.dana.drawable;

import dagger.MembersInjector;
import id.dana.contract.nearbyme.NearbyMeContract;
import id.dana.nearbyme.MerchantContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryContract;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.utils.MapHelper;

/* loaded from: classes5.dex */
public final class NewNearbyMeActivity_MembersInjector implements MembersInjector<NewNearbyMeActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(NewNearbyMeActivity newNearbyMeActivity, MapHelper mapHelper) {
        newNearbyMeActivity.mapHelper = mapHelper;
    }

    public static void getAuthRequestContext(NewNearbyMeActivity newNearbyMeActivity, NearbyMeContract.Presenter presenter) {
        newNearbyMeActivity.nearbyPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewNearbyMeActivity newNearbyMeActivity, MerchantDetailContract.Presenter presenter) {
        newNearbyMeActivity.merchantDetailPresenter = presenter;
    }

    public static void getAuthRequestContext(NewNearbyMeActivity newNearbyMeActivity, MerchantContract.Presenter presenter) {
        newNearbyMeActivity.merchantCategoryPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewNearbyMeActivity newNearbyMeActivity, PhotoGalleryContract.Presenter presenter) {
        newNearbyMeActivity.photoPreviewPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(NewNearbyMeActivity newNearbyMeActivity, NearbyAnalyticTracker nearbyAnalyticTracker) {
        newNearbyMeActivity.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }
}
