package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.paymentsetting.PaymentSettingContract;

/* loaded from: classes4.dex */
public final class PaymentSettingModule_ProvideView$app_productionReleaseFactory implements Factory<PaymentSettingContract.View> {
    private final PaymentSettingModule getAuthRequestContext;

    private PaymentSettingModule_ProvideView$app_productionReleaseFactory(PaymentSettingModule paymentSettingModule) {
        this.getAuthRequestContext = paymentSettingModule;
    }

    public static PaymentSettingModule_ProvideView$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(PaymentSettingModule paymentSettingModule) {
        return new PaymentSettingModule_ProvideView$app_productionReleaseFactory(paymentSettingModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PaymentSettingContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getBuiltInFictitiousFunctionClassFactory());
    }
}
