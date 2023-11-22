package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetDanaHomeBalanceConfig_Factory implements Factory<GetDanaHomeBalanceConfig> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetDanaHomeBalanceConfig_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDanaHomeBalanceConfig get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetDanaHomeBalanceConfig_Factory create(Provider<UserRepository> provider) {
        return new GetDanaHomeBalanceConfig_Factory(provider);
    }

    public static GetDanaHomeBalanceConfig newInstance(UserRepository userRepository) {
        return new GetDanaHomeBalanceConfig(userRepository);
    }
}
