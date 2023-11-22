package id.dana.wallet_v3.investment.presenter;

import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class InvestmentWalletDetailPresenter_Factory implements Factory<InvestmentWalletDetailPresenter> {
    private final Provider<GetUserPaymentWalletAsset> getUserInvestmentWalletAssetProvider;
    private final Provider<InvestmentWalletDetailContract.View> viewProvider;

    public InvestmentWalletDetailPresenter_Factory(Provider<InvestmentWalletDetailContract.View> provider, Provider<GetUserPaymentWalletAsset> provider2) {
        this.viewProvider = provider;
        this.getUserInvestmentWalletAssetProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final InvestmentWalletDetailPresenter get() {
        return newInstance(DoubleCheck.MyBillsEntityDataFactory(this.viewProvider), DoubleCheck.MyBillsEntityDataFactory(this.getUserInvestmentWalletAssetProvider));
    }

    public static InvestmentWalletDetailPresenter_Factory create(Provider<InvestmentWalletDetailContract.View> provider, Provider<GetUserPaymentWalletAsset> provider2) {
        return new InvestmentWalletDetailPresenter_Factory(provider, provider2);
    }

    public static InvestmentWalletDetailPresenter newInstance(Lazy<InvestmentWalletDetailContract.View> lazy, Lazy<GetUserPaymentWalletAsset> lazy2) {
        return new InvestmentWalletDetailPresenter(lazy, lazy2);
    }
}
