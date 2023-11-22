package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SaveForceDanaVizPrompt_Factory implements Factory<SaveForceDanaVizPrompt> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public SaveForceDanaVizPrompt_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SaveForceDanaVizPrompt get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static SaveForceDanaVizPrompt_Factory create(Provider<ResetPinRepository> provider) {
        return new SaveForceDanaVizPrompt_Factory(provider);
    }

    public static SaveForceDanaVizPrompt newInstance(ResetPinRepository resetPinRepository) {
        return new SaveForceDanaVizPrompt(resetPinRepository);
    }
}
