package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.transferaccount.TransferAccountEntityRepository;
import id.dana.domain.transferaccount.TransferAccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideTransferAccountRepositoryFactory implements Factory<TransferAccountRepository> {
    private final ApplicationModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<TransferAccountEntityRepository> PlaceComponentResult;

    private ApplicationModule_ProvideTransferAccountRepositoryFactory(ApplicationModule applicationModule, Provider<TransferAccountEntityRepository> provider) {
        this.BuiltInFictitiousFunctionClassFactory = applicationModule;
        this.PlaceComponentResult = provider;
    }

    public static ApplicationModule_ProvideTransferAccountRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<TransferAccountEntityRepository> provider) {
        return new ApplicationModule_ProvideTransferAccountRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (TransferAccountRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(this.PlaceComponentResult.get()));
    }
}
