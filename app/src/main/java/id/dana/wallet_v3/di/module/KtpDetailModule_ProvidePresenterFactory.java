package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.presenter.KtpDetailContract;
import id.dana.wallet_v3.presenter.KtpDetailPresenter;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KtpDetailModule_ProvidePresenterFactory implements Factory<KtpDetailContract.Presenter> {
    private final Provider<KtpDetailPresenter> ktpDetailPresenterProvider;
    private final KtpDetailModule module;

    public KtpDetailModule_ProvidePresenterFactory(KtpDetailModule ktpDetailModule, Provider<KtpDetailPresenter> provider) {
        this.module = ktpDetailModule;
        this.ktpDetailPresenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final KtpDetailContract.Presenter get() {
        return providePresenter(this.module, this.ktpDetailPresenterProvider.get());
    }

    public static KtpDetailModule_ProvidePresenterFactory create(KtpDetailModule ktpDetailModule, Provider<KtpDetailPresenter> provider) {
        return new KtpDetailModule_ProvidePresenterFactory(ktpDetailModule, provider);
    }

    public static KtpDetailContract.Presenter providePresenter(KtpDetailModule ktpDetailModule, KtpDetailPresenter ktpDetailPresenter) {
        return (KtpDetailContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(ktpDetailModule.providePresenter(ktpDetailPresenter));
    }
}
