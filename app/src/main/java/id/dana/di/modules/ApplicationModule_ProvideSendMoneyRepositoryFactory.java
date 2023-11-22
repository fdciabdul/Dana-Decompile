package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.sendmoney.repository.SendMoneyEntityRepository;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSendMoneyRepositoryFactory implements Factory<SendMoneyRepository> {
    private final ApplicationModule KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SendMoneyEntityRepository> MyBillsEntityDataFactory;

    private ApplicationModule_ProvideSendMoneyRepositoryFactory(ApplicationModule applicationModule, Provider<SendMoneyEntityRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationModule;
        this.MyBillsEntityDataFactory = provider;
    }

    public static ApplicationModule_ProvideSendMoneyRepositoryFactory getAuthRequestContext(ApplicationModule applicationModule, Provider<SendMoneyEntityRepository> provider) {
        return new ApplicationModule_ProvideSendMoneyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendMoneyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.get()));
    }
}
