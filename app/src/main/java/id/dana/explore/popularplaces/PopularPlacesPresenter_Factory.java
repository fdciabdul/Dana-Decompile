package id.dana.explore.popularplaces;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.interactor.GetExploreRecommendedPopularPlace;
import id.dana.explore.popularplaces.PopularPlacesContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PopularPlacesPresenter_Factory implements Factory<PopularPlacesPresenter> {
    private final Provider<GetExploreRecommendedPopularPlace> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PopularPlacesContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    private PopularPlacesPresenter_Factory(Provider<PopularPlacesContract.View> provider, Provider<GetExploreRecommendedPopularPlace> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static PopularPlacesPresenter_Factory PlaceComponentResult(Provider<PopularPlacesContract.View> provider, Provider<GetExploreRecommendedPopularPlace> provider2) {
        return new PopularPlacesPresenter_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PopularPlacesPresenter(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
