package id.dana.explore.presenter;

import dagger.internal.Factory;
import id.dana.explore.domain.globalsearch.interactor.GetPromoAdsExplore;
import id.dana.explore.view.PromoExploreContract;
import id.dana.promocenter.mapper.PromoAdsModelMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class PromoExplorePresenter_Factory implements Factory<PromoExplorePresenter> {
    private final Provider<PromoAdsModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetPromoAdsExplore> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<PromoExploreContract.View> getAuthRequestContext;

    private PromoExplorePresenter_Factory(Provider<PromoExploreContract.View> provider, Provider<GetPromoAdsExplore> provider2, Provider<PromoAdsModelMapper> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
    }

    public static PromoExplorePresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<PromoExploreContract.View> provider, Provider<GetPromoAdsExplore> provider2, Provider<PromoAdsModelMapper> provider3) {
        return new PromoExplorePresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PromoExplorePresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
