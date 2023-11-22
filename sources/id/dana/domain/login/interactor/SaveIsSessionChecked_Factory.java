package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveIsSessionChecked_Factory implements Factory<SaveIsSessionChecked> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public SaveIsSessionChecked_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveIsSessionChecked get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static SaveIsSessionChecked_Factory create(Provider<LoginRepository> provider) {
        return new SaveIsSessionChecked_Factory(provider);
    }

    public static SaveIsSessionChecked newInstance(LoginRepository loginRepository) {
        return new SaveIsSessionChecked(loginRepository);
    }
}
