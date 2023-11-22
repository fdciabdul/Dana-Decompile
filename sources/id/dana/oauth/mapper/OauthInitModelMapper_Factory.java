package id.dana.oauth.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class OauthInitModelMapper_Factory implements Factory<OauthInitModelMapper> {
    private final Provider<ScopeModelMapper> getAuthRequestContext;

    private OauthInitModelMapper_Factory(Provider<ScopeModelMapper> provider) {
        this.getAuthRequestContext = provider;
    }

    public static OauthInitModelMapper_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<ScopeModelMapper> provider) {
        return new OauthInitModelMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OauthInitModelMapper(this.getAuthRequestContext.get());
    }
}
