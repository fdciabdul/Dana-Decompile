package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.presenter.KtpDetailContract;

/* loaded from: classes5.dex */
public final class KtpDetailModule_ProvideViewFactory implements Factory<KtpDetailContract.View> {
    private final KtpDetailModule module;

    public KtpDetailModule_ProvideViewFactory(KtpDetailModule ktpDetailModule) {
        this.module = ktpDetailModule;
    }

    @Override // javax.inject.Provider
    public final KtpDetailContract.View get() {
        return provideView(this.module);
    }

    public static KtpDetailModule_ProvideViewFactory create(KtpDetailModule ktpDetailModule) {
        return new KtpDetailModule_ProvideViewFactory(ktpDetailModule);
    }

    public static KtpDetailContract.View provideView(KtpDetailModule ktpDetailModule) {
        return (KtpDetailContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(ktpDetailModule.getView());
    }
}
