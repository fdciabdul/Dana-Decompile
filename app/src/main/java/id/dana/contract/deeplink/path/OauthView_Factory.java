package id.dana.contract.deeplink.path;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OauthView_Factory implements Factory<OauthView> {
    private final Provider<FeatureOauth> BuiltInFictitiousFunctionClassFactory;

    private OauthView_Factory(Provider<FeatureOauth> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static OauthView_Factory getAuthRequestContext(Provider<FeatureOauth> provider) {
        return new OauthView_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OauthView(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
