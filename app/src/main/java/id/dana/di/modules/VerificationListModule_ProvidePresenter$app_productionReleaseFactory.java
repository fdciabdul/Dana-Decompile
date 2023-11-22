package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.pushverify.view.verificationlist.list.VerificationListContract;
import id.dana.pushverify.view.verificationlist.list.VerificationListPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerificationListModule_ProvidePresenter$app_productionReleaseFactory implements Factory<VerificationListContract.Presenter> {
    private final VerificationListModule BuiltInFictitiousFunctionClassFactory;
    private final Provider<VerificationListPresenter> PlaceComponentResult;

    private VerificationListModule_ProvidePresenter$app_productionReleaseFactory(VerificationListModule verificationListModule, Provider<VerificationListPresenter> provider) {
        this.BuiltInFictitiousFunctionClassFactory = verificationListModule;
        this.PlaceComponentResult = provider;
    }

    public static VerificationListModule_ProvidePresenter$app_productionReleaseFactory getAuthRequestContext(VerificationListModule verificationListModule, Provider<VerificationListPresenter> provider) {
        return new VerificationListModule_ProvidePresenter$app_productionReleaseFactory(verificationListModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (VerificationListContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
