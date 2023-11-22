package id.dana.domain.deeplink.interactor;

import dagger.internal.Factory;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RemoveDeepLinkPayload_Factory implements Factory<RemoveDeepLinkPayload> {
    private final Provider<DeepLinkRepository> deepLinkRepositoryProvider;

    public RemoveDeepLinkPayload_Factory(Provider<DeepLinkRepository> provider) {
        this.deepLinkRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveDeepLinkPayload get() {
        return newInstance(this.deepLinkRepositoryProvider.get());
    }

    public static RemoveDeepLinkPayload_Factory create(Provider<DeepLinkRepository> provider) {
        return new RemoveDeepLinkPayload_Factory(provider);
    }

    public static RemoveDeepLinkPayload newInstance(DeepLinkRepository deepLinkRepository) {
        return new RemoveDeepLinkPayload(deepLinkRepository);
    }
}
