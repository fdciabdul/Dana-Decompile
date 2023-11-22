package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.h5onlineconfig.repository.H5OnlineConfigEntityRepository;
import id.dana.domain.h5onlineconfig.H5OnlineConfigRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideH5OnlineConfigRepositoryFactory implements Factory<H5OnlineConfigRepository> {
    private final Provider<H5OnlineConfigEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideH5OnlineConfigRepositoryFactory(ApplicationModule applicationModule, Provider<H5OnlineConfigEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideH5OnlineConfigRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<H5OnlineConfigEntityRepository> provider) {
        return new ApplicationModule_ProvideH5OnlineConfigRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (H5OnlineConfigRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
