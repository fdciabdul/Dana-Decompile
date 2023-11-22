package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.paylater.repository.PaylaterEntityRepository;
import id.dana.domain.paylater.PaylaterRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePaylaterRepositoryFactory implements Factory<PaylaterRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<PaylaterEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvidePaylaterRepositoryFactory(ApplicationModule applicationModule, Provider<PaylaterEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvidePaylaterRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<PaylaterEntityRepository> provider) {
        return new ApplicationModule_ProvidePaylaterRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaylaterRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
