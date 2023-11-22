package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.nearbyme.repository.NearbyMeEntityRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideNearbyMeRepositoryFactory implements Factory<NearbyMeRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<NearbyMeEntityRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideNearbyMeRepositoryFactory(ApplicationModule applicationModule, Provider<NearbyMeEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ApplicationModule_ProvideNearbyMeRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<NearbyMeEntityRepository> provider) {
        return new ApplicationModule_ProvideNearbyMeRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (NearbyMeRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
