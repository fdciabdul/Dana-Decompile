package id.dana.onlinemerchant;

import dagger.MembersInjector;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;

/* loaded from: classes5.dex */
public final class OnlineMerchantActivity_MembersInjector implements MembersInjector<OnlineMerchantActivity> {
    public static void getAuthRequestContext(OnlineMerchantActivity onlineMerchantActivity, OnlineMerchantContract.Presenter presenter) {
        onlineMerchantActivity.onlineMerchantPresenter = presenter;
    }

    public static void PlaceComponentResult(OnlineMerchantActivity onlineMerchantActivity, OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker) {
        onlineMerchantActivity.onlineMerchantAnalyticTracker = onlineMerchantAnalyticTracker;
    }
}
