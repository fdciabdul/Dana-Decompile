package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.contract.oauth.OauthGrantContract;

/* loaded from: classes4.dex */
public final class OauthGrantModule_ProvideViewFactory implements Factory<OauthGrantContract.View> {
    private final OauthGrantModule PlaceComponentResult;

    private OauthGrantModule_ProvideViewFactory(OauthGrantModule oauthGrantModule) {
        this.PlaceComponentResult = oauthGrantModule;
    }

    public static OauthGrantModule_ProvideViewFactory PlaceComponentResult(OauthGrantModule oauthGrantModule) {
        return new OauthGrantModule_ProvideViewFactory(oauthGrantModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (OauthGrantContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.PlaceComponentResult());
    }
}
