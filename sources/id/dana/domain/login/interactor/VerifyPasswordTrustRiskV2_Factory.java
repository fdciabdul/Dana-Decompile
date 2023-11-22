package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class VerifyPasswordTrustRiskV2_Factory implements Factory<VerifyPasswordTrustRiskV2> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public VerifyPasswordTrustRiskV2_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final VerifyPasswordTrustRiskV2 get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static VerifyPasswordTrustRiskV2_Factory create(Provider<LoginRepository> provider) {
        return new VerifyPasswordTrustRiskV2_Factory(provider);
    }

    public static VerifyPasswordTrustRiskV2 newInstance(LoginRepository loginRepository) {
        return new VerifyPasswordTrustRiskV2(loginRepository);
    }
}
