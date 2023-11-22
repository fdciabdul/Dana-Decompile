package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SelfUnfreeze_Factory implements Factory<SelfUnfreeze> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public SelfUnfreeze_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SelfUnfreeze get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static SelfUnfreeze_Factory create(Provider<ResetPinRepository> provider) {
        return new SelfUnfreeze_Factory(provider);
    }

    public static SelfUnfreeze newInstance(ResetPinRepository resetPinRepository) {
        return new SelfUnfreeze(resetPinRepository);
    }
}
