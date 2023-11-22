package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class Login_Factory implements Factory<Login> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public Login_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final Login get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static Login_Factory create(Provider<LoginRepository> provider) {
        return new Login_Factory(provider);
    }

    public static Login newInstance(LoginRepository loginRepository) {
        return new Login(loginRepository);
    }
}
