package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.search.presenter.WalletSearchContract;
import id.dana.wallet_v3.view.search.presenter.WalletSearchPresenter;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class WalletSearchModule_ProvidePresenter$app_productionReleaseFactory implements Factory<WalletSearchContract.Presenter> {
    private final WalletSearchModule module;
    private final Provider<WalletSearchPresenter> presenterProvider;

    public WalletSearchModule_ProvidePresenter$app_productionReleaseFactory(WalletSearchModule walletSearchModule, Provider<WalletSearchPresenter> provider) {
        this.module = walletSearchModule;
        this.presenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final WalletSearchContract.Presenter get() {
        return providePresenter$app_productionRelease(this.module, this.presenterProvider.get());
    }

    public static WalletSearchModule_ProvidePresenter$app_productionReleaseFactory create(WalletSearchModule walletSearchModule, Provider<WalletSearchPresenter> provider) {
        return new WalletSearchModule_ProvidePresenter$app_productionReleaseFactory(walletSearchModule, provider);
    }

    public static WalletSearchContract.Presenter providePresenter$app_productionRelease(WalletSearchModule walletSearchModule, WalletSearchPresenter walletSearchPresenter) {
        return (WalletSearchContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(walletSearchModule.providePresenter$app_productionRelease(walletSearchPresenter));
    }
}
