package id.dana.data.base;

import dagger.MembersInjector;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class AuthenticatedEntityRepository_MembersInjector implements MembersInjector<AuthenticatedEntityRepository> {
    private final Provider<DeepLinkPayloadManager> deepLinkPayloadManagerProvider;

    public AuthenticatedEntityRepository_MembersInjector(Provider<DeepLinkPayloadManager> provider) {
        this.deepLinkPayloadManagerProvider = provider;
    }

    public static MembersInjector<AuthenticatedEntityRepository> create(Provider<DeepLinkPayloadManager> provider) {
        return new AuthenticatedEntityRepository_MembersInjector(provider);
    }

    public final void injectMembers(AuthenticatedEntityRepository authenticatedEntityRepository) {
        injectBuildDeepLinkPayloadDependencies(authenticatedEntityRepository, this.deepLinkPayloadManagerProvider.get());
    }

    public static void injectBuildDeepLinkPayloadDependencies(AuthenticatedEntityRepository authenticatedEntityRepository, DeepLinkPayloadManager deepLinkPayloadManager) {
        authenticatedEntityRepository.buildDeepLinkPayloadDependencies(deepLinkPayloadManager);
    }
}
