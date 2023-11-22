package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IsDanaVizEnrollmentSkippable_Factory implements Factory<IsDanaVizEnrollmentSkippable> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public IsDanaVizEnrollmentSkippable_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsDanaVizEnrollmentSkippable get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static IsDanaVizEnrollmentSkippable_Factory create(Provider<ResetPinRepository> provider) {
        return new IsDanaVizEnrollmentSkippable_Factory(provider);
    }

    public static IsDanaVizEnrollmentSkippable newInstance(ResetPinRepository resetPinRepository) {
        return new IsDanaVizEnrollmentSkippable(resetPinRepository);
    }
}
