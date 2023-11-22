package id.dana.domain.user.interactor;

import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserCohort_Factory implements Factory<GetUserCohort> {
    private final Provider<UserRepository> userRepositoryProvider;

    public GetUserCohort_Factory(Provider<UserRepository> provider) {
        this.userRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetUserCohort get() {
        return newInstance(this.userRepositoryProvider.get());
    }

    public static GetUserCohort_Factory create(Provider<UserRepository> provider) {
        return new GetUserCohort_Factory(provider);
    }

    public static GetUserCohort newInstance(UserRepository userRepository) {
        return new GetUserCohort(userRepository);
    }
}
