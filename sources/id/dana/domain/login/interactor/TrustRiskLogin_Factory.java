package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class TrustRiskLogin_Factory implements Factory<TrustRiskLogin> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public TrustRiskLogin_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final TrustRiskLogin get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static TrustRiskLogin_Factory create(Provider<LoginRepository> provider) {
        return new TrustRiskLogin_Factory(provider);
    }

    public static TrustRiskLogin newInstance(LoginRepository loginRepository) {
        return new TrustRiskLogin(loginRepository);
    }
}
