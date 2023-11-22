package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserStatusInfo_Factory implements Factory<GetUserStatusInfo> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetUserStatusInfo_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserStatusInfo get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetUserStatusInfo_Factory create(Provider<UserRepository> provider) {
        return new GetUserStatusInfo_Factory(provider);
    }

    public static GetUserStatusInfo newInstance(UserRepository userRepository) {
        return new GetUserStatusInfo(userRepository);
    }
}
