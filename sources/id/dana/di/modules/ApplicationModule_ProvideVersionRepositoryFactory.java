package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.version.VersionEntityRepository;
import id.dana.domain.version.VersionRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideVersionRepositoryFactory implements Factory<VersionRepository> {
    private final Provider<VersionEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule getAuthRequestContext;

    private ApplicationModule_ProvideVersionRepositoryFactory(ApplicationModule applicationModule, Provider<VersionEntityRepository> provider) {
        this.getAuthRequestContext = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideVersionRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<VersionEntityRepository> provider) {
        return new ApplicationModule_ProvideVersionRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VersionRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
