package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.bank.repository.UserBankEntityRepository;
import id.dana.domain.bank.repository.UserBankRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideUserBankRepositoryFactory implements Factory<UserBankRepository> {
    private final Provider<UserBankEntityRepository> MyBillsEntityDataFactory;
    private final ApplicationModule PlaceComponentResult;

    private ApplicationModule_ProvideUserBankRepositoryFactory(ApplicationModule applicationModule, Provider<UserBankEntityRepository> provider) {
        this.PlaceComponentResult = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideUserBankRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<UserBankEntityRepository> provider) {
        return new ApplicationModule_ProvideUserBankRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (UserBankRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.get()));
    }
}
