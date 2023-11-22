package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.user.repository.UserRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ConsultForceDanaVizEnroll_Factory implements Factory<ConsultForceDanaVizEnroll> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public ConsultForceDanaVizEnroll_Factory(Provider<ResetPinRepository> provider, Provider<UserRepository> provider2) {
        this.resetPinRepositoryProvider = provider;
        this.userRepositoryProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final ConsultForceDanaVizEnroll get() {
        return newInstance(this.resetPinRepositoryProvider.get(), this.userRepositoryProvider.get());
    }

    public static ConsultForceDanaVizEnroll_Factory create(Provider<ResetPinRepository> provider, Provider<UserRepository> provider2) {
        return new ConsultForceDanaVizEnroll_Factory(provider, provider2);
    }

    public static ConsultForceDanaVizEnroll newInstance(ResetPinRepository resetPinRepository, UserRepository userRepository) {
        return new ConsultForceDanaVizEnroll(resetPinRepository, userRepository);
    }
}
