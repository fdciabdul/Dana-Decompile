package id.dana.wallet_v3.investment.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InvestmentWalletDetailModule_ProvidePresenterFactory implements Factory<InvestmentWalletDetailContract.Presenter> {
    private final Provider<InvestmentWalletDetailPresenter> investmentWalletDetailPresenterProvider;
    private final InvestmentWalletDetailModule module;

    public InvestmentWalletDetailModule_ProvidePresenterFactory(InvestmentWalletDetailModule investmentWalletDetailModule, Provider<InvestmentWalletDetailPresenter> provider) {
        this.module = investmentWalletDetailModule;
        this.investmentWalletDetailPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final InvestmentWalletDetailContract.Presenter get() {
        return providePresenter(this.module, this.investmentWalletDetailPresenterProvider.get());
    }

    public static InvestmentWalletDetailModule_ProvidePresenterFactory create(InvestmentWalletDetailModule investmentWalletDetailModule, Provider<InvestmentWalletDetailPresenter> provider) {
        return new InvestmentWalletDetailModule_ProvidePresenterFactory(investmentWalletDetailModule, provider);
    }

    public static InvestmentWalletDetailContract.Presenter providePresenter(InvestmentWalletDetailModule investmentWalletDetailModule, InvestmentWalletDetailPresenter investmentWalletDetailPresenter) {
        return (InvestmentWalletDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(investmentWalletDetailModule.providePresenter(investmentWalletDetailPresenter));
    }
}
