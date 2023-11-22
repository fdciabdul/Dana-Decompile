package id.dana.promodiscovery.views;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.promocenter.promo.PromoCenterContract;

/* loaded from: classes5.dex */
public final class PromoDiscoveryListActivity_MembersInjector implements MembersInjector<PromoDiscoveryListActivity> {
    public static void getAuthRequestContext(PromoDiscoveryListActivity promoDiscoveryListActivity, PromoCenterContract.Presenter presenter) {
        promoDiscoveryListActivity.promoCenterPresenter = presenter;
    }

    public static void getAuthRequestContext(PromoDiscoveryListActivity promoDiscoveryListActivity, ReadLinkPropertiesContract.Presenter presenter) {
        promoDiscoveryListActivity.readLinkPropertiesPresenter = presenter;
    }
}
