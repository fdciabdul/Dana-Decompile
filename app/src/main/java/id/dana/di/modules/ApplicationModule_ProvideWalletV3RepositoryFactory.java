package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.wallet_v3.repository.WalletV3EntityRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideWalletV3RepositoryFactory implements Factory<WalletV3Repository> {
    private final Provider<WalletV3EntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvideWalletV3RepositoryFactory(ApplicationModule applicationModule, Provider<WalletV3EntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvideWalletV3RepositoryFactory PlaceComponentResult(ApplicationModule applicationModule, Provider<WalletV3EntityRepository> provider) {
        return new ApplicationModule_ProvideWalletV3RepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (WalletV3Repository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
