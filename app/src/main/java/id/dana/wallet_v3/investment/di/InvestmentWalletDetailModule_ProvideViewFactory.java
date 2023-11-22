package id.dana.wallet_v3.investment.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract;

/* loaded from: classes5.dex */
public final class InvestmentWalletDetailModule_ProvideViewFactory implements Factory<InvestmentWalletDetailContract.View> {
    private final InvestmentWalletDetailModule module;

    public InvestmentWalletDetailModule_ProvideViewFactory(InvestmentWalletDetailModule investmentWalletDetailModule) {
        this.module = investmentWalletDetailModule;
    }

    @Override // javax.inject.Provider
    public final InvestmentWalletDetailContract.View get() {
        return provideView(this.module);
    }

    public static InvestmentWalletDetailModule_ProvideViewFactory create(InvestmentWalletDetailModule investmentWalletDetailModule) {
        return new InvestmentWalletDetailModule_ProvideViewFactory(investmentWalletDetailModule);
    }

    public static InvestmentWalletDetailContract.View provideView(InvestmentWalletDetailModule investmentWalletDetailModule) {
        return (InvestmentWalletDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(investmentWalletDetailModule.getView());
    }
}
