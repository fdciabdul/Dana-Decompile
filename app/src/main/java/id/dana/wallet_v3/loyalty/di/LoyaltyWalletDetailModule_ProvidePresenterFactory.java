package id.dana.wallet_v3.loyalty.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class LoyaltyWalletDetailModule_ProvidePresenterFactory implements Factory<LoyaltyWalletContract.Presenter> {
    private final Provider<LoyaltyWalletPresenter> loyaltyWalletPresenterProvider;
    private final LoyaltyWalletDetailModule module;

    public LoyaltyWalletDetailModule_ProvidePresenterFactory(LoyaltyWalletDetailModule loyaltyWalletDetailModule, Provider<LoyaltyWalletPresenter> provider) {
        this.module = loyaltyWalletDetailModule;
        this.loyaltyWalletPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final LoyaltyWalletContract.Presenter get() {
        return providePresenter(this.module, this.loyaltyWalletPresenterProvider.get());
    }

    public static LoyaltyWalletDetailModule_ProvidePresenterFactory create(LoyaltyWalletDetailModule loyaltyWalletDetailModule, Provider<LoyaltyWalletPresenter> provider) {
        return new LoyaltyWalletDetailModule_ProvidePresenterFactory(loyaltyWalletDetailModule, provider);
    }

    public static LoyaltyWalletContract.Presenter providePresenter(LoyaltyWalletDetailModule loyaltyWalletDetailModule, LoyaltyWalletPresenter loyaltyWalletPresenter) {
        return (LoyaltyWalletContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(loyaltyWalletDetailModule.providePresenter(loyaltyWalletPresenter));
    }
}
