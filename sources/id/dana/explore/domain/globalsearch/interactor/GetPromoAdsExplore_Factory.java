package id.dana.explore.domain.globalsearch.interactor;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPromoAdsExplore_Factory implements Factory<GetPromoAdsExplore> {
    private final Provider<PromoCenterRepository> MyBillsEntityDataFactory;
    private final Provider<GlobalSearchRepository> PlaceComponentResult;
    private final Provider<FeatureConfigRepository> getAuthRequestContext;

    private GetPromoAdsExplore_Factory(Provider<PromoCenterRepository> provider, Provider<FeatureConfigRepository> provider2, Provider<GlobalSearchRepository> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static GetPromoAdsExplore_Factory getAuthRequestContext(Provider<PromoCenterRepository> provider, Provider<FeatureConfigRepository> provider2, Provider<GlobalSearchRepository> provider3) {
        return new GetPromoAdsExplore_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPromoAdsExplore(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
