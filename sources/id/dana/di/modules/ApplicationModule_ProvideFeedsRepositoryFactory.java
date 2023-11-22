package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.feeds.repository.FeedsEntityRepository;
import id.dana.domain.feeds.FeedsRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeedsRepositoryFactory implements Factory<FeedsRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<FeedsEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideFeedsRepositoryFactory(ApplicationModule applicationModule, Provider<FeedsEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideFeedsRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<FeedsEntityRepository> provider) {
        return new ApplicationModule_ProvideFeedsRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
