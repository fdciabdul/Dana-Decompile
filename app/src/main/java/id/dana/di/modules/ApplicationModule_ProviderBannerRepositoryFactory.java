package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.promotion.repository.PromotionEntityRepository;
import id.dana.domain.promotion.repository.PromotionRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProviderBannerRepositoryFactory implements Factory<PromotionRepository> {
    private final Provider<PromotionEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProviderBannerRepositoryFactory(ApplicationModule applicationModule, Provider<PromotionEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProviderBannerRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<PromotionEntityRepository> provider) {
        return new ApplicationModule_ProviderBannerRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PromotionRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
