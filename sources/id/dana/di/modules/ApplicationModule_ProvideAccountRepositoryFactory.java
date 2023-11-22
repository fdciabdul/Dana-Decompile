package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.domain.account.AccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideAccountRepositoryFactory implements Factory<AccountRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<AccountEntityRepository> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideAccountRepositoryFactory(ApplicationModule applicationModule, Provider<AccountEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideAccountRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<AccountEntityRepository> provider) {
        return new ApplicationModule_ProvideAccountRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (AccountRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.get()));
    }
}
