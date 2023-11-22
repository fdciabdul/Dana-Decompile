package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetDanaVizPromptAfterResetPin_Factory implements Factory<GetDanaVizPromptAfterResetPin> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public GetDanaVizPromptAfterResetPin_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetDanaVizPromptAfterResetPin get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static GetDanaVizPromptAfterResetPin_Factory create(Provider<ResetPinRepository> provider) {
        return new GetDanaVizPromptAfterResetPin_Factory(provider);
    }

    public static GetDanaVizPromptAfterResetPin newInstance(ResetPinRepository resetPinRepository) {
        return new GetDanaVizPromptAfterResetPin(resetPinRepository);
    }
}
