package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMerchantCategoriesRepositoryFactory implements Factory<MerchantCategoriesRepository> {
    private final Provider<MerchantCategoriesEntityRepository> PlaceComponentResult;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideMerchantCategoriesRepositoryFactory(ApplicationModule applicationModule, Provider<MerchantCategoriesEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideMerchantCategoriesRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<MerchantCategoriesEntityRepository> provider) {
        return new ApplicationModule_ProvideMerchantCategoriesRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantCategoriesRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.get()));
    }
}
