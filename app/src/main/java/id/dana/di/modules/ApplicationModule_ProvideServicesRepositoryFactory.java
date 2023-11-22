package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.domain.services.ServicesRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideServicesRepositoryFactory implements Factory<ServicesRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<ServicesEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideServicesRepositoryFactory(ApplicationModule applicationModule, Provider<ServicesEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideServicesRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<ServicesEntityRepository> provider) {
        return new ApplicationModule_ProvideServicesRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ServicesRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
