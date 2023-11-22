package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.contract.oauth.OauthGrantPresenter;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OauthGrantModule_ProvidePresenterFactory implements Factory<OauthGrantContract.Presenter> {
    private final Provider<OauthGrantPresenter> BuiltInFictitiousFunctionClassFactory;
    private final OauthGrantModule getAuthRequestContext;

    private OauthGrantModule_ProvidePresenterFactory(OauthGrantModule oauthGrantModule, Provider<OauthGrantPresenter> provider) {
        this.getAuthRequestContext = oauthGrantModule;
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static OauthGrantModule_ProvidePresenterFactory BuiltInFictitiousFunctionClassFactory(OauthGrantModule oauthGrantModule, Provider<OauthGrantPresenter> provider) {
        return new OauthGrantModule_ProvidePresenterFactory(oauthGrantModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OauthGrantContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
