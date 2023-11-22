package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeatureConfigRepositoryFactory implements Factory<FeatureConfigRepository> {
    private final Provider<FeatureConfigEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideFeatureConfigRepositoryFactory(ApplicationModule applicationModule, Provider<FeatureConfigEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideFeatureConfigRepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<FeatureConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideFeatureConfigRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeatureConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
