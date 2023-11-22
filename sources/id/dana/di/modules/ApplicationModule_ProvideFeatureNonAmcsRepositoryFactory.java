package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.featureswitch.repository.source.FeatureNonAMCSEntityRepository;
import id.dana.domain.featureswitch.FeatureNonAmcsRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideFeatureNonAmcsRepositoryFactory implements Factory<FeatureNonAmcsRepository> {
    private final Provider<FeatureNonAMCSEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideFeatureNonAmcsRepositoryFactory(ApplicationModule applicationModule, Provider<FeatureNonAMCSEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideFeatureNonAmcsRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<FeatureNonAMCSEntityRepository> provider) {
        return new ApplicationModule_ProvideFeatureNonAmcsRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (FeatureNonAmcsRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
