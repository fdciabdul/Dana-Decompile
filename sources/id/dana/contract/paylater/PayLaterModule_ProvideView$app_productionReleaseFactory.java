package id.dana.contract.paylater;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.paylater.PayLaterContract;

/* loaded from: classes4.dex */
public final class PayLaterModule_ProvideView$app_productionReleaseFactory implements Factory<PayLaterContract.View> {
    private final PayLaterModule getAuthRequestContext;

    private PayLaterModule_ProvideView$app_productionReleaseFactory(PayLaterModule payLaterModule) {
        this.getAuthRequestContext = payLaterModule;
    }

    public static PayLaterModule_ProvideView$app_productionReleaseFactory KClassImpl$Data$declaredNonStaticMembers$2(PayLaterModule payLaterModule) {
        return new PayLaterModule_ProvideView$app_productionReleaseFactory(payLaterModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayLaterContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getPlaceComponentResult());
    }
}
