package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeedsConfigRepositoryFactory implements Factory<FeedsConfigRepository> {
    private final Provider<FeedsConfigEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideFeedsConfigRepositoryFactory(ApplicationModule applicationModule, Provider<FeedsConfigEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideFeedsConfigRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<FeedsConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideFeedsConfigRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeedsConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
