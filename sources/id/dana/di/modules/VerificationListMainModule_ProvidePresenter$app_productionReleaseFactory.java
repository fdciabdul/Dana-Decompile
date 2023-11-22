package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.pushverify.view.verificationlist.VerificationListMainContract;
import id.dana.pushverify.view.verificationlist.VerificationListMainPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerificationListMainModule_ProvidePresenter$app_productionReleaseFactory implements Factory<VerificationListMainContract.Presenter> {
    private final Provider<VerificationListMainPresenter> PlaceComponentResult;
    private final VerificationListMainModule getAuthRequestContext;

    private VerificationListMainModule_ProvidePresenter$app_productionReleaseFactory(VerificationListMainModule verificationListMainModule, Provider<VerificationListMainPresenter> provider) {
        this.getAuthRequestContext = verificationListMainModule;
        this.PlaceComponentResult = provider;
    }

    public static VerificationListMainModule_ProvidePresenter$app_productionReleaseFactory BuiltInFictitiousFunctionClassFactory(VerificationListMainModule verificationListMainModule, Provider<VerificationListMainPresenter> provider) {
        return new VerificationListMainModule_ProvidePresenter$app_productionReleaseFactory(verificationListMainModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerificationListMainContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.PlaceComponentResult.get()));
    }
}
