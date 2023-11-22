package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideDanaProtectionInfoRepositoryFactory implements Factory<DanaProtectionInfoRepository> {
    private final Provider<DanaProtectionInfoEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideDanaProtectionInfoRepositoryFactory(ApplicationModule applicationModule, Provider<DanaProtectionInfoEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideDanaProtectionInfoRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<DanaProtectionInfoEntityRepository> provider) {
        return new ApplicationModule_ProvideDanaProtectionInfoRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (DanaProtectionInfoRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
