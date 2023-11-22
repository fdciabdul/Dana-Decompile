package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveDanaVizPromptAfterResetPin_Factory implements Factory<SaveDanaVizPromptAfterResetPin> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public SaveDanaVizPromptAfterResetPin_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveDanaVizPromptAfterResetPin get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static SaveDanaVizPromptAfterResetPin_Factory create(Provider<ResetPinRepository> provider) {
        return new SaveDanaVizPromptAfterResetPin_Factory(provider);
    }

    public static SaveDanaVizPromptAfterResetPin newInstance(ResetPinRepository resetPinRepository) {
        return new SaveDanaVizPromptAfterResetPin(resetPinRepository);
    }
}
