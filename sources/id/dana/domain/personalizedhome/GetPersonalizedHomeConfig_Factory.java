package id.dana.domain.personalizedhome;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetPersonalizedHomeConfig_Factory implements Factory<GetPersonalizedHomeConfig> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetPersonalizedHomeConfig_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetPersonalizedHomeConfig get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetPersonalizedHomeConfig_Factory create(Provider<UserRepository> provider) {
        return new GetPersonalizedHomeConfig_Factory(provider);
    }

    public static GetPersonalizedHomeConfig newInstance(UserRepository userRepository) {
        return new GetPersonalizedHomeConfig(userRepository);
    }
}
