package id.dana.domain.profilemenu.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetMobileEnvInfo_Factory implements Factory<GetMobileEnvInfo> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public GetMobileEnvInfo_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetMobileEnvInfo get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static GetMobileEnvInfo_Factory create(Provider<LoginRepository> provider) {
        return new GetMobileEnvInfo_Factory(provider);
    }

    public static GetMobileEnvInfo newInstance(LoginRepository loginRepository) {
        return new GetMobileEnvInfo(loginRepository);
    }
}
