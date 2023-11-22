package id.dana.promodiscovery.views;

import dagger.Lazy;
import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesPresenter;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.promodiscovery.tracker.PromoDiscoveryAnalyticTracker;

/* loaded from: classes5.dex */
public final class PromoDiscoveryFragment_MembersInjector implements MembersInjector<PromoDiscoveryFragment> {
    public static void MyBillsEntityDataFactory(PromoDiscoveryFragment promoDiscoveryFragment, PromoDiscoveryContract.Presenter presenter) {
        promoDiscoveryFragment.promoDiscoveryPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment promoDiscoveryFragment, PromoDiscoveryAnalyticTracker promoDiscoveryAnalyticTracker) {
        promoDiscoveryFragment.promoDiscoveryTracker = promoDiscoveryAnalyticTracker;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(PromoDiscoveryFragment promoDiscoveryFragment, Lazy<ReadLinkPropertiesPresenter> lazy) {
        promoDiscoveryFragment.readLinkPropertiesPresenter = lazy;
    }
}
