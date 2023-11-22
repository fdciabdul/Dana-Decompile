package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetSingleBalance_Factory implements Factory<GetSingleBalance> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetSingleBalance_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSingleBalance get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetSingleBalance_Factory create(Provider<UserRepository> provider) {
        return new GetSingleBalance_Factory(provider);
    }

    public static GetSingleBalance newInstance(UserRepository userRepository) {
        return new GetSingleBalance(userRepository);
    }
}
