package id.dana.nearbyme.merchantreview;

import dagger.MembersInjector;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker;

/* loaded from: classes5.dex */
public final class MerchantReviewDialogFragment_MembersInjector implements MembersInjector<MerchantReviewDialogFragment> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewDialogFragment merchantReviewDialogFragment, MerchantReviewFormContract.Presenter presenter) {
        merchantReviewDialogFragment.presenter = presenter;
    }

    public static void PlaceComponentResult(MerchantReviewDialogFragment merchantReviewDialogFragment, MerchantReviewFormAnalyticTracker merchantReviewFormAnalyticTracker) {
        merchantReviewDialogFragment.tracker = merchantReviewFormAnalyticTracker;
    }
}
