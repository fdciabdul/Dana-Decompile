package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.explore.data.sku.repository.ProductInfoEntityRepository;
import id.dana.explore.domain.sku.ProductInfoRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideProductInfoRepositoryFactory implements Factory<ProductInfoRepository> {
    private final ApplicationModule PlaceComponentResult;
    private final Provider<ProductInfoEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideProductInfoRepositoryFactory(ApplicationModule applicationModule, Provider<ProductInfoEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideProductInfoRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<ProductInfoEntityRepository> provider) {
        return new ApplicationModule_ProvideProductInfoRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ProductInfoRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.getAuthRequestContext.get()));
    }
}
