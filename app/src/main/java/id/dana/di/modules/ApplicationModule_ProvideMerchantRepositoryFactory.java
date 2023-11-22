package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyme.repository.MerchantConfigEntityRepository;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideMerchantRepositoryFactory implements Factory<MerchantConfigRepository> {
    private final Provider<MerchantConfigEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideMerchantRepositoryFactory(ApplicationModule applicationModule, Provider<MerchantConfigEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideMerchantRepositoryFactory KClassImpl$Data$declaredNonStaticMembers$2(ApplicationModule applicationModule, Provider<MerchantConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideMerchantRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (MerchantConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
