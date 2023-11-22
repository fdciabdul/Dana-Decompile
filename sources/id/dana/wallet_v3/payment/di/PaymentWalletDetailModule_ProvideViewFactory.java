package id.dana.wallet_v3.payment.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract;

/* loaded from: classes6.dex */
public final class PaymentWalletDetailModule_ProvideViewFactory implements Factory<PaymentWalletDetailContract.View> {
    private final PaymentWalletDetailModule module;

    public PaymentWalletDetailModule_ProvideViewFactory(PaymentWalletDetailModule paymentWalletDetailModule) {
        this.module = paymentWalletDetailModule;
    }

    @Override // javax.inject.Provider
    public final PaymentWalletDetailContract.View get() {
        return provideView(this.module);
    }

    public static PaymentWalletDetailModule_ProvideViewFactory create(PaymentWalletDetailModule paymentWalletDetailModule) {
        return new PaymentWalletDetailModule_ProvideViewFactory(paymentWalletDetailModule);
    }

    public static PaymentWalletDetailContract.View provideView(PaymentWalletDetailModule paymentWalletDetailModule) {
        return (PaymentWalletDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(paymentWalletDetailModule.getView());
    }
}
