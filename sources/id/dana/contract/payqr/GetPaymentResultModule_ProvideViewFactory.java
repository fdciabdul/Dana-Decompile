package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payqr.GetPaymentResultContract;

/* loaded from: classes4.dex */
public final class GetPaymentResultModule_ProvideViewFactory implements Factory<GetPaymentResultContract.View> {
    private final GetPaymentResultModule getAuthRequestContext;

    private GetPaymentResultModule_ProvideViewFactory(GetPaymentResultModule getPaymentResultModule) {
        this.getAuthRequestContext = getPaymentResultModule;
    }

    public static GetPaymentResultModule_ProvideViewFactory getAuthRequestContext(GetPaymentResultModule getPaymentResultModule) {
        return new GetPaymentResultModule_ProvideViewFactory(getPaymentResultModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (GetPaymentResultContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext());
    }
}
