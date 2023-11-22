package id.dana.nearbyme.merchantdetail.merchantreviewdetail;

import dagger.MembersInjector;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;

/* loaded from: classes5.dex */
public final class MerchantReviewDetailActivity_MembersInjector implements MembersInjector<MerchantReviewDetailActivity> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewDetailActivity merchantReviewDetailActivity, MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        merchantReviewDetailActivity.tracker = merchantDetailAnalyticTracker;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewDetailActivity merchantReviewDetailActivity, MerchantDetailReviewContract.Presenter presenter) {
        merchantReviewDetailActivity.reviewPresenter = presenter;
    }
}
