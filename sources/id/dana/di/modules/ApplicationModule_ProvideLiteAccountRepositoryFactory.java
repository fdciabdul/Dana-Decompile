package id.dana.di.modules;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.account.repository.source.LocalConfigLiteAccountEntityRepository;
import id.dana.domain.account.LiteAccountRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideLiteAccountRepositoryFactory implements Factory<LiteAccountRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<LocalConfigLiteAccountEntityRepository> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideLiteAccountRepositoryFactory(ApplicationModule applicationModule, Provider<LocalConfigLiteAccountEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideLiteAccountRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<LocalConfigLiteAccountEntityRepository> provider) {
        return new ApplicationModule_ProvideLiteAccountRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (LiteAccountRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory)));
    }
}
