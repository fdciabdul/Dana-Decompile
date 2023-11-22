package id.dana.domain.resetpin.interactor;

import dagger.internal.Factory;
import id.dana.domain.resetpin.ResetPinRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetForceDanaVizPrompt_Factory implements Factory<GetForceDanaVizPrompt> {
    private final Provider<ResetPinRepository> resetPinRepositoryProvider;

    public GetForceDanaVizPrompt_Factory(Provider<ResetPinRepository> provider) {
        this.resetPinRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetForceDanaVizPrompt get() {
        return newInstance(this.resetPinRepositoryProvider.get());
    }

    public static GetForceDanaVizPrompt_Factory create(Provider<ResetPinRepository> provider) {
        return new GetForceDanaVizPrompt_Factory(provider);
    }

    public static GetForceDanaVizPrompt newInstance(ResetPinRepository resetPinRepository) {
        return new GetForceDanaVizPrompt(resetPinRepository);
    }
}
