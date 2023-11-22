package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserPan_Factory implements Factory<GetUserPan> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetUserPan_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserPan get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetUserPan_Factory create(Provider<UserRepository> provider) {
        return new GetUserPan_Factory(provider);
    }

    public static GetUserPan newInstance(UserRepository userRepository) {
        return new GetUserPan(userRepository);
    }
}
