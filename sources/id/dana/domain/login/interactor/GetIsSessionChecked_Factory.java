package id.dana.domain.login.interactor;

import dagger.internal.Factory;
import id.dana.domain.login.LoginRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetIsSessionChecked_Factory implements Factory<GetIsSessionChecked> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public GetIsSessionChecked_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetIsSessionChecked get() {
        return newInstance(this.loginRepositoryProvider.get());
    }

    public static GetIsSessionChecked_Factory create(Provider<LoginRepository> provider) {
        return new GetIsSessionChecked_Factory(provider);
    }

    public static GetIsSessionChecked newInstance(LoginRepository loginRepository) {
        return new GetIsSessionChecked(loginRepository);
    }
}
