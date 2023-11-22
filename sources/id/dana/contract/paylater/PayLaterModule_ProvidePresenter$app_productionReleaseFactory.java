package id.dana.contract.paylater;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.paylater.PayLaterContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayLaterModule_ProvidePresenter$app_productionReleaseFactory implements Factory<PayLaterContract.Presenter> {
    private final Provider<PayLaterPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PayLaterModule PlaceComponentResult;

    private PayLaterModule_ProvidePresenter$app_productionReleaseFactory(PayLaterModule payLaterModule, Provider<PayLaterPresenter> provider) {
        this.PlaceComponentResult = payLaterModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static PayLaterModule_ProvidePresenter$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(PayLaterModule payLaterModule, Provider<PayLaterPresenter> provider) {
        return new PayLaterModule_ProvidePresenter$app_productionReleaseFactory(payLaterModule, provider);
    }

    public static PayLaterContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(PayLaterModule payLaterModule, PayLaterPresenter payLaterPresenter) {
        return (PayLaterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(payLaterModule.PlaceComponentResult(payLaterPresenter));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayLaterContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
