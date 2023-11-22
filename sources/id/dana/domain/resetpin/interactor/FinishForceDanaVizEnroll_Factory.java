package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FinishForceDanaVizEnroll_Factory implements Factory<FinishForceDanaVizEnroll> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public FinishForceDanaVizEnroll_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FinishForceDanaVizEnroll get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static FinishForceDanaVizEnroll_Factory create(Provider<ResetPinRepository> provider) {
        return new FinishForceDanaVizEnroll_Factory(provider);
    }

    public static FinishForceDanaVizEnroll newInstance(ResetPinRepository resetPinRepository) {
        return new FinishForceDanaVizEnroll(resetPinRepository);
    }
}
