package id.dana.wallet_v3.payment.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class PaymentWalletDetailModule_ProvidePresenterFactory implements Factory<PaymentWalletDetailContract.Presenter> {
    private final PaymentWalletDetailModule module;
    private final Provider<PaymentWalletDetailPresenter> paymentWalletDetailPresenterProvider;

    public PaymentWalletDetailModule_ProvidePresenterFactory(PaymentWalletDetailModule paymentWalletDetailModule, Provider<PaymentWalletDetailPresenter> provider) {
        this.module = paymentWalletDetailModule;
        this.paymentWalletDetailPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final PaymentWalletDetailContract.Presenter get() {
        return providePresenter(this.module, this.paymentWalletDetailPresenterProvider.get());
    }

    public static PaymentWalletDetailModule_ProvidePresenterFactory create(PaymentWalletDetailModule paymentWalletDetailModule, Provider<PaymentWalletDetailPresenter> provider) {
        return new PaymentWalletDetailModule_ProvidePresenterFactory(paymentWalletDetailModule, provider);
    }

    public static PaymentWalletDetailContract.Presenter providePresenter(PaymentWalletDetailModule paymentWalletDetailModule, PaymentWalletDetailPresenter paymentWalletDetailPresenter) {
        return (PaymentWalletDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(paymentWalletDetailModule.providePresenter(paymentWalletDetailPresenter));
    }
}
