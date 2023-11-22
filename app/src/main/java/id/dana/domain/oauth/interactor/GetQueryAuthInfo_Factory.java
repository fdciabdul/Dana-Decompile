package id.dana.domain.oauth.interactor;

import dagger.internal.Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetQueryAuthInfo_Factory implements Factory<GetQueryAuthInfo> {
    private final Provider<GetQrBindingConfig> getQrBindingConfigProvider;
    private final Provider<OauthRepository> oauthRepositoryProvider;

    public GetQueryAuthInfo_Factory(Provider<OauthRepository> provider, Provider<GetQrBindingConfig> provider2) {
        this.oauthRepositoryProvider = provider;
        this.getQrBindingConfigProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetQueryAuthInfo get() {
        return newInstance(this.oauthRepositoryProvider.get(), this.getQrBindingConfigProvider.get());
    }

    public static GetQueryAuthInfo_Factory create(Provider<OauthRepository> provider, Provider<GetQrBindingConfig> provider2) {
        return new GetQueryAuthInfo_Factory(provider, provider2);
    }

    public static GetQueryAuthInfo newInstance(OauthRepository oauthRepository, GetQrBindingConfig getQrBindingConfig) {
        return new GetQueryAuthInfo(oauthRepository, getQrBindingConfig);
    }
}
