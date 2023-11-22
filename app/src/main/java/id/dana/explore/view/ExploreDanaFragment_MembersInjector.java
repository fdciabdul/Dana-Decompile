package id.dana.explore.view;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.explore.popularplaces.PopularPlacesContract;
import id.dana.explore.view.PromoExploreContract;
import id.dana.globalsearch.tracker.GlobalSearchAnalyticTracker;

/* loaded from: classes5.dex */
public final class ExploreDanaFragment_MembersInjector implements MembersInjector<ExploreDanaFragment> {
    public static void PlaceComponentResult(ExploreDanaFragment exploreDanaFragment, ReadLinkPropertiesContract.Presenter presenter) {
        exploreDanaFragment.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(ExploreDanaFragment exploreDanaFragment, GlobalSearchContract.Presenter presenter) {
        exploreDanaFragment.globalSearchPresenter = presenter;
    }

    public static void PlaceComponentResult(ExploreDanaFragment exploreDanaFragment, PopularPlacesContract.Presenter presenter) {
        exploreDanaFragment.popularPlacesPresenter = presenter;
    }

    public static void getAuthRequestContext(ExploreDanaFragment exploreDanaFragment, PromoExploreContract.Presenter presenter) {
        exploreDanaFragment.promoExplorePresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ExploreDanaFragment exploreDanaFragment, GlobalSearchAnalyticTracker globalSearchAnalyticTracker) {
        exploreDanaFragment.globalSearchAnalyticTracker = globalSearchAnalyticTracker;
    }
}
