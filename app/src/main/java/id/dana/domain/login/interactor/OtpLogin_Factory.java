package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OtpLogin_Factory implements Factory<OtpLogin> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public OtpLogin_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final OtpLogin get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static OtpLogin_Factory create(Provider<LoginRepository> provider) {
        return new OtpLogin_Factory(provider);
    }

    public static OtpLogin newInstance(LoginRepository loginRepository) {
        return new OtpLogin(loginRepository);
    }
}
