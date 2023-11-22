package id.dana.explore.service;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.explore.service.ExploreServiceContract;

/* loaded from: classes5.dex */
public final class ExploreServiceView_MembersInjector implements MembersInjector<ExploreServiceView> {
    public static void PlaceComponentResult(ExploreServiceView exploreServiceView, ReadLinkPropertiesContract.Presenter presenter) {
        exploreServiceView.readDeepLinkPropertiesPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ExploreServiceView exploreServiceView, ExploreServiceContract.Presenter presenter) {
        exploreServiceView.presenter = presenter;
    }
}
