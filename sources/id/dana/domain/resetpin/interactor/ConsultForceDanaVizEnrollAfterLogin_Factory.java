package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultForceDanaVizEnrollAfterLogin_Factory implements Factory<ConsultForceDanaVizEnrollAfterLogin> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public ConsultForceDanaVizEnrollAfterLogin_Factory(Provider<ResetPinRepository> provider, Provider<UserRepository> provider2) {
        this.resetPinRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ConsultForceDanaVizEnrollAfterLogin get() {
        return newInstance(this.resetPinRepositoryProvider.get(), this.userRepositoryProvider.get());
    }

    public static ConsultForceDanaVizEnrollAfterLogin_Factory create(Provider<ResetPinRepository> provider, Provider<UserRepository> provider2) {
        return new ConsultForceDanaVizEnrollAfterLogin_Factory(provider, provider2);
    }

    public static ConsultForceDanaVizEnrollAfterLogin newInstance(ResetPinRepository resetPinRepository, UserRepository userRepository) {
        return new ConsultForceDanaVizEnrollAfterLogin(resetPinRepository, userRepository);
    }
}
