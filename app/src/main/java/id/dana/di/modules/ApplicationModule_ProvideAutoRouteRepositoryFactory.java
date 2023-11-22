package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.autoroute.repository.source.AutoRouteEntityRepository;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideAutoRouteRepositoryFactory implements Factory<AutoRouteRepository> {
    private final Provider<AutoRouteEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;

    private ApplicationModule_ProvideAutoRouteRepositoryFactory(ApplicationModule applicationModule, Provider<AutoRouteEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideAutoRouteRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<AutoRouteEntityRepository> provider) {
        return new ApplicationModule_ProvideAutoRouteRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AutoRouteRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
