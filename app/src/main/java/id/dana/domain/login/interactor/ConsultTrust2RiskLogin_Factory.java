package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultTrust2RiskLogin_Factory implements Factory<ConsultTrust2RiskLogin> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public ConsultTrust2RiskLogin_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ConsultTrust2RiskLogin get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static ConsultTrust2RiskLogin_Factory create(Provider<LoginRepository> provider) {
        return new ConsultTrust2RiskLogin_Factory(provider);
    }

    public static ConsultTrust2RiskLogin newInstance(LoginRepository loginRepository) {
        return new ConsultTrust2RiskLogin(loginRepository);
    }
}
