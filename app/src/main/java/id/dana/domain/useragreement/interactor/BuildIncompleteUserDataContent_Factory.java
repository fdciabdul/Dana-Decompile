package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class BuildIncompleteUserDataContent_Factory implements Factory<BuildIncompleteUserDataContent> {
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public BuildIncompleteUserDataContent_Factory(Provider<UserConsentRepository> provider) {
        this.userConsentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BuildIncompleteUserDataContent get() {
        return newInstance(this.userConsentRepositoryProvider.get());
    }

    public static BuildIncompleteUserDataContent_Factory create(Provider<UserConsentRepository> provider) {
        return new BuildIncompleteUserDataContent_Factory(provider);
    }

    public static BuildIncompleteUserDataContent newInstance(UserConsentRepository userConsentRepository) {
        return new BuildIncompleteUserDataContent(userConsentRepository);
    }
}
