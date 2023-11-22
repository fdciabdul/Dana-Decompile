package id.dana.domain.useragreement.interactor;

import dagger.internal.Factory;
import id.dana.domain.useragreement.UserConsentRepository;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class BuildAgreementContent_Factory implements Factory<BuildAgreementContent> {
    private final Provider<UserConsentRepository> userConsentRepositoryProvider;

    public BuildAgreementContent_Factory(Provider<UserConsentRepository> provider) {
        this.userConsentRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BuildAgreementContent get() {
        return newInstance(this.userConsentRepositoryProvider.get());
    }

    public static BuildAgreementContent_Factory create(Provider<UserConsentRepository> provider) {
        return new BuildAgreementContent_Factory(provider);
    }

    public static BuildAgreementContent newInstance(UserConsentRepository userConsentRepository) {
        return new BuildAgreementContent(userConsentRepository);
    }
}
