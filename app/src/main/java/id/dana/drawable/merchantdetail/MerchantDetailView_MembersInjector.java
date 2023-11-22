package id.dana.drawable.merchantdetail;

import dagger.MembersInjector;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;

/* loaded from: classes5.dex */
public final class MerchantDetailView_MembersInjector implements MembersInjector<MerchantDetailView> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailView merchantDetailView, MerchantDetailConfigContract.Presenter presenter) {
        merchantDetailView.merchantDetailConfigPresenter = presenter;
    }

    public static void MyBillsEntityDataFactory(MerchantDetailView merchantDetailView, MerchantAverageRatingContract.Presenter presenter) {
        merchantDetailView.ratingPresenter = presenter;
    }

    public static void getAuthRequestContext(MerchantDetailView merchantDetailView, MerchantDanaDealsContract.Presenter presenter) {
        merchantDetailView.promoDealsPresenter = presenter;
    }

    public static void PlaceComponentResult(MerchantDetailView merchantDetailView, MerchantDetailReviewContract.Presenter presenter) {
        merchantDetailView.reviewPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MerchantDetailView merchantDetailView, MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        merchantDetailView.tracker = merchantDetailAnalyticTracker;
    }
}
