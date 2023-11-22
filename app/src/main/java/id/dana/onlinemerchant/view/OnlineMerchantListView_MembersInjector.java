package id.dana.onlinemerchant.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.onlinemerchant.tracker.OnlineMerchantAnalyticTracker;

/* loaded from: classes5.dex */
public final class OnlineMerchantListView_MembersInjector implements MembersInjector<OnlineMerchantListView> {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(OnlineMerchantListView onlineMerchantListView, ReadLinkPropertiesContract.Presenter presenter) {
        onlineMerchantListView.readLinkPropertiesPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OnlineMerchantListView onlineMerchantListView, OnlineMerchantAnalyticTracker onlineMerchantAnalyticTracker) {
        onlineMerchantListView.tracker = onlineMerchantAnalyticTracker;
    }
}
