package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.citcall.CitCallEntityRepository;
import id.dana.domain.citcall.CitcallRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideCitCallEntityRepositoryFactory implements Factory<CitcallRepository> {
    private final Provider<CitCallEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideCitCallEntityRepositoryFactory(ApplicationModule applicationModule, Provider<CitCallEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideCitCallEntityRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<CitCallEntityRepository> provider) {
        return new ApplicationModule_ProvideCitCallEntityRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CitcallRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
