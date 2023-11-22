package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetEmptyUserInfo_Factory implements Factory<GetEmptyUserInfo> {
    private final Provider<UserConsentRepository> repositoryProvider;

    public GetEmptyUserInfo_Factory(Provider<UserConsentRepository> provider) {
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetEmptyUserInfo get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetEmptyUserInfo_Factory create(Provider<UserConsentRepository> provider) {
        return new GetEmptyUserInfo_Factory(provider);
    }

    public static GetEmptyUserInfo newInstance(UserConsentRepository userConsentRepository) {
        return new GetEmptyUserInfo(userConsentRepository);
    }
}
