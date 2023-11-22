package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.saving.repository.SavingEntityRepository;
import id.dana.domain.saving.SavingRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSavingRepositoryFactory implements Factory<SavingRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<SavingEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideSavingRepositoryFactory(ApplicationModule applicationModule, Provider<SavingEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideSavingRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<SavingEntityRepository> provider) {
        return new ApplicationModule_ProvideSavingRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SavingRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.getAuthRequestContext.get()));
    }
}
