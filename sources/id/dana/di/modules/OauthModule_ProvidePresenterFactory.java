package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.deeplink.path.OauthPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OauthModule_ProvidePresenterFactory implements Factory<OauthContract.Presenter> {
    private final Provider<OauthPresenter> BuiltInFictitiousFunctionClassFactory;
    private final OauthModule PlaceComponentResult;

    private OauthModule_ProvidePresenterFactory(OauthModule oauthModule, Provider<OauthPresenter> provider) {
        this.PlaceComponentResult = oauthModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static OauthModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(OauthModule oauthModule, Provider<OauthPresenter> provider) {
        return new OauthModule_ProvidePresenterFactory(oauthModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OauthContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
