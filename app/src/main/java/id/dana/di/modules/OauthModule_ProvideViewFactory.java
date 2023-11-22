package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.deeplink.path.OauthView;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OauthModule_ProvideViewFactory implements Factory<OauthContract.View> {
    private final Provider<OauthView> PlaceComponentResult;
    private final OauthModule getAuthRequestContext;

    private OauthModule_ProvideViewFactory(OauthModule oauthModule, Provider<OauthView> provider) {
        this.getAuthRequestContext = oauthModule;
        this.PlaceComponentResult = provider;
    }

    public static OauthModule_ProvideViewFactory getAuthRequestContext(OauthModule oauthModule, Provider<OauthView> provider) {
        return new OauthModule_ProvideViewFactory(oauthModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OauthContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult.get()));
    }
}
