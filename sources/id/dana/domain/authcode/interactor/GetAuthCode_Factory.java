package id.dana.domain.authcode.interactor;

import dagger.internal.Factory;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetAuthCode_Factory implements Factory<GetAuthCode> {
    private final Provider<GetEmptyUserInfo> checkUserInfoProvider;
    private final Provider<OauthRepository> repositoryProvider;

    public GetAuthCode_Factory(Provider<OauthRepository> provider, Provider<GetEmptyUserInfo> provider2) {
        this.repositoryProvider = provider;
        this.checkUserInfoProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final GetAuthCode get() {
        return newInstance(this.repositoryProvider.get(), this.checkUserInfoProvider.get());
    }

    public static GetAuthCode_Factory create(Provider<OauthRepository> provider, Provider<GetEmptyUserInfo> provider2) {
        return new GetAuthCode_Factory(provider, provider2);
    }

    public static GetAuthCode newInstance(OauthRepository oauthRepository, GetEmptyUserInfo getEmptyUserInfo) {
        return new GetAuthCode(oauthRepository, getEmptyUserInfo);
    }
}
