package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Trust2RiskLogin_Factory implements Factory<Trust2RiskLogin> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public Trust2RiskLogin_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final Trust2RiskLogin get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static Trust2RiskLogin_Factory create(Provider<LoginRepository> provider) {
        return new Trust2RiskLogin_Factory(provider);
    }

    public static Trust2RiskLogin newInstance(LoginRepository loginRepository) {
        return new Trust2RiskLogin(loginRepository);
    }
}
