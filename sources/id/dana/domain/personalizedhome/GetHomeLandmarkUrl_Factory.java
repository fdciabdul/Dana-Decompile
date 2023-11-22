package id.dana.domain.personalizedhome;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetHomeLandmarkUrl_Factory implements Factory<GetHomeLandmarkUrl> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetHomeLandmarkUrl_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetHomeLandmarkUrl get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetHomeLandmarkUrl_Factory create(Provider<UserRepository> provider) {
        return new GetHomeLandmarkUrl_Factory(provider);
    }

    public static GetHomeLandmarkUrl newInstance(UserRepository userRepository) {
        return new GetHomeLandmarkUrl(userRepository);
    }
}
