package id.dana.oauth.activity;

import dagger.MembersInjector;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.oauth.ScopeAdapter;

/* loaded from: classes5.dex */
public final class OauthGrantActivity_MembersInjector implements MembersInjector<OauthGrantActivity> {
    public static void PlaceComponentResult(OauthGrantActivity oauthGrantActivity, OauthGrantContract.Presenter presenter) {
        oauthGrantActivity.presenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OauthGrantActivity oauthGrantActivity, ReadLinkPropertiesContract.Presenter presenter) {
        oauthGrantActivity.readLinkPropertiesPresenter = presenter;
    }

    public static void BuiltInFictitiousFunctionClassFactory(OauthGrantActivity oauthGrantActivity, ScopeAdapter scopeAdapter) {
        oauthGrantActivity.scopeAdapter = scopeAdapter;
    }
}
