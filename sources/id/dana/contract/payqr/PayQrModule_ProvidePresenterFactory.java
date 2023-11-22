package id.dana.contract.payqr;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.payqr.PayQrContract;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PayQrModule_ProvidePresenterFactory implements Factory<PayQrContract.Presenter> {
    private final PayQrModule MyBillsEntityDataFactory;
    private final Provider<PayQrPresenter> getAuthRequestContext;

    private PayQrModule_ProvidePresenterFactory(PayQrModule payQrModule, Provider<PayQrPresenter> provider) {
        this.MyBillsEntityDataFactory = payQrModule;
        this.getAuthRequestContext = provider;
    }

    public static PayQrModule_ProvidePresenterFactory PlaceComponentResult(PayQrModule payQrModule, Provider<PayQrPresenter> provider) {
        return new PayQrModule_ProvidePresenterFactory(payQrModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PayQrContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.get()));
    }
}
