package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.data.paymentsetting.PaymentSettingEntityRepository;
import id.dana.domain.paymentsetting.PaymentSettingRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ApplicationModule_ProvidePaymentSettingRepositoryFactory implements Factory<PaymentSettingRepository> {
    private final Provider<PaymentSettingEntityRepository> BuiltInFictitiousFunctionClassFactory;
    private final ApplicationModule MyBillsEntityDataFactory;

    private ApplicationModule_ProvidePaymentSettingRepositoryFactory(ApplicationModule applicationModule, Provider<PaymentSettingEntityRepository> provider) {
        this.MyBillsEntityDataFactory = applicationModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ApplicationModule_ProvidePaymentSettingRepositoryFactory MyBillsEntityDataFactory(ApplicationModule applicationModule, Provider<PaymentSettingEntityRepository> provider) {
        return new ApplicationModule_ProvidePaymentSettingRepositoryFactory(applicationModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaymentSettingRepository) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
