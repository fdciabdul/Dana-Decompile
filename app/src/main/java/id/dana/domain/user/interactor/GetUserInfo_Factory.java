package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class GetUserInfo_Factory implements Factory<GetUserInfo> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetUserInfo_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserInfo get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetUserInfo_Factory create(Provider<UserRepository> provider) {
        return new GetUserInfo_Factory(provider);
    }

    public static GetUserInfo newInstance(UserRepository userRepository) {
        return new GetUserInfo(userRepository);
    }
}
