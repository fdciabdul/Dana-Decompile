package id.dana.domain.fullstory.interactor;

import dagger.internal.Factory;
import id.dana.domain.fullstory.FullstoryRepository;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class IsEligibleForFullstorySession_Factory implements Factory<IsEligibleForFullstorySession> {
    private final Provider<FullstoryRepository> fullstoryRepositoryProvider;

    public IsEligibleForFullstorySession_Factory(Provider<FullstoryRepository> provider) {
        this.fullstoryRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final IsEligibleForFullstorySession get() {
        return newInstance(this.fullstoryRepositoryProvider.get());
    }

    public static IsEligibleForFullstorySession_Factory create(Provider<FullstoryRepository> provider) {
        return new IsEligibleForFullstorySession_Factory(provider);
    }

    public static IsEligibleForFullstorySession newInstance(FullstoryRepository fullstoryRepository) {
        return new IsEligibleForFullstorySession(fullstoryRepository);
    }
}
