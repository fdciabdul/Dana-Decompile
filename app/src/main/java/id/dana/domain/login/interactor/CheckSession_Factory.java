package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CheckSession_Factory implements Factory<CheckSession> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public CheckSession_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final CheckSession get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static CheckSession_Factory create(Provider<LoginRepository> provider) {
        return new CheckSession_Factory(provider);
    }

    public static CheckSession newInstance(LoginRepository loginRepository) {
        return new CheckSession(loginRepository);
    }
}
