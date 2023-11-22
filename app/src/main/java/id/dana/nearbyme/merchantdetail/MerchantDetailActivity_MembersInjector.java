package id.dana.nearbyme.merchantdetail;

import dagger.MembersInjector;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;

/* loaded from: classes5.dex */
public final class MerchantDetailActivity_MembersInjector implements MembersInjector<MerchantDetailActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(MerchantDetailActivity merchantDetailActivity, MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        merchantDetailActivity.tracker = merchantDetailAnalyticTracker;
    }

    public static void MyBillsEntityDataFactory(MerchantDetailActivity merchantDetailActivity, NearbyAnalyticTracker nearbyAnalyticTracker) {
        merchantDetailActivity.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    public static void BuiltInFictitiousFunctionClassFactory(MerchantDetailActivity merchantDetailActivity, MerchantDetailContract.Presenter presenter) {
        merchantDetailActivity.merchantDetailPresenter = presenter;
    }
}
