package id.dana.wallet_v3.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.presenter.NewWalletContract;

/* loaded from: classes9.dex */
public final class NewWalletModule_ProvideViewFactory implements Factory<NewWalletContract.View> {
    private final NewWalletModule module;

    public NewWalletModule_ProvideViewFactory(NewWalletModule newWalletModule) {
        this.module = newWalletModule;
    }

    @Override // javax.inject.Provider
    public final NewWalletContract.View get() {
        return provideView(this.module);
    }

    public static NewWalletModule_ProvideViewFactory create(NewWalletModule newWalletModule) {
        return new NewWalletModule_ProvideViewFactory(newWalletModule);
    }

    public static NewWalletContract.View provideView(NewWalletModule newWalletModule) {
        return (NewWalletContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(newWalletModule.getView());
    }
}
