package id.dana.data.oauth.mapper;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class OauthInitResultMapper_Factory implements Factory<OauthInitResultMapper> {
    private final Provider<ScopeResultMapper> scopeResultMapperProvider;

    public OauthInitResultMapper_Factory(Provider<ScopeResultMapper> provider) {
        this.scopeResultMapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OauthInitResultMapper get() {
        return newInstance(this.scopeResultMapperProvider.get());
    }

    public static OauthInitResultMapper_Factory create(Provider<ScopeResultMapper> provider) {
        return new OauthInitResultMapper_Factory(provider);
    }

    public static OauthInitResultMapper newInstance(ScopeResultMapper scopeResultMapper) {
        return new OauthInitResultMapper(scopeResultMapper);
    }
}
