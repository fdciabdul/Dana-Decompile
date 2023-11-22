package id.dana.wallet_v3.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.presenter.NewWalletContract;
import id.dana.wallet_v3.presenter.NewWalletPresenter;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class NewWalletModule_ProvidePresenterFactory implements Factory<NewWalletContract.Presenter> {
    private final NewWalletModule module;
    private final Provider<NewWalletPresenter> newWalletPresenterProvider;

    public NewWalletModule_ProvidePresenterFactory(NewWalletModule newWalletModule, Provider<NewWalletPresenter> provider) {
        this.module = newWalletModule;
        this.newWalletPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final NewWalletContract.Presenter get() {
        return providePresenter(this.module, this.newWalletPresenterProvider.get());
    }

    public static NewWalletModule_ProvidePresenterFactory create(NewWalletModule newWalletModule, Provider<NewWalletPresenter> provider) {
        return new NewWalletModule_ProvidePresenterFactory(newWalletModule, provider);
    }

    public static NewWalletContract.Presenter providePresenter(NewWalletModule newWalletModule, NewWalletPresenter newWalletPresenter) {
        return (NewWalletContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(newWalletModule.providePresenter(newWalletPresenter));
    }
}
