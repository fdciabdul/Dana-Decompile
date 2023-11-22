package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.senddigitalmoney.repository.SendDigitalMoneyEntityRepository;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvideSendDigitalMoneyRepositoryFactory implements Factory<SendDigitalMoneyRepository> {
    private final ApplicationModule MyBillsEntityDataFactory;
    private final Provider<SendDigitalMoneyEntityRepository> getAuthRequestContext;

    private ApplicationModule_ProvideSendDigitalMoneyRepositoryFactory(ApplicationModule applicationModule, Provider<SendDigitalMoneyEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.getAuthRequestContext = provider;
    }

    public static ApplicationModule_ProvideSendDigitalMoneyRepositoryFactory BuiltInFictitiousFunctionClassFactory(ApplicationModule applicationModule, Provider<SendDigitalMoneyEntityRepository> provider) {
        return new ApplicationModule_ProvideSendDigitalMoneyRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (SendDigitalMoneyRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.getAuthRequestContext.get()));
    }
}
