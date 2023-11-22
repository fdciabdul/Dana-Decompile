package id.dana.wallet_v3.loyalty.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;

/* loaded from: classes5.dex */
public final class LoyaltyWalletDetailModule_ProvideViewFactory implements Factory<LoyaltyWalletContract.View> {
    private final LoyaltyWalletDetailModule module;

    public LoyaltyWalletDetailModule_ProvideViewFactory(LoyaltyWalletDetailModule loyaltyWalletDetailModule) {
        this.module = loyaltyWalletDetailModule;
    }

    @Override // javax.inject.Provider
    public final LoyaltyWalletContract.View get() {
        return provideView(this.module);
    }

    public static LoyaltyWalletDetailModule_ProvideViewFactory create(LoyaltyWalletDetailModule loyaltyWalletDetailModule) {
        return new LoyaltyWalletDetailModule_ProvideViewFactory(loyaltyWalletDetailModule);
    }

    public static LoyaltyWalletContract.View provideView(LoyaltyWalletDetailModule loyaltyWalletDetailModule) {
        return (LoyaltyWalletContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(loyaltyWalletDetailModule.getView());
    }
}
