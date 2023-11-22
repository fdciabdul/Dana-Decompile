package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payqr.PayQrContract;

/* loaded from: classes4.dex */
public final class PayQrModule_ProvideViewFactory implements Factory<PayQrContract.View> {
    private final PayQrModule MyBillsEntityDataFactory;

    private PayQrModule_ProvideViewFactory(PayQrModule payQrModule) {
        this.MyBillsEntityDataFactory = payQrModule;
    }

    public static PayQrModule_ProvideViewFactory BuiltInFictitiousFunctionClassFactory(PayQrModule payQrModule) {
        return new PayQrModule_ProvideViewFactory(payQrModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayQrContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext());
    }
}
