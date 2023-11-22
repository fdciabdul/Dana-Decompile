package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.repository.AppGeneralEntityRepository;
import id.dana.domain.featureconfig.AppGeneralRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideAppGeneralRepositoryFactory implements Factory<AppGeneralRepository> {
    private final Provider<AppGeneralEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideAppGeneralRepositoryFactory(ApplicationModule applicationModule, Provider<AppGeneralEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideAppGeneralRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<AppGeneralEntityRepository> provider) {
        return new ApplicationModule_ProvideAppGeneralRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AppGeneralRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
