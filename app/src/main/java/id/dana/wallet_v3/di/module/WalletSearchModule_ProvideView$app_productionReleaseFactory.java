package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.search.presenter.WalletSearchContract;

/* loaded from: classes5.dex */
public final class WalletSearchModule_ProvideView$app_productionReleaseFactory implements Factory<WalletSearchContract.View> {
    private final WalletSearchModule module;

    public WalletSearchModule_ProvideView$app_productionReleaseFactory(WalletSearchModule walletSearchModule) {
        this.module = walletSearchModule;
    }

    @Override // javax.inject.Provider
    public final WalletSearchContract.View get() {
        return provideView$app_productionRelease(this.module);
    }

    public static WalletSearchModule_ProvideView$app_productionReleaseFactory create(WalletSearchModule walletSearchModule) {
        return new WalletSearchModule_ProvideView$app_productionReleaseFactory(walletSearchModule);
    }

    public static WalletSearchContract.View provideView$app_productionRelease(WalletSearchModule walletSearchModule) {
        return (WalletSearchContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(walletSearchModule.getView());
    }
}
