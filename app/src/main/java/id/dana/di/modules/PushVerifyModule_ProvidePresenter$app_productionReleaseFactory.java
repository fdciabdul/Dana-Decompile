package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.pushverify.view.verificationdetail.PushVerifyContract;
import id.dana.pushverify.view.verificationdetail.PushVerifyPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class PushVerifyModule_ProvidePresenter$app_productionReleaseFactory implements Factory<PushVerifyContract.Presenter> {
    private final Provider<PushVerifyPresenter> BuiltInFictitiousFunctionClassFactory;
    private final PushVerifyModule PlaceComponentResult;

    private PushVerifyModule_ProvidePresenter$app_productionReleaseFactory(PushVerifyModule pushVerifyModule, Provider<PushVerifyPresenter> provider) {
        this.PlaceComponentResult = pushVerifyModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static PushVerifyModule_ProvidePresenter$app_productionReleaseFactory getAuthRequestContext(PushVerifyModule pushVerifyModule, Provider<PushVerifyPresenter> provider) {
        return new PushVerifyModule_ProvidePresenter$app_productionReleaseFactory(pushVerifyModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (PushVerifyContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
