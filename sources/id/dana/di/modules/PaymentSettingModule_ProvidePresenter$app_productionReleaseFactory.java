package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.paymentsetting.PaymentSettingContract;
import id.dana.paymentsetting.PaymentSettingPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PaymentSettingModule_ProvidePresenter$app_productionReleaseFactory implements Factory<PaymentSettingContract.Presenter> {
    private final PaymentSettingModule MyBillsEntityDataFactory;
    private final Provider<PaymentSettingPresenter> PlaceComponentResult;

    private PaymentSettingModule_ProvidePresenter$app_productionReleaseFactory(PaymentSettingModule paymentSettingModule, Provider<PaymentSettingPresenter> provider) {
        this.MyBillsEntityDataFactory = paymentSettingModule;
        this.PlaceComponentResult = provider;
    }

    public static PaymentSettingModule_ProvidePresenter$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(PaymentSettingModule paymentSettingModule, Provider<PaymentSettingPresenter> provider) {
        return new PaymentSettingModule_ProvidePresenter$app_productionReleaseFactory(paymentSettingModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaymentSettingContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.PlaceComponentResult.get()));
    }
}
