package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class HoldLogin_Factory implements Factory<HoldLogin> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public HoldLogin_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final HoldLogin get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static HoldLogin_Factory create(Provider<LoginRepository> provider) {
        return new HoldLogin_Factory(provider);
    }

    public static HoldLogin newInstance(LoginRepository loginRepository) {
        return new HoldLogin(loginRepository);
    }
}
